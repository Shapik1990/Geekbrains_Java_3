package dop_DZ;

import java.io.Serializable;

public class Student implements Serializable{
    private String name;
    private int id;
    private Book book;

    public Student(String name, int id, Book book) {
        this.name = name;
        this.id = id;
        this.book = book;
    }

    public void getInfo(){
        System.out.println(name + " " + id + " " + book.getName() + " " + this.getClass() + " " + this.hashCode());
    }
}
