package controller;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class CountingPlayers implements HttpSessionListener{
    
    private int nbJoueurs = 0;
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        nbJoueurs++;
        
        se.getSession().getServletContext().setAttribute("nbPlayers", nbJoueurs);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        nbJoueurs--;
        
        se.getSession().getServletContext().setAttribute("nbPlayers", nbJoueurs);
    }
    
}
