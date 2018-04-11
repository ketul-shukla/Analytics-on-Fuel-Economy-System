 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bestcarclassmileage;

import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 *
 * @author ketul
 */
public class BestCarClassMileageReduce extends Reducer<Text, MultipleWritable, Text, MultipleWritable> {
    
    MultipleWritable textValue = new MultipleWritable();
    
    @Override
    protected void reduce(Text key, Iterable<MultipleWritable> values, Context context) throws IOException, InterruptedException {
        float maxValue = 0;
        for(MultipleWritable value: values){
            if(!value.getMake().isEmpty() && !value.getFuelType().isEmpty()){
                if(value.getFuelType().equalsIgnoreCase("regular")){
                    float compareValue = value.getHighwayMileage();
                    if(compareValue > maxValue){
                        maxValue = compareValue;
                        textValue.setHighwayMileage(maxValue);
                        textValue.setMake(value.getMake());
                        textValue.setModel(value.getModel());
                        textValue.setFuelType(value.getFuelType());
                    }
                }
            }
        }
        context.write(key, textValue);
    }
}
