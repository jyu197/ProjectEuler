import java.util.HashMap;

public class P17NumberLetterCounts {

    public static void main(String[] args) {

        HashMap<String, Integer> counts = new HashMap<>();
        counts.put("0", 0);
        counts.put("1", 3);
        counts.put("2", 3);
        counts.put("3", 5);
        counts.put("4", 4);
        counts.put("5", 4);
        counts.put("6", 3);
        counts.put("7", 5);
        counts.put("8", 5);
        counts.put("9", 4);
        counts.put("10", 3);
        counts.put("11", 6);
        counts.put("12", 6);
        counts.put("13", 8);
        counts.put("14", 8);
        counts.put("15", 7);
        counts.put("16", 7);
        counts.put("17", 9);
        counts.put("18", 8);
        counts.put("19", 8);
        counts.put("20", 6);
        counts.put("30", 6);
        counts.put("40", 5);
        counts.put("50", 5);
        counts.put("60", 5);
        counts.put("70", 7);
        counts.put("80", 6);
        counts.put("90", 6);
        counts.put("hundred", 7);
        counts.put("and", 3);
        counts.put("thousand", 8);

        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            String curr = Integer.toString(i);
            if (counts.containsKey(curr)) {
                sum += counts.get(curr);
                continue;
            }
            if (curr.length() >= 4) {
                String thousands = curr.substring(curr.length() - 4 , curr.length() - 3);
                sum += counts.get(thousands);
                if (!thousands.equals("0")) {
                    sum += counts.get("thousand");
                }
            }
            if (curr.length() >= 3) {
                String hundreds = curr.substring(curr.length() - 3, curr.length() - 2);
                sum += counts.get(hundreds);
                if (!hundreds.equals("0")) {
                    sum += counts.get("hundred");
                }
                if (!curr.substring(curr.length() - 2).equals("00")) {
                    sum += counts.get("and");
                }
            }
            if (curr.length() >= 2) {
                String tensOnes = curr.substring(curr.length() - 2);
                if (!counts.containsKey(tensOnes)) {
                    if (Integer.parseInt(tensOnes) < 10) {
                        counts.put(tensOnes, counts.get(tensOnes.substring(1)));
                    }
                    else if (Integer.parseInt(tensOnes) > 20) {
                        counts.put(tensOnes, counts.get(tensOnes.substring(0, 1) + "0") +
                                counts.get(tensOnes.substring(1)));
                    }
                }
                sum += counts.get(tensOnes);
            }
        }

        System.out.println(sum);

    }

}
