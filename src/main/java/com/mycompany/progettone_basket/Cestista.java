/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progettone_basket;

import Eccezioni.EccezioneAltezza;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Studente
 */
public class Cestista implements Serializable
{
    private String nome;
    private String cognome;
    private int idCestista;
    private LocalDate dataNascita;
    
    private double altezza;
    private static int nextID=1;

    public Cestista(String nome, String cognome, LocalDate dataNascita, double altezza) throws EccezioneAltezza 
    {
        setIDCestista();
        setNome(nome);
        setCognome(cognome);
        setDataNascita(dataNascita);
        setAltezza(altezza);
    }
    
    public Cestista(Cestista c1)
    {
        this.idCestista=c1.getIDCestista();
        this.nome=c1.getNome();
        this.cognome=c1.getCognome();
        this.dataNascita=c1.getDataNascita();
        this.altezza=c1.getAltezza();
    }
    
    public int getIDCestista()
    {
        return idCestista;
    }
    
    private void setIDCestista()
    {
        idCestista=nextID;
        nextID++;
    }

    public String getNome() 
    {
        
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getCognome() 
    {
        return cognome;
    }

    public void setCognome(String cognome) 
    {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() 
    {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) 
    {
        this.dataNascita = dataNascita;
    }

    public double getAltezza() 
    {
        return altezza;
    }

    public void setAltezza(double altezza) throws EccezioneAltezza 
    {
        if(altezza<1.70)
            throw new EccezioneAltezza();
        this.altezza = altezza;
    }

    @Override
    public String toString() 
    {
        return idCestista+";"+nome+";"+cognome+";"+dataNascita+";"+altezza;
    }
    
    
    
    
    
    
    
}
