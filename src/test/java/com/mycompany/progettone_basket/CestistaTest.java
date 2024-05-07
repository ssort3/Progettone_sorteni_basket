/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progettone_basket;

import Eccezioni.EccezioneAltezza;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Sorteni
 */
public class CestistaTest {
    
    private Cestista c1;
    private Cestista c2;
    
    public CestistaTest() { 
    }
    
    /**
     * Creo un cestista standard prima di ogni metodo di test
     * @throws EccezioneAltezza 
     */
    @BeforeEach
    public void Cestista() throws EccezioneAltezza
    {
        c1=new Cestista("luciano","pinna",LocalDate.of(1,1,1),2);
    }
    
    /**
     * Test of getIDCestista method, of class Cestista.
     * @throws EccezioneAltezza
     */
    @Test
    public void testGetIDCestista() throws EccezioneAltezza 
    {
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
        int atteso=2; //id atteso
        c2=new Cestista("pierone","lao",LocalDate.of(1,1,1),2);
        int attuale=c2.getIDCestista();
        assertEquals(atteso,attuale);
    }

    /**
     * Test of getNome and setNome methods, of class Cestista.
     * @throws EccezioneAltezza
     */
    @Test
    public void testSetGetNome() throws EccezioneAltezza 
    {
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
    public void testSetGetCognome() throws EccezioneAltezza 
    {
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
        String atteso="1;luciano;pinna;0001-01-01;2";
        String attuale=c1.toString();
        assertEquals(atteso,attuale);
    }

    
}
