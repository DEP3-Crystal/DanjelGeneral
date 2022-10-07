package pipelines;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.*;

public class TotalScoreComputationWithPipelineOptions {
    private static final String CSV_HEADER="Id,Name,Java,c++,Python,go";

    public interface TotalScoreComputationOption extends PipelineOptions{
//        @Description("Path of the file to read from")
//        @Default.String("ApacheBeam/src/main/resources/Data.csv")
//        String getInputFile;

        void setInputFile(String value);

        @Description("Path of the fileto write to")
        @Validation.Required
        String getOutputFile();

        void setOutputFile(String value);
    }

    public static void main(String[] args) {
        TotalScoreComputationOption option= PipelineOptionsFactory.fromArgs(args).withValidation()
                .as(TotalScoreComputationOption.class);
        Pipeline pipeline=Pipeline.create(option);

     //   System.out.println("Input file: "+option.getInputFile);
        System.out.println("Input file: "+option.getOutputFile());
    }


}
