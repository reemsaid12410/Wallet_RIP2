package UI.panal;

import javax.swing.*;
import java.awt.*;
import manager.ExpenseManager;
import models.Category;
import models.Expense;
import Util.DateUtil;
import Util.Themes;

public class AddExpensePanal extends JPanel {

    private final Runnable onSaved;

    public AddExpensePanal() {
        this(null);
    }

    public AddExpensePanal(Runnable onSaved) {
        this.onSaved = onSaved;

        setLayout(null);
        setBackground(Themes.PAGE_BG);

        // ─── Card container ───
        JPanel card = new JPanel();
        card.setBounds(20, 20, 720, 340);
        card.setBackground(Themes.INK_BG);
        card.setLayout(null);
        card.setBorder(BorderFactory.createLineBorder(Themes.BORDER_SOFT));
        add(card);

        JLabel title = new JLabel("NEW EXPENSE ENTRY");
        title.setBounds(25, 18, 400, 22);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setForeground(Themes.SAND_DARK);
        card.add(title);

        // ─── Row 1: Amount + Category ───
        JLabel lblAmount = makeFieldLabel("AMOUNT (EGP)");
        lblAmount.setBounds(25, 60, 300, 16);
        card.add(lblAmount);

        JTextField amountField = makeField();
        amountField.setBounds(25, 80, 320, 38);
        card.add(amountField);

        JLabel lblCategory = makeFieldLabel("CATEGORY");
        lblCategory.setBounds(370, 60, 300, 16);
        card.add(lblCategory);

        JComboBox<String> categoryBox = new JComboBox<>(
                new String[]{"Food", "Transport", "Shopping", "Bills"}
        );
        categoryBox.setBounds(370, 80, 320, 38);
        categoryBox.setBackground(Themes.INK_BG_ALT);
        categoryBox.setFont(Themes.FONT_BODY);
        card.add(categoryBox);

        // ─── Row 2: Date + Notes ───
        JLabel lblDate = makeFieldLabel("DATE");
        lblDate.setBounds(25, 135, 300, 16);
        card.add(lblDate);

        JTextField dateField = makeField();
        dateField.setText(DateUtil.todayString());
        dateField.setBounds(25, 155, 320, 38);
        card.add(dateField);

        JLabel lblNotes = makeFieldLabel("NOTES");
        lblNotes.setBounds(370, 135, 300, 16);
        card.add(lblNotes);

        JTextField notesField = makeField();
        notesField.setBounds(370, 155, 320, 38);
        card.add(notesField);

        // ─── Buttons ───
        JButton saveBtn = new JButton("SAVE EXPENSE");
        saveBtn.setBounds(25, 235, 170, 44);
        saveBtn.setBackground(Themes.OLIVE);
        saveBtn.setForeground(Color.WHITE);
        saveBtn.setFont(new Font("Arial", Font.BOLD, 13));
        saveBtn.setFocusPainted(false);
        saveBtn.setBorderPainted(false);
        saveBtn.setOpaque(true);
        saveBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        card.add(saveBtn);

        JButton clearBtn = new JButton("CLEAR");
        clearBtn.setBounds(205, 235, 100, 44);
        clearBtn.setBackground(Themes.INK_BG);
        clearBtn.setForeground(Themes.SAND_DARK);
        clearBtn.setFont(new Font("Arial", Font.BOLD, 13));
        clearBtn.setFocusPainted(false);
        clearBtn.setBorder(BorderFactory.createLineBorder(Themes.BORDER));
        clearBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        card.add(clearBtn);

        // ─── Actions ───
        saveBtn.addActionListener(e -> {
            String amountText = amountField.getText().trim();
            String dateText   = dateField.getText().trim();

            if (amountText.isEmpty()) {
                showWarning("Please enter an amount.");
                return;
            }

            double amount;
            try {
                amount = Double.parseDouble(amountText);
            } catch (NumberFormatException ex) {
                showWarning("Amount must be a number.");
                return;
            }

            if (!ExpenseManager.isValidAmount(amount)) {
                showWarning("Amount must be greater than zero.");
                return;
            }

            if (!DateUtil.isValidDate(dateText)) {
                showWarning("Date must be in yyyy-MM-dd format.");
                return;
            }

            Category category;
            switch ((String) categoryBox.getSelectedItem()) {
                case "Transport": category = Category.TRANSPORT; break;
                case "Shopping":  category = Category.SHOPPING;  break;
                case "Bills":     category = Category.BILLS;     break;
                default:          category = Category.FOOD;      break;
            }

            Expense expense = new Expense(
                    amount, category,
                    DateUtil.parseDate(dateText),
                    notesField.getText().trim()
            );
            ExpenseManager.getInstance().addExpense(expense);

            JOptionPane.showMessageDialog(
                    this, "Expense saved successfully!",
                    "Success", JOptionPane.INFORMATION_MESSAGE
            );

            amountField.setText("");
            dateField.setText(DateUtil.todayString());
            notesField.setText("");
            categoryBox.setSelectedIndex(0);

            if (onSaved != null) onSaved.run();
        });

        clearBtn.addActionListener(e -> {
            amountField.setText("");
            dateField.setText(DateUtil.todayString());
            notesField.setText("");
            categoryBox.setSelectedIndex(0);
        });
    }

    private JLabel makeFieldLabel(String text) {
        JLabel l = new JLabel(text);
        l.setFont(new Font("Monospaced", Font.PLAIN, 10));
        l.setForeground(Themes.MUTED);
        return l;
    }

    private JTextField makeField() {
        JTextField tf = new JTextField();
        tf.setBackground(Themes.INK_BG_ALT);
        tf.setFont(Themes.FONT_BODY);
        tf.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Themes.BORDER_SOFT),
                BorderFactory.createEmptyBorder(0, 10, 0, 10)
        ));
        return tf;
    }

    private void showWarning(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Validation Error", JOptionPane.WARNING_MESSAGE);
    }
}