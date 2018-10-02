/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gf.bowling2.mavenproject1;

import bowling.Frame;
import bowling.SinglePlayerGame;
import bowling.MultiPlayerGame;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author pedago
 */
public class MultiP implements MultiPlayerGame {
    SinglePlayerGame games[];
    ArrayList<String> playerNames;
    int joueurCourant;

    public MultiP(String[] playerName) throws Exception {
        startNewGame(playerName);
    }
    
    public String getNomJoueurCourant() {
        String joueur = "Prochain tir : ";
        Frame currentPlayerFrame = games[joueurCourant].getCurrentFrame();
        
        joueur += playerNames.get(joueurCourant)
                  + ", tour n° " + currentPlayerFrame.getFrameNumber() 
                  + ", boule n° " + currentPlayerFrame.getBallsThrown() + 1;
        
        return joueur;
    }
    
    @Override
    public String startNewGame(String[] playerName) throws Exception {
        joueurCourant=0;
        games = new SinglePlayerGame[playerName.length];
        
        for(int i = 0 ; i < games.length ; i++) {
            games[i] = new SinglePlayerGame();
        }
        
        playerNames = new ArrayList<>(Arrays.asList(playerName)); // On copie les noms dans une ArrayList pour faciliter la recherche du score d'un joueur avec la méthode indexOf()
        
        return getNomJoueurCourant();
    }
    
    @Override
    /**
     * Enregistre le nombre de quilles abattues pour le joueur courant, dans le frame courant, pour la boule courante
     * @param nombreDeQuillesAbattues : nombre de quilles abattue à ce lancer
     * @return une chaîne de caractères indiquant le prochain joueur,
     * de la forme "Prochain tir : joueur Bastide, tour n° 5, boule n° 1",
     * ou bien "Partie terminée" si la partie est terminée.
     * @throws java.lang.Exception si la partie n'est pas démarrée, ou si elle est terminée.
     */
    public String lancer(int nombreDeQuillesAbattues) throws Exception {
        games[joueurCourant].lancer(nombreDeQuillesAbattues);
        joueurCourant = (joueurCourant+1) % games.length;
        
        return getNomJoueurCourant();
    }

    @Override
    /**
     * Donne le score pour le joueur playerName
     * @param playerName le nom du joueur recherché
     * @return le score pour ce joueur
     * @throws Exception si le playerName ne joue pas dans cette partie
     */
    public int scoreFor(String playerName) throws Exception {
        if(playerNames.contains(playerName)){
            int indiceJoueur = playerNames.indexOf(playerName);

            return games[indiceJoueur].score();
        } else {
            throw new Exception("Le joueur " + playerName + " ne joue pas.");
        }
    }
}
