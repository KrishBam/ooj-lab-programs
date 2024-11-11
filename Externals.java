package SEE;
import CIE.Students;

public class Externals extends Students{
    public int external_marks[];
    
    public Externals(String name, String usn, int sem, int external_marks[]){
        super(name,usn,sem);
        this.external_marks = external_marks;
    }
}

