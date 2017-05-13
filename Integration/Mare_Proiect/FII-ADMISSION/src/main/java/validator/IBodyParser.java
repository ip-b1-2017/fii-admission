package validator;

/**
 * Created by rusub on 5/7/2017.
 */
public interface IBodyParser {

    public void setBody(String str);
    public boolean hasNext();
    public String[] next();
}
