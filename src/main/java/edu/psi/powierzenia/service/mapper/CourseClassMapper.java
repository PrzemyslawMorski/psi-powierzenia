package edu.psi.powierzenia.service.mapper;

import edu.psi.powierzenia.domain.*;
import edu.psi.powierzenia.service.dto.CourseClassDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link CourseClass} and its DTO {@link CourseClassDTO}.
 */
@Mapper(componentModel = "spring", uses = {EntrustmentMapper.class})
public interface CourseClassMapper extends EntityMapper<CourseClassDTO, CourseClass> {

    @Mapping(source = "entrustments.id", target = "entrustmentsId")
    CourseClassDTO toDto(CourseClass courseClass);

    @Mapping(source = "entrustmentsId", target = "entrustments")
    CourseClass toEntity(CourseClassDTO courseClassDTO);

    default CourseClass fromId(Long id) {
        if (id == null) {
            return null;
        }
        CourseClass courseClass = new CourseClass();
        courseClass.setId(id);
        return courseClass;
    }
}
