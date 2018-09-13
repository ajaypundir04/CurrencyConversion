package com.blueoptima.currency.service;

import java.math.BigDecimal;
import java.util.Date;

public interface CurrencyConversionOperations {

	BigDecimal getExchangeRate(String currencyCodeFrom, String currencyCodeTo, Date timestamp);

	BigDecimal getExchangeRate(String currencyCodeFrom, String currencyCodeTo);

}
