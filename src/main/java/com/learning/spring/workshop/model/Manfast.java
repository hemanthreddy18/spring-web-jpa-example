package com.learning.spring.workshop.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name="APP_MANFAST")
public class Manfast {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

        @NotEmpty
        @Column(name = "NAME", unique = true, nullable = false)
        private String name;

        @NotEmpty
        @Column(name = "COUNTRY", nullable = false)
        private String country;

    //@OneToMany(fetch = FetchType.EAGER)
    @OneToMany
    private Set<Product> products;
}
