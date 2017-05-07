package validator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by rusub on 5/6/2017.
 */
public class Validator implements IValidator {

    private Map<String, Pattern> fieldRegex;
    private IBodyParser parser = new BodyParser();
    public Validator(){
        this.fieldRegex = new HashMap<String, Pattern>();
        this.fieldRegex.put("num", Pattern.compile("[0-9]+"));
        this.fieldRegex.put("alfn", Pattern.compile("([0-9]+|[a-zA-Z]+)+"));
        this.fieldRegex.put("alfa", Pattern.compile("[a-zA-Z]+"));
        this.fieldRegex.put("email", Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"));
        this.fieldRegex.put("all", Pattern.compile(".+"));
        this.fieldRegex.put("date", Pattern.compile("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}"));
    }

    @Override
    public boolean isValid(String str) {
        int i = 0;
        String[] pair;
        parser.setBody(str);
        while(parser.hasNext()){
            pair = parser.next();
            Pattern p = null;
            for(Map.Entry entry : this.fieldRegex.entrySet()){
                if(pair[0].contains((String)entry.getKey())){
                    return ((Pattern)entry.getValue()).matcher(pair[1]).matches();
                }
            }
        }
        return true;
    }


}
