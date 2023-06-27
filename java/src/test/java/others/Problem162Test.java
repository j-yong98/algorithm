package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem162Test {
    @Test
    void solution() throws IOException {
        Problem162 problem162 = new Problem162();
        String p = "2\n" +
                "4\n" +
                "0100\n" +
                "1110\n" +
                "1011\n" +
                "1010\n" +
                "6\n" +
                "011001\n" +
                "010100\n" +
                "010011\n" +
                "101001\n" +
                "010101\n" +
                "111010\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem162.solution();
    }
}