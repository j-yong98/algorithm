package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class Problem56Test {
    Problem56 problem56;
    OutputStream outputStream;

    @BeforeEach
    void init(){
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        problem56 = new Problem56();
    }
    @Test
    void solution() throws IOException {
        Problem56 problem56 = new Problem56();
        String p = "7";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem56.solution();
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo("4546454");
    }

}