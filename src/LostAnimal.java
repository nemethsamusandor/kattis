import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Java solution of Abandoned Animal problem,
 * based on solution of https://github.com/mpfeifer1/Kattis/blob/master/abandonedanimal.cpp
 *
 * @author Sandor Nemeth (nemethsamusandor)
 */
public class LostAnimal
{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int stores = s.nextInt(); // Stores in the town
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
            max = manipulateMap(i, basket, map, max, true);
        }

        int min = Integer.MAX_VALUE;
        for (int i = itemsNumbers - 1; i>=0; i--){
            min = manipulateMap(i, basket, map, min, false);
        }

        // Find answer
        boolean works = true;
        boolean ambiguous = false;
        for(String temp : basket) {
            if(map.get(temp).isEmpty()) {
                works = false;
            }
            if(map.get(temp).size() > 1) {
                ambiguous = true;
            }
        }

        // Print answer
        if (!works)
            System.out.println("impossible");
        else if (ambiguous)
            System.out.println("ambiguous");
        else
            System.out.println("unique");
    }

    static int manipulateMap(int i, List<String> basket, Map<String, List<Integer>> map, int minMax, boolean max) {
        String currentArticle = basket.get(i);
        List<Integer> rem = new ArrayList<>();
        for (Integer currentStoreNumber : map.get(currentArticle)){
            if (max && currentStoreNumber < minMax
            || !max && currentStoreNumber > minMax) {
                rem.add(currentStoreNumber);
            }
        }

        for (Integer temp : rem) {
            map.get(currentArticle).remove(temp);
        }

        if (max && !map.get(currentArticle).isEmpty()) {
            return Math.max(Collections.min(map.get(currentArticle)), minMax);
        }
        else if (!max && !map.get(currentArticle).isEmpty()) {
            return Math.min(Collections.max(map.get(currentArticle)), minMax);
        }
        return minMax;
    }
}