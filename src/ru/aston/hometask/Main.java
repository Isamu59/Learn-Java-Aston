package ru.aston.hometask;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        List<Student> students;

        try {
            students = mapper.readValue(
                new File("src/ru/aston/hometask/students.json"),
                new TypeReference<List<Student>>() {}
            );
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
            return;
        }

        students.forEach(System.out::println);

        Optional<Integer> year = students.stream()
            .flatMap(s -> s.getBooks().stream())
            .sorted((b1, b2) -> Integer.compare(b1.getPages(), b2.getPages()))
            .distinct()
            .filter(b -> b.getYear() > 2000)
            .limit(3)
            .map(Book::getYear)
            .findFirst();

        System.out.println(year.map(integer -> "Год выпуска: " + integer).orElse("Такая книга отсутствует"));
    }
}