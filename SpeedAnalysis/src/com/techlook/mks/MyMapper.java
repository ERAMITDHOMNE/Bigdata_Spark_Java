package com.techlook.mks;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable,Text,Text,IntWritable> {

	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		
		String line=value.toString();
		String []lineParts=line.split(",");
		
		String numberPlate=lineParts[0];
		
		int vehicleSpeed=Integer.parseInt(lineParts[1]);
		
		context.write(new Text(numberPlate), new IntWritable(vehicleSpeed));
		
		
	}
	

}
