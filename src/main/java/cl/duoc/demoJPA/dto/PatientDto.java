package cl.duoc.demoJPA.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    @NotNull
    Long id;
    @NotBlank
    String name;
    String lastName;
    String email;
    String phone;
    String fullName;
}
