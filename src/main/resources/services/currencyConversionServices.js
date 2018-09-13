app.service('currencyConversionService', function($http) {
	this.currencyExchange = function(data) {
		return $http({
			method : 'POST',
			url : '/currency/exchange/latest/',
			data : data
		});
	};

});

app.service('rateConversionServices', function( $http) {
	this.conversionRate = function(data) {
		return $http({
			method : 'POST',
			url : '/currency/exchange/historical/',
			data : data
		});
	};

});
