/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


public class Region {
    
    private Longitude longitude;
    private Latitude latitude;

    public Region(Longitude longitude, Latitude latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Region() {
        this.longitude = new Longitude();
        this.latitude = new Latitude();
    }

    public Longitude getLongitude() {
        return longitude;
    }

    public void setLongitude(Longitude longitude) {
        this.longitude = longitude;
    }

    public Latitude getLatitude() {
        return latitude;
    }

    public void setLatitude(Latitude latitude) {
        this.latitude = latitude;
    }
    
    

}
