(function (angular) {

    var AppController = function ($scope, Usuario) {
        Usuario.query(function (response) {
            $scope.usuarios = response ? response : [];
        });
        $scope.addUsuario = function (nomeUsuario) {
            new Usuario({
                nomeUsuario: nomeUsuario,
                checked: false
            }).$save(function (usuario) {
                    $scope.usuarios.push(usuario);
                });
            $scope.newUsuario = "";
        };
        $scope.updateUsuario = function (usuario) {
            usuario.$update();
        };
        $scope.deleteUsuario = function (usuario) {
            usuario.$remove(function () {
                $scope.usuarios.splice($scope.usuarios.indexOf(usuario), 1);
            });
        };
    };


    AppController.$inject = ['$scope', 'Usuario'];
    angular.module("myApp.controllers").controller("AppController", AppController);


}(angular));