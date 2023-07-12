package programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PRO4Test {
    @Test
    void solution() {
        PRO4 pro4 = new PRO4();
        long solution = pro4.solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0});
        Assertions.assertThat(solution).isEqualTo(16);
    }
}