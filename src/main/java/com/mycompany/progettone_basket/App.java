/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progettone_basket;

import Eccezioni.EccezioneAltezza;
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

    public static void main(String[] args)
    {
       /* Squadra s1=new Squadra("ciao",23);
        Cestista c1=new Cestista("lao","lao",LocalDate.of(2000,2,2),1.92);
        Cestista c2=new Cestista("lao","lao",LocalDate.of(2000,3,3),1.93);
        Cestista c3=new Cestista("lao","lao",LocalDate.of(2000,4,4),1.94);
        
        
        
        
        s1.setCestista(c1);
        s1.setCestista(c2);
        s1.setCestista(c3);*/        
        /*cest=new Cestista(s1.getCestista(1));
        System.out.println(s1.toString());
        System.out.println(cest.toString());
        
        s1.rimuoviCestista(2);
        System.out.println(s1.toString());*/
        
        Campionato NBA=new Campionato();
        Cestista cest;
        int attore=0;
        int sceltaUtente=0;
        int id,gg,mm,aaaa,pti;
        double h;
        String nome,cognome;
        Squadra sq;
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
                                    sq=NBA.getSquadra(id);
                                    System.out.println(sq.toString());
                                }
                                catch (IOException ex) {
                                    System.out.println("Errore nell'inserimento");
                                } catch (NumberFormatException ex) {
                                    System.out.println("ID inserito non valido");
                                }catch(EccezioneIDNonPresente ex)
                                {
                                    System.out.println("L'ID inserito non è presente nel campionato");
                                }
                            case 3:
                               System.out.print("Inserisci ID cestista da visualizzare-->");
                                try 
                                {
                                    id=tastiera.readInt();
                                    cest=NBA.getCestista(id);
                                    System.out.println(cest.toString());
                                }
                                catch (IOException ex) {
                                    System.out.println("Errore nell'inserimento");
                                } catch (NumberFormatException ex) {
                                    System.out.println("ID inserito non valido");
                                } catch (EccezioneIDNonPresente ex)
                                {
                                    System.out.println("L'ID inserito non è presente nel campionato");
                                }
                            case 4:  
                                try 
                                {
                                    System.out.print("Inserisci id della squadra dove inserire il giocatore-->");
                                    id=tastiera.readInt();
                                    System.out.print("Inserisci nome-->");
                                    nome=tastiera.readString();
                                    System.out.print("Inserisci cognome-->");
                                    cognome=tastiera.readString();
                                    System.out.println("Inserisci Data di nascita(aaaa-mm-gg):");
                                    System.out.print("Inserisci giorno-->");
                                    gg=tastiera.readInt();
                                    System.out.print("Inserisci mese-->");
                                    mm=tastiera.readInt();
                                    System.out.print("Inserisci anno-->");
                                    aaaa=tastiera.readInt();
                                    System.out.print("Inserisci altezza-->");
                                    h=tastiera.readDouble();
                                    cest=new Cestista(nome,cognome,LocalDate.of(aaaa,mm,gg),h);
                                    NBA.setCestista(id,cest);
                                    
                                } 
                                catch (IOException ex) {
                                    System.out.println("Errore nell'inserimento dei dati");
                                }
                                catch(EccezioneAltezza ex)
                                {
                                    System.out.println("L'altezza inserita non  valida per il campionato, altezza minima 1,70 m");
                                } 
                                catch (EccezioneRosaCompleta ex) 
                                {
                                    System.out.println("La rosa della squadra è al completo, cestista non inserito");
                                } 
                                catch (EccezioneIDNonPresente ex) 
                                {
                                    System.out.println("La squadra selezionata non esiste, cestista non inserito");
                                }
                                catch (NumberFormatException ex)
                                {
                                    System.out.println("Input non valido");
                                }
                            case 5:
                                try 
                                {
                                    System.out.print("Inserisci nome squadra-->");
                                    nome=tastiera.readString();
                                    System.out.print("Inserisci punteggio-->");
                                    pti=tastiera.readInt();
                                } 
                                catch (IOException ex) 
                                {
                                    System.out.println("Errore di input");
                                }
                            

                            case 6:
                                try 
                                {
                                    System.out.print("Inserisci ID del cestista da rimuovere-->");
                                    id=tastiera.readInt();
                                    NBA.rimuoviCestista(id);
                                } 
                                catch (IOException ex) 
                                {
                                    System.out.println("Errore di input");
                                } 
                                catch (NumberFormatException ex) 
                                {
                                    System.out.println("Input non valido");
                                } 
                                catch (EccezioneIDNonPresente ex) 
                                {
                                    System.out.println("Giocatore non trovato");
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
