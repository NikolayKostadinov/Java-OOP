package P05Тelephony;

import java.util.List;
import java.util.stream.Collectors;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        return this.urls
                .stream()
                .map(url -> url.matches(".*\\d+.*") ? "Invalid URL!" : String.format("Browsing: %s!", url))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String call() {
        return this.numbers
                .stream()
                .map(number -> number.matches("\\d*\\D+\\d*") ? "Invalid number!" : String.format("Calling... %s", number))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
