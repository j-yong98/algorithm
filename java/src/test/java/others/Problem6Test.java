package others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import others.Problem6;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class Problem6Test {

    @ParameterizedTest
    @MethodSource("problem")
    void solution(String p, int ans) throws IOException {
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        Problem6 problem6 = new Problem6();
        int solution = problem6.solution();

        Assertions.assertThat(solution).isEqualTo(ans);
    }

    static Stream<Arguments> problem(){
        return Stream.of(
                arguments("3\n" +
                        "9 1 9\n" +
                        "1 9 1\n" +
                        "9 1 9",4),
                arguments("5\n" +
                        "1 2 2 2 2\n" +
                        "1 3 4 4 4\n" +
                        "1 2 3 3 3\n" +
                        "1 2 3 3 3\n" +
                        "1 2 3 3 3\n",21),
                arguments("3\n" +
                        "1 2 3\n" +
                        "4 5 6\n" +
                        "7 8 8\n",20),
                arguments("5\n" +
                        "1 1 6 1 1\n" +
                        "1 6 1 6 1\n" +
                        "6 1 6 1 1\n" +
                        "1 6 1 1 1\n" +
                        "1 1 1 1 1",36)
        );
    }
}