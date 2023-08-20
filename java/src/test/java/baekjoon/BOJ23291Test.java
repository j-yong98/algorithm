package baekjoon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class BOJ23291Test {
    @ParameterizedTest
    @MethodSource("testCase")
    void solution(String p, int ans) throws IOException {
        BOJ23291 boj23291 = new BOJ23291();
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = boj23291.solution();
        Assertions.assertThat(solution).isEqualTo(ans);
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(arguments("8 7\n" +
                        "5 2 3 14 9 2 11 8", 1),
                arguments("8 4\n" +
                        "5 2 3 14 9 2 11 8", 2),
                arguments("8 3\n" +
                        "5 2 3 14 9 2 11 8", 3),
                arguments("8 2\n" +
                        "5 2 3 14 9 2 11 8", 4),
                arguments("8 1\n" +
                        "5 2 3 14 9 2 11 8", 5),
                arguments("8 0\n" +
                        "5 2 3 14 9 2 11 8", 6),
                arguments("4 0\n" +
                        "1 10000 1 10000", 10),
                arguments("16 0\n" +
                        "1 1 10000 1 2 3 10000 9999 10 9 8 10000 5 4 3 1", 13),
                arguments("8 0\n" +
                        "5 2 3 14 9 2 11 8", 6)
        );
    }
}