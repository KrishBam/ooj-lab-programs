package CIE;

public class Internals extends Students{
    public int internal_marks[];
    
    public Internals(String name, String usn, int sem, int internal_marks[]){
        super(name,usn,sem);
        this.internal_marks = internal_marks;
    }
}