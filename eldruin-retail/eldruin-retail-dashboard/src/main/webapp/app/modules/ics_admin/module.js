define(['app/app.js'], 
  function(app) {
    'use strict';
    return app.config(function($stateProvider) {
      $stateProvider.state('ics_admin', {
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
        url: '/overvew',
        templateUrl: 'app/modules/ics_admin/view/overview.html'
      }).state('ics_admin.products', {
        url: '/products',
        templateUrl: 'app/modules/ics_admin/view/products.html',
        controller: 'AdminProductController'
      });
    }
  );
});