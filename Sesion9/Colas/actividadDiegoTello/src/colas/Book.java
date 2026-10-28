package colas;

import java.util.Objects;

/**
 *
 * Profesora: Adriana Collaguazo Jaramillo
 */
public class Book implements Comparable <Book>  {
    private String title;
    public int year;
    String ISBN;
    
    public Book (String title, int year, String ISBN) {
        this.title = title;
        this.year = year;
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (this.year != other.year) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return Objects.equals(this.ISBN, other.ISBN);
    }

    @Override
    public String toString() {
        return "Book[" + "title=" + title + ", year=" + year + ", ISBN=" + ISBN + "]";    
    }

    /*
    @Override
    public int compareTo(Book b) {
        return b.getYear()- this.getYear();
    }
    */
   
    @Override
    public int compareTo(Book b) {
        return this.getTitle().compareTo(b.getTitle());
        // return b.getTitle().compareTo(this.getTitle());
    }

}
