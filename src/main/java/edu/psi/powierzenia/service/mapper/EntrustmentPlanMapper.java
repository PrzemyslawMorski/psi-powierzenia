package edu.psi.powierzenia.service.mapper;

import edu.psi.powierzenia.domain.*;
import edu.psi.powierzenia.service.dto.EntrustmentPlanDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link EntrustmentPlan} and its DTO {@link EntrustmentPlanDTO}.
 */
@Mapper(componentModel = "spring", uses = {EntrustmentMapper.class})
public interface EntrustmentPlanMapper extends EntityMapper<EntrustmentPlanDTO, EntrustmentPlan> {

    @Mapping(source = "entrustments.id", target = "entrustmentsId")
    EntrustmentPlanDTO toDto(EntrustmentPlan entrustmentPlan);

    @Mapping(source = "entrustmentsId", target = "entrustments")
    EntrustmentPlan toEntity(EntrustmentPlanDTO entrustmentPlanDTO);

    default EntrustmentPlan fromId(Long id) {
        if (id == null) {
            return null;
        }
        EntrustmentPlan entrustmentPlan = new EntrustmentPlan();
        entrustmentPlan.setId(id);
        return entrustmentPlan;
    }
}
