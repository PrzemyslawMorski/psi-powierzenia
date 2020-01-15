package edu.psi.powierzenia.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

import edu.psi.powierzenia.domain.enumeration.FieldOfStudy;

import edu.psi.powierzenia.domain.enumeration.Specialization;

import edu.psi.powierzenia.domain.enumeration.StudiesLevel;

import edu.psi.powierzenia.domain.enumeration.StudiesType;

/**
 * A EducationPlan.
 */
@Entity
@Table(name = "education_plan")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class EducationPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "start_academic_year")
    private Integer startAcademicYear;

    @Enumerated(EnumType.STRING)
    @Column(name = "field_of_study")
    private FieldOfStudy fieldOfStudy;

    @Enumerated(EnumType.STRING)
    @Column(name = "specialization")
    private Specialization specialization;

    @Enumerated(EnumType.STRING)
    @Column(name = "studies_level")
    private StudiesLevel studiesLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "studies_type")
    private StudiesType studiesType;

    @ManyToOne
    @JsonIgnoreProperties("educationPlans")
    private EntrustmentPlan educationPlans;

    @ManyToOne
    @JsonIgnoreProperties("educationPlans")
    private Course courses;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStartAcademicYear() {
        return startAcademicYear;
    }

    public EducationPlan startAcademicYear(Integer startAcademicYear) {
        this.startAcademicYear = startAcademicYear;
        return this;
    }

    public void setStartAcademicYear(Integer startAcademicYear) {
        this.startAcademicYear = startAcademicYear;
    }

    public FieldOfStudy getFieldOfStudy() {
        return fieldOfStudy;
    }

    public EducationPlan fieldOfStudy(FieldOfStudy fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
        return this;
    }

    public void setFieldOfStudy(FieldOfStudy fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public EducationPlan specialization(Specialization specialization) {
        this.specialization = specialization;
        return this;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public StudiesLevel getStudiesLevel() {
        return studiesLevel;
    }

    public EducationPlan studiesLevel(StudiesLevel studiesLevel) {
        this.studiesLevel = studiesLevel;
        return this;
    }

    public void setStudiesLevel(StudiesLevel studiesLevel) {
        this.studiesLevel = studiesLevel;
    }

    public StudiesType getStudiesType() {
        return studiesType;
    }

    public EducationPlan studiesType(StudiesType studiesType) {
        this.studiesType = studiesType;
        return this;
    }

    public void setStudiesType(StudiesType studiesType) {
        this.studiesType = studiesType;
    }

    public EntrustmentPlan getEducationPlans() {
        return educationPlans;
    }

    public EducationPlan educationPlans(EntrustmentPlan entrustmentPlan) {
        this.educationPlans = entrustmentPlan;
        return this;
    }

    public void setEducationPlans(EntrustmentPlan entrustmentPlan) {
        this.educationPlans = entrustmentPlan;
    }

    public Course getCourses() {
        return courses;
    }

    public EducationPlan courses(Course course) {
        this.courses = course;
        return this;
    }

    public void setCourses(Course course) {
        this.courses = course;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EducationPlan)) {
            return false;
        }
        return id != null && id.equals(((EducationPlan) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "EducationPlan{" +
            "id=" + getId() +
            ", startAcademicYear=" + getStartAcademicYear() +
            ", fieldOfStudy='" + getFieldOfStudy() + "'" +
            ", specialization='" + getSpecialization() + "'" +
            ", studiesLevel='" + getStudiesLevel() + "'" +
            ", studiesType='" + getStudiesType() + "'" +
            "}";
    }
}
