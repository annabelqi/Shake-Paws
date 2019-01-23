/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teamproject;

public class Fish extends Animal {


    public Fish(String nameString, String ga, String sa) {
        super(nameString, ga); // calling the superclass contructor, inherites all the general attributes of an Animal
        type = "fish";
        specificAttributes = new Attributes[4]; // setting size for specific attributes
        setSpecificAttributes(sa); // loading fish-specific attributes into the array
        setSpeciesAttributes("Fish Attributes:budget-100,cost per month-50,size-small,maintenance-low,space needed-low,lifspan-3,sheds-no");

    }
}
