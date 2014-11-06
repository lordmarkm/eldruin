define(['app/app.js'], 
  function(app) {
    'use strict';
    return app.config(function($stateProvider) {
      $stateProvider.state('manage', {
        url: '/admin',
        templateUrl: 'app/modules/ics_admin/view/hello.html',
        controller: 'IcsAdminController'
      });
    }
  );
});