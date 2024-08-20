package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static hexlet.code.Comparator.compare;
import static hexlet.code.Parser.parse;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        Path firstPath = Paths.get(filePath1).toAbsolutePath();
        Path secondPath = Paths.get(filePath2).toAbsolutePath();
        var firstParsedMap = parse(readFile(firstPath), checkFileFormat(firstPath));
        var secondParsedMap = parse(readFile(secondPath), checkFileFormat(secondPath));
        var finalMap = compare(firstParsedMap, secondParsedMap);
        return Formatter.format(finalMap, format);
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }

    public static String readFile(Path filePath) throws IOException {
        return Files.readString(filePath);
    }

    public static String checkFileFormat(Path filePath) {
        var pathString = filePath.toString();
        return pathString.substring(pathString.lastIndexOf(".") + 1);
    }
}
