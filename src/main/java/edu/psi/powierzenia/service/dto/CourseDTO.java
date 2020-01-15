package edu.psi.powierzenia.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link edu.psi.powierzenia.domain.Course} entity.
 */
public class CourseDTO implements Serializable {

    private Long id;

    private String name;

    private String code;


    private Long classesId;

    private Long tagsId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getClassesId() {
        return classesId;
    }

    public void setClassesId(Long courseClassId) {
        this.classesId = courseClassId;
    }

    public Long getTagsId() {
        return tagsId;
    }

    public void setTagsId(Long knowledgeAreaId) {
        this.tagsId = knowledgeAreaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CourseDTO courseDTO = (CourseDTO) o;
        if (courseDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), courseDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", code='" + getCode() + "'" +
            ", classesId=" + getClassesId() +
            ", tagsId=" + getTagsId() +
            "}";
    }
}
