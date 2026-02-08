class TYA1Q5 extends Thread {
    String str;

    
    TYA1Q5(String s) {  
        str = s;
    }

    public void run() {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ("AEIOUaeiou".indexOf(ch) != -1) {
                System.out.println(ch);
                try {
                    Thread.sleep(3000);delay
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        TYA1Q5 t = new TYA1Q5("Hello Java Programming");
        t.start();
    }
}
