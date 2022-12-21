import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

class Problem9Test {
    @Test
    void solution() throws IOException {
        Problem9 problem9 = new Problem9();
        String[] input = {"2","7"};
        int[] answer = {1,13};
        for (int i = 0; i < input.length; i++) {
            System.setIn(new ByteArrayInputStream(input[i].getBytes()));
            int solution = problem9.solution();
            assertThat(solution).isEqualTo(answer[i]);
        }
    }

}