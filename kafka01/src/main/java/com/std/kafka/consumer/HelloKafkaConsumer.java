/**
 * @FileName:HelloConsumer
 * @Package: com.std.kafka.consumer
 *
 * @author sence
 * @created 4/20/2015 11:49 AM
 *
 * Copyright 2011-2015 Asura
 */
package com.std.kafka.consumer;

import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Properties;

/**
 *
 * <p>消费者</p>
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
public class HelloKafkaConsumer {

	public static void main (String[] args) {
		Properties props = new Properties();

		props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("bootstrap.servers","192.168.12.105:9092,192.168.12.106:9092,192.168.12.107:9092");
		props.put("partition.assignment.strategy","default");
		props.put("enable.auto.commit","true");
		props.put("group.id","testgroup");

		KafkaConsumer consumer = new KafkaConsumer(props);
		consumer.subscribe("testrep");

		consumer.close();

	}
}
