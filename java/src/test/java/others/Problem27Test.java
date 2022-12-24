package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem27Test {

    @Test
    void solution() throws IOException {
        Problem27 problem27 = new Problem27();
        String p = "4 2 2\n" +
                "0 0 0 1\n" +
                "0 0 1 0\n" +
                "1 1 0 1\n" +
                "0 0 1 0\n" +
                "1 1\n" +
                "4 1";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem27.solution();
    }

}