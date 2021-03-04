package ru.gb.eshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.eshop.repo.ProductRepository;
import ru.gb.eshop.repo.ProductSpec;
import ru.gb.eshop.entities.Product;
import ru.gb.eshop.utils.PriceFormatter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService{
  private ProductRepository repo;
  private static final String STOCK_EMPTY = "отсутвует";
  private static final String STOCK_SMALL = "мало";
  private static final String STOCK_MEDIUM = "в наличии";
  private static final String STOCK_BIG = "много";

  //private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

  Sort.Direction sd = Sort.Direction.ASC;


  @Autowired
  public void setProductRepository (ProductRepository repo){
    this.repo = repo;
  }

  public Page<Product> findWithFilter(Optional<String> nameFilter,
                                      Optional<BigDecimal> minFilter,
                                      Optional<BigDecimal> maxFilter,
                                      Optional<Integer> page,
                                      Optional<Integer> size,
                                      Optional<Integer> brand,
                                      Optional<String> sortField,
                                      Optional<Boolean> changeSortOrder) {

    Specification<Product> spec = Specification.where(null);
    Page<Product> currentPage;

    // revert sorting order
    if (changeSortOrder.isPresent() && changeSortOrder.get()) {
      sd = (sd == Sort.Direction.ASC) ? Sort.Direction.DESC : Sort.Direction.ASC;
    }

    // fill in Specification
    if (nameFilter.isPresent()) {
      spec = spec.and(ProductSpec.nameLike(nameFilter.get()));
    }
    if (minFilter.isPresent()) {
      spec = spec.and(ProductSpec.priceBigger(minFilter.get()));
    }
    if (maxFilter.isPresent()) {
      spec = spec.and(ProductSpec.priceLess(maxFilter.get()));
    }
    if (brand.isPresent()) {
      spec = spec.and(ProductSpec.brandEqual(brand.get()));
    }

    if (sortField.isPresent() && !sortField.get().equals("")) {
      currentPage = repo.findAll(spec, PageRequest.of(page.orElse(1) - 1,
              size.orElse(10),
              Sort.by(sd, sortField.get())));
    }else{
      currentPage = repo.findAll(spec, PageRequest.of(page.orElse(1) - 1,
              size.orElse(10),
              Sort.by(Sort.Direction.ASC, "id")));
    }


    //update printable fields

    for (Product p: currentPage){
        if (p.getStock() == 0) {
          p.setPrintStock(STOCK_EMPTY);
        }else if (p.getStock() < 10){
          p.setPrintStock(STOCK_SMALL);
        }else if (p.getStock() < 30) {
          p.setPrintStock(STOCK_MEDIUM);
        }else{
          p.setPrintStock(STOCK_BIG);
        }

        p.setPrintPrice(PriceFormatter.format(p.getPrice()));
    }

    return currentPage;
  }

  public List<Product> findAll(Specification<Product> spec) {
    return repo.findAll(spec);
  }

  public Optional<Product> findById(Long id) {
    Optional<Product> p = repo.findById(id);
    p.ifPresent(product -> product.setPrintPrice(PriceFormatter.format(product.getPrice())));
    return p;
  }

  @Transactional
  public void save(Product product) {
    repo.save(product);
  }

  @Transactional
  public void deleteById(Long id) {
    repo.deleteById(id);
  }

}
