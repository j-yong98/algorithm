import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.SortedMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem7Test {

    @Test
    void solution() throws IOException {
        Problem7 problem7 = new Problem7();
        String p = "5 3\n" +
                "1 2 3\n" +
                "4 8 -2\n" +
                "-1 -3 -2\n" +
                "1 2 3\n" +
                "1 1 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem7.solution();
        assertThat(solution).isEqualTo(6);
    }

}