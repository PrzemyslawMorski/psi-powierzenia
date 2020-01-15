package edu.psi.powierzenia.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

import edu.psi.powierzenia.domain.enumeration.ClassFormType;

/**
 * A CourseClass.
 */
@Entity
@Table(name = "course_class")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CourseClass implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "hours")
    private Integer hours;

    @Enumerated(EnumType.STRING)
    @Column(name = "form")
    private ClassFormType form;

    @ManyToOne
    @JsonIgnoreProperties("courseClasses")
    private Entrustment entrustments;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHours() {
        return hours;
    }

    public CourseClass hours(Integer hours) {
        this.hours = hours;
        return this;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public ClassFormType getForm() {
        return form;
    }

    public CourseClass form(ClassFormType form) {
        this.form = form;
        return this;
    }

    public void setForm(ClassFormType form) {
        this.form = form;
    }

    public Entrustment getEntrustments() {
        return entrustments;
    }

    public CourseClass entrustments(Entrustment entrustment) {
        this.entrustments = entrustment;
        return this;
    }

    public void setEntrustments(Entrustment entrustment) {
        this.entrustments = entrustment;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CourseClass)) {
            return false;
        }
        return id != null && id.equals(((CourseClass) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "CourseClass{" +
            "id=" + getId() +
            ", hours=" + getHours() +
            ", form='" + getForm() + "'" +
            "}";
    }
}
