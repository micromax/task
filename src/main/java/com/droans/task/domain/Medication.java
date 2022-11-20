package com.droans.task.domain;

import javax.persistence.*;

@Entity
@Table(name = "medication")
public class Medication {
    @Id
    @Column(name = "medication_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String name;
    private  String code;

    private String image;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
