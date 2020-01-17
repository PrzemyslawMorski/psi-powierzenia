package edu.psi.powierzenia.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Course.
 */
@Entity
@Table(name = "course")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "course")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<CourseClass> classes = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "course_tags",
               joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "tags_id", referencedColumnName = "id"))
    private Set<KnowledgeArea> tags = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("courses")
    private EducationPlan educationPlan;

    @ManyToMany(mappedBy = "preferedCourses")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<Teacher> teachersThatPreferThisCourses = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Course name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public Course code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<CourseClass> getClasses() {
        return classes;
    }

    public Course classes(Set<CourseClass> courseClasses) {
        this.classes = courseClasses;
        return this;
    }

    public Course addClasses(CourseClass courseClass) {
        this.classes.add(courseClass);
        courseClass.setCourse(this);
        return this;
    }

    public Course removeClasses(CourseClass courseClass) {
        this.classes.remove(courseClass);
        courseClass.setCourse(null);
        return this;
    }

    public void setClasses(Set<CourseClass> courseClasses) {
        this.classes = courseClasses;
    }

    public Set<KnowledgeArea> getTags() {
        return tags;
    }

    public Course tags(Set<KnowledgeArea> knowledgeAreas) {
        this.tags = knowledgeAreas;
        return this;
    }

    public Course addTags(KnowledgeArea knowledgeArea) {
        this.tags.add(knowledgeArea);
        knowledgeArea.getCoursesWithThisKnowledgeAreas().add(this);
        return this;
    }

    public Course removeTags(KnowledgeArea knowledgeArea) {
        this.tags.remove(knowledgeArea);
        knowledgeArea.getCoursesWithThisKnowledgeAreas().remove(this);
        return this;
    }

    public void setTags(Set<KnowledgeArea> knowledgeAreas) {
        this.tags = knowledgeAreas;
    }

    public EducationPlan getEducationPlan() {
        return educationPlan;
    }

    public Course educationPlan(EducationPlan educationPlan) {
        this.educationPlan = educationPlan;
        return this;
    }

    public void setEducationPlan(EducationPlan educationPlan) {
        this.educationPlan = educationPlan;
    }

    public Set<Teacher> getTeachersThatPreferThisCourses() {
        return teachersThatPreferThisCourses;
    }

    public Course teachersThatPreferThisCourses(Set<Teacher> teachers) {
        this.teachersThatPreferThisCourses = teachers;
        return this;
    }

    public Course addTeachersThatPreferThisCourse(Teacher teacher) {
        this.teachersThatPreferThisCourses.add(teacher);
        teacher.getPreferedCourses().add(this);
        return this;
    }

    public Course removeTeachersThatPreferThisCourse(Teacher teacher) {
        this.teachersThatPreferThisCourses.remove(teacher);
        teacher.getPreferedCourses().remove(this);
        return this;
    }

    public void setTeachersThatPreferThisCourses(Set<Teacher> teachers) {
        this.teachersThatPreferThisCourses = teachers;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Course)) {
            return false;
        }
        return id != null && id.equals(((Course) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Course{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", code='" + getCode() + "'" +
            "}";
    }
}
