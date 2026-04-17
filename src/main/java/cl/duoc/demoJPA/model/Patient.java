package cl.duoc.demoJPA.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity()
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    @Column(name="last_name")
    String lastName;
    String email;
    String phone;
}
