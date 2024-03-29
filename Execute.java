import java.util.HashMap;
public class Execute extends Transaction implements HealthConditions{
    static double totalAmount = 0;
    int quant;
    char ch;
    static HashMap<String, Integer> biller = new HashMap<String, Integer>();

    static HashMap<String, Integer> costs = new HashMap<String, Integer>() {{
        put("Paracetamol", 50);
        put("Dolo-650", 40);
        put("Naproxen", 30);
        put("Coldact", 60);
        put("Cetzine", 80);
        put("Cheston_Cold", 50);
        put("Tafenoquine", 100);
        put("Doxycycline", 150);
        put("Chloroquine", 150);
    }};

    public void addToTotal(int quantity,String type){
        totalAmount+=(costs.get(type)*quantity);
        biller.put(type, biller.getOrDefault(type, 0) + quantity);
    }

    public void displayBill(double actualBill){
        System.out.println();
        System.out.println();
        System.out.printf("%-20s %-20s %-20s\n", "Item", "Quantity", "Total");
        System.out.println();
        double gst = actualBill-totalAmount;
        biller.forEach((k, v) -> System.out.printf("%-20s %-20s %-20s\n",k,v,(costs.get(k)*v)));
        System.out.printf("%-20s %-20s %.2f\n", "GST", "", gst);
        System.out.println();
        System.out.printf("%-20s %-20s %.2f\n","Total","",actualBill);
    }

    public void handleSelection(String medicine){
        System.out.println("Enter Quantity Required!");
        quant = Health_Main.sc.nextInt();
        addToTotal(quant,medicine);
        System.out.println("Click 1 to checkout or Any other Key to add more!!!");
        ch = Health_Main.sc.next().charAt(0);
        if(ch == '1'){
            double actualBill = generateBill(totalAmount);
            displayBill(actualBill);
            paymentMode();
        }
        else{
            execute();
        }
    }

    public void fever(){
        String[] meds = {"Paracetamol","Dolo-650","Naproxen"};
        System.out.println("Select medicine");
        for(int i = 0;i<meds.length;i++){
            System.out.println((i+1)+"."+meds[i]+"\t\t\t"+costs.get(meds[i])+" Rs/Tab");
        }
        int opt = Health_Main.sc.nextInt();
        switch(opt){
            case 1:
                handleSelection(meds[opt-1]);
                break;
            case 2:
                handleSelection(meds[opt-1]);
                break;
            case 3:
                handleSelection(meds[opt-1]);
                break;
            default:
                System.out.println("please select valid madicine");
                fever();
        }
    }

    public void cold(){
        String[] meds = {"Coldact","Cetzine","Cheston_Cold"};
        System.out.println("Select medicine");
        for(int i = 0;i<meds.length;i++){
            System.out.println((i+1)+"."+meds[i]+"\t\t\t"+costs.get(meds[i])+" Rs/Tab");
        }
        int opt = Health_Main.sc.nextInt();
        switch(opt){
            case 1:
                handleSelection(meds[opt-1]);
                break;
            case 2:
               handleSelection(meds[opt-1]);
                break;
            case 3:
                handleSelection(meds[opt-1]);
                break;
            default:
                System.out.println("please select valid madicine");
                cold();
        }
    }

    public void malaria(){
        String[] meds = {"Tafenoquine","Doxycycline","Chloroquine"};
        System.out.println("Select medicine");
        for(int i = 0;i<meds.length;i++){
            System.out.println((i+1)+"."+meds[i]+"\t\t\t"+costs.get(meds[i])+" Rs/Tab");
        }
        int opt = Health_Main.sc.nextInt();
        switch(opt){
            case 1:
                handleSelection(meds[opt-1]);
                break;
            case 2:
                handleSelection(meds[opt-1]);
                break;
            case 3:
                handleSelection(meds[opt-1]);
                break;
            default:
                System.out.println("please select valid madicine");
                malaria();
        }
    }

    static void handleCase(int opt){
        switch(opt){
            case 1:
                Execute obj = new Execute();
                obj.fever();
                break;
            case 2:
                Execute obj2 = new Execute();
                obj2.cold();
                break;
            case 3:
                Execute obj3 = new Execute();
                obj3.malaria();
                break;
            default:
                System.out.println("Entered Invalid Input!!!");
                System.out.println("Select your Health Issue");
                System.out.println("1.Fever" +"\n"+ "2.Cold"+"\n"+ "3.Malaria");
                int option = Health_Main.sc.nextInt();
                handleCase(option);
        }
    }
    static void execute(){
        System.out.println("Select your Health Issue");
        System.out.println("1.Fever" +"\n"+ "2.Cold"+"\n"+ "3.Malaria");
        int opt = Health_Main.sc.nextInt();
        handleCase(opt);
    }
}


/*

#include <bits/stdc++.h>
using namespace std;
int main() {
    // Write C++ code here
    map<string,int> mpp;
    vector<pair<string,int>> v = {{"a",2},{"b",5},{"c",1},{"a",4}};
    for(auto i:v){
        mpp[i.first]+=i.second;
    }
    for(auto i:mpp){
        cout<<i.first<<" "<<i.second<<endl;
    }
    return 0;
}

*/