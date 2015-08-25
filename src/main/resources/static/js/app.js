angular.module('hqApp', [])
.factory('hqService', ['$http', function($http) {

    function listar(callback) {
        $http({
            method:'GET',
            url:'/permissoes/'
        }).success(function (data) {
            if (callback) callback(data)
        });
    }

    function salvar(hq, callback) {
        $http({
            method:'POST',
            url:'/permissao/salvar',
            data:JSON.stringify(permissao)
        }).success(function (data) {
            if (callback) callback(data)
        });
    }

    return {
        listar:listar,
        salvar:salvar
    };
}])
.controller('hqCtrl', ['$scope', 'hqService',function($scope, hqService) {

    hqService.listar(function(hqs) {
        $scope.hqs = hqs;
    });

    $scope.salvar = function(hq) {
        hqService.salvar(hq, function(hq) {
            $scope.hqs.push(hq);
        });
    }
}]);

/* var app = angular.module('angularjs-starter', []);

  app.controller('MainCtrl', function($scope) {

  $scope.choices = [{id: 'choice1'}, {id: 'choice2'}];

  $scope.addNewChoice = function() {
    var newItemNo = $scope.choices.length+1;
    $scope.choices.push({'id':'choice'+newItemNo});
  };

  $scope.removeChoice = function() {
    var lastItem = $scope.choices.length-1;
    $scope.choices.splice(lastItem);
  };

}); */