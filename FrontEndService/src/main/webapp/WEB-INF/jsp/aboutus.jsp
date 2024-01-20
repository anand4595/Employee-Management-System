<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/1.4.6/tailwind.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
<title>Index page</title>
<link>

<style>
/* Add styles for the dropdown menu */
body {
	font-family: "Poppins", sans-serif !important;
	margin: 0;
	padding: 0;
}

.header-2 {
	flex: 1;
}

.footer-1 {
	background-color: #f9f9f9;
	padding: 2rem 0;
}

.dropdown {
	display: flex;
	align-items: center;
	justify-content: center;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
	top: 10%;
}

.dropdown-content a {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

@media screen and (max-width: 770px) {
	.dropdown {
		justify-content: flex-start;
	}
	.dropdown-content {
		top: 24%;
	}
}

@media screen and (max-width: 480px) {
	.footer2 {
		font-size: 14px;
	}
}
@media screen and (max-width: 1280px) {
	.box {
		margin-top: 8%;
	}
}


.footer2 {
	border-top: 1px solid gainsboro;
	padding-top: 1rem;
	text-align: center;
}

.footer-links {a { padding-bottom:2px;
	
}
}
</style>

</head>
<body>
	<%-- <h1>
		welcome to the index page
	</h1>
	<ol><li>
			<a href=/"createEmployee">Create Employee</a>
		</li>
		<li>
			<a href="contactus">Contact Us Foam</a>
		</li>
		<li>
			<a href="admin/dashboard">Administrator Dash board</a>			
		</li>
	</ol>
	
	--%>

	<div class="header-2">

		<nav class="bg-white py-2 md:py-4">
			<div class="container px-4 mx-auto md:flex md:items-center">

				<div class="flex justify-between items-center">
					<a href="#" class="font-bold text-xl text-indigo-600">EMS</a>
					<button
						class="border border-solid border-gray-600 px-3 py-1 rounded text-gray-600 opacity-50 hover:opacity-75 md:hidden"
						id="navbar-toggle">
						<i class="fas fa-bars"></i>
					</button>
				</div>

				<div
					class="hidden md:flex flex-col md:flex-row md:ml-auto mt-3 md:mt-0"
					id="navbar-collapse">
					<a href="/index"
						class="p-2 lg:px-4 md:mx-2 text-gray-600 rounded hover:bg-gray-200 hover:text-gray-700 transition-colors duration-300">Home</a>
					<%-- <a href="#" class="p-2 lg:px-4 md:mx-2 text-gray-600 rounded hover:bg-gray-200 hover:text-gray-700 transition-colors duration-300">Services</a> --%>
					<div class="dropdown">
						<a href="#"
							class="p-2 lg:px-4 md:mx-2 text-gray-600 rounded hover:bg-gray-200 hover:text-gray-700 transition-colors duration-300"
							onclick="toggleDropdown('servicesDropdown')">Services</a>
						<div id="servicesDropdown" class="dropdown-content">
							<a href="/createEmployee">Create</a> <a href="/updateEmployee">Update</a>
							<a href="/deleteEmployee">Delete</a> <a href="/readAllEmployee">Display</a>
							<a href="/admin/dashboard">Dashboard</a>
						</div>
					</div>

					<a href="/aboutus"
						class="p-2 lg:px-4 md:mx-2 text-white rounded bg-indigo-600">About</a>
					<a href="/contactus"
						class="p-2 lg:px-4 md:mx-2 text-gray-600 rounded hover:bg-gray-200 hover:text-gray-700 transition-colors duration-300">Contact</a>
					<a href="/login"
						class="p-2 lg:px-4 md:mx-2 text-indigo-600 text-center border border-solid border-indigo-600 rounded hover:bg-indigo-600 hover:text-white transition-colors duration-300 mt-1 md:mt-0 md:ml-1">Admin/Emp
						Login</a> <a href="/auth/logout"
						class="p-2 lg:px-4 md:mx-2 text-indigo-600 text-center border border-solid border-indigo-600 rounded hover:bg-indigo-600 hover:text-white transition-colors duration-300 mt-1 md:mt-0 md:ml-1">Logout</a>
				</div>
			</div>
		</nav>
		<div>
			<div class="bg-indigo-100 py-6 md:py-6">
				<div class="container px-4 mx-auto">
					<div class="box"
						style="position: absolute; top: 29%; left: 50%; transform: translate(-50%, -50%);">
						<div><h1 style="font-weight:700; font-size:large; margin-left:40%;">About EMS</h1></div>
						<br>Welcome to EMS, where we redefine efficiency and empower
						businesses through our cutting-edge Employee Management System
						(EMS). At EMS, we believe that managing your workforce should be
						seamless, intelligent, and tailored to meet the unique needs of
						your organization. <br>Our Employee Management System is a
						comprehensive solution designed to streamline workforce
						management. From efficient onboarding processes to seamless
						attendance tracking, our system ensures optimal employee
						engagement. With user-friendly interfaces and robust data
						security, we empower businesses to manage personnel records,
						performance evaluations, and payroll efficiently.
					</div>
					<img class="back-img" src="/image/img3.jpg" alt="Image">
				</div>
			</div>
		</div>

		<footer class="footer-1 bg-gray-100 py-8 sm:py-12"
			style="line-height: 3vh;">
			<div class="container mx-auto px-4">
				<div class="sm:flex sm:flex-wrap sm:-mx-4 md:py-4">
					<div class="px-4 sm:w-1/2 md:w-1/4 xl:w-1/6">
						<h5 class="text-xl font-bold mb-6">Features</h5>
						<ul class="list-none footer-links">
							<li class="mb-2"><a href="/createEmployee"
								class="border-b border-solid border-transparent hover:border-purple-800 hover:text-purple-800">Create
									Service</a></li>
							<li class="mb-2"><a href="/readAllEmployee"
								class="border-b border-solid border-transparent hover:border-purple-800 hover:text-purple-800">Read
									Service</a></li>
							<li class="mb-2"><a href="/updateEmployee"
								class="border-b border-solid border-transparent hover:border-purple-800 hover:text-purple-800">Update
									Service</a></li>
							<li class="mb-2"><a href="/deleteEmployee"
								class="border-b border-solid border-transparent hover:border-purple-800 hover:text-purple-800">Delete
									Service</a></li>
						</ul>
					</div>
					<div class="px-4 sm:w-1/2 md:w-1/4 xl:w-1/6 mt-8 sm:mt-0">
						<h5 class="text-xl font-bold mb-6">Resources</h5>
						<ul class="list-none footer-links">
							<li class="mb-2"><a href="/admin/dashboard"
								class="border-b border-solid border-transparent hover:border-purple-800 hover:text-purple-800">Dashboard</a>
							</li>
							<li class="mb-2"><a href="/login"
								class="border-b border-solid border-transparent hover:border-purple-800 hover:text-purple-800">Login Page
									</a></li>
							<li class="mb-2"><a href="/auth/logout"
								class="border-b border-solid border-transparent hover:border-purple-800 hover:text-purple-800">Logout Page
									</a></li>
						</ul>
					</div>
					<div class="px-4 sm:w-1/2 md:w-1/4 xl:w-1/6 mt-8 md:mt-0">
						<h5 class="text-xl font-bold mb-6">About</h5>
						<ul class="list-none footer-links">
							<li class="mb-2"><a href="/index"
								class="border-b border-solid border-transparent hover:border-purple-800 hover:text-purple-800">Home Page</a>
							</li>
							<li class="mb-2"><a href="/aboutus"
								class="border-b border-solid border-transparent hover:border-purple-800 hover:text-purple-800">About Us</a>
							</li>
						</ul>
					</div>
					<div class="px-4 sm:w-1/2 md:w-1/4 xl:w-1/6 mt-8 md:mt-0">
						<h5 class="text-xl font-bold mb-6">Help</h5>
						<ul class="list-none footer-links">
							<li class="mb-2"><a href="/contactus"
								class="border-b border-solid border-transparent hover:border-purple-800 hover:text-purple-800">Contact Us</a>
							</li>
						</ul>					</div>
					<div
						class="px-4 mt-4 sm:w-1/3 xl:w-1/6 sm:mx-auto xl:mt-0 xl:ml-auto">
						<h5 class="text-xl font-bold mb-6 sm:text-center xl:text-left">Stay
							connected</h5>
						<div class="flex sm:justify-center xl:justify-start">
							<a href=""
								class="w-8 h-8 border border-2 border-gray-400 rounded-full text-center py-1 text-gray-600 hover:text-white hover:bg-blue-600 hover:border-blue-600">
								<i class="fab fa-facebook"></i>
							</a> <a href=""
								class="w-8 h-8 border border-2 border-gray-400 rounded-full text-center py-1 ml-2 text-gray-600 hover:text-white hover:bg-blue-400 hover:border-blue-400">
								<i class="fab fa-twitter"></i>
							</a> <a href=""
								class="w-8 h-8 border border-2 border-gray-400 rounded-full text-center py-1 ml-2 text-gray-600 hover:text-white hover:bg-red-600 hover:border-red-600">
								<i class="fab fa-google-plus-g"></i>
							</a>
						</div>
					</div>
				</div>
				<div class="footer2">Copyright © 2024  Anand. All Right
					Reserved .</div>

			</div>
		</footer>


	</div>

	<script>
	let toggleBtn = document.querySelector("#navbar-toggle");
	let collapse = document.querySelector("#navbar-collapse");

	toggleBtn.onclick = () => {
	  collapse.classList.toggle("hidden");
	  collapse.classList.toggle("flex");
	};



	        function toggleDropdown(dropdownId) {
	            var dropdown = document.getElementById(dropdownId);
	            if (dropdown.style.display === "block") {
	                dropdown.style.display = "none";
	            } else {
	                dropdown.style.display = "block";
	            }
	        }


	</script>

</body>
</html>