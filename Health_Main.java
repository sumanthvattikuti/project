import java.util.*;
public class Health_Main{
    static Scanner sc = new Scanner(System.in);
    
    static{
        System.out.println("Welcome to Health Assistance Application");
        System.out.println("Select option");
        System.out.println("1.Register" +"\n"+ "2.Login");
    }

    static void handleLogin(int opt){
        switch(opt){
            case 1:
                boolean regStatus = Login.Register();
                if(!regStatus){
                    System.out.println("Seems like you already registered with the mobile number!!");
                    // System.out.println("Do you wanna register again with another number");
                    System.out.println("select 1 to register again with another number  or any other key for Login");
                    char ip = sc.next().charAt(0);
                    if(ip == '1'){
                        handleLogin(1);
                    }
                    else {
                        handleLogin(2);
                    }
                }
                else{
                    handleLogin(2);
                }
                break;

            case 2:
                boolean loginStatus = Login.Login();
                if(!loginStatus){
                    System.out.println("Select 1 to register or any other key to login!!");
                    char ip = sc.next().charAt(0);
                    if(ip == '1'){
                        handleLogin(1);
                    }
                    else {
                        handleLogin(2);
                    }
                }
                else{
                    System.out.println("Health Care app welcomes you");
                    Execute.execute();
                }
                break;
            default:
                System.out.println("Entered invalid Input!!!");
                System.out.println("Select option");
                System.out.println("1.Register" +"\n"+ "2.Login");
                int option = sc.nextInt();
                handleLogin(option);
        }
    }

    public static void main(String[] args){
       int option = sc.nextInt();
       handleLogin(option);
        // switch(option){
        //     case 1:
        //         boolean regStatus = Login.Register();
        //         if(!regStatus){
        //             System.out.println("Seems like you already registered with the mobile number");
        //             System.out.println("Do you wanna register again with another number");
        //         }
        //         break;
        //     case 2:
        //         boolean loginStatus = Login.Login();
        //         System.out.println("log"+loginStatus);
        //         break;
        //     default:
        //         System.out.println("Entered invalid Input!!!");
        // }
    }
}
