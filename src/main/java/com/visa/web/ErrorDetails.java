package com.visa.web;

public class ErrorDetails {
	private String input;
	private String message;
	private String description;
	public ErrorDetails() {
	}
	public ErrorDetails(String input, String message, String description) {
		this.input = input;
		this.message = message;
		this.description = description;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ErrorDetails [input=" + input + ", message=" + message + ", description=" + description + "]";
	}
	
	
}
