package ui;

import java.time.LocalDate;

import java.util.Scanner;
import model.Transaction;
import util.TransactionUtil;
import model.Income;
import model.Expenses;
import service.TransactionService;


public class ConsoleUI {

	private Scanner scanner;
    private TransactionService transactionService;



	public ConsoleUI() {
		this.scanner = new Scanner(System.in);
        this.transactionService = new TransactionService(); // Initialize the TransactionService


	}

	public double getAmountFromUser() {
		System.out.print("Please enter the amount: ");
		while (!scanner.hasNextDouble()) {
			System.out.println("That's not a valid amount. Please enter a valid number.");
			scanner.next(); 
		}
		return scanner.nextDouble();
	}

	public String getDescriptionFromUser() {
	    System.out.print("Please enter the description: ");
	    scanner.nextLine(); // Consume the leftover newline if any
	    return scanner.nextLine();
	}

	public String getSourceFromUser() {
	    System.out.print("Please enter the Source: ");
	    return scanner.nextLine();
	}

	public int getFrequencyFromUser() {
	    System.out.print("Please enter the frequency: ");
	    int frequency = scanner.nextInt();
	    scanner.nextLine(); // Consume the leftover newline
	    return frequency;
	}

	public String getPaymentTypeFromUser() {
	    System.out.print("Please enter the PaymentType: ");
	    return scanner.nextLine();
	}

	public String getCategoryFromUser() {
	    System.out.print("Please enter the Category: ");
	    return scanner.nextLine();
	}


    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();
//        consoleUI.createAndDisplayIncome();
//        consoleUI.createAndDisplayIncome();
//        consoleUI.createAndDisplayExpenses();
//        consoleUI.displayTotalTransactions();
//
//
    
        boolean running = true;
        while (running) {
            System.out.println("Enter command (income/expense/balance/analysis/exit):");
            String command = consoleUI.scanner.nextLine();

            switch (command.toLowerCase()) {
                case "income":
                    consoleUI.createAndDisplayIncome();
                    break;
                case "expense":
                    consoleUI.createAndDisplayExpenses();
                    break;
                case "balance":
                    consoleUI.displayBalance();
                    break;
                case "analysis":
                	consoleUI.displayTotalTransactions();
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Unknown command. Please try again.");
                    break;
            }
        }

        consoleUI.closeScanner();
    }
    

    public void createAndDisplayIncome() {
        // Get user input for the transaction
    	System.out.println("Enter Income Details --------------");

        double amount = getAmountFromUser();
        String description = getDescriptionFromUser();
        String source= getSourceFromUser();
        System.out.println("Type of source: "+ source);

        int frequency=getFrequencyFromUser();
        
        // Here you might have some logic to determine whether this is an Income or Expense
        // For this example, let's assume we are creating an Income transaction
        Transaction transaction = new Income(amount, LocalDate.now(), description,source,frequency);

        // Now you can call any methods available to the Transaction object
        // Since getTransactionType() is abstract in Transaction, it will call the overridden method in Income
        String type = transaction.getTransactionType();
        System.out.println("Type of Transaction: "+ type);
        transactionService.addTransaction(transaction); 
//        transactionList.add(transaction);


    }
    
    public void createAndDisplayExpenses() {
        // Get user input for the transaction
    	System.out.println("Enter Expense Details ------------");
        double amount = getAmountFromUser();
        String description = getDescriptionFromUser();
        String payment_type= getPaymentTypeFromUser();

        String category=getCategoryFromUser();
        
        Expenses transaction = new Expenses(amount, LocalDate.now(), description,payment_type,category);
        String type = transaction.getTransactionType();
        Boolean overBudget= transaction.overbudget(99999);
        System.out.println("Type of Transaction: "+ type +" and OverBudget: "+ overBudget);
//        transactionList.add(transaction);
        transactionService.addTransaction(transaction); 


    }
    
    public void displayTotalTransactions() {
    	System.out.println("--------Transaction Details ------------");

        double total_amount = TransactionUtil.getTotalAmount(transactionService.getTransactions());
        System.out.println("Total Amount of all transactions: " + total_amount);
        int total_count= TransactionUtil.getTotalTransactions(transactionService.getTransactions());
        System.out.println("Total count of all transactions: " + total_count);
        double total_amount_inc = TransactionUtil.getTotalAmountForType(transactionService.getTransactions(),"Income");
        System.out.println("Total Amount of Income transactions: " + total_amount_inc);
        double total_amount_exp = TransactionUtil.getTotalAmountForType(transactionService.getTransactions(),"Expenses");
        System.out.println("Total Amount of Expenses transactions: " + total_amount_exp);
        
    }
    
    public void displayBalance() {
        double balance = transactionService.calculateBalance();
        System.out.println("Current balance: " + balance);
    }

    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }

}
