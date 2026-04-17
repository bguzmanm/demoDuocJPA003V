package cl.duoc.demoJPA.service;

import cl.duoc.demoJPA.dto.DoctorDto;
import cl.duoc.demoJPA.model.Doctor;
import cl.duoc.demoJPA.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DoctorService {

    List<DoctorDto> findAll();
    DoctorDto findById(Long id);
    List<DoctorDto> findByName(String name);
    List<DoctorDto> findByNameAndLastName(String name, String lastName);
    DoctorDto create(DoctorDto doctor);
    DoctorDto update(Long id, DoctorDto doctor);
    boolean delete(Long id);
}
