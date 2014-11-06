define(['app/app.js'], 
  function(app) {
    'use strict';
    return app.config(function($stateProvider) {
      $stateProvider.state('ics_admin', {
        url: '/admin',
        templateUrl: 'app/modules/ics_admin/view/hello.html',
        controller: 'IcsAdminController'
      });
    }
  );
});