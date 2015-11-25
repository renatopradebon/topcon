/*
Wrap Angular components in an Immediately Invoked Function Expression (IIFE).

Why?: An IIFE removes variables from the global scope. This helps prevent 
variables and function declarations from living longer than expected in the
global scope, which also helps avoid variable collisions.

Why?: When your code is minified and bundled into a single file for deployment 
to a production server, you could have collisions of variables and many global 
variables. An IIFE protects you against both of these by providing variable 
scope for each file.

Sublime Key:

---BEGIN LICENSE---
K-20
Single User License
EA7E-940129
3A099EC1C0B5C7C5 33EBF0CF BE82FE3B
EAC2164A4F8EC954 4E87F1E5 7E4E85D6
C5605DE6DAB003B4 D60CA4D0 77CB1533
3C47F579 FB3E8476 EB3AA9A7 68C43CD9
8C60B563 80FE367D 8CAD14B3 54FB7A9F
4123FFC4 D63312BA 141AF702 F6BBA254
B094B9C0 FAA4B04C 06CC9AFC FD412671
82E3AEE0 0F0FAAA7 8FA773C9 383A9E18
---END LICENSE---

*/

(function() {

	'use strict';

	angular.module('app').controller('HomeController', ['$scope', HomeController]);

	function HomeController($scope) {

		//debugger;

		$scope.title = 'Biblioteca';

		$scope.versao = '1.0';

		$scope.nome = $scope.title + $scope.versao;


	}


})();