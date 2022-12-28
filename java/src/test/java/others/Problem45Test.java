package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class Problem45Test {

    @Test
    void solution() throws IOException {
        Problem45 problem45 = new Problem45();
        String p ="1\n" +
                "2 2\n" +
                "1 1 D\n" +
                "2 2 R\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem45.solution();
    }

}