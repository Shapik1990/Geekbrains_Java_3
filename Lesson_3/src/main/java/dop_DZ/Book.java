package dop_DZ;

import java.io.Serializable;

public class Book implements Serializable{
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
