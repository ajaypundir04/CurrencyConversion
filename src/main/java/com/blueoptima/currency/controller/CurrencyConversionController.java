package com.blueoptima.currency.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blueoptima.currency.model.HistoricalRates;
import com.blueoptima.currency.model.LatestRates;
import com.blueoptima.currency.service.CurrencyConversionService;

@RestController
@RequestMapping("/exchange")
public class CurrencyConversionController {

	private static final Logger log = LoggerFactory.getLogger(CurrencyConversionController.class);

	@Autowired
	private CurrencyConversionService currencyConversionService;

	@RequestMapping(value = "/historical/", method = RequestMethod.POST)
	public ResponseEntity<BigDecimal> historicalRates(@RequestBody HistoricalRates historicalData) {
		log.debug("historicalRates input", historicalData);
		BigDecimal rate = null;
		rate = currencyConversionService.getExchangeRate(historicalData.getBaseCurrency(),
				historicalData.getTargetCurrency(), historicalData.getDate());
		return new ResponseEntity<BigDecimal>(rate, HttpStatus.OK);
	}

	@RequestMapping(value = "/latest/", method = RequestMethod.POST)
	public ResponseEntity<BigDecimal> currencyConversion(@RequestBody LatestRates currencyExchange) {
		log.debug("currencyExchange input", currencyExchange);
		BigDecimal convertedAmount = currencyConversionService.convert(currencyExchange.getAmount(),
				currencyExchange.getBaseCurrency(), currencyExchange.getTargetCurrency());
		return new ResponseEntity<BigDecimal>(convertedAmount, HttpStatus.OK);

	}

}