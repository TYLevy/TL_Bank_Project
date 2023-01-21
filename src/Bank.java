import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank{
    private List<IAccount> accounts;

    public Bank(){
        this.accounts = new ArrayList<>();
    }
    public void OpenAccount(IAccount account) {
        this.accounts.add(account);
    }
    public void CloseAccount(int accountNumber) {
        IAccount toRemove = null;
        for(IAccount account: accounts){
            if(account.GetAccountNumber() == accountNumber){
                toRemove = account;
                break;
            }
        }
        if(toRemove != null){
            if(toRemove.GetCurrentBalance()<0){
                System.out.println("The account can not be closed due to debt");
            }
            else{
                accounts.remove(toRemove);
            }
        }
    }
    public List<IAccount> GetAllAccounts() {
        return this.accounts;
    }
    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount> inDebt = new ArrayList<>();
        for(IAccount account: accounts){
            if(account.GetCurrentBalance()<0){
                inDebt.add(account);
            }
        }
        return inDebt;
    }
    public List<IAccount> GetAllAccountsWithBalance(double balanceAbove) {
        List<IAccount> overBalance = new ArrayList<>();
        for(IAccount account: accounts){
            if(account.GetCurrentBalance() > balanceAbove){
                overBalance.add(account);
            }
        }
        return overBalance;
    }
}