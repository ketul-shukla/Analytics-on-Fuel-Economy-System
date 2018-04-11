/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fueleconomy;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 *
 * @author ketul
 */
public class FuelEconomy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
     
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "Count Number of Cars for company");
        
        job.setJarByClass(FuelEconomy.class);
        
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        
        job.setMapperClass(FuelEconomyMap.class);
        job.setReducerClass(FuelEconomyReduce.class);
        
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        
        FileInputFormat.addInputPath(job, new Path(args[1]));
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        
        System.exit(job.waitForCompletion(true) ? 0:1);
    }
    
}
