package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Transaction {
	List<Transaction> transactionList = new ArrayList<>();
	protected double amount;
	protected LocalDate date;
	protected String description;
	
	public Transaction() {
		System.out.println("No arguments");
		
	}
	public Transaction(double amount,LocalDate date, String description) {
		this.amount=amount;
		this.date= date;
		this.description=description;
		
		System.out.println("The transaction on "+date+" for "+description+" is "+ amount);
		
		
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	
	}
	
	public abstract String getTransactionType();
	
	
	

}
