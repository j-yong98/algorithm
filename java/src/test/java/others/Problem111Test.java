package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem111Test {
    @Test
    void solution() throws IOException {
        Problem111 problem111 = new Problem111();
        String p = "3\n" +
                "ababab abab\n" +
                "aba bab\n" +
                "hello hello";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem111.solution();
    }
}