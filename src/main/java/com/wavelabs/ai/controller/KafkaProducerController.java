package com.wavelabs.ai.controller;

import com.wavelabs.ai.model.MarketData;
import com.wavelabs.ai.produce.MarketDataProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Kafka producer controller.
 */
@RestController
public class KafkaProducerController {

    /**
     * The constant logger.
     */
    public static Logger logger = LoggerFactory.getLogger("Cintroller");
    /**
     * The Market data producer.
     */
    @Autowired
    MarketDataProducer marketDataProducer;
    @Autowired
    private KafkaTemplate<String, MarketData> marketData;

    /**
     * Send message scheduler. It pushes a market data bean
     * to the topic every 5 seconds
     */
    @Scheduled(cron = "*/5 * * * * *")
    public void sendMessage() {
        MarketData marketDataBean = marketDataProducer.generateMarketData();
        logger.info("Market Data Bean:" + marketDataBean.toString());
        marketData.send("sb-topic", marketDataBean);
    }

}
