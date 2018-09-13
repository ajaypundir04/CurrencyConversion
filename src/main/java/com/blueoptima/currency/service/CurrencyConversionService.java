package com.blueoptima.currency.service;

import java.math.BigDecimal;


public interface CurrencyConversionService extends CurrencyConversionOperations {

	BigDecimal convert(BigDecimal amount, String baseCurrency, String targetCurrency);

	void setProvider(ExchangeDataSource provider);
}