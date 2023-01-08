package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem90Test {

    @Test
    void solution() throws IOException {
        Problem90 problem90 = new Problem90();
        String p = "4 20\n" +
                "10 20\n" +
                "15 25\n" +
                "5 15\n" +
                "9 19\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem90.solution();
        Assertions.assertThat(solution).isEqualTo(40);
    }

}