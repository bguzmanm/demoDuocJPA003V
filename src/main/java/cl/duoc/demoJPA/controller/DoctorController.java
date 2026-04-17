package cl.duoc.demoJPA.controller;

import cl.duoc.demoJPA.dto.DoctorDto;
import cl.duoc.demoJPA.model.Doctor;
import cl.duoc.demoJPA.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<DoctorDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> findById(@PathVariable long id) {
        DoctorDto doctor = service.findById(id);
        if (doctor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(doctor);
    }

    @GetMapping("/filter/{name}")
    public ResponseEntity<List<DoctorDto>> findByName(@PathVariable String name) {
        List<DoctorDto> doctors = service.findByName(name);
        if (doctors.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(doctors);
    }
    @GetMapping("/filter/{name}/{lastName}")
    public ResponseEntity<List<DoctorDto>> findByNameAndLastName(@PathVariable String name, @PathVariable String lastName){
        List<DoctorDto> doctors = service.findByNameAndLastName(name, lastName);
        if (doctors.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(doctors);
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody DoctorDto doctor) {
        try {
            DoctorDto createdDoctor = service.create(doctor);
            return ResponseEntity.created(null).body(createdDoctor);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); //.build();
        }
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody DoctorDto doctor) {
        try {
            DoctorDto updatedDoctor = service.update(id, doctor);
            return ResponseEntity.ok(updatedDoctor);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable long id){
        return ResponseEntity.ok(service.delete(id));
    }
}
