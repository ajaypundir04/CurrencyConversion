package com.blueoptima.currency;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Date;

import org.springframework.web.client.RestTemplate;

import com.blueoptima.currency.model.HistoricalRates;
import com.blueoptima.currency.model.LatestRates;

public class CurrencyConversionTestClient {

	public static final String REST_SERVICE_URI = "http://localhost:8080/currency/exchange";

	private static void historicalCheck() {
		System.out.println("Testing historicalCheck API-----------");
		RestTemplate restTemplate = new RestTemplate();
		HistoricalRates hrates = new HistoricalRates("USD", "GBP", new Date());
		URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/historical/", hrates, HistoricalRates.class);
		System.out.println("Location : " + uri.toASCIIString());
	}

	private static void conversionCheck() {
		System.out.println("Testing conversion API----------");
		RestTemplate restTemplate = new RestTemplate();
		LatestRates lrate = new LatestRates("USD", "GBP", new BigDecimal(20));
		URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/convert/", lrate, LatestRates.class);
		System.out.println("Location : " + uri.toASCIIString());
	}

	public static void main(String args[]) {
		historicalCheck();
		conversionCheck();

	}
}