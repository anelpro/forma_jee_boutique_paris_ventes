<%@ include file="layouts/header.jsp" %>

<section>

  ${ sessionScope.email }
  
  <br>
	
	<form action="/ParisVentes/login" method="post">
		<label> Connexion</label> <br>
			<input type="text" name="email" value="Email"> <br>
			<input type="password" name="pass" value="Password"> <br>
			<input type="submit" name="enregistrer" value="Enregistrer">
	
	</form>



</section>

<%@ include file="layouts/footer.jsp" %>