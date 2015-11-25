'use strict';

angular.module('app').factory('UsuarioService', [
'$http','SERVER_BASE', UsuarioService 
]);

function UsuarioService ($http,SERVER_BASE) {

    //expect(MOVIE_TITLE).toEqual('http://localhost:5000/');

    var urlBase = SERVER_BASE +'usuario'; //SERVER_BASE

    var dataFactory = {};

    dataFactory.getUsuarios = function () {
        return $http.get(urlBase);
    };

    dataFactory.getUsuario = function (id) {
        return $http.get(urlBase + '/' + id);
    };

    dataFactory.AutenticarUsuario = function (user) {
        return $http.post(urlBase + '/' + id);
    };

 
    return dataFactory;
};
