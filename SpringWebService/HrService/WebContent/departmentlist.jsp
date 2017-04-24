<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*"%>
    <%@ page import="com.th.hr.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


</head>
<body>
<form action="CreateDepartment.jsp" bgcolor="#e9fh">
<input type="submit" value="Create New Department">
</form>
<br>
<br>
<br>
<form action="dept" method ="post">
 <input type="hidden" name="action" value="delete"/>
<input type="text" id="deptId" align="left" onkeyup="myFunction()" placeholder="Search by id" title="Type in department Id">
<br>
<br>
<table id="departmentTable" border="0" width="300" align="left" bgcolor="#e9fh">
	
  <tr class="header">
  
   <th>DepartmentID</th>
  <th>Department Name</th>
  <th>Manager Id</th>
  <th>Location Id</th>
  <th>Delete</th>
  
  </tr>
  
<%

List list = (List)session.getAttribute("departmentList");
				
				
				
					
				for(int i =0; i<list.size();i++){
					
				Department dept = (Department)list.get(i);
				int deptId = dept.getDepartmentId();
				
				
				%>
	<tr>
	
	
	<!-- <td><input name="deptId" value="<%= dept.getDepartmentId()%>"></td> -->
	<td><%= dept.getDepartmentId()%></td>
	<td><%= dept.getDepartmentName()%></td>
	<td><%= dept.getManagerId()%></td>
	<td><%= dept.getLocationId()%></td>
	 <td><input type="submit" name="delete" value="Delete" ></td> 
	 <!-- <td><button name="delete" onclick="deleteRow(this)">delete</button></td> -->
	
	</tr>
	<%} %>
	
	
	</table>
	</form>
	<script>
function myFunction() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("deptId");
  filter = input.value.toUpperCase();
  table = document.getElementById("departmentTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}

function deleteRow(elem) {
	  var table = elem.parentNode.parentNode.parentNode;
	  var rowCount = table.rows.length;

	  if(rowCount === 1) {
	    alert('Cannot delete the last row');
	    return;
	  }

	  // get the "<tr>" that is the parent of the clicked button
	  var row = elem.parentNode.parentNode; 
	  row.parentNode.removeChild(row); 
	  
	//window.location.href="http://localhost:8084/HrService/department/"+elem; 
	}
/*function fun(deptId) 
{
  var data="hello";
  $.get('http://localhost:8084/HrService/department/delete/'+deptId,{},function(response) 
  {     data = response;
  }).error(function(){
  alert("Sorry could not proceed");
});

    return data;
}*/

	</script>
    					
</body>
</html>