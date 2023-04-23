package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem121Test {
    @Test
    void solution() throws IOException {
        Problem121 problem121 = new Problem121();
        String p = "4\n" +
                "12345\n" +
                "54321\n" +
                "142857\n" +
                "102345";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem121.solution();
    }
}