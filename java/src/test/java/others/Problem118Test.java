package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem118Test {

    @Test
    void solution() throws IOException {
        Problem118 problem118 = new Problem118();
        String p = "3\n" +
                "5 1\n" +
                "5 2\n" +
                "100 3";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem118.solution();
    }
}