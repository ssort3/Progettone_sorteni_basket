/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progettone_basket;

import Eccezioni.EccezioneAltezza;
import Eccezioni.EccezioneIDNonPresente;
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
    private Cestista c1;
    private Cestista c2;

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
     * Test of getNome and setNome methods, of class Cestista.
     * @throws EccezioneAltezza
     */
    @Test
    public void testNome() throws EccezioneAltezza 
    {
        String atteso="nuggets";
        s1.setNomeSquadra("nuggets");
        String attuale=s1.getNomeSquadra();
        assertEquals(atteso,attuale);
    }

    /**
     * Test of toString method, of class Squadra.
     * Test con 0 cestisti presenti
     */
    @org.junit.jupiter.api.Test
    public void testToStringZero() 
    {
        String atteso="1;lakers;10";
        String attuale=s1.toString();
        assertEquals(atteso,attuale);
    }
    
    /**
     * Test of toString method, of class Squadra.
     * Test con 1 cestista presente
     * @throws EccezioneAltezza
     * @throws EccezioneRosaCompleta
     */
    @org.junit.jupiter.api.Test
    public void testToString() throws EccezioneAltezza, EccezioneRosaCompleta 
    {
        c=new Cestista("luciano","pinna",LocalDate.of(1,1,1),2);
        s1.setCestista(c);
        String atteso="1;lakers;10"+"\n"+"\t"+c.toString();
        String attuale=s1.toString();
        assertEquals(atteso,attuale);
    }
    
    /**
     * Test of toString method, of class Squadra.
     * Test con 15 cestisti presenti
     * @throws EccezioneAltezza
     * @throws EccezioneRosaCompleta
     */
    @org.junit.jupiter.api.Test
    public void testToStringMAX() throws EccezioneAltezza, EccezioneRosaCompleta 
    {
        String atteso="1;lakers;10";
        for(int i=0;i<15;i++)
        {
            c=new Cestista("luciano","pinna",LocalDate.of(1,1,1),2);
            s1.setCestista(c);
            atteso+="\n\t"+c.toString();
        }
        String attuale=s1.toString();
        assertEquals(atteso,attuale);
    }

    /**
     * Test of setCestista method, of class Squadra.
     * Test con 0 cestisti presenti inizialmente
     */
    @org.junit.jupiter.api.Test
    public void testSetCestista() throws Exception
    {
        c=new Cestista("luciano","pinna",LocalDate.of(1,1,1),2);
        s1.setCestista(c);
        Cestista atteso=c;
        Cestista attuale=s1.getCestista(1);
        assertEquals(atteso,attuale);       
    }
    
    /**
     * Test of setCestista method, of class Squadra.
     * Test con 1 cestista presente inizialmente
     */
    @org.junit.jupiter.api.Test
    public void testSetCestistaUNO() throws Exception
    {
        c1=new Cestista("luciano","pinna",LocalDate.of(1,1,1),2);
        c2=new Cestista("marco","evan",LocalDate.of(1,1,1),2);
        s1.setCestista(c1);
        s1.setCestista(c2);
        Cestista atteso=c2;
        Cestista attuale=s1.getCestista(2);
        assertEquals(atteso,attuale);       
    }
    
    /**
     * Test of setCestista method, of class Squadra.
     * Test con 15 cestisti presenti inizialmente
     */
    @org.junit.jupiter.api.Test
    public void testSetCestistaMAX() throws Exception
    {
        for(int i=0;i<15;i++)
        {
            c=new Cestista("luciano","pinna",LocalDate.of(1,1,1),2);
            s1.setCestista(c);
        }
        EccezioneRosaCompleta eccezione = assertThrows(EccezioneRosaCompleta.class, () 
                -> s1.setCestista(c));
    }

    /**
     * Test of getCestista method, of class Squadra.
     * Test con squadra vuota
     */
    @org.junit.jupiter.api.Test
    public void testGetCestistaVuoto() throws Exception
    {
        EccezioneIDNonPresente eccezione = assertThrows(EccezioneIDNonPresente.class, () 
                -> s1.getCestista(1));
    }
    
    /**
     * Test of getCestista method, of class Squadra.
     * Test con squadra contenente 15 cestisti
     */
    @org.junit.jupiter.api.Test
    public void testGetCestistaMAX() throws Exception
    {
        Cestista atteso = null;
        for(int i=0;i<15;i++)
        {
            c1=new Cestista("luciano","pinna",LocalDate.of(1,1,(i+1)),2);
            atteso=new Cestista(c1);
            s1.setCestista(c1);
        }
        Cestista attuale=s1.getCestista(15);
        assertEquals(atteso,attuale);
    }
    
    /**
     * Test of getCestista method, of class Squadra.
     * Test con squadra contenente 1 cestista
     */
    @org.junit.jupiter.api.Test
    public void testGetCestistaUNO() throws Exception
    {
        c1=new Cestista("luciano","pinna",LocalDate.of(1,1,1),2);
        s1.setCestista(c1);
        Cestista atteso=c1;
        Cestista attuale=s1.getCestista(1);
        assertEquals(atteso,attuale);
    }

    /**
     * Test of rimuoviCestista method, of class Squadra.
     * Test con una squadra contenente un cestista
     */
    @org.junit.jupiter.api.Test
    public void testRimuoviCestista() throws Exception 
    {
        c1=new Cestista("luciano","pinna",LocalDate.of(1,1,1),2);
        s1.setCestista(c1);
        s1.rimuoviCestista(1);
        Cestista attuale=s1.getCestista(1);
        assertNull(attuale);
    }
    
    /**
     * Test of rimuoviCestista method, of class Squadra.
     * Test con una squadra vuota
     */
    @org.junit.jupiter.api.Test
    public void testRimuoviCestistaZero() throws Exception 
    {
        EccezioneIDNonPresente eccezione = assertThrows(EccezioneIDNonPresente.class, () 
                -> s1.rimuoviCestista(1));
    }
        
    /**
     * Test of rimuoviCestista method, of class Squadra.
     * Test con una squadra piena
     */
    @org.junit.jupiter.api.Test
    public void testRimuoviCestistaMAX() throws Exception 
    {
        for(int i=0;i<15;i++)
        {
            c=new Cestista("luciano","pinna",LocalDate.of(1,1,1),2);
            s1.setCestista(c);
        }
        s1.rimuoviCestista(10);
        Cestista attuale=s1.getCestista(10);
        assertNull(attuale);
    }        
           
    /**
     * Test of ordinaAltezzaCrescente method, of class Squadra.
     */
    @org.junit.jupiter.api.Test
    public void testOrdinaAltezzaCrescente() 
    {
        
    }

    /**
     * Test of ordinaAltezzaDerescente method, of class Squadra.
     */
    @org.junit.jupiter.api.Test
    public void testOrdinaAltezzaDerescente() 
    {
        
    }
    
}
