package com.example.demo.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Seller extends User{

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Product> products;
}
