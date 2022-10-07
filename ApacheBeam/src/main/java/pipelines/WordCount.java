package pipelines;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.*;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.TypeDescriptors;

import java.util.Arrays;
import java.util.List;

public class WordCount {
    public static void main(String[] args) {
        PipelineOptions options =PipelineOptionsFactory.create();
        Pipeline pipeline=Pipeline.create(options);

        pipeline.apply(TextIO.read().from("ApacheBeam/src/main/resources/java.txt"))
                .apply("ExtractWords", FlatMapElements
                        .into(TypeDescriptors.strings())
                        .via((String line)-> {
                            List<String > splited = Arrays.asList(line.toUpperCase().split(" "));
                            System.out.println(splited);
                            System.out.println();
                            return splited;
                        }))
                .apply("CountWords", Count.<String>perElement())
                .apply("FormatResults", MapElements
                        .into(TypeDescriptors.strings())
                .via((KV<String,Long>wordcount)->
                        wordcount.getKey()+": "+wordcount.getValue()))
                .apply(TextIO.write().to("ApacheBeam/src/main/resources/java1.txt").withNumShards(1));
        pipeline.run();
    }
}
