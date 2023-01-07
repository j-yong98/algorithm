package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem85Test {
    @Test
    void solution() throws IOException {
        Problem85 problem85 = new Problem85();
        String p = "3 9\n" +
                "1 3 8\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem85.solution();
        Assertions.assertThat(solution).isEqualTo(2);
    }
}