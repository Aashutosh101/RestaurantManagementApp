package com.visa.web;

public class RestaurantApiException extends Exception {

	private String input;
	public RestaurantApiException() {
	}

	public RestaurantApiException(String arg0) {
		super(arg0);
	}

	public RestaurantApiException(Throwable arg0) {
		super(arg0);
	}

	public RestaurantApiException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	
	public RestaurantApiException(String input, String message, Throwable cause) {
		super(message, cause);
		this.input = input;
	}

	public RestaurantApiException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

}
