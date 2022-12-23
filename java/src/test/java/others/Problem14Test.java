package others;

import org.junit.jupiter.api.Test;
import others.Problem14;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

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
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        System.setOut(new PrintStream(outputStream));
        problem14.solution();
        assertThat(outputStream.toString().trim()).isEqualTo("0");
    }

}