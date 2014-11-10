define(['angular', 'app/controllers/module.js'], function (angular, controllers) {
  'use strict';
  controllers.controller('AdminProductDetailsController', ['$scope', '$modal', 'toaster', 'product', 'ProductService',
    function($scope, $modal, toaster, product, ProductService) {

    //Modal for create/update
    $scope.readOnlyProduct = product;
    $scope.product = {};

    $scope.updateProduct = function () {
      $scope.product = angular.copy($scope.readOnlyProduct);

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
    $scope.saveProduct = function () {
      ProductService.save({}, $scope.product, function (saved) {
        $scope.readOnlyProduct = saved;
        toaster.pop('success', 'Product updated', 'Successfully saved product ' + saved.name + '.');
      });
    };

  }]);
});
