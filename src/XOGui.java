import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XOGui extends JPanel {
    private char currentPlayer = 'X';
    private JButton[] buttons = new JButton[9];

    public XOGui() {
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 60));
            add(buttons[i]);
            int finalI = i;
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (buttons[finalI].getText().equals("") && currentPlayer != ' ') {
                        buttons[finalI].setText(String.valueOf(currentPlayer));
                        if (checkForWin(currentPlayer)) {
                            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
                            resetBoard();
                        } else if (isBoardFull()) {
                            JOptionPane.showMessageDialog(null, "It's a draw!");
                            resetBoard();
                        } else {
                            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                        }
                    }
                }
            });
        }
    }

    private boolean checkForWin(char player) {
        // Implement your win condition checks here
        // Return true if the player has won, false otherwise
        // For example, check rows, columns, and diagonals
        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    private void resetBoard() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
        }
        currentPlayer = 'X';
    }
}
