package edu.psi.powierzenia.service.dto;
import java.io.Serializable;
import java.util.Objects;
import edu.psi.powierzenia.domain.enumeration.KnowledgeAreaType;

/**
 * A DTO for the {@link edu.psi.powierzenia.domain.KnowledgeArea} entity.
 */
public class KnowledgeAreaDTO implements Serializable {

    private Long id;

    private KnowledgeAreaType type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KnowledgeAreaType getType() {
        return type;
    }

    public void setType(KnowledgeAreaType type) {
        this.type = type;
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
            "}";
    }
}
