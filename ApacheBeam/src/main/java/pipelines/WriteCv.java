package pipelines;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class WriteCv {

public static void writeDataLineByLine(String filePath)
{

    File file = new File(filePath);
    try {
        FileWriter outputfile = new FileWriter(file);

        CSVWriter writer = new CSVWriter(outputfile);

        String[] header = { "Id","Name", "Java", "c++","Python", "go"};
        writer.writeNext(header);

        String[] data1 = {"1", "Aman", "10", "620", "22", "241"};
        writer.writeNext(data1);
        String[] data2 = {"2", "Suraj", "10", "630", "22", "241" };
        writer.writeNext(data2);
        String[] data3 = {"3", "Nick", "11", "630", "22", "241" };
        writer.writeNext(data3);
        String[] data4 = {"4", "John", "12", "24", "22", "241" };
        writer.writeNext(data4);
        String[] data5 = {"5", "Nikita", "10", "124", "22", "241" };
        writer.writeNext(data5);
        String[] data6 = {"6","Phil", "22", "241", "22", "241" };
        writer.writeNext(data6);

        writer.close();
    }
    catch (IOException e) {
        e.printStackTrace();
    }
}

    public static void main(String[] args) {
        writeDataLineByLine("ApacheBeam/src/main/resources/Data.csv");
    }
}
