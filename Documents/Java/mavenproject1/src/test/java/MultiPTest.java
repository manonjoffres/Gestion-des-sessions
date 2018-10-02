/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import gf.bowling2.mavenproject1.MultiP;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author leolo
 */
public class MultiPTest {
    public String[] playerName;
    MultiP game;

    @Before
    public void setUp() {
        playerName = new String[] {"Nathanael", "Matthias", "Rémy"};
    }

    /**
     * On crée une partie et teste l'affichage "Prochain tir : joueur, tour n°, boule n° "
     */
    @Test
    public void testAffichage1erTour() throws Exception {
        game = new MultiP(playerName);
        System.out.println(game.getNomJoueurCourant());
        assertEquals("Prochain tir : Nathanael, tour n° 1, boule n° 01", 
                     game.getNomJoueurCourant());
    }


    
    
    /**
     * Si on envoie toutes les 20 boules dans la rigole, le score final est 0
     */
    @Test
    public void testGutterGame() throws Exception {
            rollMany(20, 0);
            assertEquals(0, game.scoreFor("Nathanael"));
    }

    @Test
    public void testAllOnes() throws Exception {
            rollMany(20, 1);
            assertEquals(20, game.scoreFor("Nathanael"));
    }

    @Test
    public void testOneSpare() throws Exception {
            rollSpare(); // 10 + 3
            game.lancer(3); // 3
            rollMany(17, 0); // 0
            assertEquals(16, game.scoreFor("Nathanael"));
    }

    @Test
    public void testOneStrike() throws Exception {
            rollStrike(); // 10 + 7
            game.lancer(3);
            game.lancer(4);
            rollMany(16, 0);
            assertEquals(24, game.scoreFor("Nathanael"));
    }

    @Test
    public void testPerfectGame() throws Exception {
            // 12 boules à 10 points
            rollMany(12, 10);
            assertEquals(300, game.scoreFor("Rémy"));
    }

    @Test
    public void testTypicalGame() throws Exception  {
            rollMany(8, 3); // 6 points aux 4 1° tours -> 24
            rollStrike(); // 10 + 10
            rollSpare(); // 10 + 0
            rollMany(6, 0); // 0 points aux 3 tours suivants
            rollMany(3, 10); // 30 points au dernier tour

            assertEquals(84, game.scoreFor("Matthias"));
    }

    // Quelques methodes utilitaires pour faciliter l'écriture des tests
    private void rollMany(int n, int pins) throws Exception {
            for (int i = 0; i < n; i++) {
                    game.lancer(pins);
            }
    }

    private void rollSpare() throws Exception {
            game.lancer(7);
            game.lancer(3);
    }

    private void rollStrike() throws Exception {
            game.lancer(10);
    }
}
