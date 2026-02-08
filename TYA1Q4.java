class TYA1Q4 extends Thread {
    public void run() {
        for (int i = 100; i >= 1; i--) {
            System.out.println(i);
            if (i == 10) {
                try {
                    Thread.sleep(6000);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        TYA1Q4 t = new TYA1Q4();
        t.start();
    }
}
