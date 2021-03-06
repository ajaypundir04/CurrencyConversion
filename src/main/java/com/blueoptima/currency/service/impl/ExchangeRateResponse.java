package com.blueoptima.currency.service.impl;

import java.math.BigDecimal;
import java.util.Map;


public class ExchangeRateResponse {

	private long timestamp;

	private String base;

	private Map<String, BigDecimal> rates;

	public ExchangeRateResponse() {
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Map<String, BigDecimal> getRates() {
		return rates;
	}

	public void setRates(Map<String, BigDecimal> rates) {
		this.rates = rates;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
