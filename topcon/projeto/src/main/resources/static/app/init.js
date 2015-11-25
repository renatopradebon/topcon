!function ($, jQuery) {
    'use strict';

    window.app = window.app || {};
    window.app.module = angular.module(
    	'xplatform-sample', 
    	
        ['ui.router',
        'pascalprecht.translate',
        'ngSanitize',
        'ngNotify',
        'angular-loading-bar',
        'leaflet-directive',
        'ngCordova',
        'ngAnimate',
       
    	'ui.bootstrap',
    	'chart.js',
    	'daterangepicker',
    	'ui.grid',
    	'ui.grid.pagination',
    	'nya.bootstrap.select',
    	'bm.bsTour',
    	'toastr'

    ]);

    // insert the base URL here
    app.module.constant('apiBaseUrl', 'https://boardzapi.azurewebsites.net/');

    app.module.constant('SERVER_BASE', 'http://localhost:5000/');

    FastClick.attach(document.body);
}();
