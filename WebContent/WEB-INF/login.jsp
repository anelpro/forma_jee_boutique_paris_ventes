

<%@ include file="layouts/header.jsp" %>

<section>

  ${ sessionScope.email }
  
  <c:out value="Bonjour"/>  <br>
  <c:out value="Bonjour !" default="hello" />  <br>
  <c:out value="${ sessionScope.email }"> Inconnu</c:out>  <br>
  <br>
  
  -------- LA CONDITION
  <br>
  <c:if test="${ 15 le 10 }"> Plus grand </c:if> <!-- condition 15 pas plus petit que 10  -->
  <br>
  
  <c:if test="${ 15 ge 10 }"> Plus grand 2</c:if> <!-- condition 15 plus grand 10  -->
  <br>
  <br>
   
   -------------------------------
 
  
	<form action="/ParisVentes/login" method="post">
		<label> Connexion</label> <br>
			<input type="text" name="email" value="Email"> <br>
			<input type="password" name="pass" value="Password"> <br>
			<input type="submit" name="enregistrer" value="Enregistrer">
	
	<br><br>
	
	 -------- LES CONDITIONS
   <br> 	
	<input type="number" name="age"> <br>
    <input type="submit" name="valider">
	
	
	</form>

	<c:choose>
	     <c:when test="${age eq null || age == 0}"> incorrect </c:when>
	     <c:when test="${age lt 10}"> enfant</c:when>
	     <c:when test="${age lt 18}"> adolescent</c:when>
	     <c:when test="${age lt 65}"> adulte</c:when>
	  	 <c:otherwise> retraité</c:otherwise>
	   </c:choose>
	   
	   
	   <br><br>
	
	 -------- LES BOUCLES
   <br> 
	   
	<c:forEach var="i" begin="0" end="10" step="1"> ${i}, </c:forEach>   <br> 
	<c:forEach begin="0" end="10" step="1"> i </c:forEach>   
	
	   

</section>

<%@ include file="layouts/footer.jsp" %>