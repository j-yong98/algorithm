package baekjoon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class BOJ17825Test {
    @ParameterizedTest
    @MethodSource("testCase")
    void solution(String p, int ans) throws IOException {
        BOJ17825 boj17825 = new BOJ17825();
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = boj17825.solution();
        Assertions.assertThat(solution).isEqualTo(ans);
    }
    private static Stream<Arguments> testCase() {
        return Stream.of(
                arguments("1 2 3 4 1 2 3 4 1 2", 190),
                arguments("1 1 1 1 1 1 1 1 1 1", 133),
                arguments("5 1 2 3 4 5 5 3 2 4", 214),
                arguments("5 5 5 5 5 5 5 5 5 5", 130),
                arguments("4 1 4 4 4 4 3 2 2 4", 205),
                arguments("4 1 3 4 4 4 3 3 2 4", 211),
                arguments("4 3 2 1 3 4 3 4 1 2", 202),
                arguments("5 3 2 5 2 4 4 2 4 1", 231),
                arguments("3 1 2 5 5 3 2 4 4 3", 202),
                arguments("5 3 4 3 1 3 3 3 5 2", 216),
                arguments("5 4 5 2 2 2 5 3 1 4", 245),
                arguments("3 5 2 5 3 5 2 1 3 1", 246),
                arguments("5 5 5 5 5 1 1 1 1 1", 167),
                arguments("5 5 5 5 5 2 2 2 2 2", 160),
                arguments("5 5 5 5 5 2 2 1 3 3", 161),
                arguments("4 5 5 5 3 4 3 5 3 4", 229)
        );
    }
}