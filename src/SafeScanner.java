import java.io.InputStream;
import java.util.Scanner;

public class SafeScanner {
    Scanner sc;
    public SafeScanner(InputStream is){
        this.sc = new Scanner(is);
    }

    public int getInt() {
        int result = 0;
        System.out.println("Entrez un chiffre.");
        if (this.sc.hasNextInt()) {
            result = this.sc.nextInt();
        }
        return result;
    }

    public String getString() {
        String result = "";
        System.out.println("Entrez un chiffre.");
        if (this.sc.hasNextInt()) {
            result = this.sc.next();
        }
        return result;
    }

    public void closeScanner() {
        sc.close();
    }
}
