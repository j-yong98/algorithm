package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem57Test {
    @Test
    void solution() throws IOException {
        Problem57 problem57 = new Problem57();
        String p = "3\n" +
                "2 8 9\n" +
                "6 4 5\n" +
                "3 7 1\n" +
                "5 3 1\n" +
                "6 3 7\n" +
                "2 4 8\n" +
                "3 3\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem57.solution();
        Assertions.assertThat(solution).isEqualTo(5);
    }

}