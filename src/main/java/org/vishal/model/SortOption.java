package org.vishal.model;

public enum SortOption {
    PRICE_HIGH_TO_LOW("Price: High to Low"),
    PRICE_LOW_TO_HIGH("Price: Low to High"),
    CUSTOMER_REVIEW("Avg. Customer Review"),
    NEWEST_ARRIVALS("Newest Arrivals");

    public String code;
    SortOption(String code) {
        this.code=code;
    }
}
