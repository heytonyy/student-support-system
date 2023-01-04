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
  
  <title>Admin Dashboard</title>
  
</head>
<body class="dark-mode with-custom-webkit-scrollbars with-custom-css-scrollbars" data-dm-shortcut-enabled="true" data-sidebar-shortcut-enabled="true" data-set-preferred-mode-onload="true">

  <!-- Page wrapper start -->
  <div class="page-wrapper with-navbar with-sidebar" data-sidebar-type="overlayed-sm-and-down">

    <!-- Navbar -->
    <nav class="navbar">
	    <div class="navbar-content">
	        <button id="toggle-sidebar-btn" class="btn btn-action" type="button" onclick="halfmoon.toggleSidebar()">
	            <i class="fa fa-bars" aria-hidden="true"></i>
	        </button>
	    </div>
	    <a href="#" class="navbar-brand ml-10 ml-sm-20">
	        <span class="d-none d-sm-flex">Student Support System</span>
	    </a>
	    <div class="navbar-content ml-auto">
	        <button class="btn btn-action mr-5" type="button" onclick="halfmoon.toggleDarkMode()">
	            <i class="fa fa-moon-o" aria-hidden="true"></i>
	            <span class="sr-only">Toggle dark mode</span>
	        </button>
	        <!-- LOGOUT -->
			<form id="logoutForm" method="POST" action="/logout">
        		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        		<input type="submit" class="btn btn-primary" value="Logout!" />
    		</form>
	    </div>
    </nav>
    
	<!-- Sidebar overlay -->
    <div class="sidebar-overlay" onclick="halfmoon.toggleSidebar()"></div>
    
    <!-- Sidebar -->
    <div class="sidebar">
	    <div class="sidebar-menu">
	        <div class="sidebar-content">
	            <h6 class="my-0">
					Welcome, 
					<span class="text-success">
						<c:out value="${currentUser.lastName}" />
					</span>!
					<c:if test="${currentUser.isAdmin()}">
						<span class="text-danger">(ADMIN)</span>
					</c:if>
					<c:if test="${!currentUser.isAdmin()}">
						<span class="text-secondary">(TEACHER)</span>
					</c:if>
				</h6>
	        </div>
	        <h5 class="sidebar-title">Navigate</h5>
	        <div class="sidebar-divider"></div>
	        <a href="/admin" class="sidebar-link sidebar-link-with-icon ${sidebar == 0 ? 'active' : ''}">
	            <span class="sidebar-icon">
	                <i class="fa-solid fa-magnifying-glass"></i>
	            </span>
	            Student Lookup
	        </a>
	        <a href="/admin/newstudent" class="sidebar-link sidebar-link-with-icon ${sidebar == 1 ? 'active' : ''}">
	            <span class="sidebar-icon">
	                <i class="fa-solid fa-user"></i>
	            </span>
	            Add Student
	        </a>
	    </div>
    </div>

    <!-- Content wrapper -->
	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="row row-eq-spacing-lg">
				
				<!-- STUDENT LOOKUP -->
				<div class="col">
					<div class="content w-400">
						<h1 class="content-title">
							Student Look Up:
						</h1>
						<form action="#" method="POST" class="form-inline">
    						<input type="text" class="form-control" placeholder="Search By Name..." />
    						<input type="submit" class="btn btn-primary" value="Submit" />
						</form>
					</div>
					<!-- STUDENT INFO CARD -->
					<!-- <h6 class="font-italic">Soon™</h6> -->
				</div>
				
			</div>
		</div>
  	</div>
    

  </div>
  
  <!-- Halfmoon JS -->
  <script src="https://cdn.jsdelivr.net/npm/halfmoon@1.1.1/js/halfmoon.min.js"></script>
</body>
</html>