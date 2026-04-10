package cl.duoc.demoJPA.controller;

import cl.duoc.demoJPA.model.Doctor;
import cl.duoc.demoJPA.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Doctor>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> findById(@PathVariable int id) {
        Doctor doctor = service.findById(id);
        if (doctor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(doctor);
    }

    @GetMapping("/filter/{name}")
    public ResponseEntity<List<Doctor>> findByName(@PathVariable String name) {
        List<Doctor> doctors = service.findByName(name);
        if (doctors.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(doctors);
    }
    @GetMapping("/filter/{name}/{lastName}")
    public ResponseEntity<List<Doctor>> findByNameAndLastName(@PathVariable String name, @PathVariable String lastName){
        List<Doctor> doctors = service.findByNameAndLastName(name, lastName);
        if (doctors.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(doctors);
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Doctor doctor) {
        try {
            Doctor createdDoctor = service.create(doctor);
            return ResponseEntity.created(null).body(createdDoctor);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); //.build();
        }
    }
    @PatchMapping()
    public ResponseEntity<Doctor> update(@RequestBody Doctor doctor) {
        try {
            Doctor updatedDoctor = service.update(doctor);
            return ResponseEntity.ok(updatedDoctor);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id){
        return ResponseEntity.ok(service.delete(id));
    }
}
