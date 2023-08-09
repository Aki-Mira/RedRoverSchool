public class Main {
    public static void main(String[] args) {
        String str[] = {"3", "2", "1", "Поехали!!!"};
        for (int i=0; i < 4; i++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( str[i] );
        }
    }
}
