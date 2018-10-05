package com.ms.stock.model;

import java.util.List;

public class Quotes {
	
	public Quotes(String username, List<String> quotes) {
		this.username = username;
		this.quotes = quotes;
	}
	
	private String username;
	private List<String> quotes;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<String> getQuotes() {
		return quotes;
	}
	public void setQuotes(List<String> quotes) {
		this.quotes = quotes;
	}
	
	
}
