package com.wavelabs.ai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * The type Market data.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarketData {

    private BigDecimal price;

    private String ricCode;

    private String lastUpdatedTime;
}
