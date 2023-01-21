public class StandardAccount extends PremiumAccount {
    double creditLimit;

    public StandardAccount(int accountNumber, double creditLimit) {
        super(accountNumber);
        if(creditLimit >0)
            creditLimit = 0;
        this.creditLimit = creditLimit;
    }

    @Override
    public double Withdraw(double amount) {
        if(this.balance - amount >= this.creditLimit){
            this.balance -= amount;
            return amount;
        }
        else{
            amount = this.balance - this.creditLimit;
            this.balance = this.creditLimit;
            return amount;
        }
    }
}