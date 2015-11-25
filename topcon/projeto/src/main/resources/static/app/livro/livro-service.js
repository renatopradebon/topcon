'use strict';

angular.module('app').factory('LivroService', [
'$http','SERVER_BASE',
function($http,SERVER_BASE) {

    //expect(MOVIE_TITLE).toEqual('http://localhost:5000/');

    var urlBase = SERVER_BASE +'livro'; //SERVER_BASE

    var dataFactory = {};

    dataFactory.getLivros = function () {
        return $http.get(urlBase);
    };

    dataFactory.getLivro = function (id) {
        return $http.get(urlBase + '/' + id);
    };

    dataFactory.insertLivro = function (merc) {
        return $http.post(urlBase, merc);
    };

    dataFactory.updateLivro = function (merc) {
        return $http.put(urlBase + '/' + merc.ID, merc)
    };

    dataFactory.deleteLivro = function (id) {
        return $http.delete(urlBase + '/' + id);
    };

    dataFactory.getAutorLivro = function (id) {
        return $http.get(urlBase + '/' + id + '/autor');
    };


    return dataFactory;
}]);
