package LaiOffer.MapReduce;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.io.BufferedReader;
import java.io.FileReader;

public class LoadData {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("laiproject");
        String fileName = "/Users/matinaju/Documents/wordCount.csv";
        String line;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                db.getCollection("words").insertOne(new Document().append("key", values[0]));
            }
            System.out.println("Import Done!");
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
