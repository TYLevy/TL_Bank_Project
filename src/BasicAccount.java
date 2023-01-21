public class BasicAccount extends PremiumAccount {
    double withdrawalLimit;
    double creditLimit;

    {
        creditLimit = 0;
    }

    public BasicAccount(int accountNumber, double withdrawalLimit) {
        super(accountNumber);
        this.withdrawalLimit = withdrawalLimit;
    }


    @Override
    public double Withdraw(double amount) {
        if(this.balance - amount >= this.creditLimit){
            if(amount <= this.withdrawalLimit){
                this.balance -= amount;
                return amount;
            }
            else{
                amount = this.withdrawalLimit;
                this.balance -= amount;
                return amount;
            }
        }
        else{
            amount = this.balance - this.creditLimit;
            if(amount >= this.withdrawalLimit){
                amount = this.withdrawalLimit;
                this.balance -= amount;
                return amount;
            }
            else{
                this.balance -= amount;
                return amount;
            }
        }
    }
}