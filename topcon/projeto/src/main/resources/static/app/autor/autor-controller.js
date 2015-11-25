'use strict';

angular.module('app').controller('AutorController', ['$scope', '$log', 'uiGridConstants', 'AutorService', AutorController]);

function AutorController($scope, $log, uiGridConstants, AutorService) {

	$scope.gridOptions = {

		enableFiltering: true,
		enablePaginationControls: true,
		enableGridMenu: true,
		paginationPageSize: 8,
		paginationPageSizes: [8, 16, 32],

		columnDefs: [{
			name: 'id',
			field: 'id',
			displayName: 'Código',
			width: '25%',
			enableColumnMenu: false
		}, {
			name: 'nome',
			field: 'nome',
			displayName: 'Nome',
			enableColumnMenu: false
		}]
	};



	$scope.loadAutores = function() {

		AutorService.getAutores()
			.success(function(data) {

				$log.info(data);
				$scope.gridOptions.data = data._embedded.autor;

			});
	};

	$scope.loadAutores();



}