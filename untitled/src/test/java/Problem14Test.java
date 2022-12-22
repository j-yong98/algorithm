import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem14Test {

    @Test
    void solution() throws IOException {
        Problem14 problem14 = new Problem14();
        String p = "6\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "1\n" +
                "1\n" +
                "5\n" +
                "2 4\n" +
                "1 3\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem14.solution();
    }

}