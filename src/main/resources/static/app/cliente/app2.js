var app = angular.module('app', ['ngTouch', 'ui.grid', 'ui.grid.infiniteScroll' , 'ui.grid.pagination']);

app.controller('MainCtrl', ['$scope', '$http', '$log', function ($scope, $http, $log) {
  $scope.gridOptions = {};

/**
  * @ngdoc property
  * @name infiniteScrollPercentage
  * @propertyOf ui.grid.class:GridOptions
  * @description This setting controls at what percentage of the scroll more data
  * is requested by the infinite scroll
  */
  $scope.gridOptions.infiniteScrollPercentage = 15;

  $scope.gridOptions.columnDefs = [
//    { name:'id'},
//    { name:'name' },
//    { name:'age' }
    { name:'doctocliente' },
    { name:'nomecliente' }
  ];
  var page = 0;
  var pageUp = 0;
  var getData = function(data, page) {
    var res = [];
    for (var i = (page * 50); i < (page + 1) * 50 && i < data.length; ++i) {
      res.push(data[i]);
    }
    return res;
  };

  var getDataUp = function(data, page) {
    var res = [];
    for (var i = data.length - (page * 50) - 1; (data.length - i) < ((page + 1) * 50) && (data.length - i) > 0; --i) {
      data[i].id = -(data.length - data[i].id)
      res.push(data[i]);
    }
    return res;
  };

  //$http.get('https://cdn.rawgit.com/angular-ui/ui-grid.info/gh-pages/data/10000_complex.json')
  $http.get('/clientes/')
    .success(function(data) {
      $scope.gridOptions.data = getData(data, page);
      ++page;
    });

  $scope.gridOptions.onRegisterApi = function(gridApi){
    gridApi.infiniteScroll.on.needLoadMoreData($scope,function(){
      //$http.get('https://cdn.rawgit.com/angular-ui/ui-grid.info/gh-pages/data/10000_complex.json')
      $http.get('/clientes')
        .success(function(data) {
          $scope.gridOptions.data = $scope.gridOptions.data.concat(getData(data, page));
          ++page;
          gridApi.infiniteScroll.dataLoaded();
        })
        .error(function() {
          gridApi.infiniteScroll.dataLoaded();
        });
    });

  };
}]);
