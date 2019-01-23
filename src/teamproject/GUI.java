/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teamproject;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;


public class GUI extends javax.swing.JFrame {
    boolean buttonPressed;
    String compatibleType;
    Animal compatibleAnimal;
    Animal[] allAnimals;
    int numAnimals;
    
    Question [] generalQuestions;
    Question [] dogQuestions;
    Question [] catQuestions;
    Question [] birdQuestions;
    Question [] fishQuestions;

    
    public GUI() throws IOException {
        initComponents();
        buttonPressed = false;
        compatibleType = "";
        allAnimals = new Animal[100]; // maximum 100 animals can be handled by the program
        compatibleAnimal = allAnimals[0];
        numAnimals = 0;    
        
        //setting sizes of arrays of questions
        generalQuestions = new Question[7];
        dogQuestions = new Question[6];
        catQuestions = new Question[5];
        birdQuestions = new Question[5];
        fishQuestions = new Question[4];
        
        //loading questions into array
        loadAnimals("AnimalInventory.txt");
        loadQuestions("generalQuestions.txt", generalQuestions);
        loadQuestions("dogQuestions.txt", dogQuestions);
        loadQuestions("catQuestions.txt", catQuestions);
        loadQuestions("birdQuestions.txt", birdQuestions);
        loadQuestions("fishQuestions.txt", fishQuestions);

    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        questionLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        submitButton = new javax.swing.JButton();
        choiceBox = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        textBox = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        questionLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        questionLabel.setText("Question");
        getContentPane().add(questionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 770, 50));

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        choiceBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Yes", "No" }));
        choiceBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choiceBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(choiceBox, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150)
                .addComponent(submitButton)
                .addContainerGap(153, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choiceBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitButton))
                .addGap(30, 30, 30))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 530, -1));

        textBox.setColumns(20);
        textBox.setRows(5);
        jScrollPane2.setViewportView(textBox);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 560, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        buttonPressed = true;
    }//GEN-LAST:event_submitButtonActionPerformed

    private void choiceBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choiceBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_choiceBoxActionPerformed

    public void loadQuestions(String fileName, Question [] qArray) throws IOException {
        FileReader f = new FileReader(fileName);
        Scanner s = new Scanner(f);
        String questionLine, answerLine;
        int i = 0;
        while (s.hasNext()) {
            questionLine = s.nextLine();
            answerLine = s.nextLine();
            qArray[i] = new Question(questionLine, answerLine);
            i++;
        }
    }
    
    public void loadAnimals(String fileName) throws IOException {
        FileReader f = new FileReader(fileName);
        Scanner s = new Scanner(f);
        String nameLine, ga, sa, emptyLine;

        while (s.hasNext()) {
            nameLine = s.nextLine();
            ga = s.nextLine();
            sa = s.nextLine();
            emptyLine = s.nextLine();

            switch (nameLine.substring(0, nameLine.indexOf(" "))) {
                case "Dog":
                    allAnimals[numAnimals] = new Dog(nameLine, ga, sa);
                    break;
                case "Cat":
                    allAnimals[numAnimals] = new Cat(nameLine, ga, sa);
                    break;
                case "Fish":
                    allAnimals[numAnimals] = new Fish(nameLine, ga, sa);
                    break;
                case "Bird":
                    allAnimals[numAnimals] = new Bird(nameLine, ga, sa);
                    break;
            }

            numAnimals++;
        }
    }
    
    public void printNames() {
        for (int i = 0; i < numAnimals; i++) {
            System.out.println(allAnimals[i].name);
        }
        System.out.println("");
    }
    
    public void printAllInfo(){
        for (int i = 0; i < numAnimals; i++) {
            allAnimals[i].printInfo();
        }
    }
    
    public void matchSpecies(){
        textBox.hide();
        int mostCompatible = 0;
        String answer;
        for (int i = 0; i < generalQuestions.length; i++){
            buttonPressed = false;
            
            // formatting the GUI display to match the question being asked
            questionLabel.setText(generalQuestions[i].description );
            choiceBox.removeAllItems();
            for (int j = 0; j < generalQuestions[i].numAnswers; j++){
                choiceBox.addItem(generalQuestions[i].answers[j]);
            }
            
            // waiting for the user to press the submit button
            while (buttonPressed == false){
                try {
                    Thread.sleep(200);
                } 
                catch (Exception e) {}
            }
            
            answer = choiceBox.getSelectedItem().toString(); // saves the option the user selected
            
            // updating each animal's compatibility rating
            for (int j = 0; j < numAnimals; j++){
                System.out.println(allAnimals[j].name +  allAnimals[j].speciesAttributes[i].value + answer);
                
                if (allAnimals[j].speciesAttributes[i].value.equalsIgnoreCase(answer)){
                    allAnimals[j].compatibility++;
                    System.out.println("upped");
                    
                }
            }
        }
        
        // returning the best species for the user
        for (int j = 0; j < numAnimals; j++){
            
            if (allAnimals[j].compatibility>mostCompatible){
                mostCompatible = allAnimals[j].compatibility;
                compatibleType = allAnimals[j].type;
            }
        }
        
    }
    
   
    public void displayType(){

        buttonPressed = false;
        questionLabel.setText("Based on your answers, we think you should get a " + compatibleType + ".");
        submitButton.setText("Next");
        choiceBox.hide();
        
         while (buttonPressed == false){
                try {
                    Thread.sleep(200);
                } 
                catch (Exception e) {}
            }
    }
    
    
    public void matcheSpecificAnimal(){
        int mostCompatible = 0;
        String answer;
        Question [] qArray;
        
        submitButton.setText("Submit");
        choiceBox.show();
        
        if (compatibleType.equalsIgnoreCase("dog")){
                            qArray = dogQuestions;
        } else if (compatibleType.equalsIgnoreCase("fish")){
                qArray = fishQuestions;
        } else if (compatibleType.equalsIgnoreCase("cat")){
                qArray = catQuestions;
        } else {
            qArray = birdQuestions;
        }
        
        for (int i = 0; i < qArray.length; i++){
            buttonPressed = false;
            
            // formatting the GUI display to match the question being asked
            questionLabel.setText(qArray[i].description );
            choiceBox.removeAllItems();
            for (int j = 0; j < qArray[i].numAnswers; j++){
                choiceBox.addItem(qArray[i].answers[j]);
            }
            
            // waiting for the user to press the submit button
            while (buttonPressed == false){
                try {
                    Thread.sleep(200);
                } 
                catch (Exception e) {}
            }
            
            answer = choiceBox.getSelectedItem().toString(); // saves the option the user selected
            
            // updating each animal's compatibility rating
            for (int j = 0; j < numAnimals; j++){
                if (allAnimals[j].type.equalsIgnoreCase(compatibleType) && allAnimals[j].specificAttributes[i].value.equalsIgnoreCase(answer)){
                    allAnimals[j].compatibility++;
                }
            }
        }
        
        // returning the best animal for the user
        for (int j = 0; j < numAnimals; j++){
            if (allAnimals[j].compatibility>mostCompatible){
                mostCompatible = allAnimals[j].compatibility;
                compatibleAnimal = allAnimals[j];
            }
        }
        System.out.println(compatibleAnimal.name);
    }
    
    public void displayResult(){
        choiceBox.hide();
        submitButton.hide();
        questionLabel.setText("You are best matched with " + compatibleAnimal.name);
        textBox.show();
        
        textBox.setText( "Here is some information about your match: \n" + "type: " + compatibleAnimal.type);
        for (int i = 0; i < compatibleAnimal.generalAttributes.length; i++){
            textBox.append("\n" + compatibleAnimal.generalAttributes[i].description + ": " + compatibleAnimal.generalAttributes[i].value);
        }
   
    }
    
    public static void main(String args[]) throws IOException {
        final GUI tp = new GUI();
;
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                tp.setVisible(true);
            }
        });
        
        tp.matchSpecies();
        tp.displayType();
        tp.matcheSpecificAnimal();
        tp.displayResult();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox choiceBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextArea textBox;
    // End of variables declaration//GEN-END:variables


}
