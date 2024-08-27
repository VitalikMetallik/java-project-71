package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class PlainFormatter {
    private static final String CHANGED_FORMAT = "\nProperty '%s' was updated. From %s to %s";
    private static final String REMOVED_FORMAT = "\nProperty '%s' was removed";
    private static final String ADDED_FORMAT = "\nProperty '%s' was added with value: %s";

    public static String format(List<Map<String, Object>> parsedMapList) {
        var resultString = new StringBuilder();
        for (var element : parsedMapList) {
            var status = element.get("status").toString();
            if ("changed".equals(status)) {
                resultString.append(String.format(
                        CHANGED_FORMAT,
                        element.get("key"),
                        getPlainData(element.get("oldValue")),
                        getPlainData(element.get("newValue")))
                );
            }
            if ("removed".equals(status)) {
                resultString.append(String.format(REMOVED_FORMAT, element.get("key")));
            }
            if ("added".equals(status)) {
                resultString.append(String.format(
                        ADDED_FORMAT,
                        element.get("key"),
                        getPlainData(element.get("newValue")))
                );
            }
        }
        return resultString.toString().trim();
    }

    public static String getPlainData(Object data) {
        if (data == null) {
            return "null";
        }
        if (data instanceof List<?> || data instanceof Map<?, ?>) {
            return "[complex value]";
        }
        if (data instanceof String) {
            return "'" + data + "'";
        }
        return data.toString();
    }
}
