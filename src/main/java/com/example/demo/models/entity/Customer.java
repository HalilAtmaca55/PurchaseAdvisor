package com.example.demo.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class Customer extends User{

    private BigDecimal money;
}
