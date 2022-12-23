package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import others.Problem17;

import java.io.*;

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
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        problem17.solution();

        Assertions.assertThat(outputStream.toString().trim()).isEqualTo("0 0 0 0 \n" +
                "0 4 2 8 \n" +
                "4 8 8 4 \n" +
                "8 2 2 4");
    }
}