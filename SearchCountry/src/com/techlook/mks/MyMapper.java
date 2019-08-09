package com.techlook.mks;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable, Text, NullWritable, Text> {

	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		String line=value.toString();
		
		String []lineParts=line.split(",");
		
		String countryCode=lineParts[1];
		
		String countryCode2Search=context.getConfiguration().get("countryCode2Search");
		
		if(countryCode.equals(countryCode2Search))
		{
			context.write(null, value);
		}
	}
	
	

}
