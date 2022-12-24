package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem28Test {

    @Test
    void solution() throws IOException {
        Problem28 problem28 = new Problem28();
        String p = "6 7\n" +
                "0 0 0 0 0 0 0\n" +
                "0 1 1 1 1 0 0\n" +
                "0 1 1 0 1 1 0\n" +
                "0 1 0 1 1 1 0\n" +
                "0 1 1 1 1 1 0\n" +
                "0 0 0 0 0 0 0\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int[] solution = problem28.solution();

        Assertions.assertThat(solution).isEqualTo(new int[]{2, 4});
    }

}