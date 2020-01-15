package edu.psi.powierzenia.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

import edu.psi.powierzenia.domain.enumeration.TeacherType;

/**
 * A Teacher.
 */
@Entity
@Table(name = "teacher")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "hour_limit")
    private Integer hourLimit;

    @Column(name = "pensum")
    private Integer pensum;

    @Column(name = "agreed_to_additional_pensum")
    private Boolean agreedToAdditionalPensum;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TeacherType type;

    @ManyToOne
    @JsonIgnoreProperties("teachers")
    private Entrustment entrustments;

    @ManyToOne
    @JsonIgnoreProperties("teachers")
    private Course preferedCourses;

    @ManyToOne
    @JsonIgnoreProperties("teachers")
    private KnowledgeArea knowledgeAreas;

    @ManyToOne
    @JsonIgnoreProperties("teachers")
    private ClassForm allowedClassForms;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public Teacher firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Teacher lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public Teacher email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getHourLimit() {
        return hourLimit;
    }

    public Teacher hourLimit(Integer hourLimit) {
        this.hourLimit = hourLimit;
        return this;
    }

    public void setHourLimit(Integer hourLimit) {
        this.hourLimit = hourLimit;
    }

    public Integer getPensum() {
        return pensum;
    }

    public Teacher pensum(Integer pensum) {
        this.pensum = pensum;
        return this;
    }

    public void setPensum(Integer pensum) {
        this.pensum = pensum;
    }

    public Boolean isAgreedToAdditionalPensum() {
        return agreedToAdditionalPensum;
    }

    public Teacher agreedToAdditionalPensum(Boolean agreedToAdditionalPensum) {
        this.agreedToAdditionalPensum = agreedToAdditionalPensum;
        return this;
    }

    public void setAgreedToAdditionalPensum(Boolean agreedToAdditionalPensum) {
        this.agreedToAdditionalPensum = agreedToAdditionalPensum;
    }

    public TeacherType getType() {
        return type;
    }

    public Teacher type(TeacherType type) {
        this.type = type;
        return this;
    }

    public void setType(TeacherType type) {
        this.type = type;
    }

    public Entrustment getEntrustments() {
        return entrustments;
    }

    public Teacher entrustments(Entrustment entrustment) {
        this.entrustments = entrustment;
        return this;
    }

    public void setEntrustments(Entrustment entrustment) {
        this.entrustments = entrustment;
    }

    public Course getPreferedCourses() {
        return preferedCourses;
    }

    public Teacher preferedCourses(Course course) {
        this.preferedCourses = course;
        return this;
    }

    public void setPreferedCourses(Course course) {
        this.preferedCourses = course;
    }

    public KnowledgeArea getKnowledgeAreas() {
        return knowledgeAreas;
    }

    public Teacher knowledgeAreas(KnowledgeArea knowledgeArea) {
        this.knowledgeAreas = knowledgeArea;
        return this;
    }

    public void setKnowledgeAreas(KnowledgeArea knowledgeArea) {
        this.knowledgeAreas = knowledgeArea;
    }

    public ClassForm getAllowedClassForms() {
        return allowedClassForms;
    }

    public Teacher allowedClassForms(ClassForm classForm) {
        this.allowedClassForms = classForm;
        return this;
    }

    public void setAllowedClassForms(ClassForm classForm) {
        this.allowedClassForms = classForm;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Teacher)) {
            return false;
        }
        return id != null && id.equals(((Teacher) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Teacher{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", hourLimit=" + getHourLimit() +
            ", pensum=" + getPensum() +
            ", agreedToAdditionalPensum='" + isAgreedToAdditionalPensum() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }
}
