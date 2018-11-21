<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body onload="document.guessForm.guess.focus()">
		<hr>
		<h2>${nbJoueurs} <c:choose>
                                    <c:when test="${nbJoueurs<=1}">
                                        joueur connecté
                                    </c:when>
                                    <c:otherwise>
                                        joueurs connectés
                                    </c:otherwise>
                                </c:choose>
                </h2>
		<hr>

                <h3>Bonjour <em>${sessionScope.playerName}</em>! Devine mon nombre </h3>
		        
                <c:if test="${nbGuesses ne 0}">
                    <p>
                        <em>Essai N°</em>
                        <b>${nbGuesses}</b>:
                        <div>
                            ${guess} 
                            <c:choose>
                                <c:when test="${answer < guess}">
                                    Trop Haut
                                </c:when>
                                <c:otherwise>
                                    Trop Bas
                                </c:otherwise>        
                            </c:choose>
                        </div>
                    </p>
                </c:if>
                
		<h2>La somme est comprise entre 0 et 100 </h2>
		<form name="guessForm" method="POST" accept-charset="UTF-8" >
			<label>Ta proposition : <input type="number" min="0" max="100" required name="guess"></label> 
			<input type="SUBMIT" name="action" value="Deviner"><br/>
		</form>
		<form method="POST">
			<input type="SUBMIT" name="action" value="Deconnexion">
		</form>

		<hr>
		
                <c:if test="${not empty highScore}">
                    <h3>Score à battre: ${highScore.nbGuesses} essais par ${highScore.playerName}</h3>
                </c:if>
				
	</body>
</html>
