package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem108Test {
    @Test
    void solution() throws IOException {
        Problem108 problem108 = new Problem108();
        String p = "1\n" +
                "6";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem108.solution();
    }
}