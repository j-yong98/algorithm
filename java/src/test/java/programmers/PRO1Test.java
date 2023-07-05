package programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PRO1Test {
    @Test
    void solution() {
        PRO1 pro1 = new PRO1();
        String[] solution = pro1.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
        String[] ans = new String[]{"AC", "ACDE", "BCFG", "CDE"};
        Assertions.assertThat(solution).isEqualTo(ans);
    }
}