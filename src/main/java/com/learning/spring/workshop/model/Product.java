package com.learning.spring.workshop.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="APP_PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @NotEmpty
    @Column(name = "PRODUCTTYPE", nullable = false)
    private String productType;

    //@NotEmpty
    @ManyToOne
    //@Column(name = "MANFAST_ID", nullable = false)
    private Manfast manfast;
}
