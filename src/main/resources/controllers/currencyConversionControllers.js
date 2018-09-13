app.controller('currencyConversionController', function($scope, $location,
		$route, $routeParams, currencyConversionService,
		rateConversionServices, $http) {
	$scope.targetHistoricalCurrency = "GBP";
	$scope.targetLatestCurrency = "GBP";
	$scope.exchangeResponse = false;
	$scope.rateResponse = false;
	$scope.amount = 20;
    $scope.latestResult=function(){
    	$scope.exchangeResponse = false;
    };
    $scope.historicalResult=function(){
    	$scope.rateResponse = false;
    };
	$scope.date = new Date();
	$scope.convertLatest = function() {

		var currencyExchange = {
			baseCurrency : "USD",
			targetCurrency : $scope.targetLatestCurrency,
			amount : $scope.amount
		};
		var currencyExchangeJSON = JSON.stringify(currencyExchange);
		var currencyConversionPromise = currencyConversionService
				.currencyExchange(currencyExchangeJSON);
		currencyConversionPromise.success(function(result) {

			$scope.exchangeResponse = true;
			$scope.convertedAmount = result;

		});
		currencyConversionPromise.error(function(error) {
			debugger;
			console.error('error');
		});

	};
	$scope.convertHistorical = function() {
		var exchangeRate = {
			baseCurrency : "USD",
			targetCurrency : $scope.targetHistoricalCurrency,
			date : $scope.date
		};
		var exchangeRateJSON = JSON.stringify(exchangeRate);
		var rateConversionPromise = rateConversionServices
				.conversionRate(exchangeRateJSON);
		rateConversionPromise.success(function(result) {
			$scope.rateResponse = true;
			$scope.rate = result;
		});
		rateConversionPromise.error(function(error) {
			debugger;
			console.error('error');
		});

	};

});
