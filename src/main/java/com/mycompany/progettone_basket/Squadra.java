/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progettone_basket;

import Eccezioni.*;
import java.io.Serializable;

/**
 *
 * @author Studente
 */
public class Squadra implements Serializable
{
    private int nCestistiPresenti;
    private final int N_MAX_CESTISTI=30;
    private Cestista[] rosa;
    private int idSquadra;
    private int nextID;
    private String nomeSquadra;
    private int punti;

    public Squadra(String nomeSquadra, int punti)
    {
        rosa=new Cestista[N_MAX_CESTISTI];
        nCestistiPresenti=0;
        setNomeSquadra(nomeSquadra);
        setIdSquadra();
        setPunti(punti);
    }
    
    public Squadra(Squadra s1)
    {
        this.nomeSquadra=s1.getNomeSquadra();
        this.idSquadra=s1.getIdSquadra();
        this.punti=s1.getPunti();
    }

    public int getNCestistiPresenti() 
    {
        return nCestistiPresenti;
    }
    
    public int getPunti()
    {
        return punti;
    }

    public int getIdSquadra() 
    {
        return idSquadra;
    }
    
    public int getN_MAX_CESTISTI()
    {
        return N_MAX_CESTISTI;
    }

    public void setPunti(int punti)
    {
        this.punti=punti;
    }

    private void setIdSquadra() 
    {
        this.idSquadra = nextID;
        nextID++;
    }

    public String getNomeSquadra() 
    {
        return nomeSquadra;
    }

    public void setNomeSquadra(String nomeSquadra) 
    {
        this.nomeSquadra = nomeSquadra;
    }

    @Override
    public String toString() 
    {
        String s="";
        for(int i=0;i<nCestistiPresenti;i++)
        { 
            s+=(i+": "+rosa[i].toString()+"\n");
        }
        return s;
    }
    
    public void setCestista(Cestista c) throws EccezioneRosaCompleta
    {
        if(nCestistiPresenti==N_MAX_CESTISTI)
            throw new EccezioneRosaCompleta();
        rosa[nCestistiPresenti]=new Cestista(c);
            nCestistiPresenti++;
    }
    
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
    
    public void rimuoviCestista(int id) throws EccezioneIDNonPresente
    {
        for(int i=0;i<nCestistiPresenti;i++)
        {
            if(rosa[i].getIDCestista()==id)
            {
                rosa[i]=null;
                return;
            }     
        }
        throw new EccezioneIDNonPresente();
        
    }
    
    
    
    
    
    
    
    
}
