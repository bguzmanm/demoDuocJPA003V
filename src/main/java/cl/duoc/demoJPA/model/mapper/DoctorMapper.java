package cl.duoc.demoJPA.model.mapper;

import cl.duoc.demoJPA.dto.DoctorDto;
import cl.duoc.demoJPA.model.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    DoctorDto toDto(Doctor doctor);
    Doctor fromDto(DoctorDto doctorDto);
    List<DoctorDto> toDtoList(List<Doctor> doctors);
}
