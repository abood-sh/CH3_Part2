/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package first_question;

import java.util.function.Consumer;

/**
 *
 * @author Abood Sh
 */
public class First_Question {

    /**
     * @param args the command line arguments
     */
 public static void main(String[] args) {
     
        //1
        Consumer<Integer> display = a -> System.out.printf("%d " , a);
        display.accept(10); 
       // 2
       
       Operation<String> operation2 = (str1) -> { str1 = str1.toUpperCase();
                    return str1 ;
       };
       System.out.println("the String : " + operation2.UpperCase("Abood"));
       // 3
       
       Operation1<String> operation3 = () -> { 
           System.out.println("Welcome to lambdas!");
       };
       operation3.lambda();
        
       // 4
       
       Operation2 <Integer> operation4 = (x) -> {
           Math.pow(x ,3) ; 
           System.out.println(""+x);
       };
       operation4.cube(3);
    }
    private interface Operation <String>{
        public String UpperCase (String y) ;
    }
    private interface Operation1 <String>{
        public void lambda () ;
     }
    private interface Operation2 <Integer>{
        public void cube (int x) ;
    }
}
