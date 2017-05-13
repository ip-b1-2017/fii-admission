package validator;

import java.util.Map;

/**
 * Created by rusub on 5/6/2017.
 */
public interface IValidator {

    public boolean isValid(Map<String, String[]> params);
}
