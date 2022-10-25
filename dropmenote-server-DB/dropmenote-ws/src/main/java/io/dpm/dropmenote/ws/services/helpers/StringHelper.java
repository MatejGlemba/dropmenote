/**
 * 
 */
package io.dpm.dropmenote.ws.services.helpers;

import io.dpm.dropmenote.ws.constants.AppConstant;

/**
 * @author Martin Jurek (Starbug s.r.o. | https://www.strabug.eu)
 *
 */
public class StringHelper {

    /**
     * Remove ,,,, from value. It is not effective TODO use regex
     * 
     * @param value
     * @return
     */
    public static String removeLastSemicolon(String value) {
        if (value.endsWith(String.valueOf(AppConstant.CSV_DELIMITER))) {
            value = value.subSequence(0, (value.length() - 1)).toString();
            value = removeLastSemicolon(value);
        }

        return value;
    }

    /**
     * 
     * @param inputString
     * @return
     */
    public static String reverse(String inputString) {
        if(inputString == null) {
            return "";
        }
        return new StringBuilder(inputString).reverse().toString();
    }

    /**
     * Convert 7 to 07 and so on..
     * 
     * @param hourOrMInutes
     * @return
     */
    public static String formatTimeToXX(int hourOrMInutes) {
        if (String.valueOf(hourOrMInutes).length() == 1) {
            return "0" + hourOrMInutes;
        }
        return "" + hourOrMInutes;
    }
    
    public static String randomString(int n, String alphabet) {
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(alphabet.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(alphabet 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    }
    
    public static String randomString(int n) {
        return randomString(n, "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz,.;!@#$%^&*()_-+~<>?[]{}");
    }
}
