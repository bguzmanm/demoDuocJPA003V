package cl.duoc.demoJPA.model;

import jakarta.persistence.*;

@Entity()
public class Patient {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

    @Column(name="last_name")
    String lastName;
    String email;
    String phone;
}
