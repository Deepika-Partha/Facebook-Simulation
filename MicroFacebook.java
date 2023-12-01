import java.util.*;
import java.io.*;
import java.util.Scanner;

public class MicroFacebook 
{
   
   public static HashMap <String, String> p = new HashMap <String,String>();
   public static String name1 = "";
   public static String name2 = "";
   
   public static void main (String [] args)
   {
      getInput();
   }
   
   public static void getInput()
   {
      Scanner ScannerInput = new Scanner(System.in);
      String input1 = ScannerInput.nextLine();

      String command = input1.substring(0,1);
      //String names = input1.substring(2);

      if((command.equals("P"))||(command.equals("p"))){
         String names = input1.substring(2);
         Pdatabase(names);
         getInput();
      }
     
      else if((command.equals("F"))||(command.equals("f"))){
         String names = input1.substring(2);
         int x = names.indexOf(" ");
         String name1 = names.substring(0,x);
         String name2 = names.substring(x+1);
         Fdatabase(name1,name2);
      }
     
     else if((command.equals("U"))||(command.equals("u"))){
         String names = input1.substring(2);
         int x = names.indexOf(" ");
         String name1 = names.substring(0,x);
         String name2 = names.substring(x+1);
         Udatabase(name1, name2);
         getInput();
     }
     else if((command.equals("L"))||(command.equals("l"))){
         String names = input1.substring(2);
         Ldatabase(names);
         getInput();
     }
     else if((command.equals("Q"))||(command.equals("q"))){
         String names = input1.substring(2);
         int x = names.indexOf(" ");
         String name1 = names.substring(0,x);
         String name2 = names.substring(x+1);
         Qdatabase(name1, name2);
         getInput();
     } 
      
     else if((command.equals("X"))||(command.equals("x"))){
        return;
     }
         
      else{
         System.out.println("Error: Input unrecognised");
         getInput();
      }  
   }
   
   public static void Pdatabase(String name)
   {
      p.put(name,"");
   }//P
   
   public static void Fdatabase(String name1, String name2){
      if(name1.equals(name2))
         getInput();   
      else {
         p.put(name1,p.get(name1)+" "+ name2);
         p.put(name2,p.get(name2)+" "+ name1);
         getInput();
      } 
      
   }//F
   
   public static void Udatabase(String name1, String name2)
   {
      String friendsList1 = p.get(name1);
      String tempWord = name2 + " ";
      friendsList1 = friendsList1.replaceAll(tempWord, "");
      tempWord = " " + name2;
      friendsList1 = friendsList1.replaceAll(tempWord, "");
      
      p.put(name1,friendsList1);
      
      String friendsList2 = p.get(name2);
      String temp = name1 + " ";
      friendsList2 = friendsList2.replaceAll(temp, "");
      temp = " " + name1;
      friendsList2 = friendsList2.replaceAll(temp, "");
      
      p.put(name2,friendsList2);
   }//U
   
   public static void Ldatabase(String name1)
   {
      System.out.println(p.get(name1));
   } 
   
   public static void Qdatabase(String name1, String name2)
   {
      String friendsList1 = p.get(name1);
      if(friendsList1.contains(name2))
         System.out.println("Yes");
      else
         System.out.println("No");   
   }      
     
}//END

/*
OUTPUTS:

  ----jGRASP exec: java MicroFacebook
 P Deepika
 P Amy
 P Aneeqa
 F Deepika Amy
 L Deepika
  Amy
 U Deepika Amy
 F Amy Aneeqa
 L Aneeqa
  Amy
 L Amy
  Aneeqa
 Q Deepika Amy
 No
 Q Deepika Aneeqa
 No
 L Deepika
 
 X
 
  ----jGRASP: operation complete.
 

*/