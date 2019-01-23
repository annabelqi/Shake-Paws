
package teamproject;

public class Question {
    String description;
    String [] answers;
    int numAnswers;
    
    public Question(String d, String a){
        description = d;
        answers = new String[20]; // excessive size
        loadAnswersFromString(a);
        
    }
    
    public void loadAnswersFromString( String a ){
        numAnswers = 0;
        int commaIndex;
        
        while (a.length()>0){
            commaIndex = a.indexOf(",");
            if (commaIndex == -1){
                answers[numAnswers] = a;
                a = a.substring(a.length());
            } else {
                answers[numAnswers] = a.substring(0, commaIndex);
                a = a.substring(commaIndex + 1);
                
            }
            numAnswers++;
        }
        
    }
}
