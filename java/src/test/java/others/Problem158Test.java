package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Problem158Test {
    @Test
    void solution() throws IOException {
        Problem158 problem158 = new Problem158();
        String p = "6 3\n" +
                "1 2 2 5 9 9\n" +
                "2 5 6\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem158.solution();
    }
}
