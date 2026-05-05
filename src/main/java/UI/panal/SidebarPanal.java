package UI.panal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

    public class SidebarPanal extends JPanel {

        JButton dashboardBtn;
        JButton addExpenseBtn;
        JButton viewExpensesBtn;
        JButton categoriesBtn;
        JButton logoutBtn;

        public SidebarPanal() {

            setLayout(new GridLayout(5, 1, 10, 10));
            setBackground(Color.LIGHT_GRAY);

            dashboardBtn = new JButton("Dashboard");
            addExpenseBtn = new JButton("Add Expense");
            viewExpensesBtn = new JButton("View Expenses");
            categoriesBtn = new JButton("Categories");
            logoutBtn = new JButton("Logout");

            add(dashboardBtn);
            add(addExpenseBtn);
            add(viewExpensesBtn);
            add(categoriesBtn);
            add(logoutBtn);
        }

        // methods علشان نربطها بعدين مع MainFrame
        public void setDashboardAction(ActionListener action) {
            dashboardBtn.addActionListener(action);
        }

        public void setAddExpenseAction(ActionListener action) {
            addExpenseBtn.addActionListener(action);
        }

        public void setViewExpensesAction(ActionListener action) {
            viewExpensesBtn.addActionListener(action);
        }

        public void setCategoriesAction(ActionListener action) {
            categoriesBtn.addActionListener(action);
        }

        public void setLogoutAction(ActionListener action) {
            logoutBtn.addActionListener(action);
        }
    }

