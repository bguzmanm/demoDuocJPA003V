package cl.duoc.demoJPA.config;

import cl.duoc.demoJPA.model.Doctor;
import cl.duoc.demoJPA.model.Patient;
import cl.duoc.demoJPA.model.Products;
import cl.duoc.demoJPA.repository.DoctorRepository;
import cl.duoc.demoJPA.repository.PatientRepository;
import cl.duoc.demoJPA.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ProductsRepository productsRepository;


    @Override
    public void run(String... args) throws Exception {
        if (doctorRepository.count() == 0) {
            log.info(">>> DataInitializer: Tabla Doctor vacía detectada, insertando datos de prueba...");

            // Aquí puedes agregar código para insertar doctores y pacientes de prueba.
            doctorRepository.save(new Doctor(null, "Juan", "Perez", "juan.perez@doctor.cl", "5555", "1980-05-10"));
            doctorRepository.save(new Doctor(null, "Pedro", "Muñoz", "pedro.munoz@doctor.cl", "6666", "1979-10-05"));
        }

        if (patientRepository.count() == 0) {
            log.info(">>> DataInitializer: Tabla Pacientes vacía detectada, insertando datos de prueba...");

            patientRepository.save(new Patient(null, "Maria", "Gonzalez", "maria.gonzalez@paciente.cl", "555555"));
            patientRepository.save(new Patient(null, "José", "Mendez", "jose.mendez@paciente.cl", "6666666"));

        }

        if (productsRepository.count() == 0) {
            log.info(">>> DataInitializer: Tabla Products vacía detectada, insertando datos de prueba...");
            productsRepository.save(new Products(null, "Producto 1", 10, 20));
            productsRepository.save(new Products(null, "Producto 2", 20, 10));

        }

        return;

    }
}
