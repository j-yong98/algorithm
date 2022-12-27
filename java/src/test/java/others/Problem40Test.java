package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem40Test {

    @Test
    void solution() throws IOException {
        Problem40 problem40 = new Problem40();
        String p = "4 2\n" +
                "0 0 1 1\n" +
                "1 1 1 1\n" +
                "1 1 1 1\n" +
                "1 1 0 0\n" +
                "1 1\n" +
                "4 4\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem40.solution();
    }

}