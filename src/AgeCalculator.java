import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator extends JFrame {

    private JTextField birthDateField;
    private JLabel resultLabel;

    public AgeCalculator() {

        setTitle("Age Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel birthDateLabel = new JLabel("Enter your birth date (YYYY-MM-DD):");
        birthDateField = new JTextField();

        JButton calculateButton = new JButton("Calculate Age");
        calculateButton.addActionListener(new AgeButtonListener());

        resultLabel = new JLabel("Your age will be displayed here.");

        panel.add(birthDateLabel);
        panel.add(birthDateField);
        panel.add(calculateButton);
        panel.add(resultLabel);

        add(panel);
        setVisible(true);
    }

    private class AgeButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Get the birth date from the text field
                LocalDate birthDate = LocalDate.parse(birthDateField.getText());
                LocalDate currentDate = LocalDate.now();

                // Calculate the age
                Period age = Period.between(birthDate, currentDate);

                // Display the age
                resultLabel.setText("You are " + age.getYears() + " years old.");
            } catch (Exception ex) {
                resultLabel.setText("Invalid date format. Please use YYYY-MM-DD.");
            }
        }
    }

    public static void main(String[] args) {
        new AgeCalculator();
    }
}
