package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem26Test {

    @Test
    void solution() throws IOException {
        Problem26 problem26 = new Problem26();
        String p = "4 4\n" +
                "1 3 2 11\n" +
                "4 9 6 9\n" +
                "2 6 9 8\n" +
                "1 9 10 7\n" +
                "4 3\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int[] solution = problem26.solution();
        Assertions.assertThat(solution).isEqualTo(new int[]{1,2});
    }

}