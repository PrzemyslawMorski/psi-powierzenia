package edu.psi.powierzenia.service.mapper;

import edu.psi.powierzenia.domain.*;
import edu.psi.powierzenia.service.dto.TeacherDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Teacher} and its DTO {@link TeacherDTO}.
 */
@Mapper(componentModel = "spring", uses = {EntrustmentMapper.class, CourseMapper.class, KnowledgeAreaMapper.class, ClassFormMapper.class})
public interface TeacherMapper extends EntityMapper<TeacherDTO, Teacher> {

    @Mapping(source = "entrustments.id", target = "entrustmentsId")
    @Mapping(source = "preferedCourses.id", target = "preferedCoursesId")
    @Mapping(source = "knowledgeAreas.id", target = "knowledgeAreasId")
    @Mapping(source = "allowedClassForms.id", target = "allowedClassFormsId")
    TeacherDTO toDto(Teacher teacher);

    @Mapping(source = "entrustmentsId", target = "entrustments")
    @Mapping(source = "preferedCoursesId", target = "preferedCourses")
    @Mapping(source = "knowledgeAreasId", target = "knowledgeAreas")
    @Mapping(source = "allowedClassFormsId", target = "allowedClassForms")
    Teacher toEntity(TeacherDTO teacherDTO);

    default Teacher fromId(Long id) {
        if (id == null) {
            return null;
        }
        Teacher teacher = new Teacher();
        teacher.setId(id);
        return teacher;
    }
}
