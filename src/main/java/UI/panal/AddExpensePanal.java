package UI.panal;

import javax.swing.*;
import java.awt.*;

    public class AddExpensePanal extends JPanel {

        public AddExpensePanal() {
            setLayout(new GridLayout(6, 2, 10, 10));

            JTextField amount = new JTextField();
            JComboBox<String> category = new JComboBox<>(new String[]{"Food","Bills"});
            JTextField date = new JTextField();
            JTextArea notes = new JTextArea();

            JButton save = new JButton("Save");
            JButton clear = new JButton("Clear");

            add(new JLabel("Amount"));
            add(amount);
            add(new JLabel("Category"));
            add(category);
            add(new JLabel("Date"));
            add(date);
            add(new JLabel("Notes"));
            add(new JScrollPane(notes));
            add(save);
            add(clear);
        }


    }


