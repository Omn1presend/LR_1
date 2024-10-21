package ru.Elenskiy.MyFirstTestAppSpringBoot.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
    private List<String> myArrayList;
    private Map<Integer, String> myHashMap;
    private int mapKeyCounter = 0;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",
    defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam String s) {
        if (myArrayList == null) {
            myArrayList = new ArrayList<>();
        }
        myArrayList.add(s);
        return "Value added to ArrayList: " + s;
    }

    @GetMapping("/show-array")
    public List<String> showArrayList() {
        return myArrayList != null ? myArrayList : new ArrayList<>();
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam String s) {
        if (myHashMap == null) {
            myHashMap = new HashMap<>();
        }
        myHashMap.put(mapKeyCounter++, s);
        return "Value added to HashMap: " + s;
    }

    @GetMapping("/show-map")
    public Map<Integer, String> showHashMap() {
        return myHashMap != null ? myHashMap : new HashMap<>();
    }

    @GetMapping("/show-all-length")
    public String showAllLength() {
        int arrayListSize = (myArrayList != null) ? myArrayList.size() : 0;
        int hashMapSize = (myHashMap != null) ? myHashMap.size() : 0;
        return "ArrayList size: " + arrayListSize + ", HashMap size: " + hashMapSize;
    }
}
