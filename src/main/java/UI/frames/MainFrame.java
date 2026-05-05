package UI.frames;

import java.awt.*;
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

    private final ExpenseManager manager;

    private JButton btnDashboard;
    private JButton btnAdd;
    private JButton btnView;
    private JButton btnCategories;
    private JButton btnLogout;

    private JLabel topbarTitle;
    private JPanel contentArea;
    private JButton activeBtn;

    public MainFrame(ExpenseManager manager) {
        this.manager = manager;

        setTitle("wallet_RIP ");
        setSize(960, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Themes.PAGE_BG);

        buildSidebar();
        buildTopbar();
        buildContentArea();
        attachEvents();
        showDashboard();
    }

    // ══════════════════════════════════
    // SIDEBAR
    // ══════════════════════════════════
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

//        JLabel lblBrandSub = new JLabel("// expense tracker");
//        lblBrandSub.setBounds(20, 48, 160, 16);
//        lblBrandSub.setFont(new Font("Monospaced", Font.PLAIN, 10));
//        lblBrandSub.setForeground(Color.WHITE);
//        sidebar.add(lblBrandSub);

//        JLabel lblMenu = new JLabel("MENU");
//        lblMenu.setBounds(20, 90, 100, 16);
//        lblMenu.setFont(new Font("Monospaced", Font.PLAIN, 9));
//        lblMenu.setForeground(Color.WHITE);
//        sidebar.add(lblMenu);

        btnDashboard = makeNavButton("Dashboard");
        btnDashboard.setBounds(0, 115, 200, 40);
        sidebar.add(btnDashboard);

        btnAdd = makeNavButton("Add Expense");
        btnAdd.setBounds(0, 155, 200, 40);
        sidebar.add(btnAdd);

        btnView = makeNavButton("View Expenses");
        btnView.setBounds(0, 195, 200, 40);
        sidebar.add(btnView);

        btnCategories = makeNavButton("Categories");
        btnCategories.setBounds(0, 235, 200, 40);
        sidebar.add(btnCategories);

        btnLogout = makeNavButton("Logout");
        btnLogout.setBounds(0, 540, 200, 40);
        sidebar.add(btnLogout);
    }

    private JButton makeNavButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 12));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setMargin(new Insets(0, 25, 0, 0));
        btn.setBackground(Themes.OLIVE);
        btn.setForeground(Color.WHITE);
        btn.setOpaque(true);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private void setActiveButton(JButton btn) {
        if (activeBtn != null) {
            activeBtn.setBackground(Themes.OLIVE);
        }
        activeBtn = btn;
        if (activeBtn != null) {
            activeBtn.setBackground(Themes.OLIVE_LIGHT);
        }
    }


    private void buildTopbar() {
        JPanel topbar = new JPanel();
        topbar.setBounds(200, 0, 760, 50);
        topbar.setBackground(Themes.INK_BG);
        topbar.setLayout(null);
        add(topbar);

        topbarTitle = new JLabel("DASHBOARD");
        topbarTitle.setBounds(20, 12, 400, 25);
        topbarTitle.setFont(new Font("Arial", Font.BOLD, 18));
        topbar.add(topbarTitle);

        JLabel lblUser = new JLabel("admin");
        lblUser.setBounds(670, 15, 70, 22);
        lblUser.setFont(new Font("Monospaced", Font.PLAIN, 11));
        lblUser.setForeground(Themes.OLIVE);
        lblUser.setOpaque(true);
        lblUser.setBackground(Themes.INK_BG_ALT);
        lblUser.setHorizontalAlignment(SwingConstants.CENTER);
        topbar.add(lblUser);
    }


    private void buildContentArea() {
        contentArea = new JPanel();
        contentArea.setBounds(200, 50, 760, 550);
        contentArea.setBackground(Themes.PAGE_BG);
        contentArea.setLayout(new BorderLayout());
        add(contentArea);
    }

    private void swapView(JPanel view, String title, JButton button) {
        topbarTitle.setText(title);
        contentArea.removeAll();
        contentArea.add(view, BorderLayout.CENTER);
        contentArea.revalidate();
        contentArea.repaint();
        setActiveButton(button);
    }

    private void showDashboard() {
        swapView(buildDashboardView(), "DASHBOARD", btnDashboard);
    }

    private void showAddExpense() {
        AddExpensePanal panel = new AddExpensePanal(this::showDashboard);
        swapView(panel, "ADD EXPENSE", btnAdd);
    }

    private void showViewExpenses() {
        swapView(new ViewExpensePanal(), "VIEW EXPENSES", btnView);
    }

    private void showCategories() {
        swapView(new CategoriesPanal(), "CATEGORIES", btnCategories);
    }


    private JPanel buildDashboardView() {
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Themes.PAGE_BG);

        // Stat cards
        JPanel card1 = makeStatCard("TOTAL SPENT",
                String.format("%.0f", manager.getTotalSpent()),
                "EGP", Themes.RED_ACCENT);
        card1.setBounds(20, 20, 235, 110);
        p.add(card1);

        JPanel card2 = makeStatCard("TRANSACTIONS",
                String.valueOf(manager.getCount()),
                "all time", Themes.TEAL);
        card2.setBounds(265, 20, 235, 110);
        p.add(card2);

        int catsUsed = 0;
        if (manager.getCountByCategory(Category.FOOD) > 0)      catsUsed++;
        if (manager.getCountByCategory(Category.TRANSPORT) > 0) catsUsed++;
        if (manager.getCountByCategory(Category.SHOPPING) > 0)  catsUsed++;
        if (manager.getCountByCategory(Category.BILLS) > 0)     catsUsed++;

        JPanel card3 = makeStatCard("CATEGORIES",
                catsUsed + " / 4",
                "in use", Themes.OLIVE);
        card3.setBounds(510, 20, 235, 110);
        p.add(card3);

        // Recent expenses
        JLabel lblHeader = new JLabel("RECENT EXPENSES");
        lblHeader.setBounds(20, 145, 300, 25);
        lblHeader.setFont(new Font("Arial", Font.BOLD, 14));
        p.add(lblHeader);

        JPanel box = new JPanel();
        box.setBounds(20, 175, 725, 320);
        box.setBackground(Themes.INK_BG);
        box.setLayout(null);
        box.setBorder(BorderFactory.createLineBorder(Themes.BORDER_SOFT));
        p.add(box);

        ArrayList<Expense> list = manager.getAll();

        if (list.isEmpty()) {
            JLabel empty = new JLabel(
                    "No expenses yet. Click 'Add Expense' to start.",
                    SwingConstants.CENTER
            );
            empty.setBounds(0, 140, 725, 30);
            empty.setFont(new Font("Arial", Font.ITALIC, 14));
            empty.setForeground(Themes.MUTED);
            box.add(empty);
            return p;
        }

        String[] headers = {"#", "AMOUNT", "CATEGORY", "DATE", "NOTES"};
        int[] xs = {15, 60, 160, 290, 420};

        for (int i = 0; i < headers.length; i++) {
            JLabel h = new JLabel(headers[i]);
            h.setBounds(xs[i], 10, 200, 25);
            h.setFont(new Font("Monospaced", Font.PLAIN, 10));
            h.setForeground(Themes.MUTED);
            box.add(h);
        }

        JPanel line = new JPanel();
        line.setBounds(15, 35, 695, 1);
        line.setBackground(Themes.BORDER_SOFT);
        box.add(line);

        int max = Math.min(list.size(), 5);
        int y = 45;
        int rowNum = 1;
        for (int i = list.size() - 1; i >= list.size() - max; i--) {
            Expense e = list.get(i);

            JLabel num = new JLabel(String.valueOf(rowNum));
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

            y += 35;
            rowNum++;
        }
        return p;
    }

    private JPanel makeStatCard(String label, String value, String hint, Color accent) {
        JPanel card = new JPanel();
        card.setBackground(Themes.INK_BG);
        card.setLayout(null);
        card.setBorder(BorderFactory.createLineBorder(Themes.BORDER_SOFT));

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

        JPanel line = new JPanel();
        line.setBounds(0, 107, 235, 3);
        line.setBackground(accent);
        card.add(line);

        return card;
    }

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
        btnDashboard.addActionListener(e -> showDashboard());
        btnAdd.addActionListener(e -> showAddExpense());
        btnView.addActionListener(e -> showViewExpenses());
        btnCategories.addActionListener(e -> showCategories());

        btnLogout.addActionListener(e -> {
            LoginFrame f = new LoginFrame();
            f.setVisible(true);
            dispose();
        });
    }
}