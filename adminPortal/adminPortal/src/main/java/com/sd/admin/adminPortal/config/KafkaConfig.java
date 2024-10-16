package com.sd.admin.adminPortal.config;

import com.sd.admin.adminPortal.constant.Kafka_Constants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic topic()
    {
        return TopicBuilder
                .name(Kafka_Constants.LOCATION_TOPIC_NAME)
//                .partitions()
//                .replicas()
                .build();
    }
}
