/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Compte;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SAMSUNG
 */
public class CompteServiceTest {

    public CompteServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of ouvrirCompte method, of class CompteService.
     */
  //  @Test
//    public void testOuvrirCompte() {
//        System.out.println("ouvrirCompte");
//        CompteService instance = new CompteService();//on a eliminé expresult et asser equls et fail... 
//        //on va crée plusieurs comptes et on elimine Compte result 
//        instance.ouvrirCompte("EE1", 7000.0);
//        instance.ouvrirCompte("EE2", 300);
//        instance.ouvrirCompte("EE3", 1000);
//        instance.ouvrirCompte("EE4", 400);
//
//    }

    /**
     * Test of fermerCompte method, of class CompteService.
     */
    @Test
    public void testFermerCompte() {
        System.out.println("fermerCompte");
        Compte c1 = null;
        CompteService instance = new CompteService();
        int expResult = 0;
        int result = instance.fermerCompte(c1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of crediter method, of class CompteService.
     */
    @Test
    public void testCrediter() {
        System.out.println("crediter");
        String rib = "EE2";
        double montantCredit = 1.0;
        CompteService instance = new CompteService();
        int expResult = 1;
        int result = instance.crediter(rib, montantCredit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of debiter method, of class CompteService.
     */
    @Test
    public void testDebiter() {
        System.out.println("debiter");
        String rib = "EE1";
        double montantDebit = 6500.0;
        CompteService instance = new CompteService();
        int expResult = 1;
        int result = instance.debiter(rib, montantDebit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of transferer method, of class CompteService.
     */
    @Test
    public void testTransferer() {
        System.out.println("transferer");
        Compte compteSource = null;
        Compte compteDestination = null;
        double montant = 0.0;
        CompteService instance = new CompteService();
        int expResult = 0;
        int result = instance.transferer(compteSource, compteDestination, montant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }



    /**
     * Test of deleteByRib method, of class CompteService.
     */
    @Test
    public void testDeleteByRib() {
        System.out.println("deleteByRib");
        String rib = "";
        List<Compte> comptes = null;
        CompteService instance = new CompteService();
        int expResult = 0;
        int result = instance.deleteByRib(rib, comptes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
}
