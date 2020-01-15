package edu.psi.powierzenia.service.mapper;

import edu.psi.powierzenia.domain.*;
import edu.psi.powierzenia.service.dto.CourseDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Course} and its DTO {@link CourseDTO}.
 */
@Mapper(componentModel = "spring", uses = {CourseClassMapper.class, KnowledgeAreaMapper.class})
public interface CourseMapper extends EntityMapper<CourseDTO, Course> {

    @Mapping(source = "classes.id", target = "classesId")
    @Mapping(source = "tags.id", target = "tagsId")
    CourseDTO toDto(Course course);

    @Mapping(source = "classesId", target = "classes")
    @Mapping(source = "tagsId", target = "tags")
    Course toEntity(CourseDTO courseDTO);

    default Course fromId(Long id) {
        if (id == null) {
            return null;
        }
        Course course = new Course();
        course.setId(id);
        return course;
    }
}
