/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bestcarclassmileage;

import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author ketul
 */
public class BestCarClassMileageMap extends Mapper<Object, Text, Text, MultipleWritable>{
    
    Text textKey = new Text();
    MultipleWritable textValue = new MultipleWritable();

    @Override
    protected void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        
        String line = value.toString();
        String[] field = line.split(";");
        
        textValue.setHighwayMileage(Float.parseFloat(field[34]));
        textValue.setMake(field[47]);
        textValue.setModel(field[48]);
        textValue.setFuelType(field[30]);
        
        textKey.set(field[38]);
        
        context.write(textKey, textValue);
    }
    
    
    
}
