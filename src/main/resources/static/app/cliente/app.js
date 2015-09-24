var app = angular.module('app', ['ngTouch', 'ui.grid', 'ui.grid.pagination']);

app.controller('MainCtrl', [
'$scope', '$http', 'uiGridConstants', function($scope, $http, uiGridConstants) {

  var paginationOptions = {
    pageNumber: 1,
    pageSize: 25,
    sort: null
  };

  $scope.gridOptions = {
    paginationPageSizes: [25, 50, 75 ,100],
    paginationPageSize: 100,
    useExternalPagination: true,
    useExternalSorting: true,
    columnDefs: [
//      { name: 'name' },
//      { name: 'gender', enableSorting: false },
//      { name: 'company', enableSorting: false }
      { name: 'doctocliente', enableSorting: false },
      { name: 'nomecliente', enableSorting: true }
    ],
    onRegisterApi: function(gridApi) {
      $scope.gridApi = gridApi;
      $scope.gridApi.core.on.sortChanged($scope, function(grid, sortColumns) {
        if (sortColumns.length == 0) {
          paginationOptions.sort = null;
        } else {
          paginationOptions.sort = sortColumns[0].sort.direction;
        }
        getPage();
      });
      gridApi.pagination.on.paginationChanged($scope, function (newPage, pageSize) {
        paginationOptions.pageNumber = newPage;
        paginationOptions.pageSize = pageSize;
        getPage();
      });
    }
  };

  var getPage = function() {
    var url;
    switch(paginationOptions.sort) {
      case uiGridConstants.ASC:
        //url = 'https://cdn.rawgit.com/angular-ui/ui-grid.info/gh-pages/data/100_ASC.json';
        url = '/clientes';
        break;
      case uiGridConstants.DESC:
        //url = 'https://cdn.rawgit.com/angular-ui/ui-grid.info/gh-pages/data/100_DESC.json';
        url = '/clientes';
        break;
      default:
        //url = 'https://cdn.rawgit.com/angular-ui/ui-grid.info/gh-pages/data/100.json';
        url = '/clientes';
        break;
    }

    $http.get(url)
    .success(function (data) {
      //$scope.gridOptions.totalItems = 500;
      $scope.gridOptions.totalItems = data.length;
      var firstRow = (paginationOptions.pageNumber - 1) * paginationOptions.pageSize;
      $scope.gridOptions.data = data.slice(firstRow, firstRow + paginationOptions.pageSize);
    });
  };

  getPage();
}
]);
