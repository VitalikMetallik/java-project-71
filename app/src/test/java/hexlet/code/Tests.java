package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class Tests {
    private static String expectedStylish;
    private static String expectedPlain;
    private static String expectedJson;

    @BeforeAll
    public static void init() throws IOException {
        expectedStylish = Files.readString(Path.of("src/test/resources/expectedStylish.txt"));
        expectedPlain = Files.readString(Path.of("src/test/resources/expectedPlain.txt"));
        expectedJson = Files.readString(Path.of("src/test/resources/expectedJson.json"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void defaultTest(String format) throws IOException {
        assertEquals(expectedStylish, generate("src/test/resources/file1." + format,
                "src/test/resources/file2." + format));
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void stylishTest(String format) throws IOException {
        assertEquals(expectedStylish, generate("src/test/resources/file1." + format,
                "src/test/resources/file2." + format, "stylish"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void plainTest(String format) throws IOException {
        assertEquals(expectedPlain, generate("src/test/resources/file1." + format,
                "src/test/resources/file2." + format, "plain"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"json", "yml"})
    public void jsonTest(String format) throws IOException {
        assertEquals(expectedJson, generate("src/test/resources/file1." + format,
                "src/test/resources/file2." + format, "json"));
    }
}
