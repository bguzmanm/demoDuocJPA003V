package cl.duoc.demoJPA.repository;

import cl.duoc.demoJPA.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findByName(String name);
    List<Doctor> findByNameAndLastName(String name, String lastName);
}
