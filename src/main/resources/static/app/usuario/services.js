(function (angular) {
    var ItemFactory = function ($resource) {
        return $resource('/usuariosList/:id', {
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
    angular.module("myApp.services").factory("Usuario", ItemFactory);
}(angular));