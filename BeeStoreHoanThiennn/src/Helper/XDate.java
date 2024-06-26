/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author phamt
 */
public class XDate {
    public static String toString(Date date,String pattern){
    SimpleDateFormat formater = new SimpleDateFormat();
        if (pattern.isEmpty()) {
            pattern="dd-MM-yyyy";
        }
        formater.applyPattern(pattern);
        return formater.format(date);
    }
}
