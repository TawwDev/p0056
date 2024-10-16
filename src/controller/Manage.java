
package controller;

import Model.SalaryHistory;
import Model.Worker;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manage {
    private Scanner sc = new Scanner (System.in);
    private List<Worker> wList;
    private List<SalaryHistory> shList;
    private static double epsi = 0.00001;
    
    public Manage() {
        wList = new ArrayList<>();
        shList = new ArrayList<>();
    }
    
    public void addWorker(){
        String id, name , workLocation;
        int age;
        double salary;
        
        id = Validation.getCode("Enter worker id: ", "Id should be unique and not null" , wList, 1);
        System.out.println("Enter worker name: ");
        name = sc.nextLine();
        age = Validation.getInt("Enter age: ", 18, 50);
        salary = Validation.getDouble("Enter Salary: ", epsi, Double.MAX_VALUE);
        
        System.out.println("Enter work location: ");
        workLocation = sc.nextLine();
        
        wList.add(new Worker(id, name, age, salary, workLocation));
    }
    
    public void updateSalary(int mode){
        String id = Validation.getCode("Enter worker id to be updated: ", "Id must exist in database and not null", wList, 2);
        double money = Validation.getDouble("Enter Salary: ", epsi, Double.MAX_VALUE);
        
        Worker o = Validation.getWorker(id, wList);
        double update = 0;
        String status ="";
        if(mode == 1){
            status = "UP";
            update = o.getSalary() + money;
        } else if(mode == 2){
            status = "DOWN";
            if(o.getSalary() > money){
                update = o.getSalary() - money;
            }
        } 
        o.setSalary(update);       
        shList.add(new SalaryHistory(id, o.getName(), o.getAge(), o.getSalary(), status, LocalDate.now()));
    }
    
    public void getInformation(){
        display(shList);
    }
    
    private void displayAll(){
        display(shList);
    }
    
    private void display(List list){
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
