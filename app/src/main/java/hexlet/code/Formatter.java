package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(List<Map<String, Object>> parsedMapList, String format)
            throws JsonProcessingException {
        return switch (format) {
            case "json" -> JsonFormatter.format(parsedMapList);
            case "plain" -> PlainFormatter.format(parsedMapList);
            case "stylish" -> StylishFormatter.format(parsedMapList);
            default -> throw new RuntimeException("Unsupported format: " + format);
        };
    }


}
