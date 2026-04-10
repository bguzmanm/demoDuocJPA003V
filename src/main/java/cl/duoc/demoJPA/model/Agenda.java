package cl.duoc.demoJPA.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    Patient patient;

    String box;
    String date;

}
