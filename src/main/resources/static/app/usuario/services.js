// (function (angular) {
//     var ItemFactory = function ($resource) {

//         return $resource('/usuariosList/:id', {
//             id: '@id'
//         } 
//         //,
//         //  {
//         //     update: {
//         //         method: "PUT"
//         //     },
//         //     remove: {
//         //         method: "DELETE"
//         //     }
//         // }
//         );
//     };

//     ItemFactory.$inject = ['$resource'];
//     angular.module("myApp.services").factory("Usuario", ItemFactory);
// }(angular));



(function (angular) {

    angular.module('myApp.services', ['ngResource']).
      factory("geoProvider", function($resource) {
        return {
          usuarios: $resource('/usuariosList', {}, {
            query: { method: 'GET', params: {}, isArray: false }
          })
          // ,
          // countries: $resource('../data/countries.json', {}, {
          //   query: { method: 'GET', params: {}, isArray: false }
          // })
        };
      });


}(angular));





// angular.module("listaTelefonica").factory("contatosAPI", function ($http, config) {

//     var _getContatos = function () {
//         return $http.get(config.baseUrl + "/contatos");
//     };

//     var _saveContato = function (contato) {
//         return $http.post(config.baseUrl + "/contatos", contato);
//     };

//     return {
//         getContatos: _getContatos,
//         saveContato: _saveContato
//     };
// });




