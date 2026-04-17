package cl.duoc.demoJPA.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    @NotNull
    Long id;
    @NotNull
    String name;
    @NotNull
    String lastName;
    @Email
    String email;
    @NotBlank
    String phone;
    @NotBlank(message = "ponele la fecha de nacimiento al cauro...")
    String birthday;
}
