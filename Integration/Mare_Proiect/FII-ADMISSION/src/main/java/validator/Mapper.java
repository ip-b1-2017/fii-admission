package validator;

import java.util.HashMap;
import java.util.Map;

public class Mapper {

    public static Map<String, String> changeToSingle(Map<String, String[]> map)
                                throws IllegalArgumentException{
        Map<String, String> params = new HashMap<String, String>();
        for(Map.Entry<String, String[]> entry : map.entrySet()){
<<<<<<< HEAD
            System.out.println(entry.getKey() + " " + entry.getValue()[0]);
            params.put(entry.getKey(), entry.getValue()[0]);
=======
            if (entry.getValue().length != 0) {
                params.put(entry.getKey(), entry.getValue()[0]);
            }
            else{
                params.put(entry.getKey(), null);
            }
>>>>>>> c51c577bb0f7802df9f5f49436f37b8f34971ef2
        }
        return params;
    }
}
