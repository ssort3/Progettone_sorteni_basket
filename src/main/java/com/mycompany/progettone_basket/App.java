/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progettone_basket;

import Eccezioni.EccezioneIDNonPresente;
import Eccezioni.EccezioneRosaCompleta;
import Utilita.ConsoleInput;
import Utilita.Menu;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Studente
 */
public class App {

    public static void main(String[] args) throws EccezioneRosaCompleta, EccezioneIDNonPresente 
    {
        Squadra s1=new Squadra("ciao",23);
        Cestista c1=new Cestista("lao","lao",LocalDate.of(2000,2,2),1.92);
        Cestista c2=new Cestista("lao","lao",LocalDate.of(2000,3,3),1.93);
        Cestista c3=new Cestista("lao","lao",LocalDate.of(2000,4,4),1.94);
        Cestista cest;
        
        s1.setCestista(c1);
        s1.setCestista(c2);
        s1.setCestista(c3);
        
        /*cest=new Cestista(s1.getCestista(1));
        System.out.println(s1.toString());
        System.out.println(cest.toString());
        
        s1.rimuoviCestista(2);
        System.out.println(s1.toString());*/
        
        int attore=0;
        int sceltaUtente=0;
        int id;
        ConsoleInput tastiera=new ConsoleInput();
        String[] voci={"Esci","Amministatore","Telespettatore"};
        Menu m=new Menu(voci);
        
        do
        {
            System.out.println("Benveuto, chi sei?");
            attore=m.sceltaMenu();
            switch (attore) 
            {
                case 0:
                    System.out.println("Arrivederci");
                    break;
                case 1:
                    String[] vociAmm={"Esci","Visualizza Campionato","Visualizza Squadra","Visualizza Cestista","Inserisci Cestista","Inserisci Squadra",
                    "Rimuovi Cestista","Rimuovi Squadra","Visualizza Altezze Crescenti di una Squadra",
                    "Visualizza Altezze Decrescenti di una Squadra","Modifica punteggio","Salva dati CSV",
                    "Carica dati CSV","Salva dati BIN","Carica dati BIN"};
                    Menu m1=new Menu(vociAmm);
                    do
                    {
                        sceltaUtente=m1.sceltaMenu();
                        switch (sceltaUtente) 
                        {
                            case 0:
                                System.out.println("Arrivederci");
                                break;
                            case 1:
                                System.out.println(); //fare toString dello scaffale
                            case 2:
                                System.out.print("Inserisci ID squadra da visualizzare-->");
                                try 
                                {
                                    id=tastiera.readInt();
                                    System.out.println(); //getSquadra()
                                }
                                catch (IOException ex) {
                                    System.out.println("io exception");
                                } catch (NumberFormatException ex) {
                                    System.out.println("number format");
                                }
                            

                                
                        }
                    }while(sceltaUtente!=0);          
                    break;
                case 2:
                    System.out.println("Benveuto");
                    String[] vociTele={"Esci","Visualizza Campionato","Visualizza Squadra","Visualizza Cestista",
                    "Visualizza Altezze Crescenti di una Squadra","Visualizza Altezze Decrescenti di una Squadra",
                    "Carica dati CSV","Carica dati BIN"};
                    Menu m2=new Menu(vociTele);
                    do
                    {
                        sceltaUtente=m2.sceltaMenu();
                        switch (sceltaUtente) 
                        {
                            case 0:
                                System.out.println("Arrivederci");
                                break;
                            default:
                                throw new AssertionError();
                        }
                    }while(sceltaUtente!=0);
                    break;
            }
        }while(attore!=0);
        
        
        
    }
}
