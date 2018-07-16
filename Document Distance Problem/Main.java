import java.util.HashMap;

/**
 * @author CHAFI Bennassar
 * @context This class illustrate a solution for the document distance problem
 *
 * Document distance problem :  We're giving 2 documents D1 and D2 and we want to compute the
 * distance between them, in other words we want to have an idea about
 * how identical those 2 documents are.
 *
 */

public class Main {

    public static void main(String[] args) {

        String doc1 = "Appreciation is a wonderful thing: It makes what is excellent in others belong to us as well";
        String doc2 = "Parting is such sweet sorrow that i shall say goodnight till it be morrow";

        Double distance = getDistanceBetween2Docs(doc1, doc2);
        distance = Math.floor(distance * 100) / 100;

        if (distance == 0.0d) {
            System.out.println("These 2 documents are identical, with a score of : " + distance);
        } else if (distance == 1.57d) {
            System.out.println("These 2 documents have no common words, with a score of : " + distance);

        } else {
            System.out.println("These 2 documents are different, score is : " + distance);
        }
    }

    /**
     *
     * @param document which is a sequence of words
     * @return array of words in a document without punctuation and whitespace
     *
     */
    public static String[] getWordsInDocWithoutPun(String document) {
        String[] words = document.split("[\\p{Punct}\\s]+");
        return words;
    }

    /**
     *
     * @param arrray of words in a document
     * @return list of all words and how many time each word occurs in the document
     *
     */
    public static HashMap<String, Integer> computeWordFrequencesInDoc(String[] words) {
        HashMap<String, Integer> documentVector = new HashMap<String, Integer>();

        for (int i = 0; i < words.length; i++) {
            Integer oldValue = documentVector.get(words[i].toLowerCase());
            Integer occurrence = (oldValue == null) ? 1 : oldValue + 1;
            documentVector.put(words[i].toLowerCase(), occurrence);
        }
        return documentVector;
    }

    public static Integer computeInnerProduct(HashMap<String, Integer> docVector1, HashMap<String, Integer> docVector2) {
        Integer sum = 0;
        HashMap<String, Integer> smallesttDocVector = (docVector1.size() < docVector2.size()) ? docVector1 : docVector2;
        HashMap<String, Integer> largestDocVector = (docVector1.size() > docVector2.size()) ? docVector1 : docVector2;

        for (String key : smallesttDocVector.keySet()) {
            if (largestDocVector.containsKey(key)) {
                sum += docVector1.get(key) * docVector2.get(key);
            }
        }
        return sum;
    }

    /**
     *
     * @param doc1
     * @param doc2
     * @return the distance between the documents doc1 and doc2
     *
     */
    public static Double getDistanceBetween2Docs(String doc1, String doc2) {
        Double angle = 0.0d;
        HashMap<String, Integer> docVector1 = computeWordFrequencesInDoc(getWordsInDocWithoutPun(doc1));
        HashMap<String, Integer> docVector2 = computeWordFrequencesInDoc(getWordsInDocWithoutPun(doc2));

        Integer numerator = computeInnerProduct(docVector1, docVector2);
        Double denominator = Math.sqrt(computeInnerProduct(docVector1, docVector1))
                * Math.sqrt(computeInnerProduct(docVector2, docVector2));

        angle = Math.acos(numerator / denominator);

        return angle;
    }
}