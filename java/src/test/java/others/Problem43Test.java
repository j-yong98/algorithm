package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem43Test {

    @Test
    void solution() throws IOException {
        Problem43 problem43 = new Problem43();
        String p = "3\n" +
                "/\\\\\n" +
                "\\\\\\\n" +
                "/\\/\n" +
                "2\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem43.solution();
    }

}