import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LostAnimal
{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int stores = s.nextInt(); // Groceries
        int goodsAmount = s.nextInt(); // Number of list of goods

        Map<String, List<Integer>> map = new HashMap<>(stores);

        for (int i = 0; i < goodsAmount; i++){
            int storeNum = s.nextInt();
            String article = s.next();

            if (!map.containsKey(article)) {
                map.put(article, new ArrayList<>());
            }

            map.get(article).add(storeNum);
        }

        //List of goods in basket
        int itemsNumbers = s.nextInt();
        List<String> basket = new ArrayList<>(itemsNumbers);
        for (int i = 0; i < itemsNumbers; i++) {
            basket.add(s.next());
        }

        int max = 0;
        for (int i = 0; i < itemsNumbers; i++) {
            String currentArticle = basket.get(i);
            List<Integer> rem = new ArrayList<>();
            for (Integer curentStoreNumber : map.get(currentArticle)){
                if (curentStoreNumber < max) {
                    rem.add(curentStoreNumber);
                }
            }

            for (Integer temp : rem) {
                map.get(currentArticle).remove(temp);
            }

            if (map.get(currentArticle).size() > 0) {
                max = Math.max(Collections.min(map.get(currentArticle)), max);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = itemsNumbers - 1; i>=0; i--){
            String currentArticle = basket.get(i);
            List<Integer> rem = new ArrayList<>();
            for (Integer curentStoreNumber : map.get(currentArticle)){
                if (curentStoreNumber > min) {
                    rem.add(curentStoreNumber);
                }
            }

            for (Integer temp : rem) {
                map.get(currentArticle).remove(temp);
            }

            if (map.get(currentArticle).size() > 0) {
                min = Math.min(Collections.max(map.get(currentArticle)), min);
            }

        }

        // Find answer
        boolean works = true;
        boolean ambig = false;
        for(String temp : basket) {
            if(map.get(temp).size() < 1) {
                works = false;
            }
            if(map.get(temp).size() > 1) {
                ambig = true;
            }
        }

        // Print answer
        if(!works) {
            System.out.println("impossible");
        }
        else if(ambig) {
            System.out.println("ambiguous");
        }
        else {
            System.out.println("unique" );
        }
    }
}