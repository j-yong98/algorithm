package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem82Test {

    @Test
    void solution() throws IOException {
        Problem82 problem82 = new Problem82();
        String p = "3\n" +
                "1 2\n" +
                "1 4\n" +
                "3 4\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem82.solution();
    }

}