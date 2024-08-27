package com.evolutionnext.concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.*;

public class FindAllJavaWordsFromURL {
    public static void main(String[] args) throws IOException {
        URL url = URI.create("https://openjdk.org/").toURL();
        try (InputStream inputStream = url.openStream();
             InputStreamReader in = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(in)) {
            long count = reader.lines()
                .flatMap(line -> Arrays.stream(line.split("\\W+")))
                .filter(word -> word.equalsIgnoreCase("java"))
                .count();
            System.out.println(count);
        }
    }
}
