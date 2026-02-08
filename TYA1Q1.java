class TYA1Q1 extends Thread {
    public void run() {
        try {
            Thread.sleep(2000); // 2 seconds delay
            for (int i = 1; i <= 100; i++) {
                System.out.print(i + " ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        RandomNumber t = new RandomNumber();
        t.start();
    }
}




