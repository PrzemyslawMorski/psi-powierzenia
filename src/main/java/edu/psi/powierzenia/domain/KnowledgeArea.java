package edu.psi.powierzenia.domain;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

import edu.psi.powierzenia.domain.enumeration.KnowledgeAreaType;

/**
 * A KnowledgeArea.
 */
@Entity
@Table(name = "knowledge_area")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class KnowledgeArea implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private KnowledgeAreaType type;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KnowledgeAreaType getType() {
        return type;
    }

    public KnowledgeArea type(KnowledgeAreaType type) {
        this.type = type;
        return this;
    }

    public void setType(KnowledgeAreaType type) {
        this.type = type;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KnowledgeArea)) {
            return false;
        }
        return id != null && id.equals(((KnowledgeArea) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "KnowledgeArea{" +
            "id=" + getId() +
            ", type='" + getType() + "'" +
            "}";
    }
}
