package com.blueoptima.currency.model;

import java.math.BigDecimal;

public class LatestRates {

	private String baseCurrency;

	private String targetCurrency;

	private BigDecimal amount;
	
	public LatestRates(){
		
	}
	
	public LatestRates(String baseCurrency, String targetCurrency, BigDecimal amount) {
		super();
		this.baseCurrency = baseCurrency;
		this.targetCurrency = targetCurrency;
		this.amount = amount;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTargetCurrency() {
		return targetCurrency;
	}

	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}

	@Override
	public String toString() {
		return "LatestRates [baseCurrency=" + baseCurrency + ", targetCurrency=" + targetCurrency + ", amount=" + amount
				+ "]";
	}

	
}
