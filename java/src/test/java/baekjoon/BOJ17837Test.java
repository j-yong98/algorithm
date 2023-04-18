package baekjoon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class BOJ17837Test {
    @ParameterizedTest
    @MethodSource("testcase")
    void solution(String p, int ans) throws IOException {
        BOJ17837 boj17837 = new BOJ17837();
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = boj17837.solution();
        Assertions.assertThat(solution).isEqualTo(ans);
    }

    private static Stream<Arguments> testcase() {
        return Stream.of(
                arguments("4 4\n" +
                        "0 0 2 0\n" +
                        "0 0 1 0\n" +
                        "0 0 1 2\n" +
                        "0 2 0 0\n" +
                        "2 1 1\n" +
                        "3 2 3\n" +
                        "2 2 1\n" +
                        "4 1 2", -1),
                arguments("4 4\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0\n" +
                        "1 1 1\n" +
                        "1 2 1\n" +
                        "1 3 1\n" +
                        "1 4 1", 1),
                arguments("4 4\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0\n" +
                        "1 1 1\n" +
                        "1 2 1\n" +
                        "1 3 1\n" +
                        "2 4 3", 1),
                arguments("4 4\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0\n" +
                        "0 0 0 0\n" +
                        "1 1 1\n" +
                        "1 2 1\n" +
                        "1 3 1\n" +
                        "3 3 3", 2),
                arguments("6 10\n" +
                        "0 1 2 0 1 1\n" +
                        "1 2 0 1 1 0\n" +
                        "2 1 0 1 1 0\n" +
                        "1 0 1 1 0 2\n" +
                        "2 0 1 2 0 1\n" +
                        "0 2 1 0 2 1\n" +
                        "1 1 1\n" +
                        "2 2 2\n" +
                        "3 3 4\n" +
                        "4 4 1\n" +
                        "5 5 3\n" +
                        "6 6 2\n" +
                        "1 6 3\n" +
                        "6 1 2\n" +
                        "2 4 3\n" +
                        "4 2 1", 7)
        );
    }
}