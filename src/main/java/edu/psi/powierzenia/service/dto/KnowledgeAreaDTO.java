package edu.psi.powierzenia.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link edu.psi.powierzenia.domain.KnowledgeArea} entity.
 */
public class KnowledgeAreaDTO implements Serializable {

    private Long id;

    private String type;


    private Long courseId;

    private Long teacherId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        KnowledgeAreaDTO knowledgeAreaDTO = (KnowledgeAreaDTO) o;
        if (knowledgeAreaDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), knowledgeAreaDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "KnowledgeAreaDTO{" +
            "id=" + getId() +
            ", type='" + getType() + "'" +
            ", courseId=" + getCourseId() +
            ", teacherId=" + getTeacherId() +
            "}";
    }
}
