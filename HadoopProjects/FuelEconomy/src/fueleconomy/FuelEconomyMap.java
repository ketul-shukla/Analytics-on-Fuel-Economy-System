/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fueleconomy;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author ketul
 */
public class FuelEconomyMap extends Mapper<Object, Text, Text, IntWritable> {
    String record;
    
    private IntWritable count = new IntWritable(1);
    private Text inputData = new Text();

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        record = value.toString();
        String[] field = record.split(";");
        
        inputData.set(field[47]);
        context.write(inputData, count);
        
    }
    
    
}
