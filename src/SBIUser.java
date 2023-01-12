import java.util.Objects;
import java.util.UUID;

public class SBIUser implements BankInterface {

    private String AccountNo;
    private String name;
    private int balance;
    private String password;
    private float rateOfInterest;

    //constructor
    public SBIUser(String name, int balance,String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;

        this.AccountNo = String.valueOf(UUID.randomUUID());
        this.rateOfInterest = 6.6f;
    }

    public String getAccountNo() {
        return AccountNo;
    }

    public void setAccountNo(String accountNo) {
        AccountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(float rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    @Override
    public int checkBalance() {
        return balance;
    }

    @Override
    public String addMoney(int money) {
        balance = balance + money;
        return "Successfully added money "+money + " you new balance is "+balance;

    }

    @Override
    public String withDrawMoney(int money,String enteredPassword) {


        if(Objects.equals(enteredPassword, password)){

            if(money>balance){
                return "Sorry bro! But less money";
            }
            else{
                this.balance = this.balance - money;
                return "Money has been withdrawn "+money;
            }

        }else{
            return "Wrong password";
        }

    }

    @Override
    public float calculateInterest(int years) {
        float interest = balance*years*rateOfInterest/100;
        return interest;
    }
}
