import CIE.*;
import SEE.*;
import java.util.Scanner;

class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
       
        System.out.println("Enter the no. of students in class: ");
        int n = sc.nextInt();
       
       
        Internals[] internals = new Internals[n];
        Externals[] externals = new Externals[n];
       
        for(int i = 0; i < n; i++){
            System.out.println("Enter the USN of student " + (i + 1) + ":");
            String usn = sc.next();
            System.out.println("Enter the name: ");
            String name = sc.next();
            System.out.println("Enter the semester: ");
            int sem = sc.nextInt();
           
            int[] internal_marks = new int[3];
            System.out.println("Enter CIE marks in 3 subjects for " + name + " (out of 50): ");
            for(int j = 0; j < 3; j++){
                internal_marks[j] = sc.nextInt();
            }
           
            internals[i] = new Internals(name, usn, sem, internal_marks);
           
            int[] external_marks = new int[3];
            System.out.println("Enter SEE marks in 3 subjects for " + name + " (out of 50): ");
            for(int j = 0; j < 3; j++){
                external_marks[j] = sc.nextInt();
            }
           
            externals[i] = new Externals(name, usn, sem, external_marks);
        }
       
       
        for(int i = 0; i < n; i++){
            System.out.println("The result of " + internals[i].name + " with USN " + internals[i].usn + " is:");
            for(int j = 0; j < 3; j++){
                int totalMarks = internals[i].internal_marks[j] + externals[i].external_marks[j];
                System.out.println("Total marks in subject " + (j + 1) + " is: " + totalMarks);
            }
        }
       
        sc.close();
    }
}
