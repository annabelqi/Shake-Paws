/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teamproject;

public class Cat extends Animal {


    public Cat(String nameString, String ga, String sa) {
        super(nameString, ga); // calling the superclass contructor, inherites all the general attributes of an Animal
        type = "cat";
        specificAttributes = new Attributes[5]; // setting size for specific attributes
        setSpecificAttributes(sa); // loading cat-specific attributes into the array
        setSpeciesAttributes("Cat Attributes:budget-200,cost per month-150,size-big,maintenance-high,space needed-high,lifespan-10,sheds-yes");

    }
}
