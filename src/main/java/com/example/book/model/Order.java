package com.example.book.model;

import com.example.book.BookApplication;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="UserOrders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "order_copy_mapping",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "copy_id")
    @Column(name = "rentalDays")
    private Map<Copy, Integer> copiesWithRentalDays = new HashMap<>();

    @ManyToOne
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private Delivery delivery;

}
