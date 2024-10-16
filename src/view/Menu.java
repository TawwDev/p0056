
package view;

import controller.Manage;
import controller.Validation;
import java.util.Scanner;


public class Menu {
    private static String [] ops = {
        "Add worker", 
        "UP salary",
        "Down salary",
        "Display Information salary",
        "Exit"
    };
    
    private static int getChoice(){
        Scanner sc = new Scanner (System.in);
        for(int i =0 ; i< ops.length; i++){
            System.out.println((i+1) + ". " + ops[i]);
        }
        return Validation.getInt("Your choice: ", 1, ops.length);
    }
    
    public static void display(){
        Manage m = new Manage();
        int choice;
        do{
            System.out.println("======== Worker Management =========");
            choice = getChoice();
            switch(choice){
                case 1: 
                    m.addWorker();
                    break;
                case 2:
                    m.updateSalary(1);
                    break;
                case 3: 
                    m.updateSalary(2);
                    break;
                case 4:
                    m.getInformation();
                    break;
                case 5:
                    break;
            }
        } while (choice != 5);   
    }
}
