# Complete Kafka Producer with Java | Kafka Data Pipeline

**Developer:** Jaya Khan 

## Abstract
This project creates a Producer class to send a record to Kafka Topic. 

## Steps
1. Install Kafka on Mac using Homebrew:

    `brew install java --cask`
    
    `brew install kafka`
2. Start ZooKeeper
    
    `zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties`
3. Start Kafka

   `kafka-server-start /usr/local/etc/kafka/server.properties`
4. Create a Topic with name test

   `kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test`
5. Start Kafka console for Producer

    `kafka-console-producer --broker-list localhost:9092 --topic test`
6. Start Kafka console for Consumer

   `kafka-console-consumer --bootstrap-server localhost:9092 --topic test --from-beginning`

## References

[1] https://medium.com/@Ankitthakur/apache-kafka-installation-on-mac-using-homebrew-a367cdefd273

[2] https://www.cloudkarafka.com/blog/part1-kafka-for-beginners-what-is-apache-kafka.html#:~:text=Kafka%20Broker&text=Producers%20are%20processes%20that%20push,%2C%20for%20example%2C%20data%20replication.

[3] https://www.conduktor.io/kafka/complete-kafka-producer-with-java/

[4] https://kafka.apache.org/documentation/#producerconfigs
