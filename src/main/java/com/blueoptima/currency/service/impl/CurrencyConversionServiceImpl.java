package com.blueoptima.currency.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueoptima.currency.service.CurrencyConversionService;
import com.blueoptima.currency.service.ExchangeDataSource;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

	@Autowired(required = false)
	private ExchangeDataSource provider;

	public BigDecimal getExchangeRate(String currencyCodeFrom, String currencyCodeTo, Date timestamp) {
		BigDecimal result = provider.getExchangeRate(currencyCodeFrom, currencyCodeTo, timestamp);
		return result;
	}

	public BigDecimal getExchangeRate(String currencyCodeFrom, String currencyCodeTo) {
		BigDecimal result = provider.getExchangeRate(currencyCodeFrom, currencyCodeTo);
		return result;
	}

	@Override
	public BigDecimal convert(BigDecimal amount, String baseCurrency, String targetCurrency) {
		BigDecimal rate = provider.getExchangeRate(baseCurrency, targetCurrency);
		if (rate == null) {
			return null;
		}
		return amount.multiply(rate);
	}

	@Override
	public void setProvider(ExchangeDataSource provider) {
		this.provider = provider;
	}

}
