package baekjoon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class BOJ19235Test {
    OutputStream out;

    @BeforeEach
    void init() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }
    @ParameterizedTest
    @MethodSource("testCase")
    void solution(String p, String ans) throws IOException {
        BOJ19235 boj19235 = new BOJ19235();
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj19235.solution();
        String res = out.toString();
        Assertions.assertThat(res).isEqualTo(ans);
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                arguments("1\n" +
                        "1 1 1", "0\n" +
                        "2"),
                arguments("2\n" +
                        "1 1 1\n" +
                        "2 3 0","0\n" +
                        "6"),
                arguments("4\n" +
                        "1 1 1\n" +
                        "2 3 0\n" +
                        "3 2 2\n" +
                        "3 2 3","1\n" +
                        "10"),
                arguments("5\n" +
                        "1 1 1\n" +
                        "2 3 0\n" +
                        "3 2 2\n" +
                        "3 2 3\n" +
                        "3 1 3","1\n" +
                        "12"),
                arguments("6\n" +
                        "1 1 1\n" +
                        "2 3 0\n" +
                        "3 2 2\n" +
                        "3 2 3\n" +
                        "3 1 3\n" +
                        "2 0 0","1\n" +
                        "16"),
                arguments("7\n" +
                        "1 1 1\n" +
                        "2 3 0\n" +
                        "3 2 2\n" +
                        "3 2 3\n" +
                        "3 1 3\n" +
                        "2 0 0\n" +
                        "3 2 0", "1\n" +
                        "18"),
                arguments("8\n" +
                        "1 1 1\n" +
                        "2 3 0\n" +
                        "3 2 2\n" +
                        "3 2 3\n" +
                        "3 1 3\n" +
                        "2 0 0\n" +
                        "3 2 0\n" +
                        "3 1 2","3\n" +
                        "11"),
                arguments("7\n" +
                        "1 0 0\n" +
                        "2 0 2\n" +
                        "2 0 0\n" +
                        "1 2 2\n" +
                        "1 1 1\n" +
                        "2 2 0\n" +
                        "1 0 3", "2\n8"),
                arguments("8\n" +
                        "3 0 0\n" +
                        "2 0 2\n" +
                        "2 0 2\n" +
                        "2 0 0\n" +
                        "1 0 3\n" +
                        "1 0 0\n" +
                        "2 0 1\n" +
                        "3 0 3", "1\n15"),
                arguments("18\n" +
                        "1 2 2\n" +
                        "1 2 3\n" +
                        "2 0 0\n" +
                        "1 2 0\n" +
                        "1 1 2\n" +
                        "1 1 0\n" +
                        "2 3 0\n" +
                        "3 0 1\n" +
                        "3 1 3\n" +
                        "2 1 0\n" +
                        "1 2 0\n" +
                        "2 3 0\n" +
                        "2 2 1\n" +
                        "1 2 2\n" +
                        "3 0 3\n" +
                        "1 2 0\n" +
                        "2 2 0\n" +
                        "3 2 3", "6\n10"),
                arguments("25\n" +
                        "3 1 0\n" +
                        "2 2 2\n" +
                        "1 1 0\n" +
                        "1 0 0\n" +
                        "3 2 0\n" +
                        "1 0 0\n" +
                        "1 0 1\n" +
                        "2 2 1\n" +
                        "3 1 0\n" +
                        "2 1 1\n" +
                        "3 1 2\n" +
                        "1 2 2\n" +
                        "2 0 0\n" +
                        "1 2 1\n" +
                        "1 1 0\n" +
                        "2 1 0\n" +
                        "1 2 2\n" +
                        "1 0 1\n" +
                        "2 1 2\n" +
                        "1 2 0\n" +
                        "3 2 1\n" +
                        "2 0 2\n" +
                        "1 0 0\n" +
                        "2 2 1\n" +
                        "1 0 1", "3\n11"),
                arguments("5\n" +
                        "1 3 3\n" +
                        "2 2 2\n" +
                        "2 1 1\n" +
                        "2 0 0\n" +
                        "2 0 2", "2\n10"),
                arguments("6\n" +
                        "2 3 0\n" +
                        "1 3 2\n" +
                        "1 2 1\n" +
                        "2 2 2\n" +
                        "2 1 0\n" +
                        "2 1 2", "1\n16"),
                arguments("6\n" +
                        "1 1 0\n" +
                        "2 1 0\n" +
                        "3 1 2\n" +
                        "3 0 1\n" +
                        "3 0 2\n" +
                        "3 0 3", "2\n11"),
                arguments("6\n" +
                        "1 0 0\n" +
                        "1 0 2\n" +
                        "2 0 0\n" +
                        "3 0 2\n" +
                        "2 0 1\n" +
                        "3 0 3", "1\n12")
        );
    }
}