package edu.psi.powierzenia.service.mapper;

import edu.psi.powierzenia.domain.*;
import edu.psi.powierzenia.service.dto.EntrustmentDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Entrustment} and its DTO {@link EntrustmentDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EntrustmentMapper extends EntityMapper<EntrustmentDTO, Entrustment> {



    default Entrustment fromId(Long id) {
        if (id == null) {
            return null;
        }
        Entrustment entrustment = new Entrustment();
        entrustment.setId(id);
        return entrustment;
    }
}
