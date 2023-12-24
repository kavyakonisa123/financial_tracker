package model;

import java.time.LocalDate;

public class Income extends Transaction {
	private String source;
	private int frequency;
	
	@Override
	public String getTransactionType() {
        return "Income";
    }
	
	public Income(double amount,LocalDate date, String description,String source, int frequency) {
		super(amount, date,description);
		this.source=source;
		this.frequency=frequency;
		System.out.println("The transaction on "+date+" for "+description+" is "+ amount +" from source "+ source + " in "+ frequency+" times.");

	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	

}
