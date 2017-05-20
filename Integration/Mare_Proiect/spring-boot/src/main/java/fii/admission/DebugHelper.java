package fii.admission;

/**
 * Created by rusub on 5/19/2017.
 */
public class DebugHelper {

    public static void printDebugMsg(String where, Object obj){
        where = "[" + where + "]";
        System.out.println("[debug]" + where + ": " + obj.toString());
    }
}
