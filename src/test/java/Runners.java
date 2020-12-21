import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runners {
    @Test
    public void day1() throws FileNotFoundException {
        Day1 day1 = new Day1();

        // Read puzzle input
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test/resources/day1Input.txt"));
        Stream<String> lines = bufferedReader.lines();
        ArrayList<Integer> linesList = lines.map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

        // PUZZLE 1

        // Sample Input
        ArrayList<Integer> sampleInput = new ArrayList<>(Arrays.asList(1721, 979, 366, 299, 675, 1456));
        Optional<ArrayList<Integer>> sample1Res = day1.puzzle1(sampleInput, 0, sampleInput.size() - 1, 2020);
        Assertions.assertTrue(sample1Res.isPresent());
        Assertions.assertEquals(514579, sample1Res.get().get(0) * sample1Res.get().get(1));

        // Puzzle Input
        Optional<ArrayList<Integer>> puzzle1Res = day1.puzzle1(linesList, 0, linesList.size() - 1, 2020);
        Assertions.assertTrue(puzzle1Res.isPresent());
        Assertions.assertEquals(1018336, puzzle1Res.get().get(0) * puzzle1Res.get().get(1));

        // PUZZLE 2

        // Sample Input
        Optional<ArrayList<Integer>> sample2Res = day1.puzzle2(sampleInput, 0, sampleInput.size() - 1, 2020);
        Assertions.assertTrue(sample2Res.isPresent());
        Assertions.assertEquals(241861950, sample2Res.get().get(0) * sample2Res.get().get(1) * sample2Res.get().get(2));

        // Puzzle Input
        Optional<ArrayList<Integer>> puzzle2Res = day1.puzzle2(linesList, 0, linesList.size() - 1, 2020);
        Assertions.assertTrue(puzzle2Res.isPresent());
        Assertions.assertEquals(288756720, puzzle2Res.get().get(0) * puzzle2Res.get().get(1) * puzzle2Res.get().get(2));

    }
}
