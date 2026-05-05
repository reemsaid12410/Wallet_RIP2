package UI.panal;

public class ViewExpensePanal {

    import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

    class ViewExpensesPanel extends JPanel {

        private JTable table;
        private DefaultTableModel model;

        public ViewExpensesPanel() {

            setLayout(new BorderLayout());

            String[] columns = {"Amount", "Category", "Date"};

            model = new DefaultTableModel(columns, 0);
            table = new JTable(model);

            model.addRow(new Object[]{100, "Food", "2026-05-05"});
            model.addRow(new Object[]{50, "Transport", "2026-05-04"});
            model.addRow(new Object[]{200, "Shopping", "2026-05-03"});

            JScrollPane scrollPane = new JScrollPane(table);
            add(scrollPane, BorderLayout.CENTER);
        }
    }

    public class Main {

        public static void main(String[] args) {

            JFrame frame = new JFrame("View Expenses");

            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ViewExpensesPanel panel = new ViewExpensesPanel();

            frame.add(panel);

            frame.setVisible(true);
        }
    }
}
