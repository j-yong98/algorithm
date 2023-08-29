package baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class BOJ4358Test {
    @Test
    void solution() throws IOException {
        BOJ4358 boj4358 = new BOJ4358();
        String p = "Red Alder\n" +
                "Ash\n" +
                "Aspen\n" +
                "Basswood\n" +
                "Ash\n" +
                "Beech\n" +
                "Yellow Birch\n" +
                "Ash\n" +
                "Cherry\n" +
                "Cottonwood\n" +
                "Ash\n" +
                "Cypress\n" +
                "Red Elm\n" +
                "Gum\n" +
                "Hackberry\n" +
                "White Oak\n" +
                "Hickory\n" +
                "Pecan\n" +
                "Hard Maple\n" +
                "White Oak\n" +
                "Soft Maple\n" +
                "Red Oak\n" +
                "Red Oak\n" +
                "White Oak\n" +
                "Poplan\n" +
                "Sassafras\n" +
                "Sycamore\n" +
                "Black Walnut\n" +
                "Willow";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        boj4358.solution();
    }
}