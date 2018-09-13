# CurrencyConversion
Currency Exchange Application
It is a spring boot based application. We are using REST api for converting the base currency “USD” to any target currency. 
WorkFlow




Functionality
Two Post Api
1.	/currency/exchange/latest/
a.	It is used for getting the latest rate 
2.	/currency/exchange/historical/
a.	It is used for viewing the historical rates
We are integrating with the third party for the currency rates https://openexchangerates.org
1.	ce.appId=e48903f3d4ee44e28398792694cd3b77
2.	ce.latestUrl=https://openexchangerates.org/api/latest.json?app_id={appId}&base={base}
3.	ce.historicalUrl=https://openexchangerates.org/api/historical/{date}.json?app_id={appId}&base={base}
  Future Scope
   We have to save the currency data in the DB
Tech Stack
Backend Tech
1.	Java
2.	Spring Boot
3.	REST
4.	In Mem DB
Front End Tech
1.	Angular JS
2.	HTML
3.	JS
4.	BootStrap

User Instructions
There are two Panel at the UI for the currency conversion
Latest Rate Panel
1.	Base Currency: a label for indicating USD
2.	Target Currency : User can select from drop down any currency of his/her choice for conversion
3.	Amount : value to be converted to the target currency
4.	Convert : Button to hit server and get response
5.	Response : For getting the converted value

Historical Rate Panel
1.	Base Currency: a label for indicating USD
2.	Target Currency : User can select from drop down any currency of his/her choice for conversion
3.	Date : at which date use wants to view the rate
4.	Rate : Button to hit server and get response
5.	Response : Get the rate at that time
