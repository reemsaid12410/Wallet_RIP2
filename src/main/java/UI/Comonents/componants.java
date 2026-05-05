package UI.Comonents;


import javax.swing.*;
import java.awt.*;

public class componants {


        public static class StyledButton extends JButton {
            public StyledButton(String text) {
                super(text);
                setFocusPainted(false);
                setBackground(new Color(41, 128, 185));
                setForeground(Color.WHITE);
                setFont(new Font("Arial", Font.BOLD, 14));
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            }
        }

        public static class StatCard extends JPanel {
            private JLabel valueLabel;

            public StatCard(String title, String value) {
                setLayout(new BorderLayout());
                setBackground(new Color(236, 240, 241));
                setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

                JLabel titleLabel = new JLabel(title);
                titleLabel.setFont(new Font("Arial", Font.PLAIN, 14));

                valueLabel = new JLabel(value);
                valueLabel.setFont(new Font("Arial", Font.BOLD, 20));
                valueLabel.setForeground(new Color(39, 174, 96));

                add(titleLabel, BorderLayout.NORTH);
                add(valueLabel, BorderLayout.CENTER);
            }

            public void setValue(String value) {
                valueLabel.setText(value);
            }
        }

        public static class CategoryCard extends JPanel {
            public CategoryCard(String name, int count, double total) {
                setLayout(new GridLayout(3, 1, 5, 5));
                setBackground(Color.WHITE);
                setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));

                JLabel nameLabel = new JLabel("Category: " + name);
                JLabel countLabel = new JLabel("Transactions: " + count);
                JLabel totalLabel = new JLabel("Total: " + total);

                nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
                totalLabel.setForeground(new Color(192, 57, 43));

                add(nameLabel);
                add(countLabel);
                add(totalLabel);
            }
        }


    }

