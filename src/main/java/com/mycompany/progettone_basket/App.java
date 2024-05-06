/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progettone_basket;

import Eccezioni.EccezioneAltezza;
import Eccezioni.EccezioneCampionatoCompleto;
import Eccezioni.EccezioneIDNonPresente;
import Eccezioni.EccezioneIDNonValido;
import Eccezioni.EccezioneNessunaSquadra;
import Eccezioni.EccezioneRosaCompleta;
import Eccezioni.FileException;
import Utilita.ConsoleInput;
import Utilita.Menu;
import Utilita.TextFile;
import java.io.FileNotFoundException;
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
        Cestista[] vOrdinato;
        int attore=0;
        int sceltaUtente=0;
        LocalDate dataNascita;
        int id,gg,mm,aaaa,pti;
        String nomeFileCSV = null,nomeFileBinario = null;
        TextFile f1;
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
                    String[] vociAmm={"Esci","Visualizza Campionato","Visualizza Squadra","Visualizza Cestista","Inserisci Cestista",
                    "Inserisci Squadra","Rimuovi Cestista","Rimuovi Squadra","Visualizza Altezze Crescenti di una Squadra",
                    "Visualizza Altezze Decrescenti di una Squadra","Modifica punteggio","Modifica cestista","Salva dati CSV",
                    "Carica dati CSV","Salva dati BIN","Carica dati BIN"};
                    Menu m1=new Menu(vociAmm);
                    do
                    {
                        sceltaUtente=m1.sceltaMenu();
                        switch (sceltaUtente) 
                        {
                            case 0: //esci
                                System.out.println("Arrivederci");
                                break;
                            case 1: //visualizza campionato
                                System.out.println(NBA.toString());
                                break;
                            case 2: //visualizza squadra
                                System.out.print("Inserisci ID squadra da visualizzare-->");
                                try 
                                {
                                    id=tastiera.readInt();
                                    sq=NBA.getSquadra(id);
                                    System.out.println(sq.toString());
                                }
                                catch (IOException ex) 
                                {
                                    System.out.println("Errore nell'inserimento");
                                } 
                                catch (NumberFormatException ex) 
                                {
                                    System.out.println("ID inserito non valido");
                                }
                                catch(EccezioneIDNonPresente ex)
                                {
                                    System.out.println("L'ID inserito non è presente nel campionato");
                                }
                                catch (EccezioneNessunaSquadra ex)
                                {
                                    System.out.println("Campionato vuoto");
                                } 
                                catch (EccezioneIDNonValido ex) 
                                {
                                    System.out.println("ID non valido");
                                }
                                break;


                            case 3: //visualizza cestista
                               System.out.print("Inserisci ID cestista da visualizzare-->");
                                try 
                                {
                                    id=tastiera.readInt();
                                    cest=NBA.getCestista(id);
                                    System.out.println(cest.toString());
                                }
                                catch (IOException ex) 
                                {
                                    System.out.println("Errore nell'inserimento");
                                }
                                catch (EccezioneIDNonValido ex) 
                                {
                                    System.out.println("ID non valido");
                                }
                                catch (NumberFormatException ex) 
                                {
                                    System.out.println("ID inserito non valido");
                                } 
                                catch(EccezioneIDNonPresente ex)
                                {
                                    System.out.println("L'ID inserito non è presente nel campionato");
                                }catch (EccezioneNessunaSquadra ex)
                                {
                                    System.out.println("Campionato vuoto");
                                }
                                break;
                            case 4: //add cestista
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
                                    System.out.println("Cestista aggiunto correttamente");
                                } 
                                catch (IOException ex) 
                                {
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
                                catch (EccezioneNessunaSquadra ex) 
                                {
                                    System.out.println("Aggiungi una squadra prima di aggiungere un cestista");
                                } 
                                catch (EccezioneIDNonValido ex) 
                                {
                                    System.out.println("ID non valido");
                                }
                                break;


                            case 5: //add squadra
                                try 
                                {
                                    System.out.print("Inserisci nome squadra-->");
                                    nome=tastiera.readString();
                                    System.out.print("Inserisci punteggio-->");
                                    pti=tastiera.readInt();
                                    sq=new Squadra(nome,pti);
                                    NBA.setSquadra(sq);
                                    System.out.println("Squadra aggiunta correttamente");
                                } 
                                catch (IOException ex) 
                                {
                                    System.out.println("Errore di input");
                                }
                                catch (EccezioneCampionatoCompleto ex)
                                {
                                    System.out.println("Il campionato è al completo, squadra non inserita");
                                }
                                catch (NumberFormatException ex)
                                {
                                    System.out.println("Input non valido");
                                }
                                break;
                            case 6: //rimuovi cestista
                                try 
                                {
                                    System.out.print("Inserisci ID del cestista da rimuovere-->");
                                    id=tastiera.readInt();
                                    if(id==0)
                                        throw new EccezioneIDNonValido();
                                    NBA.rimuoviCestista(id);
                                    System.out.println("Cestista rimosso correttamente");
                                } 
                                catch (IOException ex) 
                                {
                                    System.out.println("Errore di input");
                                }
                                catch (EccezioneIDNonValido ex) 
                                {
                                    System.out.println("ID non valido");
                                }
                                catch (NumberFormatException ex) 
                                {
                                    System.out.println("Input non valido");
                                } 
                                catch (EccezioneIDNonPresente ex) 
                                {
                                    System.out.println("Cestista non trovato");
                                } 
                                catch (EccezioneNessunaSquadra ex) 
                                {
                                    System.out.println("Campionato vuoto"); 
                                }
                                break;

                            case 7: //rimuovi squadra    
                                try
                                {
                                    System.out.print("Inserisci ID della squadra da rimuovere-->");
                                    id=tastiera.readInt();
                                    NBA.rimuoviSquadra(id);
                                    System.out.println("Squadra rimossa correttamente");
                                }
                                catch (EccezioneIDNonPresente ex)
                                {
                                    System.out.println("Squadra non trovata");
                                }
                                catch (EccezioneIDNonValido ex) 
                                {
                                    System.out.println("ID non valido");
                                }
                                catch (IOException ex) 
                                {
                                    System.out.println("Errore di input");
                                } 
                                catch (NumberFormatException ex) 
                                {
                                    System.out.println("Input non valido");
                                }
                                catch (EccezioneNessunaSquadra ex) 
                                {
                                    System.out.println("Campionato vuoto"); 
                                }
                                break;
                            case 8: //altezze crescenti                               
                                try
                                {
                                    System.out.print("Inserisci ID squadra di cui ordinare  i giocatori-->");
                                    id=tastiera.readInt();
                                    vOrdinato=NBA.ordinaAltezzaCrescente(id); //sistemare diagrama classi
                                    for(int i=0;i<vOrdinato.length;i++)
                                    {
                                        vOrdinato[i].toString();
                                    }
                                    break;
                                }
                                catch (EccezioneIDNonPresente ex)
                                {
                                    System.out.println("Squadra non trovata");
                                }
                                catch (EccezioneIDNonValido ex) 
                                {
                                    System.out.println("ID non valido");
                                }
                                catch (IOException ex) 
                                {
                                    System.out.println("Errore di input");
                                } 
                                catch (NumberFormatException ex) 
                                {
                                    System.out.println("Input non valido");
                                }                               
                                break;
                            case 9: //altezze decrescenti
                                try
                                {
                                    System.out.print("Inserisci ID squadra di cui ordinare  i giocatori-->");
                                    id=tastiera.readInt();
                                    vOrdinato=NBA.ordinaAltezzaDerescente(id); //sistemare diagrama classi
                                    for(int i=0;i<vOrdinato.length;i++)
                                    {
                                        vOrdinato[i].toString();
                                    }
                                    break;
                                }
                                catch (EccezioneIDNonPresente ex)
                                {
                                    System.out.println("Squadra non trovata");
                                } 
                                catch (IOException ex) 
                                {
                                    System.out.println("Errore di input");
                                }
                                catch (EccezioneIDNonValido ex) 
                                {
                                    System.out.println("ID non valido");
                                }
                                catch (NumberFormatException ex) 
                                {
                                    System.out.println("Input non valido");
                                }
                                break;                  
                            case 10: //moifica punteggio
                                try
                                {   
                                    System.out.print("Inserisci ID della squadra di cui si vuole modificare il punteggio-->");
                                    id=tastiera.readInt();
                                    sq=NBA.getSquadra(id);
                                    System.out.println("Squadra iniziale:\n"+sq.toString());
                                    System.out.println("Inserisci il nuovo punteggio-->");
                                    pti=tastiera.readInt();
                                    NBA.modificaPunteggio(id, pti);
                                    sq=NBA.getSquadra(id);
                                    System.out.println("Punteggio aggiornato:\n"+sq.toString());
                                }
                                catch(EccezioneIDNonPresente ex)
                                {
                                    System.out.println("Squadra non trovata");
                                }
                                catch (EccezioneIDNonValido ex) 
                                {
                                    System.out.println("ID non valido");
                                }
                                catch (IOException ex) 
                                {
                                    System.out.println("errore di input");
                                } 
                                catch (NumberFormatException ex) 
                                {
                                    System.out.println("Input non valido");
                                }
                                catch (EccezioneNessunaSquadra ex)
                                {
                                    System.out.println("Campionato vuoto");
                                }
                                break;
                            case 11: //modifica cestista
                                String[] vociModifica={"Annulla","Nome","Cognome","Data di nascita","altezza"};
                                try
                                {         
                                    System.out.print("Inserisci ID cestista da modificare-->");
                                    id=tastiera.readInt();
                                    for(int i=0;i<NBA.getNSquadrePresenti();i++)
                                    {   
                                        try
                                        {
                                            sq=new Squadra(NBA.getSquadra(i));
                                            for(int j=0;j<sq.getNCestistiPresenti();j++)
                                            {
                                                if(sq.getCestista(j).getIDCestista()==id)
                                                {
                                                    System.out.println(sq.getCestista(j).toString());
                                                    m=new Menu(voci);
                                                    sceltaUtente=m.sceltaMenu();
                                                    switch (sceltaUtente) 
                                                    {
                                                        case 0: //esci
                                                            break;
                                                        case 1: //modifica nome
                                                            System.out.print("Nuovo nome-->");
                                                            nome=tastiera.readString();
                                                            sq.getCestista(j).setNome(nome);
                                                            break;
                                                        case 2: //modifica cognome
                                                            System.out.print("Nuovo cognome-->");
                                                            cognome=tastiera.readString();
                                                            sq.getCestista(j).setCognome(cognome);
                                                            break;
                                                        case 3: //modifica data di nascita
                                                            System.out.println("Nuova data:");
                                                            System.out.print("GG-->");
                                                            gg=tastiera.readInt();
                                                            System.out.print("MM-->");
                                                            mm=tastiera.readInt();
                                                            System.out.print("AAAA-->");
                                                            aaaa=tastiera.readInt();
                                                            sq.getCestista(j).setDataNascita(LocalDate.of(aaaa,mm,gg));
                                                            break;
                                                        case 4: //modifica altezza
                                                            System.out.print("Nuova altezza-->");
                                                            h=tastiera.readDouble();
                                                            sq.getCestista(j).setAltezza(h);
                                                            break;
                                                    }
                                                }
                                                System.out.println("Cestista modificato:\n"+sq.getCestista(j));
                                            }
                                        }
                                        catch(EccezioneIDNonValido ex)
                                        {
                                            //non sucederà mai
                                        }
                                    }
                                    
                                } 
                                catch (IOException ex) 
                                {
                                    System.out.println("Errore di input");
                                }
                                catch (EccezioneNessunaSquadra ex)
                                {
                                    System.out.println("Campionato vuoto");
                                }
                                catch (NumberFormatException ex) 
                                {
                                    System.out.println("Input non corretto");
                                } 
                                catch (EccezioneIDNonPresente ex) 
                                {
                                    System.out.println("Cestista non presente");
                                } 
                                catch (EccezioneAltezza ex) 
                                {
                                    System.out.println("Altezza non valida");
                                }
                                break;
                            case 12: //salva dati CSV
                                try 
                                {
                                    NBA.salvaDatiCSV(nomeFileCSV);
                                    System.out.println("Esportazione avvenuta correttamente.");
                                } 
                                catch (IOException ex) 
                                {
                                    System.out.println("Impossibile accedere al file");
                                }
                                catch (EccezioneIDNonValido ex) 
                                {
                                    System.out.println("ID non valido");
                                }
                                catch(NullPointerException ex)
                                { 
                                    System.out.println("Errore! Impossibile caricare dati dal file!");
                                } 
                                catch (EccezioneNessunaSquadra ex) 
                                {
                                    //
                                }
                                break;                               
                               
                            case 13: //carica dati CSV
                                try
                                {
                                    NBA.caricaDatiCSV(nomeFileCSV);
                                    System.out.println("Fine operazione di caricamento");
                                }
                                catch(IOException ex)
                                { 
                                    System.out.println("Errore! Impossibile caricare dati dal file!");
                                }
                                catch(NullPointerException ex)
                                { 
                                    System.out.println("Errore! Impossibile caricare dati dal file!");
                                }
                                catch (EccezioneIDNonValido ex) 
                                {
                                    System.out.println("ID non valido");
                                }
                                break;                               
                            case 14: //salva dati BIN
                                try 
                                {
                                    NBA.salvaDatiBIN(nomeFileBinario);
                                    System.out.println("Salvataggio avvenuto correttamente");
                                } 
                                catch (FileNotFoundException ex) 
                                {
                                    System.out.println("File non trovato");
                                } 
                                catch (IOException ex) 
                                {
                                     System.out.println("Impossibile accedere al file");
                                }
                                catch(NullPointerException ex)
                                { 
                                    System.out.println("Errore! Impossibile salvare dati sul file!");
                                }
                                break;
                            case 15: //carica dati BIN
                                try 
                                {
                                    NBA=NBA.caricaDatiBIN(nomeFileBinario);
                                    System.out.println("Caricamento effettuato correttamente");
                                } 
                                catch (FileNotFoundException ex) 
                                {
                                    System.out.println("File non trovato");
                                } 
                                catch (IOException ex) 
                                {
                                     System.out.println("Impossibile accedere al file");
                                } 
                                catch (ClassNotFoundException ex) 
                                {
                                    System.out.println("Impossibile leggere il dato memorizzato");
                                }
                                catch(NullPointerException ex)
                                { 
                                    System.out.println("Errore! Impossibile caricare dati dal file!");
                                }
                                break;    
                        }           
                    }while(sceltaUtente!=0);          
                    break;
                case 2: //telespettatore
                    System.out.println("Benveuto");
                    String[] vociTele={"Esci","Visualizza Campionato","Visualizza Squadra","Visualizza Cestista",
                    "Visualizza Altezze Crescenti di una Squadra","Visualizza Altezze Decrescenti di una Squadra",
                    "Salva dai CSV","Carica dati CSV","Salva dati BIN","Carica dati BIN"};
                    Menu m2=new Menu(vociTele);
                    do
                    {
                        sceltaUtente=m2.sceltaMenu();
                        switch (sceltaUtente) 
                        {
                            case 0:
                                System.out.println("Arrivederci");
                                break;
                            case 1: //visualizza campionato
                                System.out.println(NBA.toString());
                                break;
                            case 2: //visualizza squadra
                                System.out.print("Inserisci ID squadra da visualizzare-->");
                                try 
                                {
                                    id=tastiera.readInt();
                                    sq=NBA.getSquadra(id);
                                    System.out.println(sq.toString());
                                    break;
                                }
                                catch (IOException ex) {
                                    System.out.println("Errore nell'inserimento");
                                }
                                catch (EccezioneIDNonValido ex) 
                                {
                                    System.out.println("ID non valido");
                                }
                                catch (NumberFormatException ex) {
                                    System.out.println("ID inserito non valido");
                                }
                                catch(EccezioneIDNonPresente ex)
                                {
                                    System.out.println("L'ID inserito non è presente nel campionato");
                                }
                                catch (EccezioneNessunaSquadra ex)
                                {
                                    System.out.println("Campionato vuoto");
                                }
                            case 3: //visualizza cestista
                               System.out.print("Inserisci ID cestista da visualizzare-->");
                                try 
                                {
                                    id=tastiera.readInt();
                                    cest=NBA.getCestista(id);
                                    System.out.println(cest.toString());
                                    break;
                                }
                                catch (IOException ex) 
                                {
                                    System.out.println("Errore nell'inserimento");
                                }
                                catch (EccezioneIDNonValido ex) 
                                {
                                    System.out.println("ID non valido");
                                }
                                catch (EccezioneNessunaSquadra ex)
                                {
                                    System.out.println("Campionato vuoto");
                                }
                                catch (NumberFormatException ex) 
                                {
                                    System.out.println("ID inserito non valido");
                                } 
                                catch(EccezioneIDNonPresente ex)
                                {
                                    System.out.println("L'ID inserito non è presente nel campionato");
                                }
                            case 4: //altezze crescenti
                                try
                                {
                                    System.out.print("Inserisci ID squadra di cui ordinare  i giocatori-->");
                                    id=tastiera.readInt();
                                    vOrdinato=NBA.ordinaAltezzaCrescente(id); //sistemare diagrama classi
                                    for(int i=0;i<vOrdinato.length;i++)
                                    {
                                        vOrdinato[i].toString();
                                    }
                                    break;
                                }
                                catch (EccezioneIDNonPresente ex)
                                {
                                    System.out.println("Squadra non trovata");
                                }
                                catch (EccezioneIDNonValido ex) 
                                {
                                    System.out.println("ID non valido");
                                }
                                catch (IOException ex) 
                                {
                                    System.out.println("Errore di input");
                                } 
                                catch (NumberFormatException ex) 
                                {
                                    System.out.println("Input non valido");
                                }
                                break;
                            case 5: //altezze decrescenti
                                try
                                {
                                    System.out.print("Inserisci ID squadra di cui ordinare  i giocatori-->");
                                    id=tastiera.readInt();
                                    vOrdinato=NBA.ordinaAltezzaDerescente(id); //sistemare diagrama classi
                                    for(int i=0;i<vOrdinato.length;i++)
                                    {
                                        vOrdinato[i].toString();
                                    }
                                    break;
                                }
                                catch (EccezioneIDNonPresente ex)
                                {
                                    System.out.println("Squadra non trovata");
                                } 
                                catch (IOException ex) 
                                {
                                    System.out.println("Errore di input");
                                }
                                catch (EccezioneIDNonValido ex) 
                                {
                                    System.out.println("ID non valido");
                                }
                                catch (NumberFormatException ex) 
                                {
                                    System.out.println("Input non valido");
                                }
                                break; 
                            case 6: //salva dati CSV
                                try 
                                {
                                    NBA.salvaDatiCSV(nomeFileCSV);
                                    System.out.println("Esportazione avvenuta correttamente.");
                                } 
                                catch (IOException ex) 
                                {
                                    System.out.println("Impossibile accedere al file");
                                }
                                catch (EccezioneIDNonValido ex) 
                                {
                                    System.out.println("ID non valido");
                                }
                                catch(NullPointerException ex)
                                { 
                                    System.out.println("Errore! Impossibile salvare dati sul file!");
                                }
                                catch (EccezioneNessunaSquadra ex)
                                {
                                    System.out.println("Campionato vuoto");
                                }
                                break;                               
                            case 7: //carica dati CSV
                                try
                                {
                                    NBA.caricaDatiCSV(nomeFileCSV);
                                    System.out.println("Fine operazione di caricamento");
                                }
                                catch(IOException ex)
                                { 
                                    System.out.println("Errore! Impossibile caricare dati dal file!");
                                }
                                catch(NullPointerException ex)
                                { 
                                    System.out.println("Errore! Impossibile caricare dati dal file!");
                                }
                                catch (EccezioneIDNonValido ex) 
                                {
                                    System.out.println("ID non valido");
                                }
                                break;                               
                            case 8: //salva dati BIN
                                try 
                                {
                                    NBA.salvaDatiBIN(nomeFileBinario);
                                    System.out.println("Salvataggio avvenuto correttamente");
                                } 
                                catch (FileNotFoundException ex) 
                                {
                                    System.out.println("File non trovato");
                                }
                                catch(NullPointerException ex)
                                { 
                                    System.out.println("Errore! Impossibile salvare dati sul file!");
                                }
                                catch (IOException ex) 
                                {
                                     System.out.println("Impossibile accedere al file");
                                }
                                break;
                            case 9: //carica dati BIN
                                try 
                                {
                                    NBA=NBA.caricaDatiBIN(nomeFileBinario);
                                    System.out.println("Caricamento effettuato correttamente");
                                } 
                                catch (FileNotFoundException ex) 
                                {
                                    System.out.println("File non trovato");
                                } 
                                catch (IOException ex) 
                                {
                                     System.out.println("Impossibile accedere al file");
                                } 
                                catch(NullPointerException ex)
                                { 
                                    System.out.println("Errore! Impossibile caricare dati dal file!");
                                }
                                catch (ClassNotFoundException ex) 
                                {
                                    System.out.println("Impossibile leggere il dato memorizzato");
                                }
                                break;      
                        }
                    }while(sceltaUtente!=0);
                    break;
            }
        }while(attore!=0);
        
        
        
    }
}
