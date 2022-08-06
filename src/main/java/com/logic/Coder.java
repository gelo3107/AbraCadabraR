/*
 * This module is coding and decoding messages according matrix transposition algorithm.
 */

package com.logic;

public class Coder {

    /* Check that password contains 5 symbols*/
    public static boolean checkPasswordCode (String password) {
        return password.length() == 5;
    }

    /* Return decoded password */
    public static String returnPasswordDecode(String stringMessage) {
        return (stringMessage.substring(0,5));
    }

    /* Check if size of the message more than 5 */
    public static boolean checkMessage(String message) {
        return message.length() >= 5;
    }

    /* Code message */
    public static String getCoded (String message, String password) {
        /* Create new string contains Message and password placed at first position. Password should be placed */
        String initialString=password + message;

        /* Call getTranspondedString method to return coded string */
        return getTranspondedString(initialString);
    }

    /* Matrix transposition algorithm */
    public static String getTranspondedString (String initialString) {
        /* Creating of the array with chars from string */
        char [] stringToChar = initialString.toCharArray();

	    /*
    	 * Creating of the new square array [][] stringToCharDbl with size of the
    	 * columns and rows equal to next integer squared of stringToChar length and
    	 * fill it from stringToChar
    	 */

        int a = (int) (Math.ceil((Math.sqrt(stringToChar.length))));
        char [][] stringToCharDbl = new char [a][a];
        int t = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                if (t < stringToChar.length) {
                    stringToCharDbl[i][j] = stringToChar[t];
                    t++;
                }
                else stringToCharDbl[i][j] = ' ';
            }
        }

    	/* Changing sequence of the chars in the array stringToCharDbl */
        char temp = ' ';
        for (int i = 0; i < a; i++) {
            for (int j = i + 1; j < a; j++) {
                temp = stringToCharDbl[i][j];
                stringToCharDbl[i][j] = stringToCharDbl[j][i];
                stringToCharDbl[j][i] = temp;
            }
        }

        /* Assemble new string from transposed array and return */
        String codedString = "";
        for (int i = 0; i<a; i++) {
            for (int j = 0; j<a; j++) {
                codedString = codedString + stringToCharDbl[i][j];
            }
        }
        return codedString;
    }
}
