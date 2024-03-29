import java.util.HashMap;

class dataHolder{
    private static HashMap<String, String> checker  = new HashMap<String, String>();

    static void setCreds(String number,String pass){
        checker.put(number,pass);
    }

    static boolean isExistsNumber(String number){
        return checker.containsKey(number);
    }

    static boolean passwordMatcher(String number,String pass){
        return pass.equals(checker.get(number));
    }
}

public class Login{
    static boolean Register(){
        System.out.println("Enter your mobile number");
        String number = Health_Main.sc.next();
        if(dataHolder.isExistsNumber(number)){
            // System.out.println("Already registered with this number! Please Login :)");
            return false;
        }
        else{
            System.out.println("Enter your Password");
            String pass = Health_Main.sc.next();
            dataHolder.setCreds(number,pass);
            return true;
        }
    }

    static boolean Login(){
        System.out.println("Please Login with your credentials!!!");
        System.out.println("Enter your mobile number");
        String number = Health_Main.sc.next();
        if(!dataHolder.isExistsNumber(number)){
            System.out.println("Not Registered on this Number! Please Register :)");
            return false;
        }
        else{
            System.out.println("Enter your Password");
            String pass = Health_Main.sc.next();
            if(dataHolder.passwordMatcher(number,pass)){
                return true;
            }
            else{
                System.out.println("Incorrect Password");
                return false;
            }
        }
    }
}