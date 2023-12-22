<%@page import="com.example.FrontEndService.model.DepartmentListModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="com.example.FrontEndService.model.DepartmentListModel"%>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin | Create</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/1.7.3/tailwind.min.css">
    <link rel="stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/1.4.6/tailwind.min.css" >
	<link rel="stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" >
    <style>
        body {
            font-family: "Poppins", sans-serif !important;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            background-color: #f7fafc;
        }

        h1 {
            text-align: center;
            margin-top: 10px;
            font-size: 2xl;
            color: #2d3748;
        }

        form {
            max-width: 600px;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 20px;
        }

        fieldset {
            border: none;
            margin: 0;
            padding: 0;
        }

        legend {
            font-size: lg;
            font-weight: bold;
            color: #2d3748;
        }

        label {
            display: block;
            margin-bottom: 6px;
            color: #2d3748;
        }

        input,
        select {
            width: 100%;
            padding: 8px;
            margin-bottom: 12px;
            border: 1px solid #e2e8f0;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="radio"] {
            margin-right: 6px;
        }

        input[type="submit"],
        input[type="reset"] {
            background-color: #4a90e2;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
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
        @media screen and (max-width: 770px){
        	.dropdown{
        	justify-content:flex-start;
        	}
        	.dropdown-content{
        	   top: 24%;
   				 }
        } 
        
    </style>
</head>

<body>

<nav class="bg-white py-2 md:py-4">
    <div class="container px-4 mx-auto md:flex md:items-center">

      <div class="flex justify-between items-center">
        <a href="#" class="font-bold text-xl text-indigo-600">EMS</a>
        <button class="border border-solid border-gray-600 px-3 py-1 rounded text-gray-600 opacity-50 hover:opacity-75 md:hidden" id="navbar-toggle">
          <i class="fas fa-bars"></i>
        </button>
      </div>

      <div class="hidden md:flex flex-col md:flex-row md:ml-auto mt-3 md:mt-0" id="navbar-collapse">
        <a href="/index" class="p-2 lg:px-4 md:mx-2 text-gray-600 rounded hover:bg-gray-200 hover:text-gray-700 transition-colors duration-300">Home</a>
        <%-- <a href="#" class="p-2 lg:px-4 md:mx-2 text-gray-600 rounded hover:bg-gray-200 hover:text-gray-700 transition-colors duration-300">Services</a> --%>
        <div class="dropdown">
                        <a href="#" class="p-2 lg:px-4 md:mx-2 text-white rounded bg-indigo-600"
                           onclick="toggleDropdown('servicesDropdown')">Services</a>
                        <div id="servicesDropdown" class="dropdown-content">
                            <a href="/createEmployee">Create</a>
                            <a href="/updateEmployee">Update</a>
                            <a href="#">Delete</a>
                            <a href="#">Display</a>
                            <a href="/admin/dashboard">Department</a>
                        </div>
        </div>
        
        <a href="/aboutus" class="p-2 lg:px-4 md:mx-2 text-gray-600 rounded hover:bg-gray-200 hover:text-gray-700 transition-colors duration-300">About</a>
        <a href="/contactus" class="p-2 lg:px-4 md:mx-2 text-gray-600 rounded hover:bg-gray-200 hover:text-gray-700 transition-colors duration-300">Contact</a>
        <a href="#" class="p-2 lg:px-4 md:mx-2 text-indigo-600 text-center border border-solid border-indigo-600 rounded hover:bg-indigo-600 hover:text-white transition-colors duration-300 mt-1 md:mt-0 md:ml-1">Admin Login</a>
        <a href="#" class="p-2 lg:px-4 md:mx-2 text-indigo-600 text-center border border-solid border-indigo-600 rounded hover:bg-indigo-600 hover:text-white transition-colors duration-300 mt-1 md:mt-0 md:ml-1">Employee Login</a>
      </div>
    </div>
  </nav>


    <div>
        <%
		Map<String, String> responce = (Map<String, String>) request.getAttribute("responce");
		if (responce != null) {
		%>
        <p style="color: green; margin-left: 35%;"><%=responce.get("message")%></p>
        <%
		}
		%>
    </div>
    <h1 class="bg-indigo-600 text-white py-2 px-6 rounded-full text-xl mt-6 " style="width: 250px;
    margin-left: 40%;">Create New Employee</h1>
    <form action="/createEmployee" method="post">
        <fieldset>
            <legend>Personal Details</legend><br>
            <fieldset>
                <legend>Name</legend>
                <label>First Name: <input type="text" name="firstName"></label>
                <label>Middle Name: <input type="text" name="middleName"></label>
                <label>Last Name: <input type="text" name="lastName"></label>
            </fieldset>
            <label style="font-weight: bold;">Email <input type="email" name="email"></label>
            <p style="font-weight: bold;">Gender</p>
            <label><input type="radio" name="gender" value="male" checked>Male</label>
            <label><input type="radio" name="gender" value="female">Female</label>
            <label><input type="radio" name="gender" value="others">Others</label>
            <label style="font-weight: bold;">Age <input type="number" name="age"></label>
        </fieldset>

        <fieldset>
            <legend>Company Details</legend>
            <label>Salary: <input type="number" name="salary"></label>
            <label>Department:</label>
            <%
				List<DepartmentListModel> departmentListModelList = (List<DepartmentListModel>) request
						.getAttribute("departmentListModelList");
				%>
				<%
				if (departmentListModelList.size() == 0) {
				%>
				<p>No departments Add departments in Administrator dash board</p>
				<%
				}
				%>
            <select name="department">
                <%
					for (int i = 0; i < departmentListModelList.size(); i++) {
					%>
					<option value="<%=departmentListModelList.get(i).getName()%>">
						<%=departmentListModelList.get(i).getName()%>
					</option>
					<%
					}
					%>
            </select>
            <p style="font-weight: bold;">Role</p>
            <label><input type="radio" name="role" value="Employee" checked>Employee</label>
            <label><input type="radio" name="role" value="Admin">Admin</label>
            <label style="font-weight: bold;">Password (Taken name if not given): <input type="password" name="password"></label>
        </fieldset>

        <br>
        <input type="submit" value="Create Employee">
        <input type="reset" value="Reset Form">
    </form>
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
