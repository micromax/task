package com.droans.task.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "medication")
public class Medication implements Serializable {
    @Id
    @Column(name = "medication_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private  String name;

    @Column(name = "code", nullable = false)
    private  String code;

    @Column(name = "image", nullable = false)
    private String image;


    @Column(name = "image", nullable = false)
    private String weight;


    @OneToMany(mappedBy = "MedicationId")
    Set<Transactions> transactions;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
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


    @Override
    public String toString() {
        return "Medication{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
