package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem75Test {

    @Test
    void solution() throws IOException {
        Problem75 problem75 = new Problem75();
        String p = "3\n" +
                "4 3 2\n" +
                "3 4 5\n" +
                "4 2 8\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem75.solution();
        Assertions.assertThat(solution).isEqualTo(3);
    }

}