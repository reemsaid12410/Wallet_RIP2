package UI.panal;


import javax.swing.*;
import java.awt.*;

    public class DashboardPanal extends JPanel {

        public DashboardPanal() {
            setLayout(new GridLayout(4, 1));

            add(new JLabel("Total Expenses: 1000"));
            add(new JLabel("Balance: 5000"));
            add(new JLabel("Transactions: 10"));

            JTable table = new JTable(
                    new Object[][]{
                            {"Food", 200},
                            {"Bills", 300}
                    },
                    new String[]{"Category", "Amount"}
            );

            add(new JScrollPane(table));
        }

        public static void main(String[] args) {
            JFrame frame = new JFrame("Dashboard");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.add(new DashboardPanal());

            frame.setVisible(true);
        }
    }

