'use strict';

angular.module('app').controller('LivroController',[
 '$scope','$http','LivroService', '$uibModal',
 function($scope,$http,LivroService,$uibModal){

 $scope.livros = [];
 $scope.loadLivros = function(){
	 LivroService.getLivros()
	 .success( function(data){
		 $scope.livros = data._embedded.livro;
	 });
 };
 $scope.loadLivros();


 $scope.autor={};
 $scope.open = function (size,autorId) {
      var modalInstance = $uibModal.open({
        animation: true,
        templateUrl: 'app/livro/livro-modal.html',
        controller: 'LivroModalController',
        size: size,
        resolve: {
          autorId: function () {
            return autorId;
          }
        }
      });
      modalInstance.result.then(function ( autor ) {
        $scope.autor = autor;
        console.info(autor);
      }, function () {
        //console.info('Modal dismissed at: ' + new Date());
      });
 };


}]);
