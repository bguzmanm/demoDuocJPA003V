package cl.duoc.demoJPA.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    int id;
    String name;
    String lastName;
    String email;
    String phone;
    String fullName;
}
