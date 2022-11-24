package com.droans.task.domain;




import com.droans.task.domain.enumModels.Model;
import com.droans.task.domain.enumModels.State;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "drons")
public class Drons implements Serializable {
    @Id
    @Column(name = "drons_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serial", nullable = false)
    private long serial;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "model", nullable = false)
    private Model model;

    public int getWeightlimit() {
        return weightlimit;
    }

    public void setWeightlimit(int weightlimit) {
        this.weightlimit = weightlimit;
    }

    @Column(name = "weightlimit", nullable = false)
    private  int weightlimit;

    @Column(name = "battery_capacity", nullable = false)
    private int batteryCapacity;


    @Enumerated(EnumType.ORDINAL)
    @Column(name = "state", nullable = false)
    private State state;



    @OneToMany
    Set<Transactions> transactions;

    @OneToMany
    Set<BatteryLog> battery;

    public Set<BatteryLog> getBattery() {
        return battery;
    }

    public void setBattery(Set<BatteryLog> battery) {
        this.battery = battery;
    }

    public Set<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transactions> transactions) {
        this.transactions = transactions;
    }

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



    public void setweightLimit(int weightLimit) {
        weightLimit = weightLimit;
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


    @Override
    public String toString() {
        return "Drons{" +
                "id=" + id +
                ", serial=" + serial +
                ", model=" + model +
                ", weightLimit=" + weightlimit +
                ", batteryCapacity=" + batteryCapacity +
                ", state=" + state +
                '}';
    }
}
