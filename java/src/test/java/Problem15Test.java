import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.io.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Problem15Test {

    @Test
    void solution() throws IOException {
        Problem15 problem15 = new Problem15();
        String p = "4\n" +
                "1 2 4 3\n" +
                "3 2 2 3\n" +
                "3 1 6 2\n" +
                "4 5 4 4\n" +
                "3 3\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        problem15.solution();
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo("0 0 0 0 \n" +
                "1 2 0 3 \n" +
                "3 2 0 3 \n" +
                "4 5 0 4");
    }

}