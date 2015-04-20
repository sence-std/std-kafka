/**
 * @FileName:HelloKafkaProducer
 * @Package: com.std.kafka.producer
 *
 * @author sence
 * @created 4/17/2015 5:53 PM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Date;
import java.util.Properties;

/**
 *
 * <p>第一次使用kafka helloword</p>
 *
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author sence
 * @since 1.0
 * @version 1.0
 */
public class HelloKafkaProducer {

	public static void main (String[] args) {
		long events = 20L;
		Properties props = new Properties();
		//borker list?
		props.put("bootstrap.servers","192.168.12.105:9092,192.168.12.106:9092,192.168.12.107:9092");
		props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
		props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
		props.put("request.required.acks",1);

		Producer<String,String> producer =  new KafkaProducer<String, String>(props);
		for (long nEvents =0;nEvents<events;nEvents++){
			long runtime = new Date().getTime();
			String ip = "192.168.14.49";
			String msg = runtime + ",from java client," + ip;
			ProducerRecord<String, String> data = new ProducerRecord<String, String>("testrep", ip, msg);
			producer.send(data);
		}
		producer.close();

	}
}
