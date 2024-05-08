/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progettone_basket;

import Eccezioni.EccezioneAltezza;
import Eccezioni.EccezioneIDNonPresente;
import Eccezioni.EccezioneRosaCompleta;
import com.mycompany.progettone_basket.Cestista;
import com.mycompany.progettone_basket.Squadra;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 *
 * @author Sorteni
 */
public class SquadraTest {
    
    public SquadraTest() {
    }
    
    private static Squadra s1;
    private static Squadra s2;
    private static Squadra s3;
    private Cestista c;
    private Cestista c1;
    private Cestista c2;
    private Cestista c3;
    private Squadra s4;
    private Squadra s5;

    /**
     * Creo un cestista standard prima di ogni metodo di test
     * @throws EccezioneAltezza 
     */
    @BeforeAll
    public static void inizio() throws EccezioneAltezza
    {
        s1=new Squadra("lakers",10);
        s2=new Squadra("heat",10);
        s3=new Squadra("lakers",10);
    }
    
    /**
     * Test del Costruttore della classe Squadra
     * @throws Exception
     */
    @Test
    public void testCostruttore() throws Exception
    {
        s4=new Squadra("ciao",10);
        int atteso=0;
        int attuale=s4.getNCestistiPresenti();
        assertEquals(atteso,attuale);
        atteso=10;
        attuale=s4.getPunti();
        assertEquals(atteso,attuale);
        String nomeAtteso="ciao";
        String nomeAttuale=s4.getNomeSquadra();
        assertEquals(nomeAtteso,nomeAttuale);
    }
    
    /**
     * Test del Costruttore di copia della classe Squadra
     * @throws Exception
     */
    @Test
    public void testCostruttoreCopia() throws Exception
    {
        s4=new Squadra(s1);
        assertEquals(s1,s4);
    }
    
    /**
     * Test of getNCestistiPresenti method, of class Squadra.
     * Test con squadra vuota
     */
    @org.junit.jupiter.api.Test
    public void testGetNCestistiPresentiZero() 
    {
        s1=new Squadra(s1);
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
        s1=new Squadra(s1);
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
        s1=new Squadra(s1);
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
        s1=new Squadra(s1);
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
        s1=new Squadra(s1);
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
        s1=new Squadra(s1);
        int atteso=2; //id atteso
        s2=new Squadra(s2);
        int attuale=s2.getIdSquadra();
        assertEquals(atteso,attuale);
    }

    /**
     * Test of getPunti and setPunti methods, of class Squadra.
     */
    @org.junit.jupiter.api.Test
    public void testPunti() 
    {
        s1=new Squadra(s1);
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
        s1=new Squadra(s1);
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
        s1=new Squadra(s1);
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
        s1=new Squadra(s1);
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
        s3=new Squadra(s3);
        String atteso="3;lakers;10\n";
        String attuale=s3.toString();
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
        s3=new Squadra(s3);
        c=new Cestista("luciano","pinna",LocalDate.of(1,1,1),2);
        s3.setCestista(c);
        String atteso="3;lakers;10"+"\n"+"\t"+c.toString()+"\n";
        String attuale=s3.toString();
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
        s3=new Squadra(s3);
        String atteso="3;lakers;10\n";
        for(int i=0;i<15;i++)
        {
            c=new Cestista("luciano","pinna",LocalDate.of(1,1,1),2);
            s3.setCestista(c);
            atteso+="\t"+c.toString()+"\n";
        }
        String attuale=s3.toString();
        assertEquals(atteso,attuale);
    }

    /**
     * Test of setCestista method, of class Squadra.
     * Test con squadra vuota
     */
    @org.junit.jupiter.api.Test
    public void testSetCestistaVuoto() throws Exception
    {
        s1=new Squadra(s1);
        c=new Cestista("luciano","pinna",LocalDate.of(1,1,1),2);
        s1.setCestista(c);
        Cestista atteso=c;
        Cestista attuale=s1.getCestista(c.getIDCestista());
        assertEquals(atteso,attuale);       
    }
    
    /**
     * Test of setCestista method, of class Squadra.
     * Test con 1 cestista presente inizialmente
     */
    @org.junit.jupiter.api.Test
    public void testSetCestistaUNO() throws Exception
    {
        s1=new Squadra(s1);
        c1=new Cestista("luciano","pinna",LocalDate.of(1,1,1),2);
        c2=new Cestista("marco","evan",LocalDate.of(1,1,1),2);
        s1.setCestista(c1);
        s1.setCestista(c2);
        Cestista atteso=c2;
        Cestista attuale=s1.getCestista(c2.getIDCestista());
        assertEquals(atteso,attuale);       
    }
    
    /**
     * Test of setCestista method, of class Squadra.
     * Test con 15 cestisti presenti inizialmente
     */
    @org.junit.jupiter.api.Test
    public void testSetCestistaMAX() throws Exception
    {
        s1=new Squadra(s1);
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
        s1=new Squadra(s1);
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
        s1=new Squadra(s1);
        Cestista atteso = null;
        for(int i=0;i<15;i++)
        {
            c1=new Cestista("luciano","pinna",LocalDate.of(1,1,(i+1)),2);
            atteso=new Cestista(c1);
            s1.setCestista(c1);
        }
        Cestista attuale=s1.getCestista(c1.getIDCestista());
        assertEquals(atteso,attuale);
    }
    
    /**
     * Test of getCestista method, of class Squadra.
     * Test con squadra contenente 1 cestista
     */
    @org.junit.jupiter.api.Test
    public void testGetCestistaUNO() throws Exception
    {
        s1=new Squadra(s1);
        c1=new Cestista("luciano","pinna",LocalDate.of(1,1,1),2);
        s1.setCestista(c1);
        Cestista atteso=c1;
        Cestista attuale=s1.getCestista(c1.getIDCestista());
        assertEquals(atteso,attuale);
    }
    
        /**
     * Test of getCestista method, of class Squadra.
     * Test con squadra contenente 1 cestista e cercando un ID non presente
     */
    @org.junit.jupiter.api.Test
    public void testGetCestistaEccezione() throws Exception
    {
        s1=new Squadra(s1);
        c1=new Cestista("luciano","pinna",LocalDate.of(1,1,1),2);
        s1.setCestista(c1);
        EccezioneIDNonPresente eccezione = assertThrows(EccezioneIDNonPresente.class, () 
                -> s1.getCestista(6));
    }

    /**
     * Test of rimuoviCestista method, of class Squadra.
     * Test con una squadra contenente un cestista
     */
    @org.junit.jupiter.api.Test
    public void testRimuoviCestista() throws Exception 
    {
        s1=new Squadra(s1);
        c1=new Cestista("luciano","pinna",LocalDate.of(1,1,1),2);
        s1.setCestista(c1);
        s1.rimuoviCestista(c1.getIDCestista());
        EccezioneIDNonPresente eccezione = assertThrows(EccezioneIDNonPresente.class, () 
                -> s1.getCestista(c1.getIDCestista()));
    }
    
    /**
     * Test of rimuoviCestista method, of class Squadra.
     * Test con una squadra vuota
     */
    @org.junit.jupiter.api.Test
    public void testRimuoviCestistaZero() throws Exception 
    {
        s1=new Squadra(s1);
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
        s1=new Squadra(s1);
        for(int i=0;i<15;i++)
        {
            c=new Cestista("luciano","pinna",LocalDate.of(1,1,1),2);
            s1.setCestista(c);
        }
        s1.rimuoviCestista(c.getIDCestista());
        EccezioneIDNonPresente eccezione = assertThrows(EccezioneIDNonPresente.class, () 
                ->s1.getCestista(c.getIDCestista()));
    }        
           
    /**
     * Test of ordinaAltezzaCrescente method, of class Squadra.
     * Test con altezze decrescenti
     */
    @org.junit.jupiter.api.Test
    public void testOrdinaAltezzaCrescenteContrario() throws Exception
    {
        s5=new Squadra(s1);
        Cestista[] v;
        c1=new Cestista("due","zero",LocalDate.of(1,1,1),2);
        c2=new Cestista("due","zerouno",LocalDate.of(1,1,1),2.01);
        c3=new Cestista("uno","novenove",LocalDate.of(1,1,1),1.99);
        s5.setCestista(c2);
        s5.setCestista(c1);
        s5.setCestista(c3);
        v=s5.ordinaAltezzaCrescente();
        Cestista[] atteso={c3,c1,c2};
        assertArrayEquals(atteso,v);
        
    }
    
    /**
     * Test of ordinaAltezzaCrescente method, of class Squadra.
     * Test con altezze in disordine
     */
    @org.junit.jupiter.api.Test
    public void testOrdinaAltezzaCrescenteDisordine() throws Exception
    {
        s5=new Squadra(s1);
        Cestista[] v;
        c1=new Cestista("due","zero",LocalDate.of(1,1,1),2);
        c2=new Cestista("due","zerouno",LocalDate.of(1,1,1),2.01);
        c3=new Cestista("uno","novenove",LocalDate.of(1,1,1),1.99);
        s5.setCestista(c1);
        s5.setCestista(c2);
        s5.setCestista(c3);
        v=s5.ordinaAltezzaCrescente();
        Cestista[] atteso={c3,c1,c2};
        assertArrayEquals(atteso,v);
        
    }
    
    /**
     * Test of ordinaAltezzaCrescente method, of class Squadra.
     * Test con altezze già crescenti
     */
    @org.junit.jupiter.api.Test
    public void testOrdinaAltezzaCrescenteOrdinate() throws Exception
    {
        s5=new Squadra(s1);
        Cestista[] v;
        c1=new Cestista("due","zero",LocalDate.of(1,1,1),2);
        c2=new Cestista("due","zerouno",LocalDate.of(1,1,1),2.01);
        c3=new Cestista("uno","novenove",LocalDate.of(1,1,1),1.99);
        s5.setCestista(c3);
        s5.setCestista(c1);
        s5.setCestista(c2);
        v=s5.ordinaAltezzaCrescente();
        Cestista[] atteso={c3,c1,c2};
        assertArrayEquals(atteso,v);
        
    }

    /**
     * Test of ordinaAltezzaDerescente method, of class Squadra.
     * Test con altezze già decrescenti
     */
    @org.junit.jupiter.api.Test
    public void testOrdinaAltezzaDecrescenteOrdinate() throws Exception
    {
        s5=new Squadra(s1);
        Cestista[] v;
        c1=new Cestista("due","zero",LocalDate.of(1,1,1),2);
        c2=new Cestista("due","zerouno",LocalDate.of(1,1,1),2.01);
        c3=new Cestista("uno","novenove",LocalDate.of(1,1,1),1.99);
        s5.setCestista(c2);
        s5.setCestista(c1);
        s5.setCestista(c3);
        v=s5.ordinaAltezzaDecrescente();
        Cestista[] atteso={c2,c1,c3};
        assertArrayEquals(atteso,v);
        
    }
    
    /**
     * Test of ordinaAltezzaCrescente method, of class Squadra.
     * Test con altezze in disordine
     */
    @org.junit.jupiter.api.Test
    public void testOrdinaAltezzaDecrescenteDisordine() throws Exception
    {
        s5=new Squadra(s1);
        Cestista[] v;
        c1=new Cestista("due","zero",LocalDate.of(1,1,1),2);
        c2=new Cestista("due","zerouno",LocalDate.of(1,1,1),2.01);
        c3=new Cestista("uno","novenove",LocalDate.of(1,1,1),1.99);
        s5.setCestista(c1);
        s5.setCestista(c2);
        s5.setCestista(c3);
        v=s5.ordinaAltezzaDecrescente();
        Cestista[] atteso={c2,c1,c3};
        assertArrayEquals(atteso,v);
        
    }
    
    /**
     * Test of ordinaAltezzaCrescente method, of class Squadra.
     * Test con altezze crescenti
     */
    @org.junit.jupiter.api.Test
    public void testOrdinaAltezzaDecrescenteContario() throws Exception
    {
        s5=new Squadra(s1);
        Cestista[] v;
        c1=new Cestista("due","zero",LocalDate.of(1,1,1),2);
        c2=new Cestista("due","zerouno",LocalDate.of(1,1,1),2.01);
        c3=new Cestista("uno","novenove",LocalDate.of(1,1,1),1.99);
        s5.setCestista(c3);
        s5.setCestista(c1);
        s5.setCestista(c2);
        v=s5.ordinaAltezzaDecrescente();
        Cestista[] atteso={c2,c1,c3};
        assertArrayEquals(atteso,v);
        
    }    
    
}
