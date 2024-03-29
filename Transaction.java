public class Transaction{

    double generateBill(double totalAmount){
        if(totalAmount<=1000) totalAmount+=(0.06*totalAmount);
        else totalAmount+=(0.12*totalAmount);
        return totalAmount;
    }

    void paymentMode(){
        System.out.println("Enter your Payment Mode");
        System.out.println("1.UPI" +"\n"+ "2.Card");
        int opt = Health_Main.sc.nextInt();
        if(opt == 1){
            System.out.println("Enter your UPI Id");
            String upi = Health_Main.sc.next();
            System.out.println("Enter PIN");
            String pin = Health_Main.sc.next();
            System.out.println("Your Transaction is being Processing...");
            try{
                Thread.sleep(3000);
                System.out.println("Payment successful");
                System.out.println("Please visit again😊");
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
        }
        else if(opt==2){
            System.out.println("Enter your Card Number");
            String upi = Health_Main.sc.next();
            System.out.println("Enter your CVV");
            String cvv = Health_Main.sc.next();
            if(cvv.length()!=3){
                System.out.println("Invalid CVV..CVV must be having 3 digits..Please proceed again with payment");
                paymentMode();
                return;
            }
            System.out.println("Enter One-Time-Password");
            String otp = Health_Main.sc.next();
            System.out.println("Your Transaction is being Processing...");
            try{
                Thread.sleep(3000);
                System.out.println("Payment successful");
                System.out.println("Please visit again😊");
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
        }
        else{
            System.out.println("Entered Invalid Option");
            paymentMode();
            return;
        }
    }
}