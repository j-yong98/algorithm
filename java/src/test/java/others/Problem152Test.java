package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem152Test {
    @Test
    void solution() throws IOException {
        Problem152 problem152 = new Problem152();
        String p = "4\n" +
                "3 45\n" +
                "20 20 20\n" +
                "6 10\n" +
                "1 2 5 8 9 11\n" +
                "4 100\n" +
                "80 80 60 60\n" +
                "4 20\n" +
                "10 5 10 16";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem152.solution();
    }
}