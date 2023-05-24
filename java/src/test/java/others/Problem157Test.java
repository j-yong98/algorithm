package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem157Test {
    @Test
    void solution() throws IOException {
        Problem157 problem157 = new Problem157();
        String p = "8 8\n" +
                "2 2 5 7 7 7 9 10\n" +
                "1\n" +
                "2\n" +
                "5\n" +
                "6\n" +
                "7\n" +
                "9\n" +
                "10\n" +
                "11\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem157.solution();
    }

}