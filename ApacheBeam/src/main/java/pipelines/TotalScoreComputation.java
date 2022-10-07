package pipelines;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.KV;

import java.util.Arrays;

public class TotalScoreComputation {
    private static final String CSV_HEADER="Id,Name,Java,c++,Python,go";
    public static void main(String[] args) {
        PipelineOptions options= PipelineOptionsFactory.create();
        Pipeline pipeline=Pipeline.create(options);

        pipeline.apply(TextIO.read().from("ApacheBeam/src/main/resources/Data.csv"))
                .apply(ParDo.of(new FilterHeadern(CSV_HEADER)))
                .apply(ParDo.of(new ComputeTotalScoresFn()))
                .apply(ParDo.of(new convertToStringFn()))
                .apply(TextIO.write().to("ApacheBeam/src/main/resources/nameAndValueFromCsv"));
        pipeline.run();
    }


    public static class FilterHeadern extends DoFn<String,String>{
        private final String header;
        public FilterHeadern(String header) {
            this.header = header;
        }
        @ProcessElement
        public void processElement(ProcessContext c){
            String row=c.element();
            if(!row.isEmpty()&& !row.equals(this.header)){
                c.output(row);
            }
        }
    }


    private static class ComputeTotalScoresFn extends DoFn<String,KV<String,Integer>>{
        @ProcessElement
        public void processElemet(ProcessContext c){
            //System.out.print(c.element());
            String []data=c.element().split(",");
            String name=data[1];
            System.out.println(data[1]);
            Integer totalScore=Integer.parseInt(data[2])+Integer.parseInt(data[3])+
                    Integer.parseInt(data[4])+Integer.parseInt(data[5]);


            c.output(KV.of(name,totalScore));
        }
    }


    private static class convertToStringFn extends DoFn<KV<String,Integer>,String>{
        @ProcessElement
        public void processElement(ProcessContext c){
            c.output(c.element().getKey()+","+c.element().getValue());
        }
    }

}
