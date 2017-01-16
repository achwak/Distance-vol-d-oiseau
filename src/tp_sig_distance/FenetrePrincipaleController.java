/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_sig_distance;

import Calcul_Distance.Utilitaire;
import Entity.Latitude;
import Entity.Longitude;
import Entity.Region;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

/**
 *
 * @author walid y
 */
public class FenetrePrincipaleController implements Initializable {
    
                          
    @FXML private TextField Valeur_Rayon,Distance;
    @FXML private MenuButton Nord_A,Est_A,Nord_B,Est_B,Rayon_terre;
    @FXML private TextField degre_long_A,degre_lat_A,degre_long_B,degre_lat_B,min_long_A,min_lat_A,min_long_B,min_lat_B,seconde_long_A,seconde_lat_A,seconde_long_B,seconde_lat_B;
    
    
    
  //**********************************************************************************************************************//
  //**********************************************************************************************************************//
       
    @FXML private boolean IsDigit_Int(String val) {
        boolean isd=true;
        try{
            int v = Integer.parseInt(val);
        }
        catch(NumberFormatException e)
        {
            isd=false;
        }
        return isd;
    }
    
    @FXML private boolean IsDigit_Double(String val) {
        boolean isd=true;
        try{
            double v = Double.parseDouble(val);
        }
        catch(NumberFormatException e)
        {
            isd=false;
        }
        return isd;
    }
    
     
    @FXML private boolean Long_A_isValid() {
        
        return  (IsDigit_Int(degre_long_A.getText()) && IsDigit_Int(min_long_A.getText()) && IsDigit_Double(seconde_long_A.getText())) ;
    }
    
    @FXML private boolean Lat_A_isValid() {
        
        return  (IsDigit_Int(degre_lat_A.getText()) && IsDigit_Int(min_lat_A.getText()) && IsDigit_Double(seconde_lat_A.getText())) ;
    }
    
    @FXML private boolean Long_B_isValid() {
        
        return  (IsDigit_Int(degre_long_B.getText()) && IsDigit_Int(min_long_B.getText()) && IsDigit_Double(seconde_long_B.getText())) ;
    }
    
    @FXML private boolean Lat_B_isValid() {
        
        return  (IsDigit_Int(degre_lat_B.getText()) && IsDigit_Int(min_lat_B.getText()) && IsDigit_Double(seconde_lat_B.getText())) ;
    }
    @FXML private boolean Long_A_isEmpty() {
        
        return ((degre_long_A.getText().isEmpty()) && (min_long_A.getText().isEmpty()) && (seconde_long_A.getText().isEmpty())) ;
    }
    
    @FXML private boolean Lat_A_isEmpty() {
        
        return ((degre_lat_A.getText().isEmpty()) && (min_lat_A.getText().isEmpty()) && (seconde_lat_A.getText().isEmpty())) ;
    }
    
    @FXML private boolean Long_B_isEmpty() {
        
        return ((degre_long_B.getText().isEmpty()) && (min_long_B.getText().isEmpty()) && (seconde_long_B.getText().isEmpty())) ;
    }
    
    @FXML private boolean Lat_B_isEmpty() {
        
        return  ((degre_lat_B.getText().isEmpty()) && (min_lat_B.getText().isEmpty()) && (seconde_lat_B.getText().isEmpty())) ;
    }
    
    @FXML private boolean Long_Degre_isValide(int degre) {
        
        return  (degre <=180);
     }
    
    @FXML private boolean Lat_Degre_isValide(int degre) {
        
        return  (degre <=90);
     }
    @FXML private boolean min_isValide(int minute) {
        
        return  (minute <=60);
     }
   
    //**********************************************************************************************************************//
    //**********************************************************************************************************************//
    
    @FXML void afficheAlerte(String message) {
        Alert alerte = new Alert(Alert.AlertType.ERROR);
        alerte.setTitle("Message d'Erreur");
        alerte.setHeaderText("");
        alerte.setContentText(message);
        alerte.showAndWait();
        
    }
    
    @FXML private boolean verif_champ(){
        
        boolean verif=true;
        
        if(Long_A_isEmpty()) { 
            afficheAlerte("Les champs de la longitude du lieu A ne peuvent pas être vide !!");
            verif=false;
        }
        
        if(Lat_A_isEmpty()) { 
            afficheAlerte("Les champs de la latitude du lieu A ne peuvent pas être vide !!");
            verif=false;
        } 
        
        if(!Long_A_isValid()) { 
            afficheAlerte("Les champs ''Degré'' et ''Minute'' de la longitude du lieu A doivent être des ENTIERS et le champ ''Seconde'' un REEL!!");
            verif=false;
        }else // Le format est correcte ---> verifier si les valeurs sont acceptable
        {
            if (!Long_Degre_isValide(Integer.parseInt(degre_long_A.getText()))){
                afficheAlerte("la valeur des degrés dans la longitude du lieu A doit être < 180° !!");
                verif=false;
            }
            if (! min_isValide(Integer.parseInt(min_long_A.getText()))){
                afficheAlerte("la valeur des minutes dans la longitude du lieu A doit être < 60' !!");
                verif=false;
            }
        }
        
        if(!Lat_A_isValid()) { 
            afficheAlerte("Les champs ''Degré'' et ''Minute'' de la latitude du lieu A doivent être des ENTIERS et le champ ''Seconde'' un REEL!!");
            verif=false;
        }else // Le format est correcte ---> verifier si les valeurs sont acceptables
        {
            if (!Lat_Degre_isValide(Integer.parseInt(degre_lat_A.getText()))){
                afficheAlerte("la valeur des degrés dans la latitude du lieu A doit être < 90° !!");
                verif=false;
            }
            if (! min_isValide(Integer.parseInt(min_lat_A.getText()))){
                afficheAlerte("la valeur des minutes dans la latitude du lieu A doit être < 60' !!");
                verif=false;
            }
        }
        
        if(Long_B_isEmpty()) { 
            afficheAlerte("Les champs de la longitude du lieu B ne peuvent pas être vide !!");
            verif=false;
        }
        
        if(Lat_B_isEmpty()) { 
            afficheAlerte("Les champs de la latitude du lieu B ne peuvent pas être vide !!");
            verif=false;
        } 
        
        if(!Long_B_isValid()) { 
            afficheAlerte("Les champs ''Degré'' et ''Minute'' de la longitude du lieu B doivent être des ENTIERS et le champ ''Seconde'' un REEL!!");
            verif=false;
        }else // Le format est correcte ---> verifier si les valeurs sont acceptable
        {
            if (!Long_Degre_isValide(Integer.parseInt(degre_long_B.getText()))){
                afficheAlerte("la valeur des degrés dans la longitude du lieu B doit être < 180° !!");
                verif=false;
            }
            if (! min_isValide(Integer.parseInt(min_long_B.getText()))){
                afficheAlerte("la valeur des minutes dans la longitude du lieu B doit être < 60' !!");
                verif=false;
            }
        }
        
        if(!Lat_B_isValid()) { 
            afficheAlerte("Les champs ''Degré'' et ''Minute'' de la latitude du lieu B doivent être des ENTIERS et le champ ''Seconde'' un REEL!!");
            verif=false;
        }else // Le format est correcte ---> verifier si les valeurs sont acceptables
        {
            if (!Lat_Degre_isValide(Integer.parseInt(degre_lat_B.getText()))){
                afficheAlerte("la valeur des degrés dans la latitude du lieu B doit être < 90° !!");
                verif=false;
            }
            if (! min_isValide(Integer.parseInt(min_lat_B.getText()))){
                afficheAlerte("la valeur des minutes dans la latitude du lieu B doit être < 60' !!");
                verif=false;
            }
        }
        
        return verif;
    }
    
    // Traiter les signes des coordonnes en fonction du NORD,SUD,EST et OUEST
    @FXML void Couriger_Coordonnees(Longitude A , Latitude AA ,Longitude B,Latitude BB ) {
        
        if(Nord_A.getText().equals("S")) AA.invertDegre(); // On inverse la latitude
        if(Est_A.getText().equals("O")) A.invertDegre(); // On inverse la longitude
        if(Nord_B.getText().equals("S")) BB.invertDegre(); // On inverse la latitude
        if(Est_B.getText().equals("O")) B.invertDegre(); // On inverse la longitude
        
    }
  //**********************************************************************************************************************//
  //**********************************************************************************************************************//
      
    
    @FXML
    private void set_Nord_Sud(ActionEvent event) {
        MenuItem item = (MenuItem) event.getSource();
        Nord_A.setText(item.getText());
    }
    
    @FXML
    private void set_Est_Ouest_A(ActionEvent event) {
        MenuItem item = (MenuItem) event.getSource();
        Est_A.setText(item.getText());
    }
    
    @FXML
    private void set_Est_Ouest_B(ActionEvent event) {
        MenuItem item = (MenuItem) event.getSource();
        Est_B.setText(item.getText());
    }
    
    @FXML
    private void set_Nord_Sud_B(ActionEvent event) {
        MenuItem item = (MenuItem) event.getSource();
        Nord_B.setText(item.getText());
    }
    
     @FXML
    private void set_Rayon_terre(ActionEvent event) {
        MenuItem item = (MenuItem) event.getSource();
        Rayon_terre.setText(item.getText());
        Valeur_Rayon.setText(""+Utilitaire.getRayon_Selon_Type(item.getText()));
    }
    
    @FXML
    private void Calculer_Distance(ActionEvent event) {
        
     if(verif_champ())
     {
        Longitude longA = new Longitude(Integer.parseInt(degre_long_A.getText()), Integer.parseInt(min_long_A.getText()),Double.parseDouble(seconde_long_A.getText()));
        Longitude longB = new Longitude(Integer.parseInt(degre_long_B.getText()), Integer.parseInt(min_long_B.getText()),Double.parseDouble(seconde_long_B.getText()));
       
        Latitude latA = new Latitude(Integer.parseInt(degre_lat_A.getText()), Integer.parseInt(min_lat_A.getText()),Double.parseDouble(seconde_lat_A.getText()));
        Latitude latB = new Latitude(Integer.parseInt(degre_lat_B.getText()), Integer.parseInt(min_lat_B.getText()),Double.parseDouble(seconde_lat_B.getText()));
        
        Couriger_Coordonnees(longA, latA, longB, latB); // On courrige les coordonnées (prendre en considération le signe)
        
        Region A = new Region(longA,latA);
        Region B = new Region(longB, latB);
        
        Valeur_Rayon.setText(Double.toString(Utilitaire.getRayon_Selon_Type(Rayon_terre.getText())));
        Distance.setText(""+Utilitaire.calculer_distance(A, B, Double.parseDouble(Valeur_Rayon.getText())));
     }
     else{
         afficheAlerte(" Courigez les erreurs avant de continuer !!");
     }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
