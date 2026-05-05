package UI.panal;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

    class CategoriesPanal extends JPanel {

        public CategoriesPanal() {
            setBorder(new EmptyBorder(10, 10, 10, 10));
            setLayout(new GridLayout(0, 1, 10, 10));

            add(createCard("Food", 2, 300.0));
            add(createCard("Transport", 1, 50.0));
            add(createCard("Shopping", 1, 200.0));
        }

        private JPanel createCard(String name, int count, double total) {
            JPanel card = new JPanel();
            card.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)
            ));
            card.setLayout(new GridLayout(3, 1));
            card.setBackground(Color.WHITE);

            JLabel lblName = new JLabel("Category: " + name);
            lblName.setFont(new Font("Arial", Font.BOLD, 14));

            card.add(lblName);
            card.add(new JLabel("Count: " + count));
            card.add(new JLabel("Total: $" + total));

            return card;
        }
    }

