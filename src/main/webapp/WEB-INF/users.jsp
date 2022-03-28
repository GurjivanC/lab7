<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </head>
    <body>
        <h1>Gurjivan's User Management System</h1>
        <table class="table">
            <div class = "columnOne">
                <thead>
                    <tr>
                        <th>E-mail</th>
                        <th>First Name</th> 
                        <th>Last Name</th>
                        <th>Active</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${users}" var="users">
                        <tr>
                            <td>${user.email}</td>
                            <td>${user.firstName}</td> 
                            <td>${user.lastName}</td>>
                            <td>${user.active ? "Y" : "N"}</td>
                            <td>
                                <a href="">Edit</a>
                                <a href= "user?action=delete&email=${user.email}">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </div>

            <div class= "columnTwo">
                <table>
                    <h1>Add User</h1>
                    <form action="Add" method="POST">
                        <input type="text" name="email" id="email" placeholder="Email" required>
                        <br>
                        <input type="text" name="firstName" id="firstName" placeholder="First Name" required>
                        <br>
                        <input type="text" name="lastName" id="lastName" placeholder="Last Name" required>
                        <br>
                        <input type="text" name="password" id="password" placeholder="Password" required>
                        <br>
                        <select class="options">
                            <option value="admin">company admin</option>
                            <option value="reg">regular user</option>
                            <option value="sysadmin">system admin</option>
                        </select>
                        <br>
                        <input type="hidden" value="add">
                        <button type="submit">Save</button>
                    </form>
            </div>

            <div class="columnThree">
                <h1>Edit User</h1>
                <form action="Edit" method="POST">
                    <input type="text" name="email" id="email" required>
                    <br>
                    <input type="text" name="firstName" id="firstName" required>
                    <br>
                    <input type="text" name="lastName" id="lastName" required>
                    <br>
                    <input type="text" name="password" id="password" required>
                    <br>
                    <select class="roleName">
                        <option value="admin">Company Admin</option>
                        <option value="user">Regular User</option>
                        <option value="admin">System Admin</option>
                    </select>
                    <br>
                    <button type="submit" value="edit">Save</button>
                    <button type="submit">Cancel</button>
                </form>
            </div>
        </table>
    </body>
</html>
