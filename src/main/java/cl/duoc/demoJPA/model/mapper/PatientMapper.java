package cl.duoc.demoJPA.model.mapper;

import cl.duoc.demoJPA.dto.PatientDto;
import cl.duoc.demoJPA.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    Patient toPatient(PatientDto patientDto);

    @Mapping(target = "fullName", expression = "java(patient.getName() + \" \" + patient.getLastName())")
    PatientDto toPatientDto(Patient patient);
    List<PatientDto> toPatientDtoList(List<Patient> patients);
}
