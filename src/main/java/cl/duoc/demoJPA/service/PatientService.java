package cl.duoc.demoJPA.service;

import cl.duoc.demoJPA.dto.PatientDto;

import java.util.List;

public interface PatientService {
    List<PatientDto> findAll();
    PatientDto findById(Long id);
    PatientDto create(PatientDto patient);
    PatientDto update(PatientDto patient);
    boolean deleteById(Long id);
}
