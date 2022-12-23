package others;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import others.Problem12;

import java.io.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class Problem12Test {
    Problem12 problem12;

    @BeforeEach
    void init(){
        problem12 = new Problem12();
    }
    @Test
    void encodingTest(){
        String encoding = problem12.encoding("aaabbbbcaa".toCharArray());

        assertThat(encoding).isEqualTo("a3b4c1a2");
    }

    @ParameterizedTest
    @MethodSource("problem")
    void minRunLengthEncodingTest(String p, Integer ans) throws IOException {
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        problem12.solution();

        assertThat(Integer.parseInt(outputStream.toString().trim())).isEqualTo(ans);
    }

    static Stream<Arguments> problem(){
        return Stream.of(
                arguments("aaabbbbcaa",6),
                arguments("aaaaaaaaaa",3)
        );
    }
}