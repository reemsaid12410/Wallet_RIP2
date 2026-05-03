package main;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import ui.frames.LoginFrame;

/**
 * wallet_RIP — Personal Expense Tracker
 *
 * نقطة البداية للتطبيق.
 * بتفتح شاشة الـ Login، ولو نجح الدخول بتفتح MainFrame.
 */
public class Main {

    public static void main(String[] args) {

        // الـ Swing لازم يشتغل على الـ Event Dispatch Thread (EDT)
        // ده الـ best practice عشان الـ UI ميهنجش
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                // محاولة استخدام الـ system look & feel (اختياري بس بيخلي الشكل أحسن)
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    // لو فشل، هيكمّل بالـ default look
                    System.out.println("Couldn't set system look & feel, using default.");
                }

                // فتح شاشة الـ Login
                LoginFrame loginFrame = new LoginFrame();
                loginFrame.setVisible(true);
            }
        });
    }
}