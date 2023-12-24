package util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.Transaction;

public class TransactionUtil {
	
	public static double getTotalAmount(List<Transaction> transactions) {
        double total = 0;
        for (Transaction transaction : transactions) {
            total += transaction.getAmount();
        }
        return total;
    }

	public static int getTotalTransactions(List<Transaction> transactions) {
        int count = 0;
        for (Transaction transaction : transactions) {
        	count +=1;
        }
        return count;
	}
	
	public static double getTotalAmountForType(List<Transaction> transactions, String type) {
	    double total = 0;
	    for (Transaction transaction : transactions) {
	        if (transaction.getTransactionType().equalsIgnoreCase(type)) {
	            total += transaction.getAmount();
	        }
	    }
	    return total;
	}
	
	
}
