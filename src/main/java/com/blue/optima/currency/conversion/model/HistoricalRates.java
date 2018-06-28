package com.blue.optima.currency.conversion.model;

import java.util.Date;


public class HistoricalRates {

	private String baseCurrency;

	private String targetCurrency;

	private Date date;

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTargetCurrency() {
		return targetCurrency;
	}

	public void setTargetCurrency(String targetCurrency) {
		this.targetCurrency = targetCurrency;
	}

	@Override
	public String toString() {
		return "CheckData [baseCurrency=" + baseCurrency + ", targetCurrency=" + targetCurrency + ", date=" + date
				+ "]";
	}
}
