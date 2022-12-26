package others;

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

class Problem34Test {

    @ParameterizedTest
    @MethodSource("problem")
    void solution(String p, int ans) throws IOException {
        Problem34 problem34 = new Problem34();
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem34.solution();
        Assertions.assertThat(solution).isEqualTo(ans);
    }
    static Stream<Arguments> problem(){
        return Stream.of(
                arguments("3 0 2\n" +
                        "R 2\n" +
                        "D 2\n", 4),
                arguments("2 0 2\n" +
                        "R 3\n" +
                        "D 2\n",2),
                arguments("5 4 5\n" +
                        "1 2\n" +
                        "1 3\n" +
                        "1 4\n" +
                        "1 5\n" +
                        "R 4\n" +
                        "D 1\n" +
                        "L 1\n" +
                        "U 1\n" +
                        "L 2\n",7),
                arguments("4 3 5\n" +
                        "1 2\n" +
                        "1 3\n" +
                        "1 4\n" +
                        "R 3\n" +
                        "D 1\n" +
                        "L 1\n" +
                        "U 1\n" +
                        "L 2",8)
        );
    }
}