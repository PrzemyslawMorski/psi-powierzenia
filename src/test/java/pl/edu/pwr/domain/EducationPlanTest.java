package pl.edu.pwr.domain;

import org.junit.jupiter.api.Test;
import pl.edu.pwr.web.rest.TestUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class EducationPlanTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(EducationPlan.class);
        EducationPlan educationPlan1 = new EducationPlan();
        educationPlan1.setId(1L);
        EducationPlan educationPlan2 = new EducationPlan();
        educationPlan2.setId(educationPlan1.getId());
        assertThat(educationPlan1).isEqualTo(educationPlan2);
        educationPlan2.setId(2L);
        assertThat(educationPlan1).isNotEqualTo(educationPlan2);
        educationPlan1.setId(null);
        assertThat(educationPlan1).isNotEqualTo(educationPlan2);
    }
}
