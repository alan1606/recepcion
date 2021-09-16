/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author alanm
 */
public class DateUtil {
    public static String dateToString(Long date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        return strDate;
    }
}
