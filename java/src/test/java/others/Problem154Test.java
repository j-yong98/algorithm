package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem154Test {
    @Test
    void solution() throws IOException {
        Problem154 problem154 = new Problem154();
        String p = "10\n" +
                "123 1\n" +
                "2737 1\n" +
                "757148 1\n" +
                "78466 2\n" +
                "32888 2\n" +
                "777770 5\n" +
                "436659 2\n" +
                "431159 7\n" +
                "112233 3\n" +
                "456789 10";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem154.solution();
    }
}