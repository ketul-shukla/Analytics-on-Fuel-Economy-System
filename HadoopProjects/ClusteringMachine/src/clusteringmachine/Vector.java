/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clusteringmachine;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.WritableComparable;

/**
 *
 * @author ketul
 */
public class Vector implements WritableComparable<Vector>{
    
    private double[] vector;
    
    public Vector(){
        super();
    }
    
    public Vector(Vector v){
        super();
        int l = v.vector.length;
        this.vector = new double[l];
    }
    
    public Vector (double x, double y){
        super();
        this.vector = new double[]{x,y};
    }
    
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(vector.length);
        for(int i=0; i < vector.length; i++){
            out.writeDouble(vector[i]);
        }
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        int size = in.readInt();
        vector = new double[size];
        for(int i=0;i<size; i++){
            vector[i] = in.readDouble();
        }
    }

    @Override
    public int compareTo(Vector o) {
        boolean equals = true;
        for(int i = 0;i < vector.length; i++){
           int c = (int) (vector[i] - o.vector[i]);
           if (c != 0.0d){
               return c;
           }
        }
        return 0;
    }   
}
