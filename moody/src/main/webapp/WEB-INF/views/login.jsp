<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
	<title>Sign in &middot; Stock Trading Portfolio Sign in</title>
	<!-- Bootstrap core CSS -->
	<link href="assets/css/bootstrap.min.css" rel="stylesheet">
	<!-- Bootstrap theme -->
	<link href="assets/css/bootstrap-theme.min.css" rel="stylesheet">
	<link href="assets/css/login/login.css" rel="stylesheet">
</head>
<body>

  <div class="container">
    <div data-bind="visible: showErrorMessage" class="alert alert-error">
      Invalid username/password.
    </div>
    <form class="form-signin" method="post" action="login.html">
      <h3 class="muted form-signin-heading">Please sign in</h3>
      <input type="text" class="input-block-level" placeholder="User name" name="username">
      <input type="password" class="input-block-level" placeholder="Password" name="password">
      <button class="btn btn-primary" type="submit">Sign in</button>
      <hr>
      <p class="text-info"><small>
        Log in as <strong>fabrice/fab123</strong> or <strong>paulson/bond</strong><br>
        See <code>WebSecurityConfig.java</code></small></p>
    </form>
  </div><!-- /container -->

  <script src="assets/js/bootstrap/knockout-2.3.0.js"></script>

  <script type="text/javascript">
    ko.applyBindings({
      showErrorMessage : ko.computed(function() {
        var query = window.location.search;
        return query ? (query.indexOf('error') != -1) : false;
      })
    });
  </script>

</body>
</html>
