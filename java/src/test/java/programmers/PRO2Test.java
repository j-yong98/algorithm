package programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PRO2Test {
    @Test
    void solution() {
        PRO2 pro2 = new PRO2();
        long solution = pro2.solution(new int[]{2, 3, -6, 1, 3, -1, 2, 4});
        Assertions.assertThat(solution).isEqualTo(10);
    }
}