package com.preorder.domain.cart;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "wishlist")
@NoArgsConstructor
@AllArgsConstructor
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wishId;

    @Column(nullable = false)
    private long memberNo;

    @Column(nullable = false)
    private int optionId;

    @Column(nullable = false)
    private int pdCount;

//    @CreationTimestamp
//    @Column(nullable = false)
//    private LocalDate wishaddDate;

}
