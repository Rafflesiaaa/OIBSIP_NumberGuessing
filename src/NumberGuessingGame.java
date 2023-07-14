import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NumberGuessingGame extends JFrame {
	private int targetNumber;
	private int guessCount;
	private JLabel promptLabel;
	private JTextField guessField;
	private JButton guessButton;

	public NumberGuessingGame() {
		super("Number Guessing Game");
		targetNumber = (int) (Math.random() * 100) + 1;
		guessCount = 0;

		promptLabel = new JLabel("Enter a number between 1 and 100:");
		guessField = new JTextField(10);
		guessButton = new JButton("Guess");

		guessButton.addActionListener(new GuessButtonListener());

		setLayout(new FlowLayout());
		add(promptLabel);
		add(guessField);
		add(guessButton);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setSize(500, 300);
		setLocation(700, 350);
		setVisible(true);
	}

	private class GuessButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				int guess = Integer.parseInt(guessField.getText());
				guessCount++;

				if (guess == targetNumber) {
					JOptionPane.showMessageDialog(NumberGuessingGame.this, "Congratulations! You guessed the number in " + guessCount + " attempts.", "Winner", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				} else if (guess < targetNumber) {
					JOptionPane.showMessageDialog(NumberGuessingGame.this, "Too low! Try again.", "Wrong Guess", JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(NumberGuessingGame.this, "Too high! Try again.", "Wrong Guess", JOptionPane.WARNING_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(NumberGuessingGame.this, "Invalid input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new NumberGuessingGame();
		});
	}
}
