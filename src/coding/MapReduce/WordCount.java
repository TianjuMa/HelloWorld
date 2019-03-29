package coding.MapReduce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.mongodb.Block;
import com.mongodb.client.MapReduceIterable;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class WordCount {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("laiproject");
        try {

            String map = "function() {emit(this.key, 1);}";
            String reduce = "function(key, values) {return Array.sum(values)} ";

            MapReduceIterable<Document> results = db.getCollection("words").mapReduce(map, reduce);

            List<List<String>> countWords = new ArrayList<>();
            results.forEach(new Block<Document>() {
                @Override
                public void apply(final Document document) {
                    countWords.add(Arrays.asList(document.getString("_id"), String.valueOf(document.getDouble("value"))));
                }
            });
            mongoClient.close();
            System.out.println(countWords);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
