package com.visa.web;

public class TimeOutOfBoundsException extends Exception {
	private String input;

	public TimeOutOfBoundsException(String input, String message) {
		super(message);
		this.input = input;
	}

	public TimeOutOfBoundsException() {
		super();
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	
}
