package UI.frames;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import manager.ExpenseManager;
import models.Expense;
import models.Category;
import Util.Themes;
import UI.panal.AddExpensePanal;
import UI.panal.ViewExpensePanal;
import UI.panal.CategoriesPanal;
public class MainFrame extends JFrame {

    private ExpenseManager manager;

    private JButton btnDashboard;
    private JButton btnAdd;
    private JButton btnView;
    private JButton btnCategories;
    private JButton btnLogout;

    public MainFrame(ExpenseManager manager) {
        this.manager = manager;

        setTitle("wallet_RIP - Dashboard");
        setSize(960, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Themes.PAGE_BG);

        buildSidebar();
        buildTopbar();
        buildStats();
        buildRecentTable();
        attachEvents();
    }

    private void buildSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setBounds(0, 0, 200, 600);
        sidebar.setBackground(Themes.OLIVE);
        sidebar.setLayout(null);
        add(sidebar);

        JLabel lblBrand = new JLabel("wallet_RIP");
        lblBrand.setBounds(20, 22, 160, 25);
        lblBrand.setFont(new Font("Arial", Font.BOLD, 20));
        lblBrand.setForeground(Color.WHITE);
        sidebar.add(lblBrand);

        JLabel lblBrandSub = new JLabel("// expense tracker");
        lblBrandSub.setBounds(20, 48, 160, 16);
        lblBrandSub.setFont(new Font("Monospaced", Font.PLAIN, 10));
        lblBrandSub.setForeground(Color.WHITE);
        sidebar.add(lblBrandSub);

        JLabel lblMenu = new JLabel("MENU");
        lblMenu.setBounds(20, 90, 100, 16);
        lblMenu.setFont(new Font("Monospaced", Font.PLAIN, 9));
        lblMenu.setForeground(Color.WHITE);
        sidebar.add(lblMenu);

        btnDashboard = makeNavButton("Dashboard", true);
        btnDashboard.setBounds(0, 115, 200, 40);
        sidebar.add(btnDashboard);

        btnAdd = makeNavButton("Add Expense", false);
        btnAdd.setBounds(0, 155, 200, 40);
        sidebar.add(btnAdd);

        btnView = makeNavButton("View Expenses", false);
        btnView.setBounds(0, 195, 200, 40);
        sidebar.add(btnView);

        btnCategories = makeNavButton("Categories", false);
        btnCategories.setBounds(0, 235, 200, 40);
        sidebar.add(btnCategories);

        btnLogout = makeNavButton("Logout", false);
        btnLogout.setBounds(0, 540, 200, 40);
        btnLogout.setForeground(Themes.OLIVE_DARK);
        sidebar.add(btnLogout);
    }

    private JButton makeNavButton(String text, boolean active) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 12));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setMargin(new Insets(0, 25, 0, 0));
        if (active) {
            btn.setBackground(Themes.OLIVE_LIGHT);
        } else {
            btn.setBackground(Themes.OLIVE);
        }
        btn.setForeground(Color.WHITE);
        return btn;
    }


    private void buildTopbar() {
        JPanel topbar = new JPanel();
        topbar.setBounds(200, 0, 760, 50);
        topbar.setBackground(Themes.INK_BG);
        topbar.setLayout(null);
        add(topbar);

        JLabel lblTitle = new JLabel("DASHBOARD");
        lblTitle.setBounds(20, 12, 300, 25);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        topbar.add(lblTitle);

        JLabel lblUser = new JLabel("// admin");
        lblUser.setBounds(670, 15, 70, 22);
        lblUser.setFont(new Font("Monospaced", Font.PLAIN, 11));
        lblUser.setForeground(Themes.OLIVE);
        lblUser.setOpaque(true);
        lblUser.setBackground(Themes.INK_BG_ALT);
        lblUser.setHorizontalAlignment(SwingConstants.CENTER);
        topbar.add(lblUser);
    }

    // ══════════════════════════════════
    // STAT CARDS
    // ══════════════════════════════════
    private void buildStats() {
        // Card 1: Total Spent
        JPanel card1 = makeStatCard("TOTAL SPENT",
                String.format("%.0f", manager.getTotalSpent()),
                "EGP",
                Themes.RED_ACCENT);
        card1.setBounds(220, 70, 235, 110);
        add(card1);

        // Card 2: Transactions
        JPanel card2 = makeStatCard("TRANSACTIONS",
                String.valueOf(manager.getCount()),
                "all time",
                Themes.TEAL);
        card2.setBounds(465, 70, 235, 110);
        add(card2);

        // Card 3: Categories used
        int catsUsed = 0;
        if (manager.getCountByCategory(Category.FOOD) > 0) catsUsed++;
        if (manager.getCountByCategory(Category.TRANSPORT) > 0) catsUsed++;
        if (manager.getCountByCategory(Category.SHOPPING) > 0) catsUsed++;
        if (manager.getCountByCategory(Category.BILLS) > 0) catsUsed++;

        JPanel card3 = makeStatCard("CATEGORIES",
                catsUsed + " / 4",
                "in use",
                Themes.OLIVE);
        card3.setBounds(710, 70, 235, 110);
        add(card3);
    }

    private JPanel makeStatCard(String label, String value, String hint, Color accent) {
        JPanel card = new JPanel();
        card.setBackground(Themes.INK_BG);
        card.setLayout(null);

        JLabel lbl = new JLabel(label);
        lbl.setBounds(15, 12, 200, 18);
        lbl.setFont(new Font("Monospaced", Font.PLAIN, 10));
        lbl.setForeground(Themes.MUTED);
        card.add(lbl);

        JLabel val = new JLabel(value);
        val.setBounds(15, 32, 200, 40);
        val.setFont(new Font("Arial", Font.BOLD, 32));
        val.setForeground(accent);
        card.add(val);

        JLabel hnt = new JLabel(hint);
        hnt.setBounds(15, 75, 200, 18);
        hnt.setFont(new Font("Monospaced", Font.PLAIN, 10));
        hnt.setForeground(Themes.MUTED);
        card.add(hnt);

        // Bottom accent line
        JPanel line = new JPanel();
        line.setBounds(0, 107, 235, 3);
        line.setBackground(accent);
        card.add(line);

        return card;
    }


    private void buildRecentTable() {
        JLabel lblHeader = new JLabel("RECENT EXPENSES");
        lblHeader.setBounds(220, 195, 300, 25);
        lblHeader.setFont(new Font("Arial", Font.BOLD, 14));
        add(lblHeader);

        JPanel box = new JPanel();
        box.setBounds(220, 225, 725, 320);
        box.setBackground(Themes.INK_BG);
        box.setLayout(null);
        add(box);

        ArrayList<Expense> list = manager.getAll();

        // ── If empty ──
        if (list.size() == 0) {
            JLabel empty = new JLabel("No expenses yet. Click 'Add Expense' to start.", SwingConstants.CENTER);
            empty.setBounds(0, 140, 725, 30);
            empty.setFont(new Font("Arial", Font.ITALIC, 14));
            empty.setForeground(Themes.MUTED);
            box.add(empty);
            return;
        }

        // ── Header row ──
        String[] headers = {"#", "AMOUNT", "CATEGORY", "DATE", "NOTES"};
        int[] xs = {15, 60, 160, 290, 420};

        for (int i = 0; i < headers.length; i++) {
            JLabel h = new JLabel(headers[i]);
            h.setBounds(xs[i], 10, 200, 25);
            h.setFont(new Font("Monospaced", Font.PLAIN, 10));
            h.setForeground(Themes.MUTED);
            box.add(h);
        }

        // Separator
        JPanel line = new JPanel();
        line.setBounds(15, 35, 695, 1);
        line.setBackground(Themes.MUTED);
        box.add(line);

        // ── Rows (last 5 expenses) ──
        int max = list.size();
        if (max > 5) max = 5;

        int y = 45;
        int rowNum = 1;
        for (int i = list.size() - 1; i >= list.size() - max; i--) {
            Expense e = list.get(i);

            JLabel num = new JLabel(rowNum + "");
            num.setBounds(15, y, 30, 22);
            num.setFont(new Font("Arial", Font.PLAIN, 12));
            box.add(num);

            JLabel amt = new JLabel("EGP " + (int) e.getAmount());
            amt.setBounds(60, y, 80, 22);
            amt.setFont(new Font("Arial", Font.PLAIN, 12));
            box.add(amt);

            JLabel cat = new JLabel(" " + e.getCategory().getDisplayName() + " ");
            cat.setBounds(160, y, 100, 22);
            cat.setFont(new Font("Arial", Font.BOLD, 10));
            cat.setOpaque(true);
            cat.setHorizontalAlignment(SwingConstants.CENTER);
            colorCategory(cat, e.getCategory());
            box.add(cat);

            JLabel dt = new JLabel(e.getDate().toString());
            dt.setBounds(290, y, 120, 22);
            dt.setFont(new Font("Arial", Font.PLAIN, 12));
            box.add(dt);

            JLabel nt = new JLabel(e.getNotes());
            nt.setBounds(420, y, 280, 22);
            nt.setFont(new Font("Arial", Font.PLAIN, 12));
            box.add(nt);

            y = y + 35;
            rowNum++;
        }
    }

    // Color the category label
    private void colorCategory(JLabel cat, Category category) {
        if (category == Category.FOOD) {
            cat.setBackground(Themes.FOOD_BG);
            cat.setForeground(Themes.FOOD_TEXT);
        } else if (category == Category.TRANSPORT) {
            cat.setBackground(Themes.TRANSPORT_BG);
            cat.setForeground(Themes.TRANSPORT_TEXT);
        } else if (category == Category.SHOPPING) {
            cat.setBackground(Themes.SHOPPING_BG);
            cat.setForeground(Themes.SHOPPING_TEXT);
        } else if (category == Category.BILLS) {
            cat.setBackground(Themes.BILLS_BG);
            cat.setForeground(Themes.BILLS_TEXT);
        }
    }

    private void attachEvents() {
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame("Add Expense");
                f.setSize(400, 350);
                f.setLocationRelativeTo(null);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.add(new AddExpensePanal());
                f.setVisible(true);
            }
        });

        btnView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame("View Expenses");
                f.setSize(700, 450);
                f.setLocationRelativeTo(null);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.add(new ViewExpensePanal());
                f.setVisible(true);
            }
        });

        btnCategories.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame f = new JFrame("Categories");
                f.setSize(700, 450);
                f.setLocationRelativeTo(null);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.add(new CategoriesPanal());
                f.setVisible(true);
            }
        });

        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginFrame f = new LoginFrame();
                f.setVisible(true);
                dispose();
            }
        });
    }
}