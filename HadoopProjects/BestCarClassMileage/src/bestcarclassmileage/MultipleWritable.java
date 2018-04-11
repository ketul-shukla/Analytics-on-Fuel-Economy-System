/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bestcarclassmileage;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Writable;

/**
 *
 * @author ketul
 */
public class MultipleWritable implements Writable{
    
    private float highwayMileage;
    private String make;
    private String model;
    private String fuelType;
    
    public MultipleWritable(){}
    
    public MultipleWritable(float highwayMileage, String make, String model){
	this.highwayMileage = highwayMileage;
	this.make = make;
	this.model = model;
    }

    public float getHighwayMileage() {
        return highwayMileage;
    }

    public void setHighwayMileage(float highwayMileage) {
        this.highwayMileage = highwayMileage;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeFloat(highwayMileage);
	out.writeUTF(make);
	out.writeUTF(model);
        out.writeUTF(fuelType);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        highwayMileage = in.readFloat();
	make = in.readUTF();
	model = in.readUTF();
        fuelType = in.readUTF();
    }
    
    @Override
    public String toString(){
	return highwayMileage + "\t" + make + "\t" + model + "\t" + fuelType; 
    }
    
}
