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
  
  <title>Home</title>
  
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
	    <a href="/" class="navbar-brand ml-10 ml-sm-20">
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
	        <a href="/homeroom" class="sidebar-link sidebar-link-with-icon ${sidebar == 0 ? 'active' : ''}">
	            <span class="sidebar-icon">
	                <i class="fa-solid fa-book"></i>
	            </span>
	            Homeroom
	        </a>
	        <a href="/period1" class="sidebar-link sidebar-link-with-icon ${sidebar == 1 ? 'active' : ''}">
	            <span class="sidebar-icon">
	                <i class="fa-solid fa-book"></i>
	            </span>
	            Period 1
	        </a>
	        <a href="/period2" class="sidebar-link sidebar-link-with-icon ${sidebar == 2 ? 'active' : ''}">
	            <span class="sidebar-icon">
	                <i class="fa-solid fa-book"></i>
	            </span>
	            Period 2
	        </a>
	        <a href="/period3" class="sidebar-link sidebar-link-with-icon ${sidebar == 3 ? 'active' : ''}">
	            <span class="sidebar-icon">
	                <i class="fa-solid fa-book"></i>
	            </span>
	            Period 3
	        </a>
	        <a href="/period4" class="sidebar-link sidebar-link-with-icon ${sidebar == 4 ? 'active' : ''}">
	            <span class="sidebar-icon">
	                <i class="fa-solid fa-book"></i>
	            </span>
	            Period 4
	        </a>
	        <a href="/period5" class="sidebar-link sidebar-link-with-icon ${sidebar == 5 ? 'active' : ''}">
	            <span class="sidebar-icon">
	                <i class="fa-solid fa-book"></i>
	            </span>
	            Period 5
	        </a>
	        <a href="/period6" class="sidebar-link sidebar-link-with-icon ${sidebar == 6 ? 'active' : ''}">
	            <span class="sidebar-icon">
	                <i class="fa-solid fa-book"></i>
	            </span>
	            Period 6
	        </a>
	    </div>
    </div>

    <!-- Content wrapper -->
	<div class="content-wrapper">
		<div class="container-fluid">
			<div class="row row-eq-spacing-lg mt-0">
			
				<!-- LEFT ROSTER COL -->
				<div class="col-lg-5 d-none d-lg-block">
					<div class="content">
						<h2 class="content-title mt-20">
							Roster
						</h2>
						
							
							<table class="table table-hover">
								<thead>
									<tr>
										<th class="text-center">Name</th>
										<th class="text-center">Grade</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="student" items="${studentRoster}">
										<!-- FOR HOMEROOM -->
										<c:if test="${sidebar == 0}">
											<tr>
												<td class="text-center">
													<a href="/homeroom/${student.id}/homeroom">
														<c:out value="${student.firstName} ${student.lastName}" />
													</a>
												</td>
												<td class="text-center">
													<c:out value="${student.grade}th" />
												</td>
											</tr>
										</c:if>
										<!-- FOR OTHER PERIODS -->
										<c:if test="${sidebar != 0}">
											<tr>
												<td class="text-center">
													<a href="/period${sidebar}/${student.id}/homeroom">
														<c:out value="${student.firstName} ${student.lastName}" />
													</a>
												</td>
												<td class="text-center">
													<c:out value="${student.grade}th" />
												</td>
											</tr>
										</c:if>
									</c:forEach>
								</tbody>
							</table>
						
						
					</div>
				</div>
				
				<!-- RIGHT STUDENT CARD COL -->
				<div class="col-lg-7">
					<div class="content">
						<h2 class="content-title mt-20">
							Student Info
						</h2>
					</div>
				
					<!-- STUDENT INFO CARD -->
					<div class="card p-0">
						<!-- ONLY DISPLAY INFO IF DISPLAYSTUDENT IS NOT NULL -->
						<c:if test="${studentDisplay.getId() != null}">
							<div class="row row-eq-spacing mb-0">
								<!-- PICTURE -->
								<div class="col-4">
									<img src="/assets/blank-avatar.png" class="img-fluid rounded" alt="blank avatar image" />						
								</div>
								<!-- PERSONAL INFO -->
								<div class="col-8">
									<h2 class="card-title p-0 m-0">
										Name: 
										<span class="text-primary font-italic">
											<c:out value="${studentDisplay.firstName} ${studentDisplay.lastName}" />
										</span>
									</h2>
									<h2 class="card-title p-0 m-0">
										Grade:
										<span class="text-primary font-italic">
											<c:out value="${studentDisplay.grade}" />
										</span>
									</h2>
									<h2 class="card-title p-0 m-0">
										Guardian Info:
									</h2>
									<p class="m-0 ml-20">
										Name:
										<span class="text-primary font-italic">
											<c:out value="${studentDisplay.guardianFirstName} ${studentDisplay.guardianLastName}" />
										</span>
									</p>
									<p class="m-0 ml-20">
										Email:
										<span class="text-primary font-italic">
											<c:out value="${studentDisplay.email}" />
										</span>
									</p>
									<p class="m-0 ml-20">
										Phone Number:
										<span class="text-primary font-italic">
											<c:out value="${studentDisplay.phoneNumber}" />
										</span>
									</p>
								</div>
							</div>
							
							<!-- SUPPORT NOTE COMPONENT -->
							<div class="row">
								<div class="col m-20">
								
									<!-- PERIOD PAGINATION -->
									<ul class="pagination">
										<c:if test="${sidebar == 0}">
											<li class="page-item ${studentSchedule == 0 ? 'active' : ''}">
												<a href="/homeroom/${studentDisplay.id}/homeroom" class="page-link">HOME</a>
											</li>
											<li class="page-item ${studentSchedule == 1 ? 'active' : ''}">
												<a href="/homeroom/${studentDisplay.id}/period1" class="page-link">P1</a>
											</li>
											<li class="page-item ${studentSchedule == 2 ? 'active' : ''}">
												<a href="/homeroom/${studentDisplay.id}/period2" class="page-link">P2</a>
											</li>
											<li class="page-item ${studentSchedule == 3 ? 'active' : ''}">
												<a href="/homeroom/${studentDisplay.id}/period3" class="page-link">P3</a>
											</li>
											<li class="page-item ${studentSchedule == 4 ? 'active' : ''}">
												<a href="/homeroom/${studentDisplay.id}/period4" class="page-link">P4</a>
											</li>
											<li class="page-item ${studentSchedule == 5 ? 'active' : ''}">
												<a href="/homeroom/${studentDisplay.id}/period5" class="page-link">P5</a>
											</li>
											<li class="page-item ${studentSchedule == 6 ? 'active' : ''}">
												<a href="/homeroom/${studentDisplay.id}/period6" class="page-link">P6</a>
											</li>
										</c:if>
										<c:if test="${sidebar != 0}">
											<li class="page-item ${studentSchedule == 0 ? 'active' : ''}">
												<a href="/period${sidebar}/${studentDisplay.id}/homeroom" class="page-link">HOME</a>
											</li>
											<li class="page-item ${studentSchedule == 1 ? 'active' : ''}">
												<a href="/period${sidebar}/${studentDisplay.id}/period1" class="page-link">P1</a>
											</li>
											<li class="page-item ${studentSchedule == 2 ? 'active' : ''}">
												<a href="/period${sidebar}/${studentDisplay.id}/period2" class="page-link">P2</a>
											</li>
											<li class="page-item ${studentSchedule == 3 ? 'active' : ''}">
												<a href="/period${sidebar}/${studentDisplay.id}/period3" class="page-link">P3</a>
											</li>
											<li class="page-item ${studentSchedule == 4 ? 'active' : ''}">
												<a href="/period${sidebar}/${studentDisplay.id}/period4" class="page-link">P4</a>
											</li>
											<li class="page-item ${studentSchedule == 5 ? 'active' : ''}">
												<a href="/period${sidebar}/${studentDisplay.id}/period5" class="page-link">P5</a>
											</li>
											<li class="page-item ${studentSchedule == 6 ? 'active' : ''}">
												<a href="/period${sidebar}/${studentDisplay.id}/period6" class="page-link">P6</a>
											</li>
										</c:if>
										
									</ul>
									
									<div class="card p-0 m-0">
										<!-- IF CURRENTUSER IS THEIR TEACHER, SHOW FORM -->
										<c:if test="${showForm}">
										
											<!-- CARD FORM TO ADD NOTE -->
											<form:form modelAttribute="supportNote" action="/${sidebar}/${studentDisplay.id}/addsupportnote" method="POST" class="m-20">
												<input type="hidden" name="teacher" value="${currentUser.id}" />
												<input type="hidden" name="student" value="${studentDisplay.id}" />
												<!-- CATEGORY AND DATE IN-LINE FORM -->
												<div class="form-row row-eq-spacing-md">
													<!-- ERRORS -->
													<p class="m-0">
														<form:errors path="category" class="text-danger"/>					
													</p>
													<p class="m-0">
														<form:errors path="teacherSubmitDate" class="text-danger"/>					
													</p>
													<div class="col-md-8">
														<!-- DROPDOWN -->
														<form:label path="category">Category</form:label>
														<form:select class="form-control" path="category">
															<form:option value="" label="Choose" selected="selected" disabled="disabled" />
													        <form:option value="Academic" label="Academic" />
													        <form:option value="Behavioral" label="Behavioral" />
													        <form:option value="Emotional" label="Emotional" />
													        <form:option value="Home-related" label="Home-related" />
														</form:select>
													</div>
													<div class="col-md-4">
														<!-- DATE SUBMITTED -->
														<form:label path="teacherSubmitDate">Date</form:label>
														<form:input type="date" class="form-control" path="teacherSubmitDate" />
													</div>
												</div>
													
												<!-- TEXT AREA DESCRIPTION -->
												<div class="form-group">
													<!-- ERRORS -->
													<p class="m-0">
														<form:errors path="description" class="text-danger"/>					
													</p>
													<!-- DESCRIPTION -->
													<form:label path="description">Description</form:label>
													<form:textarea class="form-control" path="description" placeholder="Describe..." />
												</div>
												
												<!-- SUBMIT -->
												<div class="text-right">
													<input class="btn btn-primary" type="submit" value="Submit">
												</div>
													
												<!-- CSRF TOKEN -->
												<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
											</form:form>
											
											<!-- ALL TEACHERS COMMENTS -->
											<div class="row row-eq-spacing m-0">
												<div class="card-title ml-20">
													<p>
														My Notes:
													</p>
												</div>
											</div>
											<c:forEach var="note" items="${allNotes}">
												
												<div class="row row-eq-spacing m-0">
													<div class="col">
														Category:
														<span class="text-secondary">
															<c:out value=" ${note.category}" />															
														</span>
													</div>
													<div class="col">
														Date:
														<span class="text-secondary">
															<c:out value=" ${note.teacherSubmitDate}" />															
														</span>
													</div>
												</div>
												<div class="row row-eq-spacing m-0 mt-20 p-0">
													<div class="col">
														<blockquote class="bg-light rounded text-dark p-20 font-italic m-10 mt-0 mb-20">
															<c:out value="${note.description}" />
														</blockquote>
													</div>
												</div>
												
											</c:forEach>
											
											
											
											
										</c:if>
										
										<!-- IF CURRENTUSER IS NOT THEIR TEACHER, SHOW NOTES  -->
										<c:if test="${!showForm}">
											<div class="card-title ml-20">
												<p>
													Teacher:
													<span class="text-success">
														<c:out value=" ${teacherDisplay.lastName}" />													
													</span>
												</p>
											</div>
											<c:if test="${allNotes.size() != 0}">
												<c:forEach var="note" items="${allNotes}">
												
													<div class="row row-eq-spacing m-0">
														<div class="col">
															Category:
															<span class="text-secondary">
																<c:out value=" ${note.category}" />															
															</span>
														</div>
														<div class="col">
															Date:
															<span class="text-secondary">
																<c:out value=" ${note.teacherSubmitDate}" />															
															</span>
														</div>
													</div>
													<div class="row row-eq-spacing m-0 mt-20 p-0">
														<div class="col">
															<blockquote class="bg-light rounded text-dark p-20 font-italic m-10 mt-0 mb-20">
																<c:out value="${note.description}" />
															</blockquote>
														</div>
													</div>
													
												</c:forEach>
												
											</c:if>
											<c:if test="${allNotes.size() == 0}">
												<div class="row row-eq-spacing">
													<div class="col">
														No notes from <c:out value="${teacherDisplay.firstName} ${teacherDisplay.lastName}" />.
													</div>
												</div>
											</c:if>
											
										</c:if>
										
									</div>
									<!-- END OF SUPPORT NOTE CARD -->
									
								</div>
							</div>
							<!-- END OF SUPPORT NOTE COMPONENT -->
							
						</c:if>
						
						<!-- SHOWS MESSAGE IF NO DISPLAY STUDENT IS ACTIVE -->
						<c:if test="${studentDisplay.getId() == null}">
							<h2 class="content-title m-20">
								Click on a student to display their info...
							</h2>
						</c:if>
						
					</div>
						
				</div>
				<!-- END OF RIGHT STUDENT INFO COLUMN -->
				
			</div>
		</div>
  	</div>
    <!-- END OF CONTENT WRAPPER -->

  </div>
  <!-- END OF PAGE WRAPPER -->
  
  <!-- Halfmoon JS -->
  <script src="https://cdn.jsdelivr.net/npm/halfmoon@1.1.1/js/halfmoon.min.js"></script>
</body>
</html>