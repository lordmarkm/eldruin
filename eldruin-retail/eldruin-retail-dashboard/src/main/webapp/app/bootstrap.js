define([
  'require',
  'angular',
  'app/app.js',
  'app/routes.js',
  'app/modules/ics_admin/module.js'
], function (require, angular) {
  'use strict';
  require(['domReady!'], function (document) {
    angular.bootstrap(document, ['eldruin-retail']);
  });
});