public class Printer2 {
    public synchronized void print(int numb) {
        for (int i = 0; i <= 5; i++)
            System.out.println(numb * i);
    }
}
