import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        IAccount standard = new StandardAccount(1,-100);
        IAccount basic = new BasicAccount(2,100);
        IAccount premium = new PremiumAccount(3);
        IBank bank = new Bank();

        bank.OpenAccount(standard);
        bank.OpenAccount(premium);
        bank.OpenAccount(basic);

        System.out.println("Depositing 1000 in each account...");
        premium.Deposit(1000);
        standard.Deposit(1000);
        basic.Deposit(1000);
        System.out.println("");

        System.out.println("Withdrawing 3000 from each account...");
        System.out.println("Withdrawn " + premium.Withdraw(3000) + " From Premium Account");
        System.out.println("Withdrawn " + basic.Withdraw(3000) + " From Basic Account");
        System.out.println("Withdrawn " + standard.Withdraw(3000) + " From Standard Account");
        System.out.println("");

        System.out.println("Current Balance in account number " + premium.GetAccountNumber()+ "(Premium) is " + premium.GetCurrentBalance());
        System.out.println("Current Balance in account number " + basic.GetAccountNumber()+ "(Basic) is " + basic.GetCurrentBalance());
        System.out.println("Current Balance in account number " + standard.GetAccountNumber()+ "(Standard) is " + standard.GetCurrentBalance());
        System.out.println("");

        for (IAccount account: bank.GetAllAccountsInDebt() ) {
            System.out.println("Account " + account.GetAccountNumber() + " is in debt");
        }
        System.out.println("");

        System.out.println("Closing all accounts in the bank...");
        bank.CloseAccount(premium.GetAccountNumber());
        bank.CloseAccount(basic.GetAccountNumber());
        bank.CloseAccount(standard.GetAccountNumber());
        System.out.println("There are " + bank.GetAllAccounts().size() + " accounts in the bank");
        System.out.println("");

        System.out.println("Depositing 2000 in each account...");
        premium.Deposit(2000);
        standard.Deposit(2000);

        for (IAccount account: bank.GetAllAccountsWithBalance(1000) ) {
            System.out.println("Account " + account.GetAccountNumber() + " has more than 1000 in its balance");
        }
        System.out.println("");

        System.out.println("Current Balance in account number " + premium.GetAccountNumber()+ "(Premium) is " + premium.GetCurrentBalance());
        System.out.println("Current Balance in account number " + standard.GetAccountNumber()+ "(Standard) is " + standard.GetCurrentBalance());

        System.out.println("");
        System.out.println("Closing all bank accounts...");
        bank.CloseAccount(premium.GetAccountNumber());
        bank.CloseAccount(standard.GetAccountNumber());
        System.out.println("There are " + bank.GetAllAccounts().size() + " accounts in the bank");
    }
}