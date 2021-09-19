package Part2.chapter5.challenge;

import java.util.stream.Stream;

public class Triples {
    private Stream<int[]> value;

    public Triples(Stream<int[]> value) {
        this.value = value;
    }

    public Stream<int[]> getValue() {
        return value;
    }


}
