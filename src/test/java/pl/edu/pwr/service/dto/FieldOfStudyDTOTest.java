package pl.edu.pwr.service.dto;

import org.junit.jupiter.api.Test;
import pl.edu.pwr.web.rest.TestUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class FieldOfStudyDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(FieldOfStudyDTO.class);
        FieldOfStudyDTO fieldOfStudyDTO1 = new FieldOfStudyDTO();
        fieldOfStudyDTO1.setId(1L);
        FieldOfStudyDTO fieldOfStudyDTO2 = new FieldOfStudyDTO();
        assertThat(fieldOfStudyDTO1).isNotEqualTo(fieldOfStudyDTO2);
        fieldOfStudyDTO2.setId(fieldOfStudyDTO1.getId());
        assertThat(fieldOfStudyDTO1).isEqualTo(fieldOfStudyDTO2);
        fieldOfStudyDTO2.setId(2L);
        assertThat(fieldOfStudyDTO1).isNotEqualTo(fieldOfStudyDTO2);
        fieldOfStudyDTO1.setId(null);
        assertThat(fieldOfStudyDTO1).isNotEqualTo(fieldOfStudyDTO2);
    }
}
