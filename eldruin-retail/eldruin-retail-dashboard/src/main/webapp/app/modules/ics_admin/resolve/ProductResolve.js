define([], function() {
  'use strict';
  return {
    product: ['$stateParams', 'ProductService', function ($stateParams, ProductService) {
      return ProductService.get({code: $stateParams.code}).$promise;
    }]
  };
});