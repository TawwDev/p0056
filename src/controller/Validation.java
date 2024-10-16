
package controller;
import Model.Worker;
import java.util.List;
import java.util.Scanner;


public class Validation {
    // input value : int, double, id
    private static Scanner sc = new Scanner (System.in);
    
    public static int getInt(String msg, int min, int max){
        while(true){
            System.out.print(msg);
            try{
                int n = Integer.parseInt(sc.nextLine());
                if(n >= min && n <= max) return n;
            } catch(NumberFormatException nfe){
                System.out.println("Please enter an integer number in range: " + min + " to " + max);
            }
        }                
    }
    
    public static double getDouble(String msg, double min, double max){
        while(true){
            System.out.print(msg);
            try{
                double n = Double.parseDouble(sc.nextLine());
                if(n > min && n <= max) return n;
            } catch(NumberFormatException nfe){
                System.out.println("Please enter a real number in range: " + min + " to " + max);
            }
        }                
    }
    
    public static String getId (String msg, String err, List<Worker> wList, int mode){
        String s;
        while(true){
            System.out.print(msg);
            s = sc.nextLine();
            // mode 1: input - id not exits
            // mode 2: update - id must exits
            if(!s.isEmpty()){
                if( (mode == 1 && getWorker(s, wList) == null) || (mode == 2 && getWorker(s, wList) != null)){
                    break;
                }
            }
        }
        return s;
    }
    
    public static Worker getWorker(String id, List<Worker> wList){
        for(Worker w : wList){
            if(w.getId().equalsIgnoreCase(id)){
                return w;
            }
        }
        return null;
    }
    
}
