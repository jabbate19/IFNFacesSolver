package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static String input = "";
    static Scanner scan = new Scanner(System.in);

    public static char[] addX( char arr[], char x)
    {
        int i;
        int n = arr.length;
        // create a new array of size n+1
        char newarr[] = new char[n + 1];

        // insert the elements from
        // the old array into the new array
        // insert all elements till n
        // then insert x at n+1
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];

        newarr[n] = x;

        return newarr;
    }

    public static void main(String[] args) {
	// write your code here
        double ang = 0;
        String out = "Output: ";
        boolean atAttention = true;
        boolean newWord = true;
        input = scan.nextLine() + " ";
        System.out.println( "Your input: " + input);
        /*
        char[] chars = input.toCharArray();
        ArrayList<String> words = new ArrayList<String>();
        for( int i = 0; i < chars.length; i++ ){
            char[] charsOfWord = {};
            char c = chars[i];
            if( c == ' ' ){
                newWord = true;

            }else{
                for( int k = i; newWord; k++ ){
                    if( chars[k] == ' ' || k == chars.length - 1 ){
                        newWord = false;
                    }else{
                        charsOfWord = addX( charsOfWord, chars[k] );
                    }
                }
                words.add( String.valueOf( charsOfWord ) );
            }
        }
*/

        String[] wordTest = input.split( " " );
        for( int i = 0; i < wordTest.length; i++ ){
            //String w = words.get(i);
            String w = wordTest[i];

            //System.out.println( w );
            if( w.equals( "Attention" ) || w.equals( "ATTENTION" ) ){
                atAttention = true;
            }
            if( ( w.equals( "At" ) && wordTest[i+1].equals("Ease") ) || ( w.equals( "AT" ) && wordTest[i+1].equals("EASE") ) ){
                atAttention = false;
            }
            if( atAttention ){
                if( w.equals( "F" ) || ( w.equals( "Front" ) && wordTest[i+1].equals("Face") ) || ( w.equals( "FRONT" ) && wordTest[i+1].equals("FACE") ) ){
                    out = out + "F ";
                    ang = 0;
                }
                if( w.equals( "A" ) || ( w.equals( "About" ) && wordTest[i+1].equals("Face") ) || ( w.equals( "ABOUT" ) && wordTest[i+1].equals("FACE") ) ){
                    out = out + "A ";
                    ang += 180;
                }
                if( w.equals( "R" ) || ( w.equals( "Right" ) && wordTest[i+1].equals("Face") ) || ( w.equals( "RIGHT" ) && wordTest[i+1].equals("FACE") ) ){
                    out = out + "R ";
                    ang -= 90;
                }
                if( w.equals( "L" ) || ( w.equals( "Left" ) && wordTest[i+1].equals("Face") ) || ( w.equals( "LEFT" ) && wordTest[i+1].equals("FACE") ) ){
                    out = out + "L ";
                    ang += 90;
                }
            }
        }

        System.out.println( out );
        ang = ang % 360;
        System.out.println( ang );
        if( ang == 0 ){
            System.out.println( "You will be facing FORWARDS" );
        }else if( ang == 180 ){
            System.out.println( "You will be facing BACKWARDS" );
        }else if( ang == 90 ){
            System.out.println( "You will be facing LEFT" );
        }else if( ang == -90 || ang == 270 ){
            System.out.println( "You will be facing RIGHT" );
        }
        System.out.println( "Done" );
    }
}
