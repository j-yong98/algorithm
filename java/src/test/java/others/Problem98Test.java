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

class Problem98Test {
    @ParameterizedTest
    @MethodSource("problem")
    void solution(String p, int ans) throws IOException {
        Problem98 problem98 = new Problem98();
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        int solution = problem98.solution();
        Assertions.assertThat(solution).isEqualTo(ans);
    }
    static Stream<Arguments> problem() {
        return Stream.of(
                arguments("5 9\n4 6 5 3 7\n",2),
                arguments("5 6\n3 3 3 3 3", 10)
        );
    }
}