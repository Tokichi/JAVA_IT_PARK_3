package ru.itpark;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {
        List<String> strings =   Files.readAllLines(Paths.get("inputName.txt"), StandardCharsets.UTF_8);
        strings.get(1).replaceAll("[a-zA-Z]+", "");
        strings.stream()
                .
//        .forEach((i) -> strings.get().replaceAll("[a-zA-Z]+", ""));
    }
}
