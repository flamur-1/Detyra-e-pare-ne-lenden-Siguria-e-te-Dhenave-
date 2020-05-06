
import java.util.Scanner;
public class tapcode {
 
public static void main(String[] args) {

    char [] Tabela = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    String [] TapCode = { ". ." , ". .." , ". ..." , ". ...." , ". ....." , ".. ." , ".. .." , ".. ..." , ".. ...." , ".. ....." , ". ..." , "... ." , "... .." , "... ..." , "... ...." , "... ....." , ".... ." ,  ".... .." , ".... ..." , ".... ...." , ".... ....." , "...... ." , "..... .." , "..... ..." , "..... ...." , "..... ....."};

       Scanner input = new Scanner (System.in);
       
       
       String choose = args[0];
       
       if ( choose.contains("tapcode" )) {
       
       
       String a = args[1];
           if ( a.equalsIgnoreCase("Dekodimi"))
           {
               
               String b = args[2];
               String[] words = null;
               if(b.contains(" ")){
                words = b.split("[|]");
               }else{
                   words = new String[1];
                   words[0] = b;
               }

               for (String word: words )
               {
                   String[] characters = word.split("  ");
                   for(int h = 0;h < characters.length;h++){
                   for(int i = 0;i < TapCode.length;i++){
                       if(characters[h].equals(TapCode[i])){
                         System.out.print(Tabela[ i ]);
                       }
                   }
                   }
                 //  System.out.print("");  
                          
        
                           
               }   
           }

           else if ( a.contains("Enkodimi" ))
           {
               
               String c = args[2];

               c = c.toLowerCase ();

               for ( int x = 0; x < c.length(); x++ )
               {
                   for ( int y = 0; y < Tabela.length; y++ )
                   {
                       if ( Tabela [ y ] == c.charAt (x))

                       System.out.print ( TapCode[ y ] + "  " );

                   }

               }
           }

           else 
           {
               System.out.println ("Invalid Input");

           }
       }
       else if(choose.contains("case")) {
    	   
    	   
    	   String choose1 = args[1];
    	   
    	   if(choose1.contains("uppercase")) {
   		
   		String s = args[2];
   		int  n;
   		char c;
   		String z = "";

   		for (int i = 0; i<s.length(); i++) {
   			c = s.charAt(i);
   			if (c >= 97 && c<= 122) //If ASCII values represent LowerCase, changing to Upper Case
   			{
   				n = c - 32;
   				c = (char) n;
   			}
   			z = z + c;
   		}
   		System.out.println("\nUpper Case: " + z);
   		z = "";

    	   }
    	   else if(choose1.contains("lowercase")) {
    		  
    	   		String s = args[2];
    	   		int  n;
    	   		char c;
    	   		String z = "";
   		for (int i = 0; i<s.length(); i++) {
   			c = s.charAt(i);
   			if (c >= 65 && c<= 90) //If ASCII values represent UpperCase, changing to Lower Case
   			{
   				n = c + 32;
   				c = (char) n;
   			}
   			z = z + c;
   		}
   		System.out.println("\nLower Case: " + z);
   		z = "";
    	   }
    	   else if(choose1.contains("inverse")) {
    		   
    		   
    		   
    	   		String s = args[2];
    	   		int  n;
    	   		char c;
    	   		String z = "";
    		   
   		for (int i = 0; i<s.length(); i++) {
   			c = s.charAt(i);
   			if (c >= 65 && c<= 90) //If ASCII values represent UpperCase, changing to Lower Case
   			{
   				n = c + 32;
   				c = (char) n;
   			}
   			else if (c>=97 && c<=122) {
   				
   				n = c-32;
   				c = (char)n;
   				
   			}
   			z = z + c;
   		}
   		System.out.println("Inverse: " + z);
   		z = "";
   		
    	   }
    	   else if(choose1.contains("capitalize")) {
    		   
    		   
    			String mesazhi = args[2];
    			
    			System.out.println("Capitalize: " + capitalizeString(mesazhi));
    		   
    	   }
   		
    	   
       }
