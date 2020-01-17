package edu.psi.powierzenia.domain;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A FieldOfStudy.
 */
@Entity
@Table(name = "field_of_study")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class FieldOfStudy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "fieldOfStudy")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<EducationPlan> educationPlans = new HashSet<>();

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

    public FieldOfStudy name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<EducationPlan> getEducationPlans() {
        return educationPlans;
    }

    public FieldOfStudy educationPlans(Set<EducationPlan> educationPlans) {
        this.educationPlans = educationPlans;
        return this;
    }

    public FieldOfStudy addEducationPlans(EducationPlan educationPlan) {
        this.educationPlans.add(educationPlan);
        educationPlan.setFieldOfStudy(this);
        return this;
    }

    public FieldOfStudy removeEducationPlans(EducationPlan educationPlan) {
        this.educationPlans.remove(educationPlan);
        educationPlan.setFieldOfStudy(null);
        return this;
    }

    public void setEducationPlans(Set<EducationPlan> educationPlans) {
        this.educationPlans = educationPlans;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FieldOfStudy)) {
            return false;
        }
        return id != null && id.equals(((FieldOfStudy) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "FieldOfStudy{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
