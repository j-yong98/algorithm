package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem145Test {
    @Test
    void solution() throws IOException {
        Problem145 problem145 = new Problem145();
        String p = "2\n" +
                "bdppq\n" +
                "qqqqpppbbd";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem145.solution();
    }
}