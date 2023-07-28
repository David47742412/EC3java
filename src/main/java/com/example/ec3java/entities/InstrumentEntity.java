package com.example.ec3java.entities;

import jakarta.persistence.*;

@Entity(name = "instrument")
public class InstrumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "instrument_id")
    public String id;
    
    @Column(name = "name", length = 300)
    public String name;
    
    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = CategoryEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    public CategoryEntity category;

}
