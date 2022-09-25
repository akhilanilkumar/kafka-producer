package com.wavelabs.ai.produce;

import com.wavelabs.ai.model.MarketData;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The service Market data producer.
 */
@Service
public class MarketDataProducer {

    private static final List<String> ricCodes = IntStream.rangeClosed('A', 'Z').mapToObj(var -> (char) var + ".HK").collect(Collectors.toList());
    ;
    private static Integer lastRic = BigInteger.ZERO.intValueExact();

    /**
     * Generate market data market data.
     *
     * @return the market data bean
     */
    public MarketData generateMarketData() {
        return new MarketData(newRandomPrice(new Random()), generateRicCode(), new Date().toString());
    }

    private BigDecimal newRandomPrice(Random r) {
        return BigDecimal
                .valueOf((double) r.nextInt(100) + r.nextDouble())
                .setScale(2, RoundingMode.CEILING);
    }

    private String generateRicCode() {
        Random r = new Random();
        int generated = r.nextInt(ricCodes.size());
        if (generated == lastRic) {
            generateRicCode();
        }
        lastRic = generated;
        return ricCodes.get(lastRic);
    }
}
