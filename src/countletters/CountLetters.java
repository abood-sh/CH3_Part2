/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countletters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Abood Sh
 */
public class CountLetters {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final Path file = Paths.get("C:/CountLetters.txt");
    try (final Stream<String> lines = Files.lines(file)) {
        final Map<Character, Integer> count = lines.
                flatMap(line -> IntStream.range(0, line.length()).mapToObj(line::charAt)).
                filter(Character::isLetter).
                map(Character::toLowerCase).
                collect(TreeMap::new, (m, c) -> m.merge(c, 1, Integer::sum), Map::putAll);
        count.forEach((letter, c) -> System.out.println(letter + ": " + c));
    } catch (IOException e) {
        System.out.println("Failed to read file.");
        e.printStackTrace(System.out);
    }
    }
    
}
