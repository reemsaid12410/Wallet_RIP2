package org.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import UI.panal.ViewExpensePanal;
import manager.ExpenseManager;
import UI.frames.LoginFrame;
import UI.panal.DashboardPanal;
import UI.panal.AddExpensePanal;
import UI.Comonents.componants.StyledButton;
import UI.Comonents.componants.StatCard;
import UI.Comonents.componants.CategoryCard;

public class Main {

    public static void main(String[] args) {

        // ── Frame اختيار ──
        JFrame chooser = new JFrame("wallet_RIP - Choose Test");
        chooser.setSize(400, 450);
        chooser.setLayout(null);
        chooser.setLocationRelativeTo(null);
        chooser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chooser.getContentPane().setBackground(new Color(0xFDFAF4));

        // ── Title ──
        JLabel lblTitle = new JLabel("wallet_RIP", SwingConstants.CENTER);
        lblTitle.setBounds(0, 30, 400, 35);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitle.setForeground(new Color(0x5A7A18));
        chooser.add(lblTitle);

        JLabel lblSub = new JLabel("Choose which part to test:", SwingConstants.CENTER);
        lblSub.setBounds(0, 70, 400, 20);
        lblSub.setFont(new Font("Arial", Font.PLAIN, 13));
        lblSub.setForeground(Color.GRAY);
        chooser.add(lblSub);

        // ════════════════════════════════
        // زرار 1 — نور (Dashboard Panel)
        // ════════════════════════════════
        JButton btnNour = new JButton("1. Dashboard - Nour");
        btnNour.setBounds(50, 110, 300, 45);
        btnNour.setBackground(new Color(0x5A7A18));
        btnNour.setForeground(Color.WHITE);
        btnNour.setFont(new Font("Arial", Font.BOLD, 13));
        btnNour.setFocusPainted(false);
        chooser.add(btnNour);

        btnNour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Dashboard");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.add(new DashboardPanal());
                frame.setVisible(true);
            }
        });

        // ════════════════════════════════
        // زرار 2 — دينا (UI Components)
        // ════════════════════════════════
        JButton btnDina = new JButton("2. UI Components - Dina");
        btnDina.setBounds(50, 165, 300, 45);
        btnDina.setBackground(new Color(0x5A7A18));
        btnDina.setForeground(Color.WHITE);
        btnDina.setFont(new Font("Arial", Font.BOLD, 13));
        btnDina.setFocusPainted(false);
        chooser.add(btnDina);

        btnDina.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("UI Test");
                frame.setSize(400, 400);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLayout(new FlowLayout());
                StyledButton btn = new StyledButton("Save");
                StatCard stat = new StatCard("Total Expenses", "5000 EGP");
                CategoryCard cat = new CategoryCard("Food", 5, 1200);
                frame.add(btn);
                frame.add(stat);
                frame.add(cat);
                frame.setVisible(true);
            }
        });

        // ════════════════════════════════
        // زرار 3 — هاجر (Add Expense Panel)
        // ════════════════════════════════
        JButton btnHagar = new JButton("3. Add Expense - Hagar");
        btnHagar.setBounds(50, 220, 300, 45);
        btnHagar.setBackground(new Color(0x5A7A18));
        btnHagar.setForeground(Color.WHITE);
        btnHagar.setFont(new Font("Arial", Font.BOLD, 13));
        btnHagar.setFocusPainted(false);
        chooser.add(btnHagar);

        btnHagar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Add Expense");
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.add(new AddExpensePanal());
                frame.setVisible(true);
            }
        });

        // ════════════════════════════════
        // زرار 4 — نور جلال (Login بدون manager)
        // ════════════════════════════════
        JButton btnNourG = new JButton("4. Login (no manager) - Nour Galal");
        btnNourG.setBounds(50, 275, 300, 45);
        btnNourG.setBackground(new Color(0x5A7A18));
        btnNourG.setForeground(Color.WHITE);
        btnNourG.setFont(new Font("Arial", Font.BOLD, 13));
        btnNourG.setFocusPainted(false);
        chooser.add(btnNourG);

        btnNourG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        LoginFrame loginScreen = new LoginFrame();
                        loginScreen.setVisible(true);
                    }
                });
            }
        });

        // ════════════════════════════════
        // زرار 5 — ريم (Login + Manager)
        // ════════════════════════════════
        JButton btnReem = new JButton("5. Full App - Reem (you)");
        btnReem.setBounds(50, 330, 300, 45);
        btnReem.setBackground(new Color(0x6B8C24));
        btnReem.setForeground(Color.WHITE);
        btnReem.setFont(new Font("Arial", Font.BOLD, 13));
        btnReem.setFocusPainted(false);
        chooser.add(btnReem);

        btnReem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ExpenseManager manager = ExpenseManager.getInstance();
                LoginFrame login = new LoginFrame();
                login.setVisible(true);
            }
        });

        // ── إظهار الفريم ──
        chooser.setVisible(true);


                JFrame frame = new JFrame("View Expenses");

                frame.setSize(600, 400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                ViewExpensePanal.ViewExpensesPanel panel = new ViewExpensePanal.ViewExpensesPanel();

                frame.add(panel);

                frame.setVisible(true);
            }
        }
