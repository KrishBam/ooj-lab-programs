// Define custom exceptions
class WrongAgeException extends Exception {
    public WrongAgeException(String message) {
        super(message);
    }
}

class InvalidSonAgeException extends Exception {
    public InvalidSonAgeException(String message) {
        super(message);
    }
}

// Base class Father
class Father {
    protected int fatherAge;

    public Father(int fatherAge) throws WrongAgeException {
        if (fatherAge < 0) {
            throw new WrongAgeException("Father's age cannot be less than 0.");
        }
        this.fatherAge = fatherAge;
        System.out.println("Father's age set to " + this.fatherAge);
    }
}

// Derived class Son
class Son extends Father {
    private int sonAge;

    public Son(int fatherAge, int sonAge) throws WrongAgeException, InvalidSonAgeException {
        super(fatherAge); // Call the constructor of the base class
        if (sonAge < 0) {
            throw new WrongAgeException("Son's age cannot be less than 0.");
        }
        if (sonAge >= fatherAge) {
            throw new InvalidSonAgeException("Son's age cannot be greater than or equal to Father's age.");
        }
        this.sonAge = sonAge;
        System.out.println("Son's age set to " + this.sonAge);
    }
}

// Main class to test the program
public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        // Display Name and USN
        System.out.println("Name: Krish Bam and USN: 1BM23CS158");

        try {
            java.util.Scanner scanner = new java.util.Scanner(System.in);

            System.out.print("Enter Father's age: ");
            int fatherAge = scanner.nextInt();

            System.out.print("Enter Son's age: ");
            int sonAge = scanner.nextInt();

            Son son = new Son(fatherAge, sonAge);
        } catch (WrongAgeException e) {
            System.out.println("WrongAgeException: " + e.getMessage());
        } catch (InvalidSonAgeException e) {
            System.out.println("InvalidSonAgeException: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input! Please enter integers for ages.");
        } finally {
            System.out.println("Program execution completed.");
        }
    }
}
