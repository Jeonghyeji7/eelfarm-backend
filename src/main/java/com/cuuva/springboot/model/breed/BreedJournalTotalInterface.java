package com.cuuva.springboot.model.breed;

import java.math.BigDecimal;

public interface BreedJournalTotalInterface {
    Integer getPreCount();
    Integer getPreWeight();
    BigDecimal getFeedAm();
    BigDecimal getFeedPm();
    BigDecimal getFeedSum();
    Integer getCount();
    Integer getWeight();
    BigDecimal getAvWeight();
    BigDecimal getSFeed();
    BigDecimal getPreTotalFeed();
    BigDecimal getTotalFeed();
}
