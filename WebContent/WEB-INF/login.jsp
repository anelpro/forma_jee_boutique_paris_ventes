<%@ include file="layouts/header.jsp" %>

<body>
	
	<form action="/ParisVentes/login" method="post">
		<label> Connexion</label> <br>
			<input type="text" name="email" value="Email"> <br>
			<input type="password" name="pass" value="Password"> <br>
			<input type="submit" name="enregistrer" value="Enregistrer">
	
	</form>



</body>

<%@ include file="layouts/footer.jsp" %>