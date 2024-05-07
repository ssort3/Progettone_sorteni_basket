/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progettone_basket;

import Eccezioni.*;
import Utilita.ConsoleInput;
import Utilita.Menu;
import Utilita.Ordinatore;
import static Utilita.Ordinatore.scambia;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe Squadra, rappresenta una squadra di cestisti
 * nCestistiPresenti rappresenta il numero dei cestisti presenti nella squadra
 * N_MAX_CESTISTI rappresenta il numero massimo di cestisti che possono far parte di una squadra
 * rosa rappresenta la rosa della squadra, cioè un array contentente tutti i cestisti della squadra
 * idSquadra rappresenta il codice identificativo univoco della squadra
 * nextID rappresenta il codice identificativo univoco della prossima squadra che verrà creata
 * nomeSquadra rappresenta il nome della squadra
 * punti rappresenta il punteggio totalizzato dalla squadra 
 * @author Studente
 */
public class Squadra implements Serializable
{
    private int nCestistiPresenti;
    private final int N_MAX_CESTISTI=15;
    private Cestista[] rosa;
    private int idSquadra;
    private static int nextID=1;
    private String nomeSquadra;
    private int punti;

    /**
     * Costruttore
     * @param nomeSquadra nome della squadra da creare
     * @param punti punteggio della squadra da creare
     */
    public Squadra(String nomeSquadra, int punti)
    {
        rosa=new Cestista[N_MAX_CESTISTI];
        nCestistiPresenti=0;
        setNomeSquadra(nomeSquadra);
        setIdSquadra();
        setPunti(punti);
    }
    
    /**
     * Costruttore di copia
     * @param s1 squadra di cui verrà creata una copia
     */
    public Squadra(Squadra s1)
    {
        rosa=new Cestista[N_MAX_CESTISTI];
        this.nomeSquadra=s1.getNomeSquadra();
        this.idSquadra=s1.getIdSquadra();
        this.punti=s1.getPunti();
    }

    /**
     * Getter dell'attributo nCestistiPresenti
     * @return numero di cestisti presenti nella rosa della squadra
     */
    public int getNCestistiPresenti() 
    {
        return nCestistiPresenti;
    }
    
    /**
     * Getter dell'attributo punti
     * @return punteggio della squadra
     */
    public int getPunti()
    {
        return punti;
    }

    /**
     * Getter dell'attributo idSquadra
     * @return ID della squadra
     */
    public int getIdSquadra() 
    {
        return idSquadra;
    }
    
    /**
     * Getter dell'attributo N_MAX_CESTISTI
     * @return numero massimo di cestisti nella rosa della squadra
     */
    public int getN_MAX_CESTISTI()
    {
        return N_MAX_CESTISTI;
    }

    /**
     * Setter dell'attributo punti
     * se il punteggio inserito è negativo, esso viene posto a 0
     * @param punti punteggio da assegnare alla squadra in creazione
     */
    public void setPunti(int punti)
    {
        if(punti<0)
            this.punti=0;
        this.punti=punti;
    }

    /**
     * Setter privato dell'attributo idSquadra
     * assegna a idSquadra il valore di nextID
     * incrementa nextID
     */
    private void setIdSquadra() 
    {
        idSquadra=nextID;
        nextID++;
    }

    /**
     * Getter dell'attributo nomeSquadra
     * @return il nome della squadra
     */
    public String getNomeSquadra() 
    {
        return nomeSquadra;
    }

    /**
     * Setter dell'attributo nomeSquadra
     * @param nomeSquadra nome da assegnare alla squadra in creazione
     */
    public void setNomeSquadra(String nomeSquadra) 
    {
        this.nomeSquadra = nomeSquadra;
    }

    /**
     * toString della squadra
     * @return una stringa contenente ID, nome, punteggio della squadra e il toString di ogni cestista presente
     */
    @Override
    public String toString() 
    {
        String s=this.getIdSquadra()+";"+nomeSquadra+";"+this.getPunti()+"\n";
        for(int i=0;i<nCestistiPresenti;i++)
        { 
            //s+=("\t"+i+": "+rosa[i].toString()+"\n"); toString con l'indice (inutile)
            s+=("\t"+rosa[i].toString()+"\n");
        }
        return s;
    }
    
    /**
     * Inserisce un cestista nella squadra
     * @param c cestista da inserire
     * @throws EccezioneRosaCompleta rosa della squadra al completo
     */
    public void setCestista(Cestista c) throws EccezioneRosaCompleta
    {
        if(nCestistiPresenti==N_MAX_CESTISTI)
            throw new EccezioneRosaCompleta();
        rosa[nCestistiPresenti]=new Cestista(c);
            nCestistiPresenti++;
    }
    
    /**
     * Restituisce un cestista della squadra
     * @param id ID del cestista da restituire
     * @return il cestista con id corrispondente a quello indicato dal parametro
     * @throws EccezioneIDNonPresente se l'ID cercato non è presente nella squadra 
     */
    public Cestista getCestista(int id) throws EccezioneIDNonPresente
    {
        Cestista cest;
        for(int i=0;i<nCestistiPresenti;i++)
        {
            if(rosa[i].getIDCestista()==id)
            {
                cest=new Cestista(rosa[i]);
                return cest;
            }
        }
        throw new EccezioneIDNonPresente();      
    }
    
    /**
     * Rimuove un cestista dalla squadra
     * @param id ID del cestista da rimuovere
     * @throws EccezioneIDNonPresente se l'ID cercato non è presente nella squadra
     * * @throws NullPointerException in caso la posizione "i" fosse vuota
     */
    public void rimuoviCestista(int id) throws EccezioneIDNonPresente
    {
        for(int i=0;i<nCestistiPresenti;i++)
        {
            if(rosa[i].getIDCestista()==id)
            {
                eliminaPosizione(i);
                return;
            }     
        }
        throw new EccezioneIDNonPresente();
        
    }
    
    /**
     * Scorre la squadra e scala di una posizione i cestisti successivi a quello eliminato
     * @param pos posizione da cui parte la scalata
     * @throws NullPointerException in caso la posizione fosse vuota
     */
    private void eliminaPosizione(int pos) throws NullPointerException//vedere se in uml c'è public o private
    {
        for(int i=pos;i<nCestistiPresenti;i++)
        {
            rosa[i]=rosa[i+1];
        }
        nCestistiPresenti--;
    }
    
    /**
     * Ordina i cestisti di una squadra dal più basso al più alto
     * @return un array con i cestisti ordinati
     */
    public Cestista[] ordinaAltezzaCrescente()
    {
        //creo una copia di "s" e lo chiamo "vOrdinato"
        Cestista[] vOrdinato=new Cestista[getNCestistiPresenti()];
        for(int i=0;i<getNCestistiPresenti();i++)
        {
            try 
            {
                vOrdinato[i]=this.getCestista(i);
            } 
            catch (EccezioneIDNonPresente ex) 
            {
                //non fare nulla
            }
        }
        for(int i=0;i<getNCestistiPresenti()-1;i++)
        {
            for(int j=i+1;j<getNCestistiPresenti();j++)
            {
                if(vOrdinato[j].getAltezza()<vOrdinato[i].getAltezza())
                    Ordinatore.scambiaCestista(vOrdinato, i, j);
            }
        }
        return vOrdinato;
    }
    
    /**
     * Ordina i cestisti di una squadra dal più alto al più basso
     * @return un array con i cestisti ordinati
     */
    public Cestista[] ordinaAltezzaDerescente()
    {
        //creo una copia di "s" e lo chiamo "vOrdinato"
        Cestista[] vOrdinato=new Cestista[getNCestistiPresenti()];
        for(int i=0;i<getNCestistiPresenti();i++)
        {
            try 
            {
                vOrdinato[i]=this.getCestista(i);
            } 
            catch (EccezioneIDNonPresente ex) 
            {
                //non fare nulla
            }
        }
        for(int i=0;i<getNCestistiPresenti()-1;i++)
        {
            for(int j=i+1;j<getNCestistiPresenti();j++)
            {
                if(vOrdinato[j].getAltezza()>vOrdinato[i].getAltezza())
                    Ordinatore.scambiaCestista(vOrdinato, i, j);
            }
        }
        return vOrdinato;
    }
    
    
    
    
    
    
}
