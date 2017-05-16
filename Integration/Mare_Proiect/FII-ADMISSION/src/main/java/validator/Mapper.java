package validator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rusub on 5/12/2017.
 */
public class Mapper {

    public static Map<String, String> changeToSingle(Map<String, String[]> map)
                                throws IllegalArgumentException{
        Map<String, String> params = new HashMap<String, String>();
        for(Map.Entry<String, String[]> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue()[0]);
            params.put(entry.getKey(), entry.getValue()[0]);
        }
        return params;
    }
}
