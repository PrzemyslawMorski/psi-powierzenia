package edu.psi.powierzenia.service.dto;
import java.io.Serializable;
import java.util.Objects;
import edu.psi.powierzenia.domain.enumeration.SemesterType;

/**
 * A DTO for the {@link edu.psi.powierzenia.domain.EntrustmentPlan} entity.
 */
public class EntrustmentPlanDTO implements Serializable {

    private Long id;

    private Integer academicYear;

    private SemesterType semesterType;


    private Long entrustmentsId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(Integer academicYear) {
        this.academicYear = academicYear;
    }

    public SemesterType getSemesterType() {
        return semesterType;
    }

    public void setSemesterType(SemesterType semesterType) {
        this.semesterType = semesterType;
    }

    public Long getEntrustmentsId() {
        return entrustmentsId;
    }

    public void setEntrustmentsId(Long entrustmentId) {
        this.entrustmentsId = entrustmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EntrustmentPlanDTO entrustmentPlanDTO = (EntrustmentPlanDTO) o;
        if (entrustmentPlanDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), entrustmentPlanDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EntrustmentPlanDTO{" +
            "id=" + getId() +
            ", academicYear=" + getAcademicYear() +
            ", semesterType='" + getSemesterType() + "'" +
            ", entrustmentsId=" + getEntrustmentsId() +
            "}";
    }
}
