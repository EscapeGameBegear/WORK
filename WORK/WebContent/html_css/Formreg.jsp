<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <title> Admin Form </title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="Formreg.css">
</head>
<body>
	<div class="regform">
        <h1> Registration Form </h1>
    </div>
    
    <div class="main">
        <form action ="submit" method="POST">
            <div id="name">
            
                <div class="div1"> 
	                <label class="userlabel"> Username </label>
	                <input class="username" type="text" name="username" placeholder="username" /> 
                </div>
                
				<div class="div2">	
	                <label class="emaillabel"> Email </label>
	                <input class="email" type="email" name="email" placeholder="email" />
              	</div>
              	
              	<div class="div3">	
	                <label class="passlabel"> Password </label>
	                <input class="password" type="password" name="password" placeholder="password" />
			    </div>   
			              
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
                    <select name="form" onchange="location =this.value;">
                        <option> Select language </option>
                        <option id="eng" value="Formreg.jsp" > English </option>
                        <option id="it" value="FormregIT.jsp" > Italiano </option>
                        <option id="fr" value="FormregFR.jsp" > Francais </option>
                    </select>
                </div> 
            </div>
        </form>
    </div>
    
    <script> 
    
    </script>
</body>
</html>