/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progettone_basket;

import Eccezioni.EccezioneAltezza;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Classe cestista, rappresenta un giocatore di basket
 * nome rappresenta il nome del cestista
 * cognome rappresenta il cognome del cestista
 * idCestista rappresenta il codice identificativo univoco del cestista
 * dataNascita rappresenta la data di nascita del cestista
 * altezza rappresenta l'altezza in metri del cestista
 * nextID rappresenta il codice identificativo univoco del prossimo cestista che verrà creato
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

    /**
     * Costruttore
     * @param nome nome del cestista da creare
     * @param cognome cognome del cestista da creare
     * @param dataNascita data di nascita del cestista da creare
     * @param altezza altezza (cm) del cestista da creare
     * @throws EccezioneAltezza l'altezza viene accettata solo se maggiore o uguale a 1.70 valore minimo standard del campionato
     */
    public Cestista(String nome, String cognome, LocalDate dataNascita, double altezza) throws EccezioneAltezza 
    {
        setIDCestista();
        setNome(nome);
        setCognome(cognome);
        setDataNascita(dataNascita);
        setAltezza(altezza);
    }
    
    /**
     * Costruttore di copia
     * @param c1 cestista di cui verrà generata una copia
     */
    public Cestista(Cestista c1)
    {
        this.idCestista=c1.getIDCestista();
        this.nome=c1.getNome();
        this.cognome=c1.getCognome();
        this.dataNascita=c1.getDataNascita();
        this.altezza=c1.getAltezza();
    }
    
    /**
     * Getter dell'attributo idCestista
     * @return ID del cestista
     */
    public int getIDCestista()
    {
        return idCestista;
    }
    
    /**
     * Setter privato dell'attributo idCestista
     * assegna a idCestista il valore di nextID
     * incrementa il valore di nextID
     */
    private void setIDCestista()
    {
        idCestista=nextID;
        nextID++;
    }
    
    /**
     * Setter privato di nextID utilizzato da caricaDatiBIN
     * @param id valore attribuito a nextID
     */
    public static void setNextID(int id)
    {
        nextID=id;
    }

    /**
     * Getter dell'attributo nome
     * @return nome del cestista
     */
    public String getNome() 
    {
        return nome;
    }

    /**
     * Setter dell'attributo nome
     * @param nome assegnato all'attributo nome del cestista in creazione
     */
    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    /**
     * Getter dell'attributo cognome
     * @return cognome del cestista
     */
    public String getCognome() 
    {
        return cognome;
    }

    /**
     * Setter dell'attributo cognome
     * @param cognome assegnato all'attributo cognome del cestista in creazione
     */
    public void setCognome(String cognome) 
    {
        this.cognome = cognome;
    }

    /**
     * Getter dell'attributo dataNascita
     * @return data di nascita del cestista
     */
    public LocalDate getDataNascita() 
    {
        return dataNascita;
    }

    /**
     * Setter dell'attributo dataNascita
     * @param dataNascita assegnato all'attributo dataNascita del cestista in creazione
     */
    public void setDataNascita(LocalDate dataNascita)
    {
        this.dataNascita = dataNascita;
    }

    /**
     * Getter dell'attributo altezza
     * @return altezza del cestista
     */
    public double getAltezza() 
    {
        return altezza;
    }

    /**
     * Setter dell'attributo altezza
     * @param altezza assegnato all'attributo altezza del cestista in creazione
     * @throws EccezioneAltezza sollevata se altezza minore di 1.70
     */
    public void setAltezza(double altezza) throws EccezioneAltezza 
    {
        if(altezza<1.70)
            throw new EccezioneAltezza();
        this.altezza = altezza;
    }

    /**
     * toString del cestista
     * @return una stringa contenente valori degli attributi idCestista, nome, cognome, dataNascita, altezza separati da un ";"
     */
    @Override
    public String toString() 
    {
        return idCestista+";"+nome+";"+cognome+";"+dataNascita+";"+altezza;
    }
    
    /**
     * Ridefinizione del metodo equals
     * @param obj oggeto generico
     * @return true se gli attributi di s coincidono con quelli di this, altrimenti return false
     * 
     */
    @Override
    public boolean equals(Object obj)
    {
        Cestista cest;
        cest=(Cestista)obj;
        return((cest.getIDCestista()==idCestista)&&(cest.getNome()==nome)&&(cest.getCognome()==cognome)
                &&(cest.getDataNascita()==dataNascita)&&(cest.getAltezza()==altezza));
    }
    
    
    
    
    
    
}
