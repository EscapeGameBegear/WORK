<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="regform">
        <h1> Registration Form </h1>
    </div>
    <div class="main">
        <form action ="submit" method="POST">
            <div id="name">
            
               <h2 class="credentials"> Credentials </h2>
                <label class="userlabel"> Username </label>
                <input class="username" type="text" name="UserName" placeholder="Username" /> 

                <label class="email"> Email </label>
                <input class="email" type="email" name="email" placeholder="email" />
              
                <label class="password"> Password </label>
                <input class="password" type="password" name="PassWord" placeholder="Password" />
			              
                <input class="btn" type="submit" value="submit" />

                <div class="list">
                    <h3 class="list1"> Designers </h3>
                    <ul>
                        <li>Marco</li>
                        <li>Elisa: The Boss</li>
                        <li>Igor</li>
                    </ul>
                </div>

                <div class="language">
                    <select>
                        <option> Select language </option>
                        <option value="English"> English </option>
                        <option value="Italiano"> Italiano </option>
                        <option value="Francais"> Francais </option>
                    </select>
                </div>
            </div>
        </form>
    </div>
</body>
</html>