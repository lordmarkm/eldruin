define(['angular', 'app/controllers/module.js'], function (angular, controllers) {
  'use strict';
  controllers.controller('AdminProductController', ['$scope', '$modal', 'toaster', 'ngTableParams', 'ProductService',
    function($scope, $modal, toaster, ngTableParams, ProductService) {

    $scope.reloadTable = function () {
      if ($scope.tableParams.page() == 1) {
        $scope.tableParams.reload();
      } else {
        $scope.tableParams.page(1);
      }
    };
    $scope.tableParams = new ngTableParams({
      page: 1,
      count: 5,
      sorting: {
        trackingNo: 'asc'
      }
    }, {
      total: 0,
      counts: [], //hides pager
      getData: function($defer, params) {
        //Ajax request to backend resource
        ProductService.get(params.$params, function(response) {
          params.total(response.total);
          $defer.resolve(response.data);
        });
      }
    });

    //Modal for create/update
    $scope.product = {};
    $scope.clearProduct = function () {
      $scope.product = {};
    };
    $scope.updateProduct = function (product) {
      if (!product) {
        //create new
        $scope.clearProduct();
      } else {
        //update
        $scope.product = angular.copy(product);
      }
      return $modal.open({
        scope: $scope,
        templateUrl: 'modal-update-product',
        backdrop: 'static',
        controller: ['$scope', '$modalInstance', function ($scope, $modalInstance) {
          $scope.confirm = function () {
            $modalInstance.dismiss('ok');
            $scope.saveProduct();
          };
          $scope.close = function () {
            $modalInstance.dismiss('ok');
          };
        }]
      });
    };
    $scope.saveProduct = function (product) {
      if (!product) {
        product = $scope.product;
      }
      ProductService.save({}, product, function (saved) {
        $scope.clearProduct();
        $scope.reloadTable();
        toaster.pop('success', product.id ? 'Product updated' : 'Product created', 'Successfully saved product ' + saved.name + '.');
      });
    };

  }]);
});
