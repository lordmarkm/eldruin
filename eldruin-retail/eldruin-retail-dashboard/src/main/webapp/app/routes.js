define([
    'app/app.js'
  ], function(app) {
  'use strict';
  return app.config(function($stateProvider) {
    $stateProvider.state('default', {
      url: '/',
      abstract: true
    }).state('default.welcome', {
      url: '',
      templateUrl: 'app/view/welcome.html'
    }).state('default.hello', {
      url: 'hello',
      templateUrl: 'app/view/hello.html'
    });
  });
});