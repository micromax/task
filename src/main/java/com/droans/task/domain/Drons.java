package com.droans.task.domain;




import com.droans.task.domain.enumModels.Model;
import com.droans.task.domain.enumModels.State;

import javax.persistence.*;

@Entity
@Table(name = "drons")
public class Drons {
    @Id
    @Column(name = "drons_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial", nullable = false)
    private long serial;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "model", nullable = false)
    private Model model;

    @Column(name = "weight_limit", nullable = false)
    private  int WeightLimit;

    @Column(name = "battery_capacity", nullable = false)
    private int batteryCapacity;


    @Enumerated(EnumType.ORDINAL)
    @Column(name = "state", nullable = false)
    private State state;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




}
