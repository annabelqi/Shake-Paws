/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teamproject;

public class Dog extends Animal {


    public Dog(String nameString, String ga, String sa) {
        super(nameString, ga); // calling the superclass contructor, inherites all the general attributes of an Animal
        type = "dog";
        specificAttributes = new Attributes[7]; // setting size for specific attributes
        setSpecificAttributes(sa); // loading dog-specific attributes into the array
        setSpeciesAttributes("Dog Attributes:budget-300,cost per month-150,size-big,maintenance level-high,space needed-high,lifespan-8,sheds-yes");

    }
}
