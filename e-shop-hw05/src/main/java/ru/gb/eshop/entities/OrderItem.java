package ru.gb.eshop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oi_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "oi_quantity")
    private Integer quantity;

    @Column(name = "oi_price")
    private BigDecimal itemPrice;

    @Column(name = "oi_total_price")
    private BigDecimal totalPrice;

    @Column(name = "oi_details")
    private String details;

    @Transient
    private String printTotalPrice;
}
