/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Calcul_Distance.Utilitaire;


public class Longitude {
    
    private int degre;
    private int minute;
    private double seconde;
    private double degre_total;
    private boolean isnegatif;

    public Longitude(int degre, int minute, double seconde) {
        this.degre = degre;
        this.minute = minute;
        this.seconde = seconde;
        this.degre_total = Utilitaire.transformer_DMS_DEGRE(degre, minute, seconde,isnegatif);
        isnegatif=false;
    }

    
    public Longitude() {
         this.degre = 0;
        this.minute = 0;
        this.seconde = 0.0f;
         this.degre_total = 0.0f;
         isnegatif=false;
    }

    

    public int getDegre() {
        return degre;
    }

    public void setDegre(int degre) {
        this.degre = degre;
    }


    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public double getSeconde() {
        return seconde;
    }

    public void setSeconde(double seconde) {
        this.seconde = seconde;
    }

    public double getDegre_total() {
        return degre_total;
    }

    public void setDegre_total(double degre_total) {
        this.degre_total = degre_total;
    }
    
    public void invertDegre()
    {
       isnegatif=true;
       this.degre_total = Utilitaire.transformer_DMS_DEGRE(degre, minute, seconde,isnegatif);
    }
    
    
}
