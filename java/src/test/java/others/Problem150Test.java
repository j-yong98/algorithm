package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem150Test {
    @Test
    void solution() throws IOException {
        Problem150 problem150 = new Problem150();
        String p = "5\n" +
                "4 1\n" +
                "4 30\n" +
                "4 47\n" +
                "5 31\n" +
                "5 62";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem150.solution();
    }

}