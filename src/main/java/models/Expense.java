package models;
import java.time.LocalDate;
public class Expense {

        private int id;
        private  double amount;
        private  Category category;
        private  LocalDate date;
        private  String notes;

        public Expense(int id,double amount, Category category, LocalDate date, String notes) {
            this.id=id;
            this.amount = amount;
            this.category = category;
            this.date = date;
            this.notes = notes;
        }
        public Expense(double amount,Category category,LocalDate date,String notes){

            this(0,amount,category,date,notes);
        }

        //Getters

        public int getId() { return id; }
        public double getAmount() { return amount; }
        public Category getCategory() { return category; }
        public LocalDate getDate() { return date; }
        public String getNotes() { return notes; }

    //Setters

    public void setId(int id) { this.id = id; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setCategory(Category category) { this.category = category; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setNotes(String notes) { this.notes = notes; }

    //

    @Override
    public String toString() {
        return "Expense{" + "id=" + id + ", amount=" + amount + ", category=" + category + '}';
    }

}
