package cl.duoc.demoJPA.service.impl;

import cl.duoc.demoJPA.dto.DoctorDto;
import cl.duoc.demoJPA.model.Doctor;
import cl.duoc.demoJPA.model.mapper.DoctorMapper;
import cl.duoc.demoJPA.repository.DoctorRepository;
import cl.duoc.demoJPA.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository repository;
    private final DoctorMapper mapper;



    public List<DoctorDto> findAll(){
        return mapper.toDtoList(repository.findAll());
    }

    public DoctorDto findById(Long id){
        return mapper.toDto(
                repository.findById(id)
                        .orElse(null)
        );
    }

    public List<DoctorDto> findByName(String name){
        return mapper.toDtoList(repository.findByName(name));
    }

    public List<DoctorDto> findByNameAndLastName(String name, String lastName){
        return mapper.toDtoList(repository.findByNameAndLastName(name, lastName));
    }

    public DoctorDto create(DoctorDto doctor) {
        if (repository.findById(doctor.getId()).isPresent()) {
            throw new RuntimeException("Doctor with id " + doctor.getId() + " already exists");
        }
        return mapper.toDto(
                repository.save(
                    mapper.fromDto(doctor)
                )
        );
    }

    public DoctorDto update(Long id, DoctorDto doctor){
        if (repository.findById(id).isEmpty()) {
            throw new RuntimeException("Doctor with id " + id + " does not exist");
        }
        return mapper.toDto(repository.save(mapper.fromDto(doctor)));
    }

    public boolean delete(Long id){
        boolean exist = repository.existsById(id);
        repository.deleteById(id);
        return exist;
    }
}
