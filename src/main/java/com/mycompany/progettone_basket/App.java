/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progettone_basket;

import Eccezioni.EccezioneIDNonPresente;
import Eccezioni.EccezioneRosaCompleta;
import Utilita.ConsoleInput;
import Utilita.Menu;
import java.time.LocalDate;

/**
 *
 * @author Studente
 */
public class App {

    public static void main(String[] args) throws EccezioneRosaCompleta, EccezioneIDNonPresente 
    {
        int attore=0;
        int sceltaUtente=0;
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
                            default:
                                throw new AssertionError();
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
