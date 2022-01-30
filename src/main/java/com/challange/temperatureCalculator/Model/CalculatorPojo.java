package com.challange.temperatureCalculator.Model;

public class CalculatorPojo {

	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public double getCalculated() {
		return calculated;
	}
	public void setCalculated(double calculated) {
		this.calculated = calculated;
	}
	private String from;
	private String to;
	private double value;
	private double calculated;
	
}
