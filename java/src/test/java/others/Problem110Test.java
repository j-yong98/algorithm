package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem110Test {
    @Test
    void solution() throws IOException {
        Problem110 problem110 = new Problem110();
        String p = "3\n" +
                "1\n" +
                "17\n" +
                "2020";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem110.solution();
    }
}