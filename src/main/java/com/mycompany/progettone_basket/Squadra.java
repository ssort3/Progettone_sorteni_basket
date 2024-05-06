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
 *
 * @author Studente
 */
public class Squadra implements Serializable
{
    private int nCestistiPresenti;
    private final int N_MAX_CESTISTI=15;
    private Cestista[] rosa;
    private int idSquadra;
    private int nextID=1;
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
        if(punti<0)
            this.punti=0;
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
        String s=nomeSquadra+"\n";
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
    
    
    public void rimuoviCestista(int id) throws EccezioneIDNonPresente, NullPointerException
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
    
    public void eliminaPosizione(int pos) throws NullPointerException
    {
        for(int i=pos;i<nCestistiPresenti;i++)
        {
            rosa[i]=rosa[i+1];
        }
        nCestistiPresenti--;
    }
    
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
