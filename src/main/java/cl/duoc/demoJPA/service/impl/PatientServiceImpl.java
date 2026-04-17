package cl.duoc.demoJPA.service.impl;

import cl.duoc.demoJPA.dto.PatientDto;
import cl.duoc.demoJPA.model.mapper.PatientMapper;
import cl.duoc.demoJPA.repository.PatientRepository;
import cl.duoc.demoJPA.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;
    private final PatientMapper mapper;

    public PatientServiceImpl(PatientRepository repository, PatientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<PatientDto> findAll() {
        return mapper.toPatientDtoList(repository.findAll());
    }

    @Override
    public PatientDto findById(Long id) {
        return mapper.toPatientDto(
                repository.findById(id).orElse(null)
        );
    }

    @Override
    public PatientDto create(PatientDto patient) {
        return mapper.toPatientDto(
                repository.save(
                        mapper.toPatient(patient)
                )
        );
    }

    @Override
    public PatientDto update(PatientDto patient) {
        return mapper.toPatientDto(repository.save(mapper.toPatient(patient)));
    }

    @Override
    public boolean deleteById(Long id) {
        if  (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
