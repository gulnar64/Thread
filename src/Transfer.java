public class Transfer {
    public Transfer(int amount) {
        this.amount = amount;
    }

    private int amount;
    public synchronized void withdraw(int outcome) throws InterruptedException {
        System.out.println("withdraw start");
        if(amount < outcome) {
            wait();
        }
        this.amount -= outcome;
        System.out.println("withdraw end, amount: " + amount);
    }

    public synchronized void deposit(int income) {
        System.out.println("deposit start");
        this.amount += income;
        System.out.println("after income: " + amount);
        notify();
        System.out.println("deposit end, deposit: " + amount);
    }
}
