package model;

import java.time.LocalDate;

public class Expenses extends Transaction {
	private String paymentType;
	private String category;

	@Override
	public String getTransactionType() {
        return "Expenses";
    }
	
	public Expenses(double amount, LocalDate date, String description,String paymentType, String category) {
		super(amount, date, description);
		this.paymentType= paymentType;
		this.category=category;
		System.out.println("The transaction on "+date+" for "+description+" is "+ amount +" based on  "+ category + " and paid in "+ paymentType);

		
		
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public Boolean overbudget(double threshold) {
		return amount > threshold;
	}
	
	
	

}
