package com.droans.task.service.dto;

import com.droans.task.domain.Drons;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Optional;

public class DronsBatteryLevelDTO {

    private Long id;

    @NotBlank
    @Size(min = 1, max = 100)
    private long serial;


    @NotBlank
    @Min(1)
    @Max(100)
    private int batteryCapacity;


    public DronsBatteryLevelDTO() {
    }


    public DronsBatteryLevelDTO(Drons drones) {
        if(drones != null)
        {
            this.setId(drones.getId());
            this.setSerial(drones.getSerial());
            this.setBatteryCapacity(drones.getBatteryCapacity());
        }

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

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }
}
