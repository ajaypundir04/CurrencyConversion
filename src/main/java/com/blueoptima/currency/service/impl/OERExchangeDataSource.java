package com.blueoptima.currency.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.blueoptima.currency.service.ExchangeDataSource;


@Service
public class OERExchangeDataSource implements ExchangeDataSource {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(OERExchangeDataSource.class);

	@Value("${ce.latestUrl}")
	private String recent;

	@Value("${ce.historicalUrl}")
	private String history;

	@Value("${ce.appId}")
	private String appId;

	private RestTemplate restTemplate = new RestTemplate();

	@Cacheable("historicalRates")
	@Override
	public BigDecimal getExchangeRate(String currencyCodeFrom, String currencyCodeTo, Date timestamp) {
		return callExchangeRateApi(history, currencyCodeFrom, currencyCodeTo, timestamp);
	}

	@Cacheable("latestRates")
	@Override
	public BigDecimal getExchangeRate(String currencyCodeFrom, String currencyCodeTo) {
		return callExchangeRateApi(recent, currencyCodeFrom, currencyCodeTo, null);
	}

	protected BigDecimal callExchangeRateApi(String url, String currencyCodeFrom, String currencyCodeTo,
			Date timestamp) {
		Map<String, String> params = new HashMap<String, String>();

		params.put("appId", appId);
		params.put("base", currencyCodeFrom);

		if (timestamp != null) {
			params.put("date", new SimpleDateFormat("yyyy-MM-dd").format(timestamp));
		}

		log.debug("Calling {} [params = {}]...", url, params);

		BigDecimal result = null;

		try {
			ResponseEntity<ExchangeRateResponse> response = restTemplate.getForEntity(url, ExchangeRateResponse.class, params);
			log.debug(" response = {}", response);
			if (response.hasBody()) {
				result = response.getBody().getRates().get(currencyCodeTo);
			}
		} catch (RestClientException e) {
			log.error("Problem calling API", e);
		}

		return result;
	}
}
