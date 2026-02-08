class TYA1Q2 extends Thread {
    public void run() {
        try {
            Thread.sleep(5000); // 5 seconds delay
            for (char ch = 'Z'; ch >= 'A'; ch--) {
                System.out.print(ch + " ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        TYA1Q2 t = new TYA1Q2(); 
        t.start();
    }
}
