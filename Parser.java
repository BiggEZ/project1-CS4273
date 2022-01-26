import java.io.*;

public class Parser{
    private static String[] en = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static String[] es = {"a", "b", "c", "ch", "d", "e", "f", "g", "h", "i", "j", "k", "l", "ll", "m", "n", "\u00F1", "o", "p", "q", "r", "rr", "s", "t", "u", "v", "w", "x", "y", "z"};
    public static void main(String[] args){
        
        readFile("en");
        readFile("es");
    }
    
    public static boolean readFile(String mode){
        BufferedReader reader = null;
        Boolean test = false;
        String[] alphabet = null;
        
        try {
            String line = "";
            reader =  new BufferedReader(new FileReader(mode + ".csv"));
            
            while ((line = reader.readLine()) != null) {
                alphabet = line.split(",");
            }
            
            test = validate(mode, alphabet);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        return test;
    }
    
    public static boolean validate(String mode, String[] input){
        String[] test;
        
        switch (mode){
            case "en":
                test = en;
                break;
            case "es":
                test = es;
                break;
            default:
                return false;
        }
        
        for (int i = 0; i < input.length; i++)
        {
            if (!input[i].equals(test[i])) {
                return false;
            }
        }
 
        return true;
    }
}