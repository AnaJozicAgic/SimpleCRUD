<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Pregled zivotinja</title>

<!-- Bootstrap Core CSS -->
<link
	href="css/startbootstrap-one-page-wonder-gh-pages/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="css/startbootstrap-one-page-wonder-gh-pages/css/one-page-wonder.css"
	rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Naslovnica</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<!-- 				<li><a href="lista.jsp">Pregledaj zivotinje</a></li> -->
				<li><a href="listasvih"
					>Pregledaj zivotinje &raquo;</a></li>
				<li><a href="dodaj.jsp">Dodaj zivotinje</a></li>
				<li><a href="contact.jsp">Kontakt</a></li>
			</ul>
			<form class="navbar-form navbar-left" role="pretrazivanje" action="pretrazivanje"
				method="get">
				<div class="form-group">
					<input type="text" class="form-control"
						placeholder="Pretrazuj zivotinje" name="name">
				</div>
				<button type="submit" class="btn btn-default">Pretrazi</button>
			</form>
			<p class="navbar-text navbar-right">
				Prijavljeni ste kao: <b>${korisnik.username}</b>
			</p>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

<div class="text-center">
		<h3>
			<c:out value="${message}"></c:out>
		</h3>
	</div>
  <div class="container">
        <div class="card card-container">
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
            <form class="form-signin"  action="dodaj" method="post">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="text" name="vrsta" class="form-control" placeholder="vrsta zivotinje" required autofocus>
                <textarea type="text" name="kratakOpis" placeholder="Kratak opis" required cols="40" rows = "3"></textarea>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Unesi</button>
            </form><!-- /form -->
        </div><!-- /card-container -->
    </div><!-- /container -->


	<!-- Footer -->
	<footer>
	<div class="row">
		<div class="col-lg-12">
			<p>Copyright &copy; ovo-ono.com</p>
		</div>
	</div>
	</footer>

	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>