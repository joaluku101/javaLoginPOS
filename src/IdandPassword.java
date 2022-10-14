import java.util.HashMap;

public class IdandPassword {

    HashMap <String,String> logininfo = new HashMap<>();

    IdandPassword(){

        logininfo.put("Bro","pizza");
        logininfo.put("Brometheus","PASSWORD");
        logininfo.put("Aluku","maragwe");



    }

    protected HashMap<String, String> getLogininfo() {
        return logininfo;
    }
    
}
