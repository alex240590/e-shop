package ru.gb.eshop.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "o_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "status_code")
    private OrderStatus status;

    @Column(name = "o_price")
    private BigDecimal price;

    @Column(name = "o_delivery_date")
    private LocalDateTime deliveryDate;

    @Column(name = "o_create_date")
    @CreationTimestamp
    private LocalDateTime createDate;

    @Column(name = "o_update_date")
    @CreationTimestamp
    private LocalDateTime updateDate;

    @Column(name = "o_details")
    private String details;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderItem> orderItems;
}
