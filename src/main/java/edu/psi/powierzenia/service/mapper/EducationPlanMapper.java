package edu.psi.powierzenia.service.mapper;

import edu.psi.powierzenia.domain.*;
import edu.psi.powierzenia.service.dto.EducationPlanDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link EducationPlan} and its DTO {@link EducationPlanDTO}.
 */
@Mapper(componentModel = "spring", uses = {EntrustmentPlanMapper.class, CourseMapper.class})
public interface EducationPlanMapper extends EntityMapper<EducationPlanDTO, EducationPlan> {

    @Mapping(source = "educationPlans.id", target = "educationPlansId")
    @Mapping(source = "courses.id", target = "coursesId")
    EducationPlanDTO toDto(EducationPlan educationPlan);

    @Mapping(source = "educationPlansId", target = "educationPlans")
    @Mapping(source = "coursesId", target = "courses")
    EducationPlan toEntity(EducationPlanDTO educationPlanDTO);

    default EducationPlan fromId(Long id) {
        if (id == null) {
            return null;
        }
        EducationPlan educationPlan = new EducationPlan();
        educationPlan.setId(id);
        return educationPlan;
    }
}
