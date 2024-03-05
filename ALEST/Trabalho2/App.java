import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<String> list = Dictionary.getWords();
        String[] contexts = Dictionary.findContexts(list.get(1));

        System.out.println(contexts[0]);
    }
}
