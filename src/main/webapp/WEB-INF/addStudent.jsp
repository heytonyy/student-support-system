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
  
  <title>Add Student</title>
  
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
	        <a href="/admin" class="sidebar-link sidebar-link-with-icon ${sidebar == 0 ? 'active' : null}">
	            <span class="sidebar-icon">
	                <i class="fa-solid fa-magnifying-glass"></i>
	            </span>
	            Student Lookup
	        </a>
	        <a href="/admin/newstudent" class="sidebar-link sidebar-link-with-icon ${sidebar == 1 ? 'active' : null}">
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
		
			<!-- STUDENT FORM -->
			<form:form modelAttribute="student" method="POST" action="/admin/newstudent" >
				<div class="row row-eq-spacing-lg">
				
					<!-- LEFT CARD -->
					<div class="col-6">
						<div class="card">
							<h2 class="card-title">
								Student Information
							</h2>
							<!-- ERRORS -->
							<p class="m-0">
								<form:errors path="firstName" class="text-danger"/>					
							</p>
							<p class="m-0">
								<form:errors path="lastName" class="text-danger"/>					
							</p>
							<div class="form-row row-eq-spacing-md mt-10">	
								<div class="col-md">
								
									<!-- FIRST NAME -->
									<form:label path="firstName">First Name:</form:label>
	    							<form:input type="text" class="form-control" path="firstName" />	
	    														
								</div>
								<div class="col-md">
								
									<!-- LAST NAME -->
									<form:label path="lastName">Last Name:</form:label>
	    							<form:input type="text" class="form-control" path="lastName" />	
	    														
								</div>
							</div>
							<div class="form-row row-eq-spacing-md">
								<div class="col-md">
									<!-- ERRORS -->
									<p class="m-0">
										<form:errors path="grade" class="text-danger"/>					
									</p>
									<!-- GRADE -->
	    							<form:label path="grade">Grade:</form:label>
									<form:select path="grade" class="form-control" >
										<form:option value="" selected="selected" disabled="disabled"> Choose </form:option>
	   									<form:option value="9" > 9th </form:option>
	   									<form:option value="10" > 10th </form:option>
	   									<form:option value="11" > 11th </form:option>
	   									<form:option value="12" > 12th </form:option>
	   								</form:select>
	   																
								</div>
							</div>
							
							<h2 class="card-title">&nbsp;</h2>
							
							<h2 class="card-title">
								Guardian Information
							</h2>
							<div class="col-md">
							
								<!-- GUARDIAN FIRST NAME -->
								<p class="m-0">
									<form:errors path="guardianFirstName" class="text-danger"/>					
								</p>
								<form:label path="guardianFirstName">First Name:</form:label>
	    						<form:input type="text" class="form-control mb-10" path="guardianFirstName" />	
	    												
							</div>
							<div class="col-md">
							
    							<!-- GUARDIAN LAST NAME -->
								<p class="m-0">
									<form:errors path="guardianLastName" class="text-danger"/>					
								</p>
								<form:label path="guardianLastName">Last Name:</form:label>
	    						<form:input type="text" class="form-control mb-10" path="guardianLastName" />	
	    													
							</div>
							<div class="col-md">
							
    							<!-- PHONE NUMBER -->
								<p class="m-0">
									<form:errors path="phoneNumber" class="text-danger"/>					
								</p>
								<form:label path="phoneNumber">Phone Number:</form:label>
	    						<form:input type="text" class="form-control" path="phoneNumber" />
	    													
							</div>
							<div class="col-md">
							
    							<!-- EMAIL -->
								<p class="m-0">
									<form:errors path="email" class="text-danger"/>					
								</p>
								<form:label path="email">Email:</form:label>
	    						<form:input type="text" class="form-control" path="email" />
	    													
							</div>
						</div>
					</div>
					
					<!-- RIGHT CARD -->
					<div class="col-6">
						<div class="card">
							<h2 class="card-title">
								Student Schedule
							</h2>
							
							<!-- PERIOD DROPDOWN LOOP -->
							<c:forEach var="period" items="${schedule}">
								<div class="form-group">
								
									<c:if test="${period == 0}">
										<!-- ERROR -->
										<p class="m-0">
											<form:errors path="homeroomTeacher" class="text-danger"/>					
										</p>
										<!-- LABEL -->
										<form:label path="homeroomTeacher">
    										<c:out value="Homeroom" />	
    									</form:label>
    									<!-- DROPDOWN -->	
    									<form:select path="homeroomTeacher" class="form-control" >
    										<option value="${null}" selected="selected" disabled="disabled">Teacher</option>
	   										<c:forEach var="teacher" items="${allTeachers}">
	   											<form:option value="${teacher.id}" >
	   												<c:out value="${teacher.lastName}" />
	   											</form:option>	   						
	   										</c:forEach>
	   									</form:select>
    								</c:if>
    								
    								<c:if test="${period != 0}">
    									<!-- ERROR -->
										<p class="m-0">
											<form:errors path='${String.format("period%dTeacher", period)}' class="text-danger"/>					
										</p>
    									<!-- LABEL -->
										<form:label path='${String.format("period%dTeacher", period)}'>
    										<c:out value='${String.format("Period %d", period)}' />
    									</form:label>
    									<!-- DROPDOWN -->	
    									<form:select path='${String.format("period%dTeacher", period)}' class="form-control" >
    										<option value="${null}" selected="selected" disabled="disabled">Teacher</option>
	   										<c:forEach var="teacher" items="${allTeachers}">
	   											<form:option value="${teacher.id}" >
	   												<c:out value="${teacher.lastName}" />
	   											</form:option>	   						
	   										</c:forEach>
	   									</form:select>		
    								</c:if>
    								
  								</div>
							</c:forEach>
							
						</div>
					</div>
				</div>
				
				<!-- SUBMIT FORM -->
				<div class="text-right mr-20">
					<input type="submit" class="btn btn-primary mr-20 mb-20" value="Create Record" />				
				</div>
			</form:form>
			
			
		</div>
  	</div>
    

  </div>
  
  <!-- Halfmoon JS -->
  <script src="https://cdn.jsdelivr.net/npm/halfmoon@1.1.1/js/halfmoon.min.js"></script>
</body>
</html>