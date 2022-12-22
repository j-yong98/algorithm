import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem17Test {

    @Test
    void solution() throws IOException {
        Problem17 problem17 = new Problem17();
        String p = "4 2 0 8\n" +
                "4 2 2 4\n" +
                "0 8 8 2\n" +
                "4 2 2 2\n" +
                "D";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem17.solution();
    }
}