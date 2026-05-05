package UI.panal;

import javax.swing.*;
import java.awt.*;
import manager.ExpenseManager;
import models.Category;
import models.Expense;
import Util.Themes;

public class CategoriesPanal extends JPanel {

    public CategoriesPanal() {
        setLayout(null);
        setBackground(Themes.PAGE_BG);

        // ─── Section header ───
        JLabel header = new JLabel("SPENDING BY CATEGORY");
        header.setBounds(20, 15, 300, 22);
        header.setFont(new Font("Arial", Font.BOLD, 14));
        header.setForeground(Themes.SAND_DARK);
        add(header);

        JPanel headerLine = new JPanel();
        headerLine.setBounds(220, 26, 520, 1);
        headerLine.setBackground(Themes.BORDER_SOFT);
        add(headerLine);

        // ─── Cards grid (2x2) ───
        Category[] cats = {Category.FOOD, Category.TRANSPORT, Category.SHOPPING, Category.BILLS};
        int[][] positions = {
                {20, 55},   // Food
                {390, 55},  // Transport
                {20, 185},  // Shopping
                {390, 185}  // Bills
        };

        for (int i = 0; i < cats.length; i++) {
            JPanel card = makeCategoryCard(cats[i]);
            card.setBounds(positions[i][0], positions[i][1], 350, 115);
            add(card);
        }
    }

    private JPanel makeCategoryCard(Category cat) {
        Color bg, text, border;
        if (cat == Category.FOOD) {
            bg = Themes.FOOD_BG;       text = Themes.FOOD_TEXT;       border = Themes.FOOD_BORDER;
        } else if (cat == Category.TRANSPORT) {
            bg = Themes.TRANSPORT_BG;  text = Themes.TRANSPORT_TEXT;  border = Themes.TRANSPORT_BORDER;
        } else if (cat == Category.SHOPPING) {
            bg = Themes.SHOPPING_BG;   text = Themes.SHOPPING_TEXT;   border = Themes.SHOPPING_BORDER;
        } else {
            bg = Themes.BILLS_BG;      text = Themes.BILLS_TEXT;      border = Themes.BILLS_BORDER;
        }

        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBackground(Themes.INK_BG);
        card.setBorder(BorderFactory.createLineBorder(Themes.BORDER_SOFT));

        // Icon box
        JPanel iconBox = new JPanel();
        iconBox.setBounds(18, 22, 72, 72);
        iconBox.setBackground(bg);
        iconBox.setBorder(BorderFactory.createLineBorder(border));
        iconBox.setLayout(new BorderLayout());

        JLabel emoji = new JLabel(cat.getEmoji(), SwingConstants.CENTER);
        emoji.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 32));
        iconBox.add(emoji, BorderLayout.CENTER);
        card.add(iconBox);

        // Category name
        JLabel name = new JLabel(cat.getDisplayName().toUpperCase());
        name.setBounds(105, 30, 150, 22);
        name.setFont(new Font("Arial", Font.BOLD, 14));
        name.setForeground(Themes.SAND_DARK);
        card.add(name);

        // Transactions count
        int count = countByCategory(cat);
        JLabel sub = new JLabel(count + " transactions");
        sub.setBounds(105, 55, 180, 18);
        sub.setFont(new Font("Monospaced", Font.PLAIN, 11));
        sub.setForeground(Themes.MUTED);
        card.add(sub);

        // Total amount
        double total = totalByCategory(cat);
        JLabel amount = new JLabel(String.format("%.0f", total), SwingConstants.RIGHT);
        amount.setBounds(220, 32, 115, 50);
        amount.setFont(new Font("Arial", Font.BOLD, 32));
        amount.setForeground(text);
        card.add(amount);

        return card;
    }

    private int countByCategory(Category cat) {
        return ExpenseManager.getInstance().getCountByCategory(cat);
    }

    private double totalByCategory(Category cat) {
        double sum = 0;
        for (Expense e : ExpenseManager.getInstance().getAll()) {
            if (e.getCategory() == cat) sum += e.getAmount();
        }
        return sum;
    }
}