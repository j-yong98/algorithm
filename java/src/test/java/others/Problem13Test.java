package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import others.Problem13;

import java.io.*;

class Problem13Test {

    @Test
    void solution() throws IOException {
        String p = "5\n" +
                "1 2 2 2 2\n" +
                "1 3 4 4 4\n" +
                "1 2 3 3 3\n" +
                "1 2 3 3 3\n" +
                "1 2 3 3 3\n" +
                "4 2 2 1 2 1 1\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Problem13 problem13 = new Problem13();
        problem13.solution();

        Assertions.assertThat(outputStream.toString().trim()).isEqualTo(
                "1 2 3 2 2\n" +
                        "1 1 4 2 4\n" +
                        "2 2 4 3 3\n" +
                        "1 3 3 3 3\n" +
                        "1 2 3 3 3");
    }

}