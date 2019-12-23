
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jakub Rybicki <Jake at lansoftprogramming.com>
 */
public class Day4_2 {

    

    

    
    int differentPassCount;
    public static int[] passArray;
    public static int totalCount;
    
    public static int MIN=372304;
    public static int MAX =847060;
    public static int curr=0;
    public static void main(String[] args){
        totalCount=0;
        for(curr=MIN;curr<=MAX;curr++){
            isPasswordDifferent(curr);
       //     System.out.println(curr);
        }
        System.out.println("CALCULATION FINISHED: "+totalCount);
        //while()
        //isPasswordDifferent(113444);

    }
    private static void isPasswordDifferent(int pass) {
        //convert int into int[]
        String[] a=Integer.toString(pass).split("");
        passArray=new int[a.length];
        for(int i=0;i<a.length;i++){
            passArray[i]=Integer.parseInt(a[i]);
        }
        
        
        //must be 6 digits
        boolean isCorrectSize=isCorrectSize();
        //some adj. numbers must be same
        boolean isAnyAdjNoSame=isCorrectAdjNo();
        
        boolean isNoNotIncreasing=isNoNotIncreasing();
        
       // System.out.println("Above 6 digits: "+isCorrectSize);
        //System.out.println("Adj numbers: "+isAnyAdjNoSame);
        //System.out.println("Numbers Never increase: "+isNoNotIncreasing);
        //System.out.println(passArray.length);
        
        
        if(isCorrectSize&&isAnyAdjNoSame&&isNoNotIncreasing)
            totalCount++;
        
        
        //System.out.println("Sameno: "+sameNo);
        //System.out.println("neverLessNo: "+neverLessNo);

    }
    
    public static boolean isCorrectSize(){
        if(passArray.length!=6){
            System.out.println("NUMBER BELOW 6");
            return false;
        }else{
            return true;
        }
    }
    
    private static boolean isCorrectAdjNo() {
        boolean sameNo=false;
        List<Integer> results=new ArrayList<>();
        //2 adjecent numbers are same
        try{
            for(int i=0;i<passArray.length;i++){
                //first item
                if(i==0){
                    if(passArray[i]==passArray[i+1]){
                        if(passArray[i]!=passArray[i+2])
                            sameNo=true;
                    }
                    
                }else if(i==1||i==2||i==3){
                    if(passArray[i]==passArray[i+1]){
                        if(passArray[i]!=passArray[i+2]){
                            if(passArray[i]!=passArray[i-1]){
                                sameNo=true;
                            }
                        }
                    }
                }else if(i==4){
                    if(passArray[i]==passArray[i+1]){
                        if(passArray[i]!=passArray[i-1]){
                            sameNo=true;
                        }
                    }
            
            }
            }
              
       }catch(Exception e){
            System.out.println(results.toString());
            System.out.println(e.toString());
        }
        //make sure there is no mroe than 2 adj. numbers in a row.
        
        return sameNo;
    }
    
    private static boolean isNoNotIncreasing() {
        boolean neverLessNo=true;
        for(int i=0;i<passArray.length;i++){
            //digits NEVER decrease (left to right)
            if(i<passArray.length-1){
                if(passArray[i]>passArray[i+1])
                    neverLessNo=false;
            }   
        }
        return neverLessNo;
    }
    //find the password
}
