<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Meta tags -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
  <meta name="viewport" content="width=device-width" />

  <!-- Font awesome -->
   <script src="https://kit.fontawesome.com/0f4771ad8a.js" crossorigin="anonymous"></script>
   
  <!-- Halfmoon CSS -->
  <link href="https://cdn.jsdelivr.net/npm/halfmoon@1.1.1/css/halfmoon-variables.min.css" rel="stylesheet" />
  
  <!-- CUSTOM CSS -->
  <link rel="stylesheet" href="/css/style.css" />
  
  <title>Register</title>
  
</head>
<body class="dark-mode with-custom-webkit-scrollbars with-custom-css-scrollbars" data-set-preferred-mode-onload="true">

  <!-- Page wrapper start -->
  <div class="page-wrapper">

    <!-- Content wrapper -->
	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="row row-eq-spacing-lg">
			
				<!-- MIDDLE COL -->
				<div class="col">
					<div class="content">
						<div class="card w-400 mx-auto">
							<h2 class="card-title">
								Register Account
							</h2>
							<!-- FORM -->
							<p class="text-danger"><form:errors path="user.*"/></p>
							<form:form modelAttribute="user" action="/registration" method="POST">
						  		<!-- FIRST NAME -->
						  		<div class="form-group">
					   				<form:label path="firstName">First Name:</form:label>
					   				<form:input type="text" class="form-control" path="firstName" />
						  		</div>
						  		<!-- LAST NAME -->
						  		<div class="form-group">
					   				<form:label path="lastName">Last Name:</form:label>
					   				<form:input type="text" class="form-control" path="lastName" />
						  		</div>
						  		<!-- EMAIL -->
						  		<div class="form-group">
					   				<form:label path="username">Username:</form:label>
					   				<form:input type="text" class="form-control" path="username" />
						  		</div>
						  		<!-- PASSWORD -->
						  		<div class="form-group">
					   				<form:label path="password">Password:</form:label>
					   				<form:input type="password" class="form-control" path="password" />
						  		</div>
						  		<!-- CONFIRM -->
						  		<div class="form-group">
					   				<form:label path="confirm">Confirm Password:</form:label>
					   				<form:input type="password" class="form-control" path="confirm" />
						  		</div>		
						  		<!-- SUBMIT -->
						  		<input class="btn btn-primary" type="submit" value="Create Account">
							</form:form>
						</div>
						<a href="/login" class="font-size-20 d-flex justify-content-center">Go to Login</a>
					</div>
				</div>

			</div>
		</div>
  	</div>
    

  </div>
  
  <!-- Halfmoon JS -->
  <script src="https://cdn.jsdelivr.net/npm/halfmoon@1.1.1/js/halfmoon.min.js"></script>
</body>
</html>