package com.droans.task.service.dto;

import com.droans.task.domain.enumModels.Model;
import com.droans.task.domain.enumModels.State;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class DronsDTO implements Serializable {


    private Long id;

    @NotBlank
    @Size(min = 1, max = 100)
    private long serial;

    @NotBlank
    private Model model;



    @NotBlank
    @Size(min = 1, max = 500)
    private  int weightlimit;

    @NotBlank
    @Size(min = 25, max = 100)
    private int batteryCapacity;

    @NotBlank
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

    public int getWeightlimit() {
        return weightlimit;
    }

    public void setWeightlimit(int weightlimit) {
        this.weightlimit = weightlimit;
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
