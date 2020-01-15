package edu.psi.powierzenia.service.mapper;

import edu.psi.powierzenia.domain.*;
import edu.psi.powierzenia.service.dto.ClassFormDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ClassForm} and its DTO {@link ClassFormDTO}.
 */
@Mapper(componentModel = "spring", uses = {TeacherMapper.class})
public interface ClassFormMapper extends EntityMapper<ClassFormDTO, ClassForm> {

    @Mapping(source = "teacher.id", target = "teacherId")
    ClassFormDTO toDto(ClassForm classForm);

    @Mapping(source = "teacherId", target = "teacher")
    ClassForm toEntity(ClassFormDTO classFormDTO);

    default ClassForm fromId(Long id) {
        if (id == null) {
            return null;
        }
        ClassForm classForm = new ClassForm();
        classForm.setId(id);
        return classForm;
    }
}
