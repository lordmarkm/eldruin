define(['angular', 'app/controllers/module.js'], function (angular, controllers) {
  'use strict';
  controllers.controller('AdminProductDetailsController', ['$scope', '$modal', 'toaster', 'product', 'ProductService', 'ProductImagesService',
    function($scope, $modal, toaster, product, ProductService, ProductImagesService) {

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

    //Manage thumbnail
    $scope.updateThumbnail = function () {
      return $modal.open({
        scope: $scope,
        templateUrl: 'modal-update-thumbnail',
        backdrop: 'static',
        controller: ['$scope', '$modalInstance', function ($scope, $modalInstance) {
          $scope.thumbnailInfo = {
              url: $scope.readOnlyProduct.gallery.thumbnail ? $scope.readOnlyProduct.gallery.thumbnail.url : '',
              addToGallery: true
          };
          $scope.confirm = function () {
            $modalInstance.dismiss('ok');
            $scope.saveThumbnail($scope.thumbnailInfo.url, $scope.thumbnailInfo.addToGallery);
          };
          $scope.close = function () {
            $modalInstance.dismiss('ok');
          };
        }]
      });
    };
    $scope.saveThumbnail = function (url, addToGallery) {
      console.debug('Saving thumbnail.');
      ProductImagesService.put({
          action: 'thumbnail',
          productCode: $scope.readOnlyProduct.code,
          url: url,
          addToGallery: addToGallery
        }, {}, function () {
        toaster.pop('success', 'Product updated', 'Successfully updated thumbnail.');
      });
    };



  }]);
});
