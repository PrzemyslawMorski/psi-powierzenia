package edu.psi.powierzenia.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

import edu.psi.powierzenia.domain.enumeration.SemesterType;

/**
 * A EntrustmentPlan.
 */
@Entity
@Table(name = "entrustment_plan")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class EntrustmentPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "academic_year")
    private Integer academicYear;

    @Enumerated(EnumType.STRING)
    @Column(name = "semester_type")
    private SemesterType semesterType;

    @ManyToOne
    @JsonIgnoreProperties("entrustmentPlans")
    private Entrustment entrustments;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAcademicYear() {
        return academicYear;
    }

    public EntrustmentPlan academicYear(Integer academicYear) {
        this.academicYear = academicYear;
        return this;
    }

    public void setAcademicYear(Integer academicYear) {
        this.academicYear = academicYear;
    }

    public SemesterType getSemesterType() {
        return semesterType;
    }

    public EntrustmentPlan semesterType(SemesterType semesterType) {
        this.semesterType = semesterType;
        return this;
    }

    public void setSemesterType(SemesterType semesterType) {
        this.semesterType = semesterType;
    }

    public Entrustment getEntrustments() {
        return entrustments;
    }

    public EntrustmentPlan entrustments(Entrustment entrustment) {
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
        if (!(o instanceof EntrustmentPlan)) {
            return false;
        }
        return id != null && id.equals(((EntrustmentPlan) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "EntrustmentPlan{" +
            "id=" + getId() +
            ", academicYear=" + getAcademicYear() +
            ", semesterType='" + getSemesterType() + "'" +
            "}";
    }
}
