package com.droans.task.domain;

import com.droans.task.domain.enumModels.State;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "transactions ")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @MapsId("DronsId")
    @JoinColumn(name = "drons_id")
    Drons DronsId;

    @ManyToOne
    @MapsId("MedicationId")
    @JoinColumn(name = "medication_id")
    Medication MedicationId;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "state", nullable = false)
    private State state;

    public Drons getDronsId() {
        return DronsId;
    }

    public void setDronsId(Drons dronsId) {
        DronsId = dronsId;
    }

    public Medication getMedicationId() {
        return MedicationId;
    }

    public void setMedicationId(Medication medicationId) {
        MedicationId = medicationId;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
