/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progettone_basket;

import Eccezioni.EccezioneAltezza;
import com.mycompany.progettone_basket.Cestista;
import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 *
 * @author Sorteni
 */
public class CestistaTest {
    
    private static Cestista c1;
    private static Cestista c2;
    private Cestista c3;
    
    public CestistaTest() { 
    }
    
    /**
     *
     * @throws Exception
     */
    @BeforeAll
    public static void inizio() throws Exception
    {
        c1=new Cestista("luciano","pinna",LocalDate.of(1,1,1),2);
        c2=new Cestista("pierone","lao",LocalDate.of(1,1,1),2);
    }
        
    /**
     * Test of getIDCestista method, of class Cestista.
     * @throws EccezioneAltezza
     */
    @Test
    public void testGetIDCestista() throws EccezioneAltezza 
    {
        c1=new Cestista(c1);
        int atteso=1; //id atteso
        int attuale=c1.getIDCestista();
        assertEquals(atteso,attuale);
    }
    
    /**
     * Test of getIDCestista method, of class Cestista.
     * @throws EccezioneAltezza
     */
    @Test
    public void testGetIDCestistaDUE() throws EccezioneAltezza 
    {
        c1=new Cestista(c1);
        int atteso=2; //id atteso
        c2=new Cestista(c2);
        int attuale=c2.getIDCestista();
        assertEquals(atteso,attuale);
    }

    /**
     * Test of getNome and setNome methods, of class Cestista.
     * @throws EccezioneAltezza
     */
    @Test
    public void testNome() throws EccezioneAltezza 
    {
        c1=new Cestista(c1);
        String atteso="mario";
        c1.setNome("mario");
        String attuale=c1.getNome();
        assertEquals(atteso,attuale);
    }

    /**
     * Test of getCognome and setCognome methods, of class Cestista.
     * @throws EccezioneAltezza
     */
    @Test
    public void testCognome() throws EccezioneAltezza 
    {
        c1=new Cestista(c1);
        String atteso="lao";
        c1.setCognome("lao");
        String attuale=c1.getCognome();
        assertEquals(atteso,attuale);
    }


    /**
     * Test of getDataNascita and setDataNascita methods, of class Cestista.
     * @throws EccezioneAltezza
     */
    @Test
    public void testDataNascita() throws EccezioneAltezza 
    {
        c1=new Cestista(c1);
        LocalDate atteso=LocalDate.of(2000,3,5);
        c1.setDataNascita(LocalDate.of(2000,3,5));
        LocalDate attuale=c1.getDataNascita();
        assertEquals(atteso,attuale);
    }
    

    /**
     * Test of setAltezza and getAltezza method, of class Cestista.
     * @throws EccezioneAltezza
     */
    @Test
    public void testAltezza() throws  EccezioneAltezza
    {
        c1=new Cestista(c1);
        double atteso=1.70;
        c1.setAltezza(1.70);
        double attuale=c1.getAltezza();
        assertEquals(atteso,attuale);
        
        //altezza<1.70
        EccezioneAltezza eccezione = assertThrows(EccezioneAltezza.class, () 
                -> c1.setAltezza(1.69));
        
        //altezza=0
        EccezioneAltezza eccezioneZero = assertThrows(EccezioneAltezza.class, () 
                -> c1.setAltezza(0));
    }
    

    /**
     * Test of toString method, of class Cestista.
     * @throws EccezioneAltezza
     */
    @Test
    public void testToString() throws EccezioneAltezza 
    {
        c3=new Cestista("luciano","pinna",LocalDate.of(1,1,1),1.98);
        String atteso="3;luciano;pinna;0001-01-01;1.98";
        String attuale=c3.toString();
        assertEquals(atteso,attuale);
    }
    
    

    
}
