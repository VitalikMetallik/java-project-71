package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {

    public static Map parse(String fileString, String fileFormat)
            throws IOException {
        ObjectMapper objectMapper = switch (fileFormat) {
            case "json" -> new JsonMapper();
            case "yml", "yaml"  -> new YAMLMapper();
            default -> throw new RuntimeException("Неподдерживаемый формат: " + fileFormat);
        };
        return objectMapper.readValue(fileString, Map.class);
    }
}
