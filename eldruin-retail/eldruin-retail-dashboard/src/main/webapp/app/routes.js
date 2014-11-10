define([
    'app/app.js'
  ], function(app) {
  'use strict';
  return app.config(function($stateProvider) {
    $stateProvider.state('default', {
      url: '/',
      abstract: true
    });
  });
});