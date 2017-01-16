/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Calcul_Distance;

import Entity.*;


public class Utilitaire {
    
    
    public static double calculer_distance(Region A,Region B,double rayon_terre) {
        
        double distance = 0;
        
        double dalta_degre_longitude = Math.toRadians(B.getLongitude().getDegre_total() - A.getLongitude().getDegre_total()); // On calcule la différence entre les deux longitudes en "radian"
        
        // Transformer les degrés de la latitude des deux lieux en "radian"
        
        
        double lat_A_radian = (A.getLatitude().getDegre_total())*Math.PI/180;
        double lat_B_radian = (B.getLatitude().getDegre_total())*Math.PI/180;
        
        double produit_sin_lat =  Math.sin(lat_A_radian) * Math.sin(lat_B_radian); 
        double produit_cos_lat = Math.cos(lat_A_radian) * Math.cos(lat_B_radian);
        
        
        distance = Math.acos(produit_sin_lat + (produit_cos_lat * Math.cos(dalta_degre_longitude)))* rayon_terre; // On calcule la distance en KM
       
        // distance = ( (int) (distance*1000000))/1000000 ; // pour arrondir à 6 chiffres après la virgule
        
        return distance;
    } 
    
    public static double transformer_DMS_DEGRE(int degre,int minute, double seconde,boolean isnegatif) {
        double degre_total = 0.0f;
        
        if(isnegatif) // c'est une valeur negative 
        {
        degre_total = (-1)*((degre) + (minute + (seconde /60))/60); // convertir de DMS à degré
        }
        else degre_total = degre + (minute + (seconde /60))/60; // convertir de DMS à degré
        
        return degre_total;
    }
    
    public static double getRayon_Selon_Type(String ellipsoide) {
        
        double rayon=0;
    if(ellipsoide.equals("Par défault")) rayon=6378.000;
    else
      {
        if(ellipsoide.equalsIgnoreCase("Clarke 1866")) rayon=6378.2064;
        else 
        {
            if (ellipsoide.equals("Clarke 1880")) rayon=6378.249145;
            else 
            {
                if (ellipsoide.equalsIgnoreCase("Everest India")) rayon=6377.276345;
                else {
                    if (ellipsoide.equals("WGS 72")) rayon=6378.135;
                    else
                    {
                        if (ellipsoide.equals("WGS 84")) rayon=6378.137;
                    }
                }
            }
        }
        }
        return rayon;
    }
    
    
}
