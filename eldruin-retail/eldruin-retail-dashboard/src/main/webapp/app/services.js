define(['angular'], function(angular) {
  'use strict';

  angular.module('app.services', ['ngResource'])

  .factory('ProductService', function($resource) {
    return $resource('retailproduct/:code');
  })
  .factory('ProductImagesService', function($resource) {
    return $resource('retailproductimages/:action', {}, {
      put: {method: 'PUT', isArray: false}
    });
  });

});