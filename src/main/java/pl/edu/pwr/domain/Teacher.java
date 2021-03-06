package pl.edu.pwr.domain;

import pl.edu.pwr.domain.enumeration.TeacherType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Teacher.
 */
@Entity
@Table(name = "teacher")
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

    @OneToMany(mappedBy = "teacher")
    private Set<Entrustment> entrustments = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "teacher_allowed_class_forms",
        joinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "allowed_class_forms_id", referencedColumnName = "id"))
    private Set<ClassForm> allowedClassForms = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "teacher_knowledge_areas",
        joinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "knowledge_areas_id", referencedColumnName = "id"))
    private Set<KnowledgeArea> knowledgeAreas = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "teacher_prefered_courses",
        joinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "prefered_courses_id", referencedColumnName = "id"))
    private Set<Course> preferedCourses = new HashSet<>();

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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Teacher firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Teacher lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Teacher email(String email) {
        this.email = email;
        return this;
    }

    public Integer getHourLimit() {
        return hourLimit;
    }

    public void setHourLimit(Integer hourLimit) {
        this.hourLimit = hourLimit;
    }

    public Teacher hourLimit(Integer hourLimit) {
        this.hourLimit = hourLimit;
        return this;
    }

    public Integer getPensum() {
        return pensum;
    }

    public void setPensum(Integer pensum) {
        this.pensum = pensum;
    }

    public Teacher pensum(Integer pensum) {
        this.pensum = pensum;
        return this;
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

    public void setType(TeacherType type) {
        this.type = type;
    }

    public Teacher type(TeacherType type) {
        this.type = type;
        return this;
    }

    public Set<Entrustment> getEntrustments() {
        return entrustments;
    }

    public void setEntrustments(Set<Entrustment> entrustments) {
        this.entrustments = entrustments;
    }

    public Teacher entrustments(Set<Entrustment> entrustments) {
        this.entrustments = entrustments;
        return this;
    }

    public Teacher addEntrustments(Entrustment entrustment) {
        this.entrustments.add(entrustment);
        entrustment.setTeacher(this);
        return this;
    }

    public Teacher removeEntrustments(Entrustment entrustment) {
        this.entrustments.remove(entrustment);
        entrustment.setTeacher(null);
        return this;
    }

    public Set<ClassForm> getAllowedClassForms() {
        return allowedClassForms;
    }

    public void setAllowedClassForms(Set<ClassForm> classForms) {
        this.allowedClassForms = classForms;
    }

    public Teacher allowedClassForms(Set<ClassForm> classForms) {
        this.allowedClassForms = classForms;
        return this;
    }

    public Teacher addAllowedClassForms(ClassForm classForm) {
        this.allowedClassForms.add(classForm);
        classForm.getTeachersAllowedToTeachThisForms().add(this);
        return this;
    }

    public Teacher removeAllowedClassForms(ClassForm classForm) {
        this.allowedClassForms.remove(classForm);
        classForm.getTeachersAllowedToTeachThisForms().remove(this);
        return this;
    }

    public Set<KnowledgeArea> getKnowledgeAreas() {
        return knowledgeAreas;
    }

    public void setKnowledgeAreas(Set<KnowledgeArea> knowledgeAreas) {
        this.knowledgeAreas = knowledgeAreas;
    }

    public Teacher knowledgeAreas(Set<KnowledgeArea> knowledgeAreas) {
        this.knowledgeAreas = knowledgeAreas;
        return this;
    }

    public Teacher addKnowledgeAreas(KnowledgeArea knowledgeArea) {
        this.knowledgeAreas.add(knowledgeArea);
        knowledgeArea.getTeachersWithThisKnowledgeAreas().add(this);
        return this;
    }

    public Teacher removeKnowledgeAreas(KnowledgeArea knowledgeArea) {
        this.knowledgeAreas.remove(knowledgeArea);
        knowledgeArea.getTeachersWithThisKnowledgeAreas().remove(this);
        return this;
    }

    public Set<Course> getPreferedCourses() {
        return preferedCourses;
    }

    public void setPreferedCourses(Set<Course> courses) {
        this.preferedCourses = courses;
    }

    public Teacher preferedCourses(Set<Course> courses) {
        this.preferedCourses = courses;
        return this;
    }

    public Teacher addPreferedCourses(Course course) {
        this.preferedCourses.add(course);
        course.getTeachersThatPreferThisCourses().add(this);
        return this;
    }

    public Teacher removePreferedCourses(Course course) {
        this.preferedCourses.remove(course);
        course.getTeachersThatPreferThisCourses().remove(this);
        return this;
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
