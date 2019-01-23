/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teamproject;


public class Animal {
    String name, type;
    Attributes [] speciesAttributes = new Attributes[7]; // array of attributes that are the same for each species (Dogs, Cats, etc)
    Attributes [] generalAttributes = new Attributes[7]; //max 9 general attributes for each animal
    Attributes [] specificAttributes; // this array is a different size for each type of animal
    int compatibility;
    
    
    public Animal(String nameString, String ga){
        this.name = getNameFromNameString(nameString);
        setGeneralAttributes(ga);
        compatibility = 0;
    }
    
    public void resetCompatibility(){
        compatibility = 0;
    }
    
    private void setGeneralAttributes(String ga){
        loadAttributesFromString( removeLabel(ga), this.generalAttributes);
    }
    
    public void setSpecificAttributes(String sa){
        loadAttributesFromString( removeLabel(sa), this.specificAttributes);
    }
    
    public void setSpeciesAttributes(String spa){ // will only ever be called in subclass constructors
        loadAttributesFromString( removeLabel(spa), this.speciesAttributes);
    }
    
    public static String getNameFromNameString(String ns){
        return ns.substring(ns.indexOf(" ") + 1);
    }
    
    public static String getAttribute(String d, Attributes [] array){
        for (int i = 0; i < array.length; i++){
            if (array[i].description.equals(d)){
                return array[i].value;
            }
        }
        return "";
    }

    public static String removeLabel(String s) {
          return s.substring(s.indexOf(":") + 1); //removing the label
    }
    
    public void printInfo(){
        System.out.println(type + " " + name);
        System.out.println("General Attributes:");
        for (int i = 0; i < generalAttributes.length; i++){
            generalAttributes[i].printInfo();
        }
        System.out.println("Specific Attributes:");
        for (int i = 0; i < specificAttributes.length; i++){
            specificAttributes[i].printInfo();
        }
        
        System.out.println("Species Attributes:");
        for (int i = 0; i < speciesAttributes.length; i++){
            System.out.println(speciesAttributes[i].description + ": " + speciesAttributes[i].value);
        }
        System.out.println("");
        
    }
    
    public static void loadAttributesFromString(String s, Attributes [] array){
        int commaIndex, spaceIndex, i;
        
        i = 0;
        while (s.length()>0){
            commaIndex = s.indexOf(",");
            spaceIndex = s.indexOf("-");
            
            if (commaIndex == -1){
                array[i] = new Attributes( (s.substring(0, spaceIndex)), (s.substring(spaceIndex+1)) );
                break;
                
            } else {
                array[i] = new Attributes( (s.substring(0, spaceIndex)), (s.substring(spaceIndex+1, commaIndex)) );
                s = s.substring(commaIndex+1);
            }
            
            i++;
        }
        
    }

}