package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

public class Comparator {
    public static List<Map<String, Object>> compare(Map<String, Object[]> firstMap, Map<String, Object[]> secondMap) {
        var mapSet = new TreeSet<>();
        List<Map<String, Object>> parsedMapList = new ArrayList<>();

        mapSet.addAll(firstMap.keySet());
        mapSet.addAll(secondMap.keySet());

        for (var key : mapSet) {
            Map<String, Object> iterationMap = new HashMap<>();
            if (firstMap.containsKey(key) && !secondMap.containsKey(key)) {
                iterationMap.put("key", key);
                iterationMap.put("status", "removed");
                iterationMap.put("oldValue", firstMap.get(key));
            } else if (!firstMap.containsKey(key) && secondMap.containsKey(key)) {
                iterationMap.put("key", key);
                iterationMap.put("status", "added");
                iterationMap.put("newValue", secondMap.get(key));
            } else if (Objects.equals(firstMap.get(key), secondMap.get(key))) {
                iterationMap.put("key", key);
                iterationMap.put("status", "noChange");
                iterationMap.put("oldValue", firstMap.get(key));
            } else {
                iterationMap.put("key", key);
                iterationMap.put("status", "changed");
                iterationMap.put("oldValue", firstMap.get(key));
                iterationMap.put("newValue", secondMap.get(key));
            }
            parsedMapList.add(iterationMap);
        }
        return parsedMapList;
    }
}
