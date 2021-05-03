package src;

public class user {
    private String userIdAccount;
    private String userName;
    private String userPhoneNumber;
    private int accountBalance;

    public user(String userIdAccount, String userName, String userPhoneNumber, int accountBalance){
        this.userIdAccount=userIdAccount;
        if (userName=="") this.userName="undefined";
        else this.userName=userName;
        if (userPhoneNumber=="") this.userPhoneNumber="undefined";
        else this.userPhoneNumber=userPhoneNumber;
        this.accountBalance=accountBalance;
    }

    public void transferMoney(int amountOfMoney){
        this.accountBalance=this.accountBalance+amountOfMoney;
    }

    public void payBill(int amountOfMoney){
        this.accountBalance=this.accountBalance-amountOfMoney;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public String getUserIdAccount() {
        return userIdAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int compareTo(user x){
        if(this.userName.equals("undefined") && x.userName.equals("undefined")) return 1;
        else if(this.userName.equals("undefined")) return -1;
        else if(x.userName.equals("undefined")) return 1;
        else {
            return this.userName.compareTo(x.userName);
        }
    }
}
