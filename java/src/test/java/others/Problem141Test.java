package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem141Test {
    @Test
    void solution() throws IOException {
        Problem141 problem141 = new Problem141();
        String p = "5\n" +
                "9 7 5 3 1\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem141.solution();
    }
}