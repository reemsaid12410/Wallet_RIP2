package UI.panal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import manager.ExpenseManager;
import models.Category;
import models.Expense;
import Util.Themes;

public class ViewExpensePanal extends JPanel {

    public ViewExpensePanal() {
        setLayout(null);
        setBackground(Themes.PAGE_BG);

        // ─── Section header ───
        JLabel header = new JLabel("ALL EXPENSES");
        header.setBounds(20, 15, 300, 22);
        header.setFont(new Font("Arial", Font.BOLD, 14));
        header.setForeground(Themes.SAND_DARK);
        add(header);

        JPanel headerLine = new JPanel();
        headerLine.setBounds(20, 42, 720, 1);
        headerLine.setBackground(Themes.BORDER_SOFT);
        add(headerLine);

        // ─── Table container ───
        JPanel tableBox = new JPanel();
        tableBox.setLayout(null);
        tableBox.setBackground(Themes.INK_BG);

        ArrayList<Expense> list = ExpenseManager.getInstance().getAll();

        // Column headers
        String[] headers = {"#", "AMOUNT", "CATEGORY", "DATE", "NOTES"};
        int[] xs = {20, 70, 220, 400, 540};
        int[] widths = {30, 120, 150, 120, 180};

        JPanel colHeader = new JPanel();
        colHeader.setLayout(null);
        colHeader.setBackground(Themes.INK_BG_ALT);
        colHeader.setBounds(0, 0, 720, 38);
        tableBox.add(colHeader);

        for (int i = 0; i < headers.length; i++) {
            JLabel h = new JLabel(headers[i]);
            h.setBounds(xs[i], 10, widths[i], 18);
            h.setFont(new Font("Monospaced", Font.PLAIN, 10));
            h.setForeground(Themes.MUTED);
            colHeader.add(h);
        }

        // Rows
        int y = 50;
        int rowNum = 1;
        for (Expense e : list) {
            JLabel num = new JLabel(String.valueOf(rowNum));
            num.setBounds(xs[0], y, widths[0], 22);
            num.setFont(new Font("Arial", Font.PLAIN, 13));
            num.setForeground(Themes.SAND_DARK);
            tableBox.add(num);

            JLabel amt = new JLabel("EGP " + (int) e.getAmount());
            amt.setBounds(xs[1], y, widths[1], 22);
            amt.setFont(new Font("Arial", Font.PLAIN, 13));
            amt.setForeground(Themes.SAND_DARK);
            tableBox.add(amt);

            JLabel badge = makeCategoryBadge(e.getCategory());
            badge.setBounds(xs[2], y - 2, 90, 26);
            tableBox.add(badge);

            JLabel dt = new JLabel(e.getDate().toString());
            dt.setBounds(xs[3], y, widths[3], 22);
            dt.setFont(new Font("Arial", Font.PLAIN, 13));
            dt.setForeground(Themes.SAND_DARK);
            tableBox.add(dt);

            String notes = e.getNotes() == null ? "" : e.getNotes();
            JLabel nt = new JLabel(notes);
            nt.setBounds(xs[4], y, widths[4], 22);
            nt.setFont(new Font("Arial", Font.PLAIN, 13));
            nt.setForeground(Themes.SAND_DARK);
            tableBox.add(nt);

            // Row separator
            JPanel rowSep = new JPanel();
            rowSep.setBounds(15, y + 28, 690, 1);
            rowSep.setBackground(Themes.BORDER_SOFT);
            tableBox.add(rowSep);

            y += 42;
            rowNum++;
        }

        if (list.isEmpty()) {
            JLabel empty = new JLabel(
                    "No expenses yet. Click 'Add Expense' to start.",
                    SwingConstants.CENTER
            );
            empty.setBounds(0, 70, 720, 30);
            empty.setForeground(Themes.MUTED);
            empty.setFont(new Font("Arial", Font.ITALIC, 14));
            tableBox.add(empty);
            y = 130;
        }

        int contentHeight = Math.max(y + 20, 200);
        tableBox.setPreferredSize(new Dimension(720, contentHeight));

        JScrollPane scroll = new JScrollPane(tableBox);
        scroll.setBounds(20, 55, 720, 470);
        scroll.setBorder(BorderFactory.createLineBorder(Themes.BORDER_SOFT));
        scroll.getViewport().setBackground(Themes.INK_BG);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll);
    }

    private JLabel makeCategoryBadge(Category cat) {
        JLabel lbl = new JLabel(cat.getDisplayName().toUpperCase(), SwingConstants.CENTER);
        lbl.setFont(new Font("Monospaced", Font.BOLD, 10));
        lbl.setOpaque(true);

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

        lbl.setBackground(bg);
        lbl.setForeground(text);
        lbl.setBorder(BorderFactory.createLineBorder(border));
        return lbl;
    }
}