package com.mymarket.mvp.products;

import jakarta.persistence.*;
import lombok.*;

/**
 * The Account entity represents user account in the application.
 *
 * @author Pedro Lucas
 * @since 1.0
 */
@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "name"})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Long price;

}
