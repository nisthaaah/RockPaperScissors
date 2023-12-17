import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RPSGUI extends JFrame implements ActionListener {
    private final JLabel resultLabel;
    private final JButton rockButton, paperButton, scissorButton;
    private final JTextField playerMoveField;
    private final JTextArea gameOutputArea;
    private final Random random;
    private String[] rps = {"Rock", "Paper", "Scissor"};

    public RPSGUI() {
        setTitle("Rock-Paper-Scissors Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        resultLabel = new JLabel("Result: ");
        resultLabel.setBounds(20, 20, 150, 30);
        add(resultLabel);

        rockButton = new JButton("Rock");
        rockButton.setBounds(20, 70, 100, 30);
        rockButton.addActionListener(this);
        add(rockButton);

        paperButton = new JButton("Paper");
        paperButton.setBounds(140, 70, 100, 30);
        paperButton.addActionListener(this);
        add(paperButton);

        scissorButton = new JButton("Scissor");
        scissorButton.setBounds(260, 70, 100, 30);
        scissorButton.addActionListener(this);
        add(scissorButton);

        playerMoveField = new JTextField();
        playerMoveField.setBounds(20, 120, 340, 30);
        playerMoveField.setEditable(false);
        add(playerMoveField);

        gameOutputArea = new JTextArea();
        gameOutputArea.setBounds(20, 170, 340, 180);
        gameOutputArea.setEditable(false);
        add(gameOutputArea);

        random = new Random();

        setSize(400, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String computerMove = rps[random.nextInt(rps.length)];
        String playerMove = "";

        if (e.getSource() == rockButton) {
            playerMove = "Rock";
        } else if (e.getSource() == paperButton) {
            playerMove = "Paper";
        } else if (e.getSource() == scissorButton) {
            playerMove = "Scissor";
        }

        playerMoveField.setText("Player move: " + playerMove);
        String result = determineWinner(playerMove, computerMove);
        gameOutputArea.append("Computer played: " + computerMove + "\n" + result + "\n\n");
    }

    private String determineWinner(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "IT'S A TIE!!";
        } else if ((playerMove.equals("Rock") && computerMove.equals("Scissor")) ||
                   (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                   (playerMove.equals("Scissor") && computerMove.equals("Paper"))) {
            return "YOU WIN!!";
        } else {
            return "YOU LOSE!!";
        }
    }

    public static void main(String[] args) {
        new RPSGUI();
    }
}
