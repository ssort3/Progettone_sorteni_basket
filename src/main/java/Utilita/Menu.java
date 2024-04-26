/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilita;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Classe che rappresenta un menu
 * elencoVoci è un array di stringhe dove ogni stringa rappresenta una voce del menu
 * Ad ogni voce del menu è associato un valore intero. Alla prima voce è associato il valore 0,
 * alla seconda il valore 1 ecc...
 * Ad esempio:
 * 0-->Esci                 val. associato=0
 * 1-->Fai questa cosa      val. associato=1
 * 2-->Fai quest'altra cosa val. associato=2
 * ...
 * La classe consente di:
 *  -visualizzare le voci del menu
 *  -far scegliere all'utente una voce e restituire il val. associato alla voce scelta
 *  
 * @author Studente
 */
public class Menu 
{
    private String[] elencoVoci;
    private int numeroVoci;
    
    
    /**
     * Costruttore
     * @param elenco rappresenta l'elenco di voci di cui è costituito il menu
     */
    public Menu(String[] elenco)
    {
        numeroVoci=elenco.length;
        elencoVoci=new String[numeroVoci];
        for(int i=0;i<numeroVoci;i++)
        {
            elencoVoci[i]=elenco[i]; 
        }
    }
    
    /**
     * Permette all'utente di scegliere una voce del menu
     * I valori interi associati alle voci vanno da 0 al numero di voci-1
     * Il metodo controlla il valore di input inserito accettandolo solo se è un 
     * valore intero compreso fra 0 e numeroVoci-1
     * @return il valore intero associato alla voce scelta
     */
    public int sceltaMenu()
    {
        ConsoleInput tastiera=new ConsoleInput();
        //Scanner tastiera=new Scanner(System.in);
        int sceltaUtente=0;
        boolean sceltaOK;
        
        do
        {
            sceltaOK=true;
            visualizzaMenu();
            System.out.print("Scegli-->");
            try 
            {
                sceltaUtente=tastiera.readInt();
                if(sceltaUtente<0||sceltaUtente>numeroVoci-1)
                {
                    sceltaOK=false;
                    System.out.println("La voce scelta non esiste");
                }
                           
            } 
            catch (IOException ex) 
            {
                System.out.println("Impossibile leggere da tastiera");
            } 
            catch (NumberFormatException ex) 
            {
                System.out.println("Formato input non corretto");
                sceltaOK=false;
            }
                
        }while(!sceltaOK);
        return sceltaUtente;
          
    }
    
    /**
     * Mostra le voci del menu con il loro valore associato
     */
    public void visualizzaMenu()
    {
        for(int i=0;i<numeroVoci;i++)
        {
            System.out.println("("+i+")"+elencoVoci[i]);
        }
    }
}
