/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progettone_basket;

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
    private int nextID=1;

    public Cestista(String nome, String cognome, LocalDate dataNascita, double altezza) 
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
    
    private void setIDCestista()
    {
        this.idCestista=nextID;
        nextID++;
    }
    
    
    public int getIDCestista()
    {
        return idCestista;
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

    public void setAltezza(double altezza) 
    {
        this.altezza = altezza;
    }

    @Override
    public String toString() 
    {
        return idCestista+";"+nome+";"+cognome+";"+dataNascita+";"+altezza;
    }
    
    
    
    
    
    
    
}
