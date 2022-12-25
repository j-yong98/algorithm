package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem32Test {

    @Test
    void solution() throws IOException {
        Problem32 problem32 = new Problem32();
        String p = "4 4 2 3\n" +
                "L D R U\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem32.solution();

        Assertions.assertThat(solution).isEqualTo(16);
    }

}