class TYA1Q6 extends Thread {
    String text;
    int n;

    PrintText(String text, int n) {  // ❌ Constructor name does NOT match class name
        this.text = text;
        this.n = n;
    }

    public void run() {
        for (int i = 1; i <= n; i++) {
            System.out.println(text);
        }
    }

    public static void main(String[] args) {
        PrintText t1 = new PrintText("Hello", 10);
        PrintText t2 = new PrintText("Good Morning", 20);
        PrintText t3 = new PrintText("Sir/Mam", 30);

        t1.start();
        t2.start();
        t3.start();
    }
}
