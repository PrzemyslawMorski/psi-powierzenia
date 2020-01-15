package edu.psi.powierzenia.service.mapper;

import edu.psi.powierzenia.domain.*;
import edu.psi.powierzenia.service.dto.KnowledgeAreaDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link KnowledgeArea} and its DTO {@link KnowledgeAreaDTO}.
 */
@Mapper(componentModel = "spring", uses = {CourseMapper.class, TeacherMapper.class})
public interface KnowledgeAreaMapper extends EntityMapper<KnowledgeAreaDTO, KnowledgeArea> {

    @Mapping(source = "course.id", target = "courseId")
    @Mapping(source = "teacher.id", target = "teacherId")
    KnowledgeAreaDTO toDto(KnowledgeArea knowledgeArea);

    @Mapping(source = "courseId", target = "course")
    @Mapping(source = "teacherId", target = "teacher")
    KnowledgeArea toEntity(KnowledgeAreaDTO knowledgeAreaDTO);

    default KnowledgeArea fromId(Long id) {
        if (id == null) {
            return null;
        }
        KnowledgeArea knowledgeArea = new KnowledgeArea();
        knowledgeArea.setId(id);
        return knowledgeArea;
    }
}
