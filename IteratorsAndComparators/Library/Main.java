package IteratorsAndComparators.Library;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("DefiningClasses.Polymorphism.Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case 2", 1930, "Dorothy Sayers", "Robert Eustace");
        Library library = new Library(bookOne, bookTwo, bookThree);
        //library има възможността да се обхожда

        Iterator<Book> iterator = library.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next().getTitle());
        }

    }
}