package pl.edu.pwr.domain;

import org.junit.jupiter.api.Test;
import pl.edu.pwr.web.rest.TestUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class EntrustmentPlanTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(EntrustmentPlan.class);
        EntrustmentPlan entrustmentPlan1 = new EntrustmentPlan();
        entrustmentPlan1.setId(1L);
        EntrustmentPlan entrustmentPlan2 = new EntrustmentPlan();
        entrustmentPlan2.setId(entrustmentPlan1.getId());
        assertThat(entrustmentPlan1).isEqualTo(entrustmentPlan2);
        entrustmentPlan2.setId(2L);
        assertThat(entrustmentPlan1).isNotEqualTo(entrustmentPlan2);
        entrustmentPlan1.setId(null);
        assertThat(entrustmentPlan1).isNotEqualTo(entrustmentPlan2);
    }
}
