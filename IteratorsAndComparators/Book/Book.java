package IteratorsAndComparators.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//описваме как ще изглежда и какви действия ще можем да правим с всяка една книга
public class Book {
    //полета -> описваме характеристики
    private String title; //заглавие на книгата
    private int year; //година на издаване
    private List<String> authors; //списък с авторите

    //конструктор
    public Book (String title, int year, String... authors) {
        //нова празна книга
        this.title = title;
        this.year = year;
        this.authors = new ArrayList<>(Arrays.asList(authors));
    }


    //методи -> описваме действие
    public String getTitle() {
        return this.title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return this.year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    private void setAuthors(List<String> authors) {
        this.authors = authors;
    }
}
