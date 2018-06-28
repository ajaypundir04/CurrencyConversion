var app = angular.module('currencyConversionApp', ['ngRoute']);

		app.config(function($routeProvider){
				$routeProvider
				.when('/',
				{
					//controller: 'ListTasksController',
					templateUrl: '/views/conversion.html'
				})
				.otherwise({
					redirectTo: '/#'
				})

		});
		