var app = angular.module('currencyConversionApp', ['ngRoute','ngResource']);

		app.config(function($routeProvider){
				$routeProvider
				.when('/',
				{
					controller: 'currencyConversionController',
					templateUrl: 'views/conversion.html'
				})
				.otherwise({
					redirectTo: '/#'
				})

		});
		