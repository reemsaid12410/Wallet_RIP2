package UI.frames;

import manager.AuthManager;
import javax.swing.*;
import java.awt.*;


import javax.swing.*;
import java.awt.*;

    public class LoginFrame extends JFrame {
        private JTextField usernameField;
        private JPasswordField passwordField;
        private JButton loginBtn;

        public LoginFrame() {
            // إعدادات النافذة الأساسية
            setTitle("Login");
            setSize(400, 550);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null); // عشان تظهر في نص الشاشة

            // تعريف الألوان من تصميم Wallet_RIP
            Color oliveGreen = new Color(107, 142, 35);
            Color creamBg = new Color(242, 241, 232);
            Color inputBg = new Color(230, 230, 225);

            // إنشاء الـ Panel الرئيسي وترتيبه
            JPanel formPanel = new JPanel();
            formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
            formPanel.setBackground(creamBg);
            formPanel.setBorder(BorderFactory.createEmptyBorder(50, 40, 50, 40));

            // عنوان SIGN IN
            JLabel titleLabel = new JLabel("SIGN IN");
            titleLabel.setFont(new Font("Monospaced", Font.BOLD, 28));
            titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            // حقل اسم المستخدم (Username)
            JLabel userLabel = new JLabel("USERNAME");
            userLabel.setFont(new Font("SansSerif", Font.BOLD, 11));
            userLabel.setForeground(Color.GRAY);

            usernameField = new JTextField();
            usernameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
            usernameField.setBackground(inputBg);
            usernameField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 190)));

            // حقل كلمة المرور (Password)
            JLabel passLabel = new JLabel("PASSWORD");
            passLabel.setFont(new Font("SansSerif", Font.BOLD, 11));
            passLabel.setForeground(Color.GRAY);

            passwordField = new JPasswordField();
            passwordField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
            passwordField.setBackground(inputBg);
            passwordField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 190)));

            loginBtn = new JButton("LOGIN →");
            loginBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
            loginBtn.setBackground(oliveGreen); // الخلفية زيتوني زي ما هي

            loginBtn.setForeground(new Color(225, 225, 200));

            loginBtn.setFocusPainted(false);
            loginBtn.setBorder(BorderFactory.createEmptyBorder());
            loginBtn.setFont(new Font("SansSerif", Font.BOLD, 14)); // عشان يظهر أوضح


            formPanel.add(titleLabel);
            formPanel.add(Box.createRigidArea(new Dimension(0, 30)));
            formPanel.add(userLabel);
            formPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            formPanel.add(usernameField);
            formPanel.add(Box.createRigidArea(new Dimension(0, 20)));
            formPanel.add(passLabel);
            formPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            formPanel.add(passwordField);
            formPanel.add(Box.createRigidArea(new Dimension(0, 30)));
            formPanel.add(loginBtn);

            add(formPanel);

            // ربط الأكشن الخاص بالدخول
            loginBtn.addActionListener(e -> {
                System.out.println("Login button clicked!");

            });
        }
}
