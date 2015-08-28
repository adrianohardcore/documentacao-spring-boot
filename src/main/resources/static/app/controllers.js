(function(angular) {
  var AppController = function($scope, Permissao) {
	  
    Permissao.query(function(response) {
      $scope.permissoes = response ? response : [];
    });
    
    $scope.addPermissao = function(nomePermissao) {
      new Permissao({
        nomePermissao: nomePermissao,
        checked: false
      }).$save(function(permissao) {
        $scope.permissoes.push(permissao);
      });
      $scope.newPermissao = "";
    };
    
    $scope.updatePermissao = function(permissao) {
      permissao.$update();
    };
    
    $scope.deletePermissao = function(permissao) {
      permissao.$remove(function() {
        $scope.permissoes.splice($scope.permissoes.indexOf(permissao), 1);
      });
    };
  };
  
  AppController.$inject = ['$scope', 'Permissao'];
  angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));