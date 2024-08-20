package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlainFormatter {
    private static final String CHANGED_FORMAT = "\nProperty '%s' was updated. From %s to %s";
    private static final String REMOVED_FORMAT = "\nProperty '%s' was removed";
    private static final String ADDED_FORMAT = "\nProperty '%s' was added with value: %s";

    public static String format(List<Map<String, Object>> parsedMapList) {
        var resultString = new StringBuilder();
        for (var element : parsedMapList) {
            switch (element.get("status").toString()) {
                case "changed":
                    resultString.append(String.format(
                            CHANGED_FORMAT,
                            element.get("key"),
                            getPlainData(element.get("oldValue")),
                            getPlainData(element.get("newValue")))
                    );
                    break;
                case "removed":
                    resultString.append(String.format(REMOVED_FORMAT, element.get("key")));
                    break;
                case "added":
                    resultString.append(String.format(
                            ADDED_FORMAT,
                            element.get("key"),
                            getPlainData(element.get("newValue")))
                    );
                    break;
                default:
                    break;
            }
        }
        return resultString.toString().trim();
    }

    public static String getPlainData(Object data) {
        if (data == null) {
            return "null";
        } else if (data instanceof ArrayList<?> || data instanceof Map<?, ?>) {
            return "[complex value]";
        } else if (data instanceof String) {
            return "'" + data + "'";
        } else {
            return data.toString();
        }
    }
}
