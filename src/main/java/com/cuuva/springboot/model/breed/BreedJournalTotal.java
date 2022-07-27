package com.cuuva.springboot.model.breed;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class BreedJournalTotal {
    private Integer preCount;
    private Integer preWeight;
    private BigDecimal feedAm;
    private BigDecimal feedPm;
    private BigDecimal feedSum;
    private Integer count;
    private Integer weight;
    private BigDecimal avWeight;
    private BigDecimal sFeed;
    private BigDecimal preTotalFeed;
    private BigDecimal totalFeed;
}
