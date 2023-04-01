package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ1620Test {
    @Test
    void solution() throws IOException {
        BOJ1620 boj1620 = new BOJ1620();
        String p = "26 5\n" +
                "Bulbasaur\n" +
                "Ivysaur\n" +
                "Venusaur\n" +
                "Charmander\n" +
                "Charmeleon\n" +
                "Charizard\n" +
                "Squirtle\n" +
                "Wartortle\n" +
                "Blastoise\n" +
                "Caterpie\n" +
                "Metapod\n" +
                "Butterfree\n" +
                "Weedle\n" +
                "Kakuna\n" +
                "Beedrill\n" +
                "Pidgey\n" +
                "Pidgeotto\n" +
                "Pidgeot\n" +
                "Rattata\n" +
                "Raticate\n" +
                "Spearow\n" +
                "Fearow\n" +
                "Ekans\n" +
                "Arbok\n" +
                "Pikachu\n" +
                "Raichu\n" +
                "25\n" +
                "Raichu\n" +
                "3\n" +
                "Pidgey\n" +
                "Kakuna";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj1620.solution();
    }
}