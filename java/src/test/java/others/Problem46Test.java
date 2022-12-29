package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem46Test {

    @Test
    void solution() throws IOException {
        Problem46 problem46 = new Problem46();
        String p = "3 4\n" +
                "7 1 4\n" +
                "2 6 3\n" +
                "9 8 5\n" +
                "1 7 4 1\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem46.solution();

    }

}