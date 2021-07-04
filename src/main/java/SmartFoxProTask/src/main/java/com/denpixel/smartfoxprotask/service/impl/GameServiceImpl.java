package com.denpixel.smartfoxprotask.service.impl;

import com.denpixel.smartfoxprotask.exception.*;
import com.denpixel.smartfoxprotask.service.GameService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {
    private final static String NAME_FILE_WITH_CITIES = "cities.txt";
    private Set<String> cities = new HashSet<>();
    private String previousCity;


    private void load() {
        try {
            Path path = Paths.get(ClassLoader.getSystemResource(NAME_FILE_WITH_CITIES).toURI());
            List<String> listCities = Files.readAllLines(path);
            cities = new HashSet<>(listCities);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String start() {
        load();
        if (cities.isEmpty()) throw new CitiesNotFoundException();

        String city = cities.stream()
                .findAny()
                .get();

        previousCity = city;

        cities.remove(city);

        return city;
    }

    @Override
    public String nextWord(final String word) {
        validate(word);

        String nextWord = searchNextCity(word);

        cities.remove(word);
        cities.remove(nextWord);

        previousCity = nextWord;

        return nextWord;
    }

    @Override
    public String end() {
        cities = new HashSet<>();
        return "Спасибо за игру";
    }

    private String searchNextCity(final String word) {
        int pos = word.length() - 1;
        char lastChar = word.toUpperCase().charAt(pos);

        if (lastChar == 'Ь' || lastChar == 'Ъ') lastChar = word.toUpperCase().charAt(--pos);

        char finalLastChar = lastChar;

        return cities.stream()
                .filter(s -> s.charAt(0) == finalLastChar)
                .findAny()
                .orElseThrow(CitiesAreOverException::new);
    }

    private void validate(final String word) {
        if (cities.isEmpty()) throw new CitiesAreOverException();
        if (word.isEmpty()) throw new WordIsEmptyException();

        int pos = previousCity.length() - 1;

        char firstChar = word.charAt(0);
        char lastChar = previousCity.toUpperCase().charAt(pos);

        if (firstChar == 'Ё') firstChar = 'Е';
        if (lastChar == 'Ь' || lastChar == 'Ъ') lastChar = previousCity.toUpperCase().charAt(--pos);

        if (firstChar != lastChar) throw new CharacterMismatchException();
        if (!cities.contains(word)) throw new CityNotFoundException(word);
    }
}
