<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Login</title>
 </head>
 <body>

<form name="form1" action="LoginServlet" method="post">

<table align="center">
<tr>
<td>User Id</td>
<td><input type="text" name="userId" /></td>
</tr>

<tr>
<td>Password</td>
<td><input type="text" name="password" /></td>
</tr>

<tr>


 <td><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></td>
 </tr>
<tr>
<td></td>

 <td><input type="submit" value="Login"></input></td>
 </tr>
</table>

 </form>
</body>
 </html>