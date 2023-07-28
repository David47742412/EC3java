package com.example.ec3java.entities;

import jakarta.persistence.*;

@Entity(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "category_id")
    public String id;
    
    @Column(name = "name", length = 300)
    public String name;
}
