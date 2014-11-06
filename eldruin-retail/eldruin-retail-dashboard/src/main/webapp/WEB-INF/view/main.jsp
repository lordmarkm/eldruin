<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html>

<head>
<title>Eldruin Retail</title>
<link rel="stylesheet" href="<@spring.url '/lib/bootstrap-3.2.0/css/bootstrap.min.css' />" />
<link rel="stylesheet" href="<@spring.url '/lib/angular-ngtable/ng-table.min.css' />" />
<link rel="stylesheet" href="<@spring.url '/lib/font-awesome-4.1.0/css/font-awesome.min.css' />" />
<link rel="stylesheet" href="<@spring.url '/lib/angular/toaster.css' />" />
<script src="<@spring.url '/lib/jquery/jquery.min.js' />"></script>
<style>
    .navbar { border-radius:0; }
</style>
<script data-main="<@spring.url '/app/main.js' />" src="<@spring.url '/lib/require/require.js' />"></script>
</head>

<body>
  <!-- NAVIGATION -->
  <nav class="navbar navbar-inverse" role="navigation">
    <div class="navbar-header">
      <a class="navbar-brand" href="<@spring.url '/#/' />">App to date
         <small style="font-size: 0.5em;">Powered by Chikka</small>
      </a>
    </div>
    <ul class="nav navbar-nav">
      <li><a ui-sref="default.hello">Hello</a></li>
      <li><a ui-sref="ics_admin">Admin</a></li>
    </ul>
  </nav>

  <!-- Main Content -->
  <div class="container">
    <toaster-container toaster-options="{'time-out': 4000, 'limit' : 3}"></toaster-container>
    <div ui-view>Loading resources...</div>
  </div>

  <div style="margin-bottom: 30px;"></div>
</body>

</html>