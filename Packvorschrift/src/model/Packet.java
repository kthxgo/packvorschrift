/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author kthxgo
 */
public class Packet {
    
    private String name;
    private int id;
    private double width;
    private double height;
    private String coolness;
    private boolean hotiness;
    
    public Packet() {
        
    }
    
    public Packet(String name, int id, double width, double height, 
            String coolness, boolean hotiness) {
        this.name = name;
        this.id = id;
        this.width = width;
        this.height = height;
        this.coolness = coolness;
        this.hotiness = hotiness;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @return the coolness
     */
    public String getCoolness() {
        return coolness;
    }

    /**
     * @param coolness the coolness to set
     */
    public void setCoolness(String coolness) {
        this.coolness = coolness;
    }

    /**
     * @return the hotiness
     */
    public boolean getHotiness() {
        return hotiness;
    }

    /**
     * @param hotiness the hotiness to set
     */
    public void setHotiness(boolean hotiness) {
        this.hotiness = hotiness;
    }
    
    
    
}
