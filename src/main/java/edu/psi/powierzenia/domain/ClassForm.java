package edu.psi.powierzenia.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

import edu.psi.powierzenia.domain.enumeration.ClassFormType;

/**
 * A ClassForm.
 */
@Entity
@Table(name = "class_form")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ClassForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ClassFormType type;

    @ManyToOne
    @JsonIgnoreProperties("allowedClassForms")
    private Teacher teacher;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClassFormType getType() {
        return type;
    }

    public ClassForm type(ClassFormType type) {
        this.type = type;
        return this;
    }

    public void setType(ClassFormType type) {
        this.type = type;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public ClassForm teacher(Teacher teacher) {
        this.teacher = teacher;
        return this;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ClassForm)) {
            return false;
        }
        return id != null && id.equals(((ClassForm) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ClassForm{" +
            "id=" + getId() +
            ", type='" + getType() + "'" +
            "}";
    }
}
