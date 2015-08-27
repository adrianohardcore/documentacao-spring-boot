(function(angular) {
  var ItemFactory = function($resource) {
    return $resource('/permissoes/:id', {
      id: '@id'
    }, {
      update: {
        method: "PUT"
      },
      remove: {
        method: "DELETE"
      }
    });
  };
  
  ItemFactory.$inject = ['$resource'];
  angular.module("myApp.services").factory("Permissao", ItemFactory);
}(angular));