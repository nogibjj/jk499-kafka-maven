package com.example.kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.*;

import java.util.Properties;

public class Producer {
    public static void main(String[] args){

        final Logger logger = LoggerFactory.getLogger(Producer.class);

        //Create properties object for Producer
        Properties prop = new Properties();
        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        //Create the Producer
        final KafkaProducer<String, String> producer = new KafkaProducer<String, String>(prop);

        //Create the ProducerRecord
        ProducerRecord<String, String> record = new ProducerRecord<>("test","key2","value2");

        //Send Data - Asynchronous
        producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if(e == null){
                    logger.info("\nReceived Record Metadata\n" + "Topic: "
                            + recordMetadata.topic() + ", Offset: " + recordMetadata.offset()
                    + ", Timestamp: " + recordMetadata.timestamp() + "\n");
                }else{
                    logger.error("Error occured while sending record", e);
                }
            }
        });

        //flush and close Producer
        producer.flush();
        producer.close();
    }
}
