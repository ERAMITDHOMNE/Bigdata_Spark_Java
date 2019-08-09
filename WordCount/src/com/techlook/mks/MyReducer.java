package com.techlook.mks;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {

		// we need to count the occurrence of each key

		int sum = 0; // for summing the occurrence

		for (IntWritable value : values) {
			sum = sum + value.get(); // fetching the value and summing it
		}

		context.write(key, new IntWritable(sum));
		

	}

}
