package manager;

import java.util.ArrayList;
import model.Expense;
import model.Category;

    public class ExpenseManager {
        private static ExpenseManager instance;
        private final ArrayList<Expense> expenses = new ArrayList<>();
        private double income = 5000.0; // الرصيد المبدئي
        private int nextId = 1;

        // Constructor خاص بالـ Singleton
        private ExpenseManager() {}

        public static ExpenseManager getInstance() {
            if (instance == null) {
                instance = new ExpenseManager();
            }
            return instance;
        }

        public void addExpense(Expense e) {
            if (e != null) {
                e.setId(nextId++);
                expenses.add(e);
            }
        }

        public boolean deleteExpense(int id) {
            return expenses.removeIf(e -> e.getId() == id);
        }


        public double getTotalExpenses() {
            double total = 0;

            for (Expense e : expenses) {
                total += e.getAmount();
            }

            return total;
        }
        public double getBalance (double totalExpenses) {
            return income - totalExpenses;
        }

        public int getCount() {
            return expenses.size();
        }

        public ArrayList<Expense> getAll() {
            return expenses;
        }
        public static boolean isValidAmount(double amount) {
            return amount > 0;
        }
        public static boolean isValidDate(String d) {
            return d != null && d.matches("\\d{4}-\\d{2}-\\d{2}");
        }
    }


