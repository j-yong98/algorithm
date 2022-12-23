package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import others.Problem11;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem11Test {

    @Test
    void solution() throws IOException {
        Problem11 problem11 = new Problem11();
        String p = "4 6 1\n" +
                "4 5 2 5 6 6\n" +
                "2 6 1 0 5 5\n" +
                "5 1 2 1 6 6\n" +
                "4 2 5 2 8 8\n" +
                "2 2 4 6\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int[][] solution = problem11.solution();
        Assertions.assertThat(solution).isEqualTo(new int[][]{
                {4, 5, 2, 5, 6, 6},
                {2, 3, 2, 2, 3, 4},
                {5, 3, 2, 3, 4, 5},
                {4, 3, 4, 4, 7, 6}
        });
    }
}