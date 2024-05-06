/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progettone_basket;

import Eccezioni.EccezioneAltezza;
import Eccezioni.EccezioneCampionatoCompleto;
import Eccezioni.EccezioneIDNonPresente;
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
 *
 * @author Studente
 */
public class Campionato implements Serializable
{
    private int nSquadrePresenti;
    private final int N_MAX_SQUADRE=20;
    private Squadra[] elencoSquadre;
    
    public Campionato()
    {
        elencoSquadre=new Squadra[N_MAX_SQUADRE];
        nSquadrePresenti=0;
    }
    
    //costruttore di copia tolto per indicazione del professore
    
    public int getNSquadrePresenti()
    {
        return nSquadrePresenti;
    }
    
    public int getN_MAX_SQUADRE()
    {
        return N_MAX_SQUADRE;
    }
    
    public void setCestista(int idSquadra, Cestista c) throws EccezioneRosaCompleta, EccezioneIDNonPresente, EccezioneNessunaSquadra
    {
        if(nSquadrePresenti==0)
            throw new EccezioneNessunaSquadra();
        for(int i=0;i<nSquadrePresenti;i++)
        {
            if(elencoSquadre[i].getIdSquadra()==idSquadra)
            {
                elencoSquadre[i].setCestista(c);
                return;
            }
            throw new EccezioneIDNonPresente();
        }
    }
    
    public void setSquadra(Squadra s) throws EccezioneCampionatoCompleto
    {
        if(nSquadrePresenti==N_MAX_SQUADRE)
            throw new EccezioneCampionatoCompleto();
        else
        {
            elencoSquadre[nSquadrePresenti]=new Squadra(s.getNomeSquadra(),s.getPunti());
        }
        nSquadrePresenti++;
        if(nSquadrePresenti!=1)
            elencoSquadre=Ordinatore.ordinaClassifica(elencoSquadre);
    }
    
    public Cestista getCestista(int id) throws EccezioneIDNonPresente, EccezioneNessunaSquadra
    {
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
    
    public Squadra getSquadra(int id) throws EccezioneIDNonPresente, EccezioneNessunaSquadra
    {
        if(nSquadrePresenti==0)
            throw new EccezioneNessunaSquadra();
        Squadra sq;
        for(int i=0;i<nSquadrePresenti;i++)
        {
            if(elencoSquadre[i].getIdSquadra()==id)
            {
                sq=new Squadra(elencoSquadre[i].getNomeSquadra(),elencoSquadre[i].getPunti());
                return sq;
            }            
        }
        throw new EccezioneIDNonPresente(); 
    }
    
    public void rimuoviCestista(int id) throws EccezioneIDNonPresente, EccezioneNessunaSquadra
    {
        if(nSquadrePresenti==0)
            throw new EccezioneNessunaSquadra();
        for(int i=0;i<nSquadrePresenti;i++)
        {
            if(elencoSquadre[i].getCestista(i).getIDCestista()==id)
            {
                elencoSquadre[i].rimuoviCestista(id);
            }            
        }
        throw new EccezioneIDNonPresente(); 
    }
    
    public void rimuoviSquadra(int id) throws EccezioneIDNonPresente, EccezioneNessunaSquadra
    {
        if(nSquadrePresenti==0)
            throw new EccezioneNessunaSquadra();
        for(int i=0;i<nSquadrePresenti;i++)
        {
            if(elencoSquadre[i].getIdSquadra()==id)
            {
                eliminaPosizione(i);
            }            
        }
        throw new EccezioneIDNonPresente(); 
    }
    
    public void eliminaPosizione(int pos) throws NullPointerException
    {
        for(int i=pos;i<nSquadrePresenti;i++)
        {
            elencoSquadre[i]=elencoSquadre[i+1];
        }
        nSquadrePresenti--;
    }
    
    public void modificaPunteggio(int id,int nuovoPunteggio) throws EccezioneIDNonPresente
    {
        for(int i=0;i<nSquadrePresenti;i++)
        {
            if(elencoSquadre[i].getIdSquadra()==id)
            {
                System.out.println("Squadra iniziale:\n"+elencoSquadre[i].toString());
                elencoSquadre[i].setPunti(nuovoPunteggio);
            }            
        }
        throw new EccezioneIDNonPresente(); 
    }
    
    public Cestista[] ordinaAltezzaCrescente(int id) throws EccezioneIDNonPresente
    {
        for(int i=0;i<nSquadrePresenti;i++)
        {
            if(elencoSquadre[i].getIdSquadra()==id)
            {
                elencoSquadre[i].ordinaAltezzaCrescente();
            }            
        }
        throw new EccezioneIDNonPresente();
    }
    
        public Cestista[] ordinaAltezzaDerescente(int id) throws EccezioneIDNonPresente
    {
        for(int i=0;i<nSquadrePresenti;i++)
        {
            if(elencoSquadre[i].getIdSquadra()==id)
            {
                elencoSquadre[i].ordinaAltezzaDerescente();
            }            
        }
        throw new EccezioneIDNonPresente();
    }
    
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
    
    private int getIDSquadraAppartenenza(int idCestista) throws EccezioneIDNonPresente, EccezioneNessunaSquadra
    {
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
    
    public void salvaDatiCSV(String nomeFile) throws IOException, EccezioneNessunaSquadra
    {
        TextFile f1;
        Cestista cest;
        f1= new TextFile(nomeFile,'W'); //Apro ill file in scrittura
        String datiCestista;
        for(int i=0;i<this.getNSquadrePresenti();i++)
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
        f1.closeFile();  //Tutti i cestisti sono stati scritti
        System.out.println("Esportazione avvenuta correttamente.");       
    }
    
    public void caricaDatiCSV(String nomeFile) throws IOException
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
    
    public void salvaDatiBIN(String nomeFile) throws FileNotFoundException, IOException
    {
        ObjectOutputStream writer=new ObjectOutputStream(new FileOutputStream(nomeFile));
        writer.writeObject(this);
        writer.flush();
        writer.close();
    }
    
    public Campionato caricaDatiBIN(String nomeFile) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        Campionato camp;
        ObjectInputStream reader=new ObjectInputStream(new FileInputStream(nomeFile));
        camp=(Campionato)reader.readObject();
        reader.close();
        
        return camp;
    }
    
    
}
