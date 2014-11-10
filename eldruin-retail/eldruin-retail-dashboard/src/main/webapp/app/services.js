define(['angular'], function(angular) {
  'use strict';

  angular.module('app.services', ['ngResource'])

  .factory('ProductService', function($resource) {
    return $resource('retailproduct/:code');
  });

});