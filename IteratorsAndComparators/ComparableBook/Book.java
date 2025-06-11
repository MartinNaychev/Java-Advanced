package IteratorsAndComparators.ComparableBook;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Book implements Comparable<Book>{

    private String title; //заглавие на книгата
    private int year; //година на издаване
    private List<String> authors; //списък с авторите

    public Book (String title, int year, String... authors) {

        this.title = title;
        this.year = year;
        this.authors = new ArrayList<>(Arrays.asList(authors));
    }

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

    @Override
    public int compareTo(Book nextBook) {
        int result =this.title.compareTo(nextBook.title);

        if (result==0){

            result= Integer.compare(this.year,nextBook.year);



        }
        return result;
    }
}

