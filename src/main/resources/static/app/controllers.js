(function(angular) {
  var AppController = function($scope, Permissao) {
    Permissao.query(function(response) {
      $scope.permissaos = response ? response : [];
    });
    
    $scope.addPermissao = function(description) {
      new Permissao({
        description: description,
        checked: false
      }).$save(function(permissao) {
        $scope.permissaos.push(permissao);
      });
      $scope.newPermissao = "";
    };
    
    $scope.updatePermissao = function(permissao) {
      permissao.$update();
    };
    
    $scope.deletePermissao = function(permissao) {
      permissao.$remove(function() {
        $scope.permissaos.splice($scope.permissaos.indexOf(permissao), 1);
      });
    };
  };
  
  AppController.$inject = ['$scope', 'Permissao'];
  angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));