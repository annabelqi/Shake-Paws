/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teamproject;


public class Attributes {
    String description;
    String value;
    
    public Attributes(String d, String v){
        description = d;
        value = v;
    }
    
    public void printInfo(){
        System.out.println(description + ": " + value);
    }
}