package com.techlook.mks;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		String line = value.toString(); // Converting to String

		String[] lineParts = line.split(","); // Splitting and storing it in
												// array

		for (String words : lineParts) { // iterating the array elements
			Text outKey = new Text(words);
			IntWritable outValue = new IntWritable(1);
			context.write(outKey, outValue);

		}

	}

}
