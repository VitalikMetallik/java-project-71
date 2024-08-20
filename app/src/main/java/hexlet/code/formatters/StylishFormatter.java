package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class StylishFormatter {

    private static final String NO_CHANGE_FORMAT = "    %s: %s\n";
    private static final String REMOVED_FORMAT = "  - %s: %s\n";
    private static final String ADDED_FORMAT = "  + %s: %s\n";

    public static String format(List<Map<String, Object>> parsedMapList) {
        var resultString = new StringBuilder("{\n");
        for (var element : parsedMapList) {
            switch (element.get("status").toString()) {
                case "noChange":
                    resultString.append(String.format(NO_CHANGE_FORMAT, element.get("key"), element.get("oldValue")));
                    break;
                case "changed":
                    resultString.append(String.format(REMOVED_FORMAT, element.get("key"), element.get("oldValue")))
                            .append(String.format(ADDED_FORMAT, element.get("key"), element.get("newValue")));
                    break;
                case "removed":
                    resultString.append(String.format(REMOVED_FORMAT, element.get("key"), element.get("oldValue")));
                    break;
                case "added":
                    resultString.append(String.format(ADDED_FORMAT, element.get("key"), element.get("newValue")));
                    break;
                default:
                    break;
            }
        }
        resultString.append("}");
        return resultString.toString();
    }
}
