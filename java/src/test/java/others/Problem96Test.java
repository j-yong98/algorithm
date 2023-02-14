package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem96Test {

    @Test
    void solution() throws IOException {
        Problem96 problem96 = new Problem96();
        String p = "7\n" +
                "4 -1 2 -19 3 6 9\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem96.solution();
    }
}