package fii.admission.users;

/**
 * Created by cosmin on 5/22/2017.
 */
public class AdminMaker {
    public static void main(String []args){
        User user = new User();
        HashConvertor hash = new HashConvertor("12345");
        user.setEmail("cosmin@gmail.com");
        user.setPassword(hash.toString());
        user.setRole("admin");
        user.setToken("claclaasdas123123");
        UserService.updateUser("cosmin@gmail.com",user);
    }
}
