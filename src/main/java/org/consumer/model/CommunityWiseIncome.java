package org.consumer.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class CommunityWiseIncome {

    private String community_area_name;
    private int per_capita_income_;

    public String getCommunity_area_name() {
        return community_area_name;
    }

    public void setCommunity_area_name(String community_area_name) {
        this.community_area_name = community_area_name;
    }

    public int getPer_capita_income_() {
        return per_capita_income_;
    }

    public void setPer_capita_income_(int per_capita_income_) {
        this.per_capita_income_ = per_capita_income_;
    }
}
