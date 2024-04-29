/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilita;

import com.mycompany.progettone_basket.Cestista;

/**
 * Classe che contiene metodi statici per ordinare dei vettori
 * 
 * @author Studente
 */
public class Ordinatore 
{
    /**
     * Scambia fra di loro gli elementi in posizione "pos1" e "pos2" di un array "v" di interi
     * @param v array che contiene gli elementi da scambiare
     * @param pos1 la posizione del primo elemento
     * @param pos2 la posizione del secondo elemento
     */
    public static void scambia(int[] v, int pos1, int pos2)
    {
        int sost;
        if(v==null)
            return;
        if(v.length==0)
            return;
        if(pos1<0||pos2<0||pos1>=v.length||pos2>=v.length)
            return;
        sost=v[pos1];
        v[pos1]=v[pos2];
        v[pos2]=sost;
        
    }
    
    /**
     * Scambia fra di loro gli elementi in posizione "pos1" e "pos2" di un array "v" di stringhe
     * @param v array che contiene gli elementi da scambiare
     * @param pos1 la posizione del primo elemento
     * @param pos2 la posizione del secondo elemento
     */
    public static void scambia(String[] v, int pos1, int pos2)
    {
        String sost=v[pos1];
        v[pos1]=v[pos2];
        v[pos2]=sost;
        
    }
    
    public static void scambiaCestista(Cestista[] v, int pos1, int pos2)
    {
        Cestista sost=v[pos1];
        v[pos1]=v[pos2];
        v[pos2]=sost;
        
    }
    
    /**
     * Restituisce una copia ordinata in ordine crescente di un array "v" di interi
     * secondo l'arlgoritmo selection sort
     * @param v vettore da ordinare
     * @return una copia del vettore in ordine crescente
     */
    public static int[] selectionSortCrescente(int[] v)
    {
        int lunghezza=v.length;
        //creo una copia di "v" e lo chiamo "vOrdinato"
        int[] vOrdinato=new int[lunghezza];
        for(int i=0;i<lunghezza;i++)
        {
            vOrdinato[i]=v[i];
        }
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if(vOrdinato[j]<vOrdinato[i])
                    scambia(vOrdinato,i,j);
            }
        }
        return vOrdinato;
    }
    
    /**
     * Restituisce una copia ordinata in ordine decrescente di un array "v" di interi
     * secondo l'arlgoritmo selection sort
     * @param v vettore da ordinare
     * @return una copia del vettore in ordine decrescente
     */
    public static int[] selectionSortDecrescente(int[] v)
    {
        int lunghezza=v.length;
        //creo una copia di "v" e lo chiamo "vOrdinato"
        int[] vOrdinato=new int[lunghezza];
        for(int i=0;i<lunghezza;i++)
        {
            vOrdinato[i]=v[i];
        }
        
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if(vOrdinato[j]>vOrdinato[i])
                    scambia(vOrdinato,i,j);
            }
        }
        return vOrdinato;
    }
    
    /**
     * Restituisce una copia ordinata in ordine alfabetico di un array "v" di stringhe
     * secondo l'arlgoritmo selection sort
     * @param v vettore da ordinare
     * @return una copia del vettore in ordine alfabetico
     */
    public static String[] selectionSortCrescente(String[] v)
    {
        int lunghezza=v.length;
        //creo una copia di "v" e lo chiamo "vOrdinato"
        String[] vOrdinato=new String[lunghezza];
        for(int i=0;i<lunghezza;i++)
        {
            vOrdinato[i]=v[i];
        }
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if(vOrdinato[i].compareToIgnoreCase(vOrdinato[j])>0)
                    scambia(vOrdinato,i,j);
            }
        }
        return vOrdinato;
    }
    
    /**
     * Restituisce una copia ordinata in ordine alfabetico inverso di un array "v" di stringhe
     * secondo l'arlgoritmo selection sort
     * @param v vettore da ordinare
     * @return una copia del vettore in ordine alfabetico inverso
     */
    public static String[] selectionSortDecrescente(String[] v)
    {
        int lunghezza=v.length;
        //creo una copia di "v" e lo chiamo "vOrdinato"
        String[] vOrdinato=new String[lunghezza];
        for(int i=0;i<lunghezza;i++)
        {
            vOrdinato[i]=v[i];
        }
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if(vOrdinato[i].compareToIgnoreCase(vOrdinato[j])<0)
                    scambia(vOrdinato,i,j);
            }
        }
        return vOrdinato;
    }
    
    /**
     * Restituisce una copia ordinata in ordine crescente di un array "v" di interi
     * secondo l'arlgoritmo bubble sort
     * @param v vettore da ordinare
     * @return una copia del vettore in ordine crescente
     */
    public static int[] bubbleSortCrescente(int[] v)
    {
        int lunghezza=v.length;
        //creo una copia di "v" e lo chiamo "vOrdinato"
        int[] vOrdinato=new int[lunghezza];
        for(int i=0;i<lunghezza;i++)
        {
            vOrdinato[i]=v[i];
        }
        
        boolean scambio=false;
        do
        {
            scambio=false;
            for(int i=0;i<lunghezza-1;i++)
            {
               if(vOrdinato[i]>vOrdinato[i+1])
               {
                   scambia(vOrdinato,i,i+1);
                   scambio=true;
               }
            }  
        }while(scambio==true);
        return vOrdinato;
    }
    
    /**
     * Restituisce una copia ordinata in ordine decrescente di un array "v" di interi
     * secondo l'arlgoritmo bubble sort
     * @param v vettore da ordinare
     * @return una copia del vettore in ordine decrescente
     */
    public static int[] bubbleSortDecrescente(int[] v)
    {
        int lunghezza=v.length;
        //creo una copia di "v" e lo chiamo "vOrdinato"
        int[] vOrdinato=new int[lunghezza];
        for(int i=0;i<lunghezza;i++)
        {
            vOrdinato[i]=v[i];
        }
        
        boolean scambio=false;
        do
        {
            scambio=false;
            for(int i=0;i<lunghezza-1;i++)
            {
               if(vOrdinato[i]<vOrdinato[i+1])
               {
                   scambia(vOrdinato,i,i+1);
                   scambio=true;
               }
            }  
        }while(scambio==true);
        return vOrdinato;
    }
    
    /**
     * Restituisce una copia ordinata in ordine alfabetico di un array "v" di stringhe
     * secondo l'arlgoritmo bubble sort
     * @param v vettore da ordinare
     * @return una copia del vettore in ordine alfabetico
     */
    public static String[] bubbleSortCrescente(String[] v)
    {
        int lunghezza=v.length;
        //creo una copia di "v" e lo chiamo "vOrdinato"
        String[] vOrdinato=new String[lunghezza];
        for(int i=0;i<lunghezza;i++)
        {
            vOrdinato[i]=v[i];
        }
        
        boolean scambio=false;
        do
        {
            scambio=false;
            for(int i=0;i<lunghezza-1;i++)
            {
               if(vOrdinato[i].compareToIgnoreCase(vOrdinato[i+1])>0)
               {
                   scambia(vOrdinato,i,i+1);
                   scambio=true;
               }
            }  
        }while(scambio);
        return vOrdinato;
    }
    
    /**
     * Restituisce una copia ordinata in ordine alfabetico inverso di un array "v" di stringhe
     * secondo l'arlgoritmo bubble sort
     * @param v vettore da ordinare
     * @return una copia del vettore in ordine alfabetico inverso
     */
    public static String[] bubbleSortDecrescente(String[] v)
    {
        int lunghezza=v.length;
        //creo una copia di "v" e lo chiamo "vOrdinato"
        String[] vOrdinato=new String[lunghezza];
        for(int i=0;i<lunghezza;i++)
        {
            vOrdinato[i]=v[i];
        }
        
        boolean scambio=false;
        do
        {
            scambio=false;
            for(int i=0;i<lunghezza-1;i++)
            {
               if(vOrdinato[i].compareToIgnoreCase(vOrdinato[i+1])<0)
               {
                   scambia(vOrdinato,i,i+1);
                   scambio=true;
               }
            }  
        }while(scambio==true);
        return vOrdinato;
    }
}