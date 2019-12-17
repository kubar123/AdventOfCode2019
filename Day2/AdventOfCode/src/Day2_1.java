
import java.util.Arrays;
import sun.font.EAttribute;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jakub Rybicki <Jake at lansoftprogramming.com>
 */
public class Day2_1 {
    public static String programDataStr="1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,6,1,"
            + "19,1,19,5,23,2,9,23,27,1,5,27,31,1,5,31,35,1,35,13,39,1,39,9,43,"
            + "1,5,43,47,1,47,6,51,1,51,13,55,1,55,9,59,1,59,13,63,2,63,13,67,1,"
            + "67,10,71,1,71,6,75,2,10,75,79,2,10,79,83,1,5,83,87,2,6,87,91,1,"
            + "91,6,95,1,95,13,99,2,99,13,103,1,103,9,107,1,10,107,111,2,111,13"
            + ",115,1,10,115,119,1,10,119,123,2,13,123,127,2,6,127,131,1,13,131"
            + ",135,1,135,2,139,1,139,6,0,99,2,0,14,0";
    //public static String programDataStr="1,1,1,4,99,5,6,0,99";
    public static int[] programData;
    
    public static void main(String[] args){
        programData=parseData();
        //restore gravity assist to 1202 program alarm
        programData[1]=12;
        programData[2]=2;
        
        for(int i=0;i<programData.length;i+=4){
            //System.out.println(programData[i]);
            parseOpCode(programData[i],programData[i+1],programData[i+2],programData[i+3]);
            //programData[77]=334;
            System.out.println(Arrays.toString(programData));
        }
    }
    
    //converts a string seperated by commas into int[]
    public static int[] parseData(){
        int[] numbers = Arrays.stream(programDataStr.split(",")).mapToInt(Integer::parseInt).toArray();

        return numbers;
    }

    private static void parseOpCode(int opCode, int i1, int i2,int i3) {
        int a=0;
        if(opCode==1){   
            a=programData[i1]+programData[i2];
        }else if(opCode==2){
            a=programData[i1]*programData[i2];
        }else if(opCode==99){
            System.out.println(Arrays.toString(programData));
            System.exit(0);
        }
        
        else{
            return;
        }
        
        programData[i3]=a;
    }
}
