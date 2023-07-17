package others;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

class Problem168Test {
    @Test
    void solution() throws IOException {
        Problem168 problem168 = new Problem168();
        String p = "10\n" +
                "4\n" +
                "monster\n" +
                "9\n" +
                "sesquipedalian\n" +
                "18\n" +
                "supercalifragilisticexpialidocious\n" +
                "20\n" +
                "lwxqkixrxdelzxvcylocxtmwu\n" +
                "22\n" +
                "hippopotomonstrosesquippedaliophobia\n" +
                "23\n" +
                "pneumonoultramicroscopicsilicovolcanoconiosis\n" +
                "45\n" +
                "csaccylwynxsirddjnvzfsbjikyewrkjgcetbdlxjkfboezjzhephuugzlqzbeuiiuwucwzgowduazjombimjptzpfztklu\n" +
                "70\n" +
                "duazjombimjptzpfztkluchuugzlqzbeuiiuwucwzgowsaccylwynxsirddjnvzfsbjikyewrkjgcetbdlxjkfboezjzhepxrqlobvbqjezkheifdwdouwosciuupcdgniznfnqdlmsckefn\n" +
                "201\n" +
                "zlqzbeuiiuwucwzgowduazjombimjptzpfztklucsaccylwynxsirddjnvzfsbjikyewrkjgcetbdlxjkfboezjzhepxrqlobvbqjezkheifdwdouwosciuupcdgniznfnqdlmsckefnpnriuwlnnxdzzorbpjjwhgzvumymslqvktsxuisacmwogfmobxgckcsidythaewxzskxhpfnkygvlhaipiqkbynfvbuomqtdjdnceupgusgznecpeviidnqrbghfpzoktuwhygwizyogffsjytsyiukogjxuhfszombbidhncmbgrbbryrpudlnukhpaoxrimaomhdpvyvzkqtzvlxvtkmrcilltssmxiepqyvodcwepahxrolwkfbeqdtbvvfpq\n" +
                "278\n" +
                "wvotseejlcuuubtiaynoriiqscofsarulkpkncnotjioonwwtbmtrfrbizzaelsofdstuzfepimejxipwvmwnsdbiqwdmohcqnswxcpdecjvildcrofjcfhcjiwcynvkgalswnvivhakxnrfeasymuvlpyzxdwbmazjoauepxetkpvwzsfvwkgrojsfcedgvgdgqebwanhozynbwcvovasdciowvckoroeesuxsgczrbztrktitnvpblhvemmjesnfnltvmzodsiknkeguqmkzjlzcbbdluzvhhfzbbhabnfwlrqnfspacvpharaizgkteuelezbejipwoavulaxajrjkvpttkmmuyrgxblyjcgmfldvmnuoerftaxnnrkgtavuasyjijotyemwm\n";
        System.setIn(new ByteArrayInputStream(p.getBytes()));
        problem168.solution();
    }
}