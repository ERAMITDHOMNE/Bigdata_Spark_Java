package com.techlook.mks;

import java.io.IOException;



import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MyDriver {
	public static void main(String [] ar) throws IOException, ClassNotFoundException, InterruptedException
	{
	
	Configuration config=new Configuration();
	config.set("countryCode2Search",ar[2]);
	Job job=new Job(config,"MapReduce Job to Search a country code");
	
	job.setJarByClass(MyDriver.class);
	job.setMapperClass(MyMapper.class);
	job.setMapOutputKeyClass(NullWritable.class);
	job.setMapOutputValueClass(Text.class);
	job.setNumReduceTasks(0);
	FileInputFormat.addInputPath(job,new Path(ar[0]));
	FileOutputFormat.setOutputPath(job,new Path(ar[1]));
	System.exit(job.waitForCompletion(true)?0:1);
	}
	

}
