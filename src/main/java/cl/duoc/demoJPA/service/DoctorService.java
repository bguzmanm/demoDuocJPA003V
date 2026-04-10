package cl.duoc.demoJPA.service;

import cl.duoc.demoJPA.model.Doctor;
import cl.duoc.demoJPA.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository repository;

    public DoctorService(DoctorRepository repository) {
        this.repository = repository;
    }

    public List<Doctor> findAll(){
        return repository.findAll();
    }

    public Doctor findById(int id){
        return repository.findById(id).orElse(null);
    }

    public List<Doctor> findByName(String name){
        return repository.findByName(name);
    }

    public List<Doctor> findByNameAndLastName(String name, String lastName){
        return repository.findByNameAndLastName(name, lastName);
    }

    public Doctor create(Doctor doctor) {
        if (repository.findById(doctor.getId()).isPresent()) {
            throw new RuntimeException("Doctor with id " + doctor.getId() + " already exists");
        }
        return repository.save(doctor);
    }

    public Doctor update(Doctor doctor){
        if (repository.findById(doctor.getId()).isEmpty()) {
            throw new RuntimeException("Doctor with id " + doctor.getId() + " does not exist");
        }
        return repository.save(doctor);
    }

    public boolean delete(int id){
        boolean exist = repository.existsById(id);
        repository.deleteById(id);
        return exist;
    }
}
