'use strict';

angular.module('app').factory('AutorService', [
'$http','SERVER_BASE',
function($http,SERVER_BASE) {

    //expect(MOVIE_TITLE).toEqual('http://localhost:5000/');

    var urlBase = SERVER_BASE +'autor'; //SERVER_BASE

    var dataFactory = {};

    dataFactory.getAutores = function () {
        return $http.get(urlBase);
    };

    dataFactory.getAutor = function (id) {
        return $http.get(urlBase + '/' + id);
    };

    dataFactory.insertAutor = function (merc) {
        return $http.post(urlBase, merc);
    };

    dataFactory.updateAutor = function (merc) {
        return $http.put(urlBase + '/' + merc.ID, merc)
    };

    dataFactory.deleteAutor = function (id) {
        return $http.delete(urlBase + '/' + id);
    };

    dataFactory.getLivrosAutor = function (id) {
        return $http.get(urlBase + '/' + id + '/autor');
    };


    return dataFactory;
}]);
