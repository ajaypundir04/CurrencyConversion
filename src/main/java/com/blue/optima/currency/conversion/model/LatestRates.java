package com.blue.optima.currency.conversion.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

public class LatestRates {

	private String baseCurrency;

	private String targetCurrency;

	@NotNull
	@Range(min = 0)
	private BigDecimal amount;

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
		return "ConvertData [baseCurrency=" + baseCurrency + ", targetCurrency=" + targetCurrency + ", amount=" + amount
				+ "]";
	}
}
