package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem136Test {
    @Test
    void solution() throws IOException {
        Problem136 problem136 = new Problem136();
        String p = "1\n" +
                "5\n" +
                "80 -14\n" +
                "117 12\n" +
                "98 -69\n" +
                "-86 21\n" +
                "-121 99";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem136.solution();
    }

}