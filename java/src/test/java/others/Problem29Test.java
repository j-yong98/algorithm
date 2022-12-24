package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem29Test {

    @Test
    void solution() throws IOException {
        Problem29 problem29 = new Problem29();
        String p = "3 2 1 3\n" +
                "1 1 2 \n" +
                "1 2 1\n" +
                "1 1 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem29.solution();
        Assertions.assertThat(solution).isEqualTo(7);
    }

}