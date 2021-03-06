package pl.edu.pwr.service.dto;

import org.junit.jupiter.api.Test;
import pl.edu.pwr.web.rest.TestUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassFormDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ClassFormDTO.class);
        ClassFormDTO classFormDTO1 = new ClassFormDTO();
        classFormDTO1.setId(1L);
        ClassFormDTO classFormDTO2 = new ClassFormDTO();
        assertThat(classFormDTO1).isNotEqualTo(classFormDTO2);
        classFormDTO2.setId(classFormDTO1.getId());
        assertThat(classFormDTO1).isEqualTo(classFormDTO2);
        classFormDTO2.setId(2L);
        assertThat(classFormDTO1).isNotEqualTo(classFormDTO2);
        classFormDTO1.setId(null);
        assertThat(classFormDTO1).isNotEqualTo(classFormDTO2);
    }
}
