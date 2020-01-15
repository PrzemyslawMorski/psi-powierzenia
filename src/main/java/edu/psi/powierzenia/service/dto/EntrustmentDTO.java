package edu.psi.powierzenia.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link edu.psi.powierzenia.domain.Entrustment} entity.
 */
public class EntrustmentDTO implements Serializable {

    private Long id;

    private Integer hours;

    private Float hoursMultiplier;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Float getHoursMultiplier() {
        return hoursMultiplier;
    }

    public void setHoursMultiplier(Float hoursMultiplier) {
        this.hoursMultiplier = hoursMultiplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EntrustmentDTO entrustmentDTO = (EntrustmentDTO) o;
        if (entrustmentDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), entrustmentDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "EntrustmentDTO{" +
            "id=" + getId() +
            ", hours=" + getHours() +
            ", hoursMultiplier=" + getHoursMultiplier() +
            "}";
    }
}
