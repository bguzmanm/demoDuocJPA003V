package cl.duoc.demoJPA.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Doctor {
    @Id
    int id;

    String name;

    @Column(name="last_name")
    String lastName;
    String email;
    String phone;

}


