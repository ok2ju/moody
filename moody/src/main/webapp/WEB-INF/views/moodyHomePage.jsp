<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="assets/ico/favicon.png">

<title>Theme Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap theme -->
<link href="assets/css/bootstrap-theme.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="assets/css/theme.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="assets/js/html5shiv.js"></script>
      <script src="assets/js/bootstrap/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<!-- Fixed navbar -->
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Moody</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#"> Profile </a></li>
					<li><a href="#about">Follower</a></li>
					<li><a href="#contact">Messages<span class="badge" style="margin-left:3px;">14</span></a></li>
					<li class="dropdown"><a hre	f="#" class="dropdown-toggle"
						data-toggle="dropdown">Dropdown <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li class="dropdown-header">Nav header</li>
							<li><a href="#">Settings</a></li>
							<li><a href="#">Log out</a></li>
						</ul></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<div class="container theme-showcase">
		<div class="row">
			<div class="col-sm-4 col-md-3 col-lg-3">
				<img src="assets/img/0fyx_5tcwlI.jpg"
					class="img-responsive"
					alt="A generic square placeholder image with a white border around it, 
					making it resemble a photograph taken with an old instant camera"
					style="border: 1px solid #DDD;
						   box-shadow: 0 1px 2px rgba(0, 0, 0, 0.15);">
					
				<h2>
					<span class="name">${person.userDetails.username}</span>
				</h2>
				
				<div class="info">
					<span class="location">
						Grodno, Belarus
					</span>
				</div>
				
				<ul class="stats" style="">
					<li>
						<a href="/OlegAtsman/followers"> 
							<strong>1</strong>
							<span>follower</span>
						</a>
					</li>
					<li>
						<a href="/stars"> 
							<strong>6</strong> 
							<span>starred</span>
						</a>
					</li>
					<li>
						<a href="/OlegAtsman/following"> 
							<strong>1</strong>
							<span>following</span>
						</a>
					</li>
				</ul>
				
			</div>
			
			<div class="col-sm-9 col-md-9 col-lg-9">
				
				<div class="bs-example bs-example-tabs">
			      <ul id="myTab" class="nav nav-tabs">
			        <li class="active"><a href="#home" data-toggle="tab">Info</a></li>
			        <li class=""><a href="#profile" data-toggle="tab">Contact</a></li>
			        <li class="dropdown">
			          <a href="#" id="myTabDrop1" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
			          <ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
			            <li class=""><a href="#dropdown1" tabindex="-1" data-toggle="tab">@fat</a></li>
			            <li class=""><a href="#dropdown2" tabindex="-1" data-toggle="tab">@mdo</a></li>
			          </ul>
			        </li>
			      </ul>
			      <div id="myTabContent" class="tab-content">
			        <div class="tab-pane fade active in" id="home">
			        
			          <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p>
			        </div>
			        <div class="tab-pane fade" id="profile">
			          <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit. Keytar helvetica VHS salvia yr, vero magna velit sapiente labore stumptown. Vegan fanny pack odio cillum wes anderson 8-bit, sustainable jean shorts beard ut DIY ethical culpa terry richardson biodiesel. Art party scenester stumptown, tumblr butcher vero sint qui sapiente accusamus tattooed echo park.</p>
			        </div>
			        <div class="tab-pane fade" id="dropdown1">
			          <p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork. Williamsburg banh mi whatever gluten-free, carles pitchfork biodiesel fixie etsy retro mlkshk vice blog. Scenester cred you probably haven't heard of them, vinyl craft beer blog stumptown. Pitchfork sustainable tofu synth chambray yr.</p>
			        </div>
			        <div class="tab-pane fade" id="dropdown2">
			          <p>Trust fund seitan letterpress, keytar raw denim keffiyeh etsy art party before they sold out master cleanse gluten-free squid scenester freegan cosby sweater. Fanny pack portland seitan DIY, art party locavore wolf cliche high life echo park Austin. Cred vinyl keffiyeh DIY salvia PBR, banh mi before they sold out farm-to-table VHS viral locavore cosby sweater. Lomo wolf viral, mustache readymade thundercats keffiyeh craft beer marfa ethical. Wolf salvia freegan, sartorial keffiyeh echo park vegan.</p>
			        </div>
			      </div>
			    </div>
				
				<div>
					<h3>
						Moody Time Line
					</h3>
				</div>					
			    
			    <div class="progress">
					<div class="progress-bar progress-bar-success" style="width: 35%">
						<span class="sr-only">35% Complete (success)</span>
					</div>
					<div class="progress-bar progress-bar-warning" style="width: 20%">
						<span class="sr-only">20% Complete (warning)</span>
					</div>
					<div class="progress-bar progress-bar-danger" style="width: 10%">
						<span class="sr-only">10% Complete (danger)</span>
					</div>
				</div>
			</div>
			
		</div>
		
		<div class="row">
			<div class="col-sm-4">
				<ul class="list-group">
					<li class="list-group-item">Cras justo odio</li>
					<li class="list-group-item">Dapibus ac facilisis in</li>
					<li class="list-group-item">Morbi leo risus</li>
					<li class="list-group-item">Porta ac consectetur ac</li>
					<li class="list-group-item">Vestibulum at eros</li>
				</ul>
			</div>
			<!-- /.col-sm-4 -->
			<div class="col-sm-4">
				<div class="list-group">
					<a href="#" class="list-group-item active"> Cras justo odio </a> <a href="#" class="list-group-item">Dapibus ac facilisis in</a> <a href="#" class="list-group-item">Morbi leo risus</a> <a href="#" class="list-group-item">Porta ac consectetur ac</a> <a href="#" class="list-group-item">Vestibulum at eros</a>
				</div>
			</div>
			<!-- /.col-sm-4 -->
			<div class="col-sm-4">
				<div class="list-group">
					<a href="#" class="list-group-item active">
						<h4 class="list-group-item-heading">List group item heading</h4>
						<p class="list-group-item-text">Donec id elit non mi porta
							gravida at eget metus. Maecenas sed diam eget risus varius
							blandit.</p>
					</a> <a href="#" class="list-group-item">
						<h4 class="list-group-item-heading">List group item heading</h4>
						<p class="list-group-item-text">Donec id elit non mi porta
							gravida at eget metus. Maecenas sed diam eget risus varius
							blandit.</p>
					</a> <a href="#" class="list-group-item">
						<h4 class="list-group-item-heading">List group item heading</h4>
						<p class="list-group-item-text">Donec id elit non mi porta
							gravida at eget metus. Maecenas sed diam eget risus varius
							blandit.</p>
					</a>
				</div>
			</div>
			<!-- /.col-sm-4 -->
		</div>
			
	
		<div class="page-header">
			<h1>Dropdown menus</h1>
		</div>
		<div class="dropdown theme-dropdown clearfix">
			<a id="dropdownMenu1" href="#" role="button"
				class="sr-only dropdown-toggle" data-toggle="dropdown">Dropdown
				<b class="caret"></b>
			</a>
			<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				<li role="presentation"><a role="menuitem" tabindex="-1"
					href="#">Action</a></li>
				<li role="presentation"><a role="menuitem" tabindex="-1"
					href="#">Another action</a></li>
				<li role="presentation"><a role="menuitem" tabindex="-1"
					href="#">Something else here</a></li>
				<li role="presentation" class="divider"></li>
				<li role="presentation"><a role="menuitem" tabindex="-1"
					href="#">Separated link</a></li>
			</ul>
		</div>

		<div class="page-header">
			<h1>Navbars</h1>
		</div>

		<div class="navbar navbar-default">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Project name</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#about">About</a></li>
						<li><a href="#contact">Contact</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Dropdown <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li class="dropdown-header">Nav header</li>
								<li><a href="#">Separated link</a></li>
								<li><a href="#">One more separated link</a></li>
							</ul></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="../navbar/">Default</a></li>
						<li><a href="../navbar-static-top/">Static top</a></li>
						<li class="active"><a href="./">Fixed top</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>

		<div class="navbar navbar-inverse">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Project name</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#about">About</a></li>
						<li><a href="#contact">Contact</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Dropdown <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li class="dropdown-header">Nav header</li>
								<li><a href="#">Separated link</a></li>
								<li><a href="#">One more separated link</a></li>
							</ul></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="../navbar/">Default</a></li>
						<li><a href="../navbar-static-top/">Static top</a></li>
						<li class="active"><a href="./">Fixed top</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>



		<div class="page-header">
			<h1>Alerts</h1>
		</div>
		<div class="alert alert-success">
			<strong>Well done!</strong> You successfully read this important
			alert message.
		</div>
		<div class="alert alert-info">
			<strong>Heads up!</strong> This alert needs your attention, but it's
			not super important.
		</div>
		<div class="alert alert-warning">
			<strong>Warning!</strong> Best check yo self, you're not looking too
			good.
		</div>
		<div class="alert alert-danger">
			<strong>Oh snap!</strong> Change a few things up and try submitting
			again.
		</div>



		<div class="page-header">
			<h1>Progress bars</h1>
		</div>
		<div class="progress">
			<div class="progress-bar" role="progressbar" aria-valuenow="60"
				aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
				<span class="sr-only">60% Complete</span>
			</div>
		</div>
		<div class="progress">
			<div class="progress-bar progress-bar-success" role="progressbar"
				aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
				style="width: 40%">
				<span class="sr-only">40% Complete (success)</span>
			</div>
		</div>
		<div class="progress">
			<div class="progress-bar progress-bar-info" role="progressbar"
				aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"
				style="width: 20%">
				<span class="sr-only">20% Complete</span>
			</div>
		</div>
		<div class="progress">
			<div class="progress-bar progress-bar-warning" role="progressbar"
				aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
				style="width: 60%">
				<span class="sr-only">60% Complete (warning)</span>
			</div>
		</div>
		<div class="progress">
			<div class="progress-bar progress-bar-danger" role="progressbar"
				aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"
				style="width: 80%">
				<span class="sr-only">80% Complete (danger)</span>
			</div>
		</div>
		<div class="progress">
			<div class="progress-bar progress-bar-success" style="width: 35%">
				<span class="sr-only">35% Complete (success)</span>
			</div>
			<div class="progress-bar progress-bar-warning" style="width: 20%">
				<span class="sr-only">20% Complete (warning)</span>
			</div>
			<div class="progress-bar progress-bar-danger" style="width: 10%">
				<span class='sr-only'>10% Complete (danger)</span>
			</div>
		</div>



		<div class="page-header">
			<h1>List groups</h1>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<ul class="list-group">
					<li class="list-group-item">Cras justo odio</li>
					<li class="list-group-item">Dapibus ac facilisis in</li>
					<li class="list-group-item">Morbi leo risus</li>
					<li class="list-group-item">Porta ac consectetur ac</li>
					<li class="list-group-item">Vestibulum at eros</li>
				</ul>
			</div>
			<!-- /.col-sm-4 -->
			<div class="col-sm-4">
				<div class="list-group">
					<a href="#" class="list-group-item active"> Cras justo odio </a> <a
						href="#" class="list-group-item">Dapibus ac facilisis in</a> <a
						href="#" class="list-group-item">Morbi leo risus</a> <a href="#"
						class="list-group-item">Porta ac consectetur ac</a> <a href="#"
						class="list-group-item">Vestibulum at eros</a>
				</div>
			</div>
			<!-- /.col-sm-4 -->
			<div class="col-sm-4">
				<div class="list-group">
					<a href="#" class="list-group-item active">
						<h4 class="list-group-item-heading">List group item heading</h4>
						<p class="list-group-item-text">Donec id elit non mi porta
							gravida at eget metus. Maecenas sed diam eget risus varius
							blandit.</p>
					</a> <a href="#" class="list-group-item">
						<h4 class="list-group-item-heading">List group item heading</h4>
						<p class="list-group-item-text">Donec id elit non mi porta
							gravida at eget metus. Maecenas sed diam eget risus varius
							blandit.</p>
					</a> <a href="#" class="list-group-item">
						<h4 class="list-group-item-heading">List group item heading</h4>
						<p class="list-group-item-text">Donec id elit non mi porta
							gravida at eget metus. Maecenas sed diam eget risus varius
							blandit.</p>
					</a>
				</div>
			</div>
			<!-- /.col-sm-4 -->
		</div>



		<div class="page-header">
			<h1>Panels</h1>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Panel title</h3>
					</div>
					<div class="panel-body">Panel content</div>
				</div>
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Panel title</h3>
					</div>
					<div class="panel-body">Panel content</div>
				</div>
			</div>
			<!-- /.col-sm-4 -->
			<div class="col-sm-4">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">Panel title</h3>
					</div>
					<div class="panel-body">Panel content</div>
				</div>
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Panel title</h3>
					</div>
					<div class="panel-body">Panel content</div>
				</div>
			</div>
			<!-- /.col-sm-4 -->
			<div class="col-sm-4">
				<div class="panel panel-warning">
					<div class="panel-heading">
						<h3 class="panel-title">Panel title</h3>
					</div>
					<div class="panel-body">Panel content</div>
				</div>
				<div class="panel panel-danger">
					<div class="panel-heading">
						<h3 class="panel-title">Panel title</h3>
					</div>
					<div class="panel-body">Panel content</div>
				</div>
			</div>
			<!-- /.col-sm-4 -->
		</div>



		<div class="page-header">
			<h1>Wells</h1>
		</div>
		<div class="well">
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
				Maecenas sed diam eget risus varius blandit sit amet non magna.
				Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent
				commodo cursus magna, vel scelerisque nisl consectetur et. Cras
				mattis consectetur purus sit amet fermentum. Duis mollis, est non
				commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem
				nec elit. Aenean lacinia bibendum nulla sed consectetur.</p>
		</div>


	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="assets/js/jquery/jquery.js"></script>
	<script src="assets/js/jquery/jquery-migrate-plugin.js"></script>
	<script src="assets/js/bootstrap/bootstrap.min.js"></script>
	<script src="assets/js/bootstrap/holder.js"></script>
	<script src="assets/js/atmosphere/jquery.atmosphere.js"></script>
	<script src="assets/js/atmosphere/moodyConnection.js"></script>
</body>
</html>
