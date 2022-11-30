
package example.flatmap;

import java.util.HashSet;
import java.util.Set;


public class Student {

  
    private String id;
    private String name;
    private String familyName;
    private Set< String > books= new HashSet<String>();

    public Student(String id, String name, String familyName ) {
        this.id = id;
        this.name = name;
        this.familyName = familyName;
    }

    public void addBook( String bookName ) {
        books.add( bookName );
    }
    public Set<String> getBooks( ) {
        return new HashSet<String>( books);
    }
    // getters 
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getFamilyName() {
        return familyName;
    }
};

class P extends Student{

    public P(String id, String name, String familyName) {
        super(id, name, familyName);
    }

    public String g() {
        return getId();
    }
}
