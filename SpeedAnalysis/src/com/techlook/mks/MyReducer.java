package com.techlook.mks;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<Text, IntWritable, NullWritable, Text> {

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Context context) throws IOException, InterruptedException {
		final int MAX=65;
		int offence=0;
		int vehicleVisited=0;
		
		for(IntWritable speed:values)
		{
			vehicleVisited++;
			if(speed.get()>MAX)
			{
			offence++;	
			}
			
		}
		String output="The vehicle number is: "+key+"\n"+"Visited "+vehicleVisited+" times"+"\n"
				+ "Crossed the maximum speed: "+offence+"\n"+"Offence percentage for "+key+" is"+(offence*100)/vehicleVisited + "%";
		
		context.write(null,new Text(output));
	}

}
