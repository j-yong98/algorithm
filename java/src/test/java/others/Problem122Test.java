package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem122Test {
    @Test
    void solution() throws IOException {
        Problem122 problem122 = new Problem122();
        String p = "3\n" +
                "SUN\n" +
                "SAT\n" +
                "MON";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem122.solution();
    }
}