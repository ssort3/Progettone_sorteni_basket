/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progettone_basket;

import Eccezioni.EccezioneAltezza;
import Eccezioni.EccezioneRosaCompleta;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Sorteni
 */
public class SquadraTest {
    
    public SquadraTest() {
    }
    
    private Squadra s1;
    private Squadra s2;
    private Cestista c;

    /**
     * Creo un cestista standard prima di ogni metodo di test
     * @throws EccezioneAltezza 
     */
    @BeforeEach
    public void Cestista() throws EccezioneAltezza
    {
        s1=new Squadra("lakers",10);
    }
    
    /**
     * Test of getNCestistiPresenti method, of class Squadra.
     * Test con squadra vuota
     */
    @org.junit.jupiter.api.Test
    public void testGetNCestistiPresentiZero() 
    {
        int atteso=0;
        int attuale=s1.getNCestistiPresenti();
        assertEquals(atteso,attuale);
    }
    
    /**
     * Test of getNCestistiPresenti method, of class Squadra.
     * Test con squadra piena
     * @throws EccezioneAltezza
     * @throws EccezioneRosaCompleta
     */
    @org.junit.jupiter.api.Test
    public void testGetNCestistiPresentiMAX() throws EccezioneAltezza, EccezioneRosaCompleta 
    {
        int atteso=15;
        for(int i=0;i<s1.getN_MAX_CESTISTI();i++)
        {
            c=new Cestista("luciano","pinna",LocalDate.of(1,1,1),2);
            s1.setCestista(c);
        }
        int attuale=s1.getNCestistiPresenti();
        assertEquals(atteso,attuale);
    }
    
    /**
     * Test of getNCestistiPresenti method, of class Squadra.
     * @throws EccezioneAltezza
     * @throws EccezioneRosaCompleta
     */
    @org.junit.jupiter.api.Test
    public void testGetNCestistiPresenti() throws EccezioneAltezza, EccezioneRosaCompleta 
    {
        int atteso=1;
        c=new Cestista("luciano","pinna",LocalDate.of(1,1,1),2);
        s1.setCestista(c);
        int attuale=s1.getNCestistiPresenti();
        assertEquals(atteso,attuale);
    }
    
    /**
     * Test of getN_MAX_CESTISTI method, of class Squadra.
     */
    @org.junit.jupiter.api.Test
    public void testGetN_MAX_CESTISTI() 
    {
        int atteso=15;
        int attuale=s1.getN_MAX_CESTISTI();
        assertEquals(atteso,attuale);
    }
    
    /**
     * Test of getIDSquadra method, of class Cestista.
     * Test con una squadra
     */
    @Test
    public void testGetIDSquadra()
    {
        int atteso=1; //id atteso
        int attuale=s1.getIdSquadra();
        assertEquals(atteso,attuale);
    }
    
    /**
     * Test of getIDCestista method, of class Cestista.
     * Test con due squadre
     */
    @Test
    public void testGetIDSquadraDUE()
    {
        int atteso=2; //id atteso
        s2=new Squadra("heat",10);
        int attuale=s2.getIdSquadra();
        assertEquals(atteso,attuale);
    }

    /**
     * Test of getPunti and setPunti methods, of class Squadra.
     */
    @org.junit.jupiter.api.Test
    public void testPunti() 
    {
        int atteso=25;
        s1.setPunti(25);
        int attuale=s1.getPunti();
        assertEquals(atteso,attuale);
    }
    
    /**
     * Test of getPunti and setPunti methods, of class Squadra.
     * Test con punteggio inserito negativo
     */
    @org.junit.jupiter.api.Test
    public void testPuntiNegativo() 
    {
        int atteso=0;
        s1.setPunti(-1);
        int attuale=s1.getPunti();
        assertEquals(atteso,attuale);
    }
    
    /**
     * Test of getPunti and setPunti methods, of class Squadra.
     * Test con punteggio inserito negativo
     */
    @org.junit.jupiter.api.Test
    public void testPuntiZero() 
    {
        int atteso=0;
        s1.setPunti(0);
        int attuale=s1.getPunti();
        assertEquals(atteso,attuale);
    }

   
    /**
     * Test of getNomeSquadra method, of class Squadra.
     */
    @org.junit.jupiter.api.Test
    public void testGetNomeSquadra() {
    }

    /**
     * Test of setNomeSquadra method, of class Squadra.
     */
    @org.junit.jupiter.api.Test
    public void testSetNomeSquadra() {
    }

    /**
     * Test of toString method, of class Squadra.
     */
    @org.junit.jupiter.api.Test
    public void testToString() {
    }

    /**
     * Test of setCestista method, of class Squadra.
     */
    @org.junit.jupiter.api.Test
    public void testSetCestista() throws Exception {
    }

    /**
     * Test of getCestista method, of class Squadra.
     */
    @org.junit.jupiter.api.Test
    public void testGetCestista() throws Exception {
    }

    /**
     * Test of rimuoviCestista method, of class Squadra.
     */
    @org.junit.jupiter.api.Test
    public void testRimuoviCestista() throws Exception {
    }

    /**
     * Test of ordinaAltezzaCrescente method, of class Squadra.
     */
    @org.junit.jupiter.api.Test
    public void testOrdinaAltezzaCrescente() {
    }

    /**
     * Test of ordinaAltezzaDerescente method, of class Squadra.
     */
    @org.junit.jupiter.api.Test
    public void testOrdinaAltezzaDerescente() {
    }
    
}
