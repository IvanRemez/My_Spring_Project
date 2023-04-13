package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
// ^^ will try to create foreign key, b/c Many it creates a 3rd table
// since you cannot add multiple item ids in the same row of your cart object

    @JoinTable(name = "cart_item-rel",
    // ^^ rel = relationship (best practice**)
    joinColumns = @JoinColumn(name = "c_id"),
    inverseJoinColumns = @JoinColumn(name = "i_id"))
    // ^^ just syntax on how to change joined table name,
    // and it's column names
    private List<Item> itemList;

}
