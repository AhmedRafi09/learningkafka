package kafka.kafka.learning1;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class Producer {
    public static void main(String[] args) {


        String bootstrapServers = "127.0.0.1:9092";

        // create Producer properties
        Properties properties = new Properties();

        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());



        //create Producer

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        // create a Producer Record

        ProducerRecord<String, String> record =
                new ProducerRecord<String, String>("topic2", "hello world");


        // send data



        producer.send(record);

        // flush data

        producer.flush();

        // flush and close Producer
        producer.close();
    }
}
