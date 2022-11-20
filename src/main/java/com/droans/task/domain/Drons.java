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

    public long getSerial() {
        return serial;
    }

    public void setSerial(long serial) {
        this.serial = serial;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public int getWeightLimit() {
        return WeightLimit;
    }

    public void setWeightLimit(int weightLimit) {
        WeightLimit = weightLimit;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
