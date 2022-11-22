package com.droans.task.service.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class MedicationDTO implements Serializable {
    public static final String REGEX = "^(?>[a-zA-Z0-9!$&*+=?^_`{|}~.-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*)|(?>[_.@A-Za-z0-9-]+)$";
    public static final String UP_REGEX = "^[A-Z0-9]+$";

    private Long id;

    @Pattern(regexp = REGEX)
    @Size(min = 1, max = 250)
    private  String name;

    @Pattern(regexp = UP_REGEX)
    @Column(name = "code", nullable = false)
    private  String code;

    @Column(name = "image", nullable = false)
    private String image;








    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
