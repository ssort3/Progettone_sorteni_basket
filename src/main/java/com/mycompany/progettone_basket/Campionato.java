/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progettone_basket;

import Eccezioni.EccezioneCampionatoCompleto;
import Eccezioni.EccezioneIDNonPresente;
import Eccezioni.EccezioneRosaCompleta;
import Utilita.Ordinatore;
import java.io.Serializable;

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
    
    public void setCestista(int idSquadra, Cestista c) throws EccezioneRosaCompleta, EccezioneIDNonPresente
    {
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
            elencoSquadre[nSquadrePresenti]=new Squadra(s.getNomeSquadra(),s.getIdSquadra());
        }
        nSquadrePresenti++;
        elencoSquadre=Ordinatore.ordinaClassifica(elencoSquadre);
    }
    
    public Cestista getCestista(int id) throws EccezioneIDNonPresente
    {
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
    
    public Squadra getSquadra(int id) throws EccezioneIDNonPresente
    {
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
    
    public void rimuoviCestista(int id) throws EccezioneIDNonPresente
    {
        Cestista cest;
        for(int i=0;i<nSquadrePresenti;i++)
        {
            if(elencoSquadre[i].getCestista(i).getIDCestista()==id)
            {
                elencoSquadre[i].rimuoviCestista(id);
            }            
        }
        throw new EccezioneIDNonPresente(); 
    }
    
    public void rimuoviSquadra(int id) throws EccezioneIDNonPresente
    {
        Squadra sq;
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
    
    
}
