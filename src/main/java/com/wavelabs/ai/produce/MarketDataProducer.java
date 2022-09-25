package com.wavelabs.ai.produce;

import com.wavelabs.ai.model.MarketData;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * The service Market data producer.
 */
@Service
public class MarketDataProducer {

	private static Integer lastRic = BigInteger.ZERO.intValueExact() ;
	private static List<String> riccodes = List.of("A.HK","B.HK","C.HK","D.HK","E.HK","F.HK","G.HK","H.HK","I.HK","J.HK","K.HK","L.HK","M.HK","N.HK","O.HK","P.HK","Q.HK","R.HK","S.HK","T.HK","U.HK","V.HK","W.HK","X.HK","Y.HK","Z.HK");

	/**
	 * Generate market data market data.
	 *
	 * @return the market data bean
	 */
	public static MarketData generateMarketData(){

		return new MarketData(newRandomPrice(new Random(),2),generateRicCode(), new Date().toString());
	}

	private static BigDecimal newRandomPrice(Random r, int precision) {
		return new BigDecimal(
				new Double(
						r.nextInt(100))+r.nextDouble())
				.setScale(2, RoundingMode.CEILING);
	}

	private static String generateRicCode(){
		Random r = new Random();
		int generated = r.nextInt(riccodes.size());
		if(generated == lastRic)
		{
			generateRicCode();
		}
		lastRic = generated;
		return riccodes.get(lastRic);
	}
}
