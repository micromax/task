package com.droans.task.service.dto;

import com.droans.task.domain.Drons;
import com.droans.task.domain.Transactions;
import com.droans.task.domain.enumModels.Model;
import com.droans.task.domain.enumModels.State;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class DroneLoadInforamtionsDTO   {



    private Long id;


    private long serial;


    private Model model;




    private  int weightlimit;


    private int batteryCapacity;


    private State state;


    private Transactions transactions;


    public DroneLoadInforamtionsDTO() {
    }

    public DroneLoadInforamtionsDTO(Drons drone) {


        this.id = drone.getId();
        this.state = drone.getState();
        this.model = drone.getModel();
        this.serial = drone.getSerial();
        this.batteryCapacity = drone.getBatteryCapacity();
        this.weightlimit = drone.getWeightlimit();


    }

    public DroneLoadInforamtionsDTO(Drons drone, Transactions transactions) {
        new DroneLoadInforamtionsDTO(drone);
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

    public Transactions getTransactions() {
        return transactions;
    }

    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
    }
}
