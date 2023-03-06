package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem104Test {
    @Test
    void solution() throws IOException {
        Problem104 problem104 = new Problem104();
        String p = "5 4\n" +
                "1 3\n" +
                "1 2\n" +
                "2 3\n" +
                "2 4\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem104.solution();
    }
}