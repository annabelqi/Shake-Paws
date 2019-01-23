/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teamproject;

public class Bird extends Animal {

    public Bird(String nameString, String ga, String sa) {
        super(nameString, ga); // calling the superclass contructor, inherites all the general attributes of an Animal
        type = "bird";
        specificAttributes = new Attributes[5]; // setting size for specific attributes
        setSpecificAttributes(sa); // loading bird-specific attributes into the array
        setSpeciesAttributes("Bird Attributes:budget-100,cost per month-25,size-small,maintenance-low,space needed-low,lifspan-3,sheds-no");
    }
}
