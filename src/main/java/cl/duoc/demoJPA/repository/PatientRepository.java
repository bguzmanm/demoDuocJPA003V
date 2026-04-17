package cl.duoc.demoJPA.repository;

import cl.duoc.demoJPA.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
