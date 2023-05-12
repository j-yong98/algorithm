package baekjoon;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BOJ23290Test {

    @ParameterizedTest
    @MethodSource("testCase")
    void solution(String p, int ans) throws IOException {
        BOJ23290 boj23290 = new BOJ23290();
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = boj23290.solution();

        Assertions.assertThat(solution).isEqualTo(ans);
    }

    private static Stream<Arguments> testCase() {
        return Stream.of(
                arguments("5 1\n" +
                        "4 3 5\n" +
                        "1 3 5\n" +
                        "2 4 2\n" +
                        "2 1 6\n" +
                        "3 4 4\n" +
                        "4 2", 9),
                arguments("5 2\n" +
                        "4 3 5\n" +
                        "1 3 5\n" +
                        "2 4 2\n" +
                        "2 1 6\n" +
                        "3 4 4\n" +
                        "4 2", 13),
                arguments("5 3\n" +
                        "4 3 5\n" +
                        "1 3 5\n" +
                        "2 4 2\n" +
                        "2 1 6\n" +
                        "3 4 4\n" +
                        "4 2", 17),
                arguments("5 5\n" +
                        "4 3 5\n" +
                        "1 3 5\n" +
                        "2 4 2\n" +
                        "2 1 6\n" +
                        "3 4 4\n" +
                        "4 2", 35),
                arguments("5 26\n" +
                        "4 3 5\n" +
                        "1 3 5\n" +
                        "2 4 2\n" +
                        "2 1 6\n" +
                        "3 4 4\n" +
                        "4 2", 640240),
                arguments("1 10\n" +
                        "1 1 1\n" +
                        "4 4", 26),
                arguments("8 100\n" +
                        "1 1 1\n" +
                        "1 1 2\n" +
                        "1 1 3\n" +
                        "1 1 4\n" +
                        "1 1 5\n" +
                        "1 1 6\n" +
                        "1 1 7\n" +
                        "1 1 8\n" +
                        "1 1", 8),
                arguments("10 25\n" +
                        "1 1 1\n" +
                        "1 1 2\n" +
                        "1 1 3\n" +
                        "1 1 4\n" +
                        "1 1 5\n" +
                        "1 1 6\n" +
                        "1 1 7\n" +
                        "1 1 8\n" +
                        "2 1 1\n" +
                        "2 1 1\n" +
                        "2 1", 574418)
        );
    }
}