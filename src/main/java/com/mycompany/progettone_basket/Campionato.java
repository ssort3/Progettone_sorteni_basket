/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progettone_basket;

import Eccezioni.EccezioneAltezza;
import Eccezioni.EccezioneCampionatoCompleto;
import Eccezioni.EccezioneIDNonPresente;
import Eccezioni.EccezioneIDNonValido;
import Eccezioni.EccezioneNessunaSquadra;
import Eccezioni.EccezioneRosaCompleta;
import Eccezioni.FileException;
import Utilita.Ordinatore;
import Utilita.TextFile;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe Campionato, rappresenta un campionato di basket
 * nSquadrepresenti rappresenta il numero di squadre del campionato
 * N_MAX_SQUADRE rappresenta il numero massimo di squadre possibili nel campionato
 * elencoSquadre array contentente le squadre del campionato
 * @author Studente
 */
public class Campionato implements Serializable
{
    private int nSquadrePresenti;
    private final int N_MAX_SQUADRE=20;
    private Squadra[] elencoSquadre;
    
    /**
     * Costruttore
     * Inizializza elencoSquadre
     * Imposta nSquadrePresenti a 0
     */
    public Campionato()
    {
        elencoSquadre=new Squadra[N_MAX_SQUADRE];
        nSquadrePresenti=0;
    }  
    
    //costruttore di copia tolto per indicazione del professore
    
    /**
     * Getter dell'attributo nSquadrePresenti
     * @return il numero di squadre nel campionato
     */
    public int getNSquadrePresenti()
    {
        return nSquadrePresenti;
    }
    
    /**
     * Getter dell'attributo N_MAX_SQUADRE
     * @return il numero massimo di squadre del campionato
     */
    public int getN_MAX_SQUADRE()
    {
        return N_MAX_SQUADRE;
    }
    
    /**
     * Aggiunge un cestista a una squadra selezionata
     * @param idSquadra ID della squadra in cui aggiungere il cestista
     * @param c cestista da aggiungere
     * @throws EccezioneRosaCompleta se la rosa della squadra è piena
     * @throws EccezioneIDNonPresente se la squadra selezionata non esiste
     * @throws EccezioneNessunaSquadra se non ci sono squadre nel campionato
     * @throws EccezioneIDNonValido se l'ID della squadra è negativo
     */
    public void setCestista(int idSquadra, Cestista c) throws EccezioneRosaCompleta, EccezioneIDNonPresente, EccezioneNessunaSquadra, EccezioneIDNonValido
    {
        if(nSquadrePresenti==0)
            throw new EccezioneNessunaSquadra();
        if(idSquadra<0)
            throw new EccezioneIDNonValido();
        for(int i=0;i<nSquadrePresenti+1;i++)
        {
            if(elencoSquadre[i].getIdSquadra()==idSquadra)
            {
                elencoSquadre[i].setCestista(c);
                return;
            }
            
        }
        throw new EccezioneIDNonPresente();
    }
    
    /**
     * Aggiunge una squadra al campionato
     * @param s squadra da aggiungere
     * @throws EccezioneCampionatoCompleto se il campionato è pieno
     */
    public void setSquadra(Squadra s) throws EccezioneCampionatoCompleto
    {
        if(nSquadrePresenti==N_MAX_SQUADRE)
            throw new EccezioneCampionatoCompleto();
        else
        {
            elencoSquadre[nSquadrePresenti]=new Squadra(s);
        }
        nSquadrePresenti++;
        if(nSquadrePresenti!=1)
            elencoSquadre=Ordinatore.ordinaClassifica(elencoSquadre);
    }
    
    /**
     * Restituisce un cestista
     * @param id ID del cestista da restituire
     * @return il cestista di ID "id"
     * @throws EccezioneIDNonPresente se l'ID cercato non è presente nel campionato
     * @throws EccezioneNessunaSquadra se il campionato è vuoto
     * @throws EccezioneIDNonValido se l'ID inserito è negativo
     */
    public Cestista getCestista(int id) throws EccezioneIDNonPresente, EccezioneNessunaSquadra, EccezioneIDNonValido
    {
        if(id<0)
            throw new EccezioneIDNonValido();
        if(nSquadrePresenti==0)
            throw new EccezioneNessunaSquadra();
        Cestista cest;
        for(int i=0;i<nSquadrePresenti;i++)
        {
            if(elencoSquadre[i].getCestista(i).getIDCestista()==id)
            {
                cest=new Cestista(elencoSquadre[i].getCestista(id));
                return cest;
            }            
        }
        throw new EccezioneIDNonPresente();
    }
    
    /**
     * Restituisce una squadra
     * @param id ID della squadra da restituire
     * @return la squadra di ID "id"
     * @throws EccezioneIDNonPresente se l'ID cercato non è presente nel campionato
     * @throws EccezioneNessunaSquadra se il campionato è vuoto
     * @throws EccezioneIDNonValido se l'ID inserito è negativo
     */
    public Squadra getSquadra(int id) throws EccezioneIDNonPresente, EccezioneNessunaSquadra, EccezioneIDNonValido
    {
        if(id<0)
            throw new EccezioneIDNonValido();
        if(nSquadrePresenti==0)
            throw new EccezioneNessunaSquadra();
        Squadra sq;
        for(int i=0;i<nSquadrePresenti;i++)
        {
            if(elencoSquadre[i].getIdSquadra()==id)
            {
                sq=new Squadra(elencoSquadre[i]);
                return sq;
            }         
        }
        throw new EccezioneIDNonPresente(); 
    }
    
    /**
     * Rimuove un cestista dal campionato
     * @param id ID del cestista da rimuovere
     * @throws EccezioneIDNonPresente se l'ID cercato non è presente nel campionato
     * @throws EccezioneNessunaSquadra se il campionato è vuoto
     * @throws EccezioneIDNonValido se l'ID inserito è negativo
     */
    public void rimuoviCestista(int id) throws  EccezioneIDNonPresente, EccezioneNessunaSquadra, EccezioneIDNonValido
    {
        if(nSquadrePresenti==0)
            throw new EccezioneNessunaSquadra(); 
        if(id<0)
            throw new EccezioneIDNonValido();
        for(int i=0;i<nSquadrePresenti;i++)
        {
            for(int j=0;j<elencoSquadre[i].getNCestistiPresenti();j++)
            {
                if(elencoSquadre[i].getCestista(id)!=null)
                {
                    elencoSquadre[i].rimuoviCestista(id);
                    return;
                }
                else
                    throw new EccezioneIDNonPresente(); 
            }     
        }
        throw new EccezioneIDNonPresente(); 
    }
    
    /**
     * Elimina una squadra dal campionato
     * @param id ID della squadra da eliminare
     * @throws EccezioneIDNonPresente se l'ID cercato non è presente nel campionato
     * @throws EccezioneNessunaSquadra se il campionato è vuoto
     * @throws EccezioneIDNonValido se l'ID inserito è negativo
     */
    public void rimuoviSquadra(int id) throws EccezioneIDNonPresente, EccezioneNessunaSquadra, EccezioneIDNonValido
    {
        if(nSquadrePresenti==0)
            throw new EccezioneNessunaSquadra();
        if(id<0)
            throw new EccezioneIDNonValido();
        for(int i=0;i<nSquadrePresenti;i++)
        {
            if(elencoSquadre[i].getIdSquadra()==id)
            {
                eliminaPosizione(i);
                return;
            }            
        }
        throw new EccezioneIDNonPresente(); 
    }
    
    /**
     * "scala" il campionato in modo da non lasciare posizioni vuote
     * @param pos posizione da cui parte la "scalata"
     * @throws NullPointerException in caso la posizione fosse vuota
     */
    public void eliminaPosizione(int pos) throws NullPointerException
    {
        for(int i=pos;i<nSquadrePresenti-1;i++)
        {
            elencoSquadre[i]=elencoSquadre[i+1];
        }
        nSquadrePresenti--;
    }
    
    /**
     * Modifica il punteggio di una squadra
     * @param id Id della squadra di cui si vuole eliminare il punteggio
     * @param nuovoPunteggio nuovo punteggio della squadra
     * @throws EccezioneIDNonPresente se la squadra cercara non è presente
     * @throws EccezioneIDNonValido se l'ID inserito è negativo
     */
    public void modificaPunteggio(int id,int nuovoPunteggio) throws EccezioneIDNonPresente, EccezioneIDNonValido
    {
        if(id<0)
            throw new EccezioneIDNonValido();
        for(int i=0;i<nSquadrePresenti;i++)
        {
            if(elencoSquadre[i].getIdSquadra()==id)
            {  
                elencoSquadre[i].setPunti(nuovoPunteggio);
                return;
            }            
        }
        throw new EccezioneIDNonPresente(); 
    }
    
    /**
     * Ordina i cestisti di una squadra dal più basso al più alto
     * @param id ID della squadra da ordinare
     * @return la squadra ordinata
     * @throws EccezioneIDNonPresente se la squadra non è presente
     * @throws Eccezioni.EccezioneNessunaSquadra se campionato vuoto
     * @throws EccezioneIDNonValido se l'ID inserito è negativo
     */
    public Cestista[] ordinaAltezzaCrescente(int id) throws EccezioneNessunaSquadra, EccezioneIDNonValido, EccezioneIDNonPresente
    {
        Cestista[] vOrdinato;
        if(nSquadrePresenti==0)
            throw new EccezioneNessunaSquadra();
        if(id<0)
            throw new EccezioneIDNonValido();
        for(int i=0;i<nSquadrePresenti;i++)
        {
                if(elencoSquadre[i].getIdSquadra()==id)
                {
                    vOrdinato=elencoSquadre[i].ordinaAltezzaCrescente();
                    return vOrdinato;
                }                        
        }
        throw new EccezioneIDNonPresente();
    }
    
    /**
     * Ordina i cestisti di una squadra dal più alto al più basso
     * @param id ID della squadra da ordinare
     * @return la squadra ordinata
     * @throws EccezioneIDNonPresente se la squadra non è presente
     * @throws EccezioneIDNonValido se l'ID inserito è negativo
     */
    public Cestista[] ordinaAltezzaDerescente(int id) throws EccezioneIDNonPresente, EccezioneIDNonValido, EccezioneNessunaSquadra
    {
        Cestista[] vOrdinato;
        if(nSquadrePresenti==0)
            throw new EccezioneNessunaSquadra();
        if(id<0)
            throw new EccezioneIDNonValido();
        for(int i=0;i<nSquadrePresenti;i++)
        {
            if(elencoSquadre[i].getIdSquadra()==id)
            {
                vOrdinato=elencoSquadre[i].ordinaAltezzaDerescente();
                return vOrdinato;
            }            
        }
        throw new EccezioneIDNonPresente();
    }
    
    /**
     * toString della classe campionato
     * @return una stringa contenente il toString di ogni squadra presente
     */
    @Override
    public String toString()
    {
        String s="";
        for(int i=0;i<nSquadrePresenti;i++)
        {
            s+=elencoSquadre[i].toString();
        }
        return s;
    }
    
    /**
     * Restituisce l'id di una squadra di un cestista di riferimento
     * @param idCestista id del cestista di riferimento
     * @return l'ID della squadra del cestista
     * @throws EccezioneIDNonPresente se il cestista non è presente
     * @throws EccezioneNessunaSquadra se il campionato è vuoto
     * @throws EccezioneIDNonValido se l'ID inserito è negativo
     */
    private int getIDSquadraAppartenenza(int idCestista) throws EccezioneIDNonPresente, EccezioneNessunaSquadra, EccezioneIDNonValido
    {
        if(idCestista<=0)
            throw new EccezioneIDNonValido();
        for(int i=0;i<nSquadrePresenti;i++)
        {
            for(int j=0;j<elencoSquadre[i].getNCestistiPresenti();j++)
            {
                if(elencoSquadre[i].getCestista(j)==this.getCestista(idCestista))
                    return i;
            }
        }
        throw new EccezioneIDNonPresente();
    }
    
    /**
     * Salva i dati del campionato in un file di in formato .CSV
     * @param nomeFile nome del file
     * @throws IOException se silecchia stacca la spina del pc
     * @throws EccezioneNessunaSquadra se il campionato è vuoto
     * @throws EccezioneIDNonValido se id negativo
     * @throws Eccezioni.EccezioneIDNonPresente se id non presente
     */
    public void salvaDatiCSV(String nomeFile) throws IOException, EccezioneNessunaSquadra, EccezioneIDNonValido
    {
        TextFile f1;
        Cestista cest;
        f1= new TextFile(nomeFile,'W'); //Apro ill file in scrittura
        String datiCestista;
        for(int i=0;i<this.getNSquadrePresenti();i++)
        {
            try
            {
                for(int j=0;j<getSquadra(i).getNCestistiPresenti();j++)
                {
                
                    try 
                    {
                        cest=this.getCestista(i);
                        datiCestista=cest.toString()+";"+this.getIDSquadraAppartenenza(i);
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
            }
            catch(EccezioneIDNonPresente ex)
            {
                //non fare niente e vai avanti
            }          
        }
        f1.closeFile();  //Tutti i cestisti sono stati scritti
        System.out.println("Esportazione avvenuta correttamente.");       
    }

    /**
     * Carica i dati del campionato da un file di in formato .CSV
     * @param nomeFile nome del file 
     * @throws IOException se silecchia stacca la spina del pc
     * @throws EccezioneIDNonValido se Valido id negativo
     */
    public void caricaDatiCSV(String nomeFile) throws IOException, EccezioneIDNonValido
    {
        String rigaLetta;
        String[] datiCestista;
        Cestista cest;
        TextFile f1;
        int gg,mm,aaaa,id,idSquadra;
        double h;
        LocalDate dataNascita;
        String nome,cognome;
        //Importa da file CSV
        f1=new TextFile(nomeFile,'R');
        do
        {
            try
            {
                rigaLetta=f1.fromFile();
                datiCestista=rigaLetta.split(";");
                id=Integer.parseInt(datiCestista[0]);
                nome=datiCestista[1];
                cognome=datiCestista[2];
                dataNascita=LocalDate.parse(datiCestista[3]);
                h=Double.parseDouble(datiCestista[4]);
                idSquadra=Integer.parseInt(datiCestista[5]);
                cest=new Cestista(nome,cognome,dataNascita,h);
                try 
                {
                    this.setCestista(idSquadra, cest);
                } 
                catch (EccezioneRosaCompleta ex) 
                {
                    //non succederà mai
                } 
                catch (EccezioneIDNonPresente ex) 
                {
                    //non succederà mai
                } 
                catch (EccezioneNessunaSquadra ex) 
                {
                    //boh
                }
            }
            catch (FileException ex) 
            {
                //fine del file
                f1.closeFile();
                System.out.println("Fine operazione di caricamento");
                break;
            } 
            catch (EccezioneAltezza ex) 
            {
                //non succederà mai perché l'altezza è salvata correttamente sul file
            }
        }while(true);                          
    }
    
    /**
     * Salva i dati del campionato su un file binario
     * @param nomeFile nome del file
     * @throws FileNotFoundException se non trova il file
     * @throws IOException se silecchia stacca la spina del pc
     */
    public void salvaDatiBIN(String nomeFile) throws FileNotFoundException, IOException
    {
        ObjectOutputStream writer=new ObjectOutputStream(new FileOutputStream(nomeFile));
        writer.writeObject(this);
        writer.flush();
        writer.close();
    }
    
    /**
     * Carica i dati del campionato da un file di in formato binario
     * @param nomeFile nome del file
     * @return il campionato salvato sul file
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public Campionato caricaDatiBIN(String nomeFile) throws FileNotFoundException, ClassNotFoundException, IOException
    {
        Campionato camp;
        ObjectInputStream reader=new ObjectInputStream(new FileInputStream(nomeFile));
        camp=(Campionato)reader.readObject();
        reader.close();
        Squadra.setNextID(camp.getNSquadrePresenti()+1);
        return camp;
    }
    
    
}
