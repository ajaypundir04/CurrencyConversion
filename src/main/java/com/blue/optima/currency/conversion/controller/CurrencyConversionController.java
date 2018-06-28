package com.blue.optima.currency.conversion.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blue.optima.currency.conversion.model.HistoricalRates;
import com.blue.optima.currency.conversion.model.LatestRates;
import com.blue.optima.currency.conversion.service.CurrencyConversionService;

@RestController
public class CurrencyConversionController {

	private static final Logger log = LoggerFactory.getLogger(CurrencyConversionController.class);


	@Autowired
	private CurrencyConversionService currencyConversionService;



	/*@RequestMapping(value = "/check", method = RequestMethod.GET)
	public String check(Model model, @ModelAttribute("checkData") @Valid RequestRates data, BindingResult result) {
		model.addAttribute("convertData", new ResponseRates());
		//model.addAttribute("queries", userService.listUserQueries());

		log.debug("check [data = {}]", data);

		if (result.hasErrors()) {
			return "home";
		}

		BigDecimal rate = null;
		if (data.getDate() == null) {
			// Get latest
			rate = currencyConversionService.getExchangeRate(data.getBaseCurrency(), data.getTargetCurrency());
		} else {
			rate = currencyConversionService.getExchangeRate(data.getBaseCurrency(), data.getTargetCurrency(), data.getDate());
		}

		if (rate != null) {
			model.addAttribute("rate", rate);
		} else {
			model.addAttribute("checkFailed", true);
		}

		return "home";
	}
*/
	@RequestMapping(value = "/currencyConversion", method = RequestMethod.POST)
	public BigDecimal convert(Model model, @RequestParam("latestRate") LatestRates data) {
		log.debug("convert [data = {}]", data);
		BigDecimal convertedAmount = currencyConversionService.convert(data.getAmount(), data.getBaseCurrency(),
				data.getTargetCurrency());

		return convertedAmount;

	}
}
