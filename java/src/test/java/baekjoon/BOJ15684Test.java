package baekjoon;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class BOJ15684Test {

    @Test
    void ladderTest() {
        BOJ15684 boj15684 = new BOJ15684();
        int[][] map = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0}
        };
        System.out.println(boj15684.check(map, 6, 5));
    }

    @ParameterizedTest
    @MethodSource("problem")
    void solution(String p, int ans) throws IOException {
        BOJ15684 boj15684 = new BOJ15684();
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj15684.solution();
    }

    static Stream<Arguments> problem() {
        return Stream.of(
                arguments("2 0 3", 0),
                arguments("2 1 3\n" +
                        "1 1", 1),
                arguments("5 5 6\n" +
                        "1 1\n" +
                        "3 2\n" +
                        "2 3\n" +
                        "5 1\n" +
                        "5 4", 3),
                arguments("6 5 6\n" +
                        "1 1\n" +
                        "3 2\n" +
                        "1 3\n" +
                        "2 5\n" +
                        "5 5" ,3),
                arguments("5 8 6\n" +
                        "1 1\n" +
                        "2 2\n" +
                        "3 3\n" +
                        "4 4\n" +
                        "3 1\n" +
                        "4 2\n" +
                        "5 3\n" +
                        "6 4", -1),
                arguments("5 12 6\n" +
                        "1 1\n" +
                        "1 3\n" +
                        "2 2\n" +
                        "2 4\n" +
                        "3 1\n" +
                        "3 3\n" +
                        "4 2\n" +
                        "4 4\n" +
                        "5 1\n" +
                        "5 3\n" +
                        "6 2\n" +
                        "6 4",-1),
                arguments("5 6 6\n" +
                        "1 1\n" +
                        "3 1\n" +
                        "5 2\n" +
                        "4 3\n" +
                        "2 3\n" +
                        "1 4",2)
        );
    }
}