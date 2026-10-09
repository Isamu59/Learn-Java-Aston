package ru.aston.hometask;

import java.util.List;

public class Student {
    private String name;
    private List<Book> books;

    public Student() {}

    public Student(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "'\n  books=[\n    " + 
               books.stream().map(b -> b.toString()).collect(java.util.stream.Collectors.joining(",\n    ")) + 
               "\n  ]}";
    }
}