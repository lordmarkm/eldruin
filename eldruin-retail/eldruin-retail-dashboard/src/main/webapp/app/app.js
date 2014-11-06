define([
  'angular',
  'angular-animate',
  'angular-toaster',
  'bootstrap',
  'uiRouter',
  'uiBootstrap',
  'ngResource',
  'ngTable',
  'sugar',
  'app/controllers/op-controllers.js'
], function (angular) {
  'use strict';
  return angular.module('eldruin-retail', [
    'ui.router',
    'ui.bootstrap',
    'ngResource',
    'ngAnimate',
    'toaster',
    'ngTable',
    'app.controllers'
  ])
  //This is our rudimentary global error handler
  .config(['$httpProvider', function ($httpProvider) {
    $httpProvider.interceptors.push(['$q', 'toaster', function ($q, toaster) {
      return {
        'responseError': function (rejection) {
          toaster.pop('error', rejection.status, rejection.statusText);
          return $q.reject(rejection);
        }
      };
    }]);
  }]);
});