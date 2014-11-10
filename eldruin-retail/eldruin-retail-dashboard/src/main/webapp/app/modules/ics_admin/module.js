define([
      'app/app.js',
      'app/modules/ics_admin/resolve/ProductResolve.js'
  ], 
  function(app, ProductResolve) {
    'use strict';
    return app.config(function($stateProvider) {
      $stateProvider.state('ics_admin', {
        abstract: true,
        url: '/admin',
        views: {
          sidebar: {
            templateUrl: 'app/modules/ics_admin/view/sidebar.html'
          },
          main: {
            template: '<ui-view></ui-view>'
          }
        }
      }).state('ics_admin.overview', {
        templateUrl: 'app/modules/ics_admin/view/overview.html'
      }).state('ics_admin.products', {
        url: '/products',
        templateUrl: 'app/modules/ics_admin/view/products.html',
        controller: 'AdminProductController'
      }).state('ics_admin.product', {
        url: '/product/{code}',
        templateUrl: 'app/modules/ics_admin/view/product_details.html',
        controller: 'AdminProductDetailsController',
        resolve: ProductResolve
      });
    }
  );
});