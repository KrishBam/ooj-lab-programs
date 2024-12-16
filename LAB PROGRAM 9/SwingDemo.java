import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SwingDemo {
    SwingDemo() {
        // Create JFrame container
        JFrame jfrm = new JFrame("Divider App");
        jfrm.setSize(300, 250); // Increased the size for better readability
        jfrm.setLayout(new FlowLayout());

        // To terminate on close
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Display Name and USN
        JLabel nameLabel = new JLabel("Name: Krish Bam and USN: 1BM23CS158");
        jfrm.add(nameLabel); // Display Name and USN label

        // Text label
        JLabel jlab = new JLabel("Enter the dividend and divisor:");

        // Add text field for both numbers
        JTextField ajtf = new JTextField(8);
        JTextField bjtf = new JTextField(8);

        // Calculate button
        JButton button = new JButton("Calculate");

        // Labels to display result and error messages
        JLabel err = new JLabel();
        JLabel alab = new JLabel();
        JLabel blab = new JLabel();
        JLabel anslab = new JLabel();

        // Add components in order
        jfrm.add(jlab);
        jfrm.add(ajtf);
        jfrm.add(bjtf);
        jfrm.add(button);
        jfrm.add(alab);
        jfrm.add(blab);
        jfrm.add(anslab);
        jfrm.add(err); // Error label at the bottom

        // ActionListener for button click
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    // Parse integers from text fields
                    int a = Integer.parseInt(ajtf.getText());
                    int b = Integer.parseInt(bjtf.getText());

                    // Perform division
                    int ans = a / b;

                    // Display results
                    alab.setText("A = " + a);
                    blab.setText("B = " + b);
                    anslab.setText("Answer = " + ans);
                    err.setText(""); // Clear any previous error
                } catch (NumberFormatException e) {
                    // Handle non-integer input
                    alab.setText("");
                    blab.setText("");
                    anslab.setText("");
                    err.setText("Enter only integers!");
                } catch (ArithmeticException e) {
                    // Handle division by zero
                    alab.setText("");
                    blab.setText("");
                    anslab.setText("");
                    err.setText("B should be NON-zero!");
                }
            }
        });

        // Display frame
        jfrm.setVisible(true);
    }

    public static void main(String args[]) {
        // Create frame on event dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingDemo();
            }
        });
    }
}
