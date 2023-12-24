package service;

import model.Transaction;
import model.Income;
import model.Expenses;
import java.util.List;
import java.util.ArrayList;

public class TransactionService {
    private List<Transaction> transactions;

    public TransactionService() {
        this.transactions = new ArrayList<>();
    }
    
    
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public double calculateBalance() {
        double balance = 0;
        for (Transaction transaction : transactions) {
            if (transaction instanceof Income) {
                balance += transaction.getAmount();
            } else if (transaction instanceof Expenses) {
                balance -= transaction.getAmount();
            }
        }
        return balance;
    }
 // Getters and Setters
    public List<Transaction> getTransactions() {
        return transactions;
    }
    
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
