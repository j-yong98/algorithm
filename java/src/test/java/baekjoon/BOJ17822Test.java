package baekjoon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class BOJ17822Test {
    @ParameterizedTest
    @MethodSource("testCase")
    void solution(String p, int ans) throws IOException {
        BOJ17822 boj17822 = new BOJ17822();
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = boj17822.solution();
        Assertions.assertThat(solution).isEqualTo(ans);
    }
    private static Stream<Arguments> testCase() {
        return Stream.of(
                arguments("4 4 1\n" +
                        "1 1 2 3\n" +
                        "5 2 4 2\n" +
                        "3 1 3 5\n" +
                        "2 1 3 2\n" +
                        "2 0 1", 30),
                arguments("4 4 2\n" +
                        "1 1 2 3\n" +
                        "5 2 4 2\n" +
                        "3 1 3 5\n" +
                        "2 1 3 2\n" +
                        "2 0 1\n" +
                        "3 1 3", 22),
                arguments("4 4 3\n" +
                        "1 1 2 3\n" +
                        "5 2 4 2\n" +
                        "3 1 3 5\n" +
                        "2 1 3 2\n" +
                        "2 0 1\n" +
                        "3 1 3\n" +
                        "2 0 2", 22),
                arguments("4 4 4\n" +
                        "1 1 2 3\n" +
                        "5 2 4 2\n" +
                        "3 1 3 5\n" +
                        "2 1 3 2\n" +
                        "2 0 1\n" +
                        "3 1 3\n" +
                        "2 0 2\n" +
                        "3 1 1", 0),
                arguments("4 6 3\n" +
                        "1 2 3 4 5 6\n" +
                        "2 3 4 5 6 7\n" +
                        "3 4 5 6 7 8\n" +
                        "4 5 6 7 8 9\n" +
                        "2 1 4\n" +
                        "3 0 1\n" +
                        "2 1 2", 26)
                );
    }
}