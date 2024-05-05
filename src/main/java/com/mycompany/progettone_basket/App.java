/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progettone_basket;

import Eccezioni.EccezioneAltezza;
import Eccezioni.EccezioneCampionatoCompleto;
import Eccezioni.EccezioneIDNonPresente;
import Eccezioni.EccezioneRosaCompleta;
import Eccezioni.FileException;
import Utilita.ConsoleInput;
import Utilita.Menu;
import Utilita.TextFile;
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
        String nomeFileCSV = null,nomeFileBinario;
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
                                catch (IOException ex) {
                                    System.out.println("Errore nell'inserimento");
                                } catch (NumberFormatException ex) {
                                    System.out.println("ID inserito non valido");
                                }catch(EccezioneIDNonPresente ex)
                                {
                                    System.out.println("L'ID inserito non è presente nel campionato");
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
                                catch (NumberFormatException ex) 
                                {
                                    System.out.println("ID inserito non valido");
                                } 
                                catch(EccezioneIDNonPresente ex)
                                {
                                    System.out.println("L'ID inserito non è presente nel campionato");
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
                                break;
                            case 7: //rimuovi squadra    
                                try
                                {
                                    System.out.print("Inserisci ID della squadra da rimuovere-->");
                                    id=tastiera.readInt();
                                    NBA.rimuoviSquadra(id);
                                }
                                catch (EccezioneIDNonPresente ex)
                                {
                                    System.out.println("Squadra non trovata");
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
                            case 8: //altezze crescenti                               
                                try
                                {
                                    System.out.print("Inserisci ID squadra di cui ordinare  i giocatori-->");
                                    id=tastiera.readInt();
                                    NBA.ordinaAltezzaCrescente(id); //sistemare diagrama classi
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
                                    NBA.ordinaAltezzaDerescente(id); //sistemare diagrama classi
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
                                catch (IOException ex) 
                                {
                                    System.out.println("errore di input");
                                } 
                                catch (NumberFormatException ex) 
                                {
                                    System.out.println("Input non valido");
                                }
                            case 11: //modifica cestista
                                //aggiungere a diagramma delle classi e sistemare parametri di modificaPunteggio
                                break;
                            case 12: //salva dati CSV
                                try 
                                {
                                    f1= new TextFile(nomeFileCSV,'W'); //Apro ill file in scrittura
                                    String datiCestista;
                                    for(int i=0;i<NBA.getNSquadrePresenti();i++)
                                    {
                                            try 
                                            {
                                                cest=NBA.getCestista(i);
                                                datiCestista=cest.toString();
                                                f1.toFile(datiCestista);
                                            }                       
                                            catch (FileException ex) 
                                            {
                                                //non succederà mai
                                                //mostra il messaggio dell'eccezione
                                                System.out.println(ex.toString());
                                            } 
                                            catch (EccezioneIDNonPresente ex) 
                                            {
                                                //non fare  niente e vai avanti
                                            }
                                    }
                                    f1.closeFile();  //Tutti i cestisti sono stati scritti
                                    System.out.println("Esportazione avvenuta correttamente.");
                                } 
                                catch (IOException ex) 
                                {
                                    System.out.println("Impossibile accedere al file");
                                }
                                break;                               
                            case 13: //carica dati CSV
                                /*String rigaLetta;
                                String[] datiCestista;
                                try 
                                {   
                                    //Importa da file CSV
                                    f1=new TextFile(nomeFileCSV,'R');
                                    do
                                    {
                                        try
                                        {
                                            rigaLetta=f1.fromFile();
                                            datiCestista=rigaLetta.split(";");
                                            id=Integer.parseInt(datiCestista[0]);
                                            nome=datiCestista[1];
                                            cognome=datiCestista[2];
                                            //dataNascita=datiCestista[3]; capire come salvare data su file per caricarla meglio
                                            h=Double.parseDouble(datiCestista[4]);
                                            cest=new Cestista(nome,cognome,LocalDate.of(1111,11,1),h);
                                            try 
                                            {
                                                s1.setLibro(lib, ripiano, posizione);
                                            } 
                                            catch (EccezioneRipianoNonValido ex) 
                                            {
                                                System.out.println("Errore: ripiano "+ripiano+ " non corretto per il volume "+titolo);
                                            } 
                                            catch (EccezionePosizioneNonValida ex) 
                                            {
                                                 System.out.println("Errore: posizione "+posizione+ " non corretta per il volume "+titolo);
                                            }
                                            catch (EccezionePosizioneOccupata ex) 
                                            {
                                                 System.out.println("Nel ripiano  "+ripiano+ " e posizione "+posizione+" è già presente un volume. Il volume "+titolo+ " non sarà posizionato nello scaffale.");
                                            }
                                        }
                                        catch (FileException ex) 
                                        {
                                            //fine del file
                                            f1.closeFile();
                                            System.out.println("Fine operazione di caricamento");
                                            break;
                                        }
                                    }while(true);                
                                } 
                                catch (IOException ex) 
                                {
                                    System.out.println("Impossibile accedere al file!");
                                }*/
                                break;                               
                            case 14: //salva dati BIN
                                break;
                            case 15: //carica dati BIN
                                break;    
                        }           
                    }while(sceltaUtente!=0);          
                    break;
                case 2:
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
                                } catch (NumberFormatException ex) {
                                    System.out.println("ID inserito non valido");
                                }catch(EccezioneIDNonPresente ex)
                                {
                                    System.out.println("L'ID inserito non è presente nel campionato");
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
                                    NBA.ordinaAltezzaCrescente(id); //sistemare diagrama classi
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
                                    NBA.ordinaAltezzaDerescente(id); //sistemare diagrama classi
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
                                catch (NumberFormatException ex) 
                                {
                                    System.out.println("Input non valido");
                                }
                                break; 
                            case 6: //salva dati CSV
                                break;
                            case 7: //carica dati CSV
                                break;
                            case 8: //salva dati BIN
                                break;
                            case 9: //carica dati BIN
                                break; 
                            
                        }
                    }while(sceltaUtente!=0);
                    break;
            }
        }while(attore!=0);
        
        
        
    }
}
