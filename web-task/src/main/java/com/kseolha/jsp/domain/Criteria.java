package com.kseolha.jsp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Criteria {
    private int pageNum = 1;
    private int amount = 10;
    private int category = 1;
    private String type = "title";
    private String keyword = "";

    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

    public String getQueryString() {
        String str = "";
        str += "amount=" + amount + "&category=" + category;
        if (!type.equals("")) {
            str += "&type=" + type + "&keyword=" + keyword;
        }
        return str;
    }

    public String getFullQueryString() {
        String str = "pageNum=" + pageNum + "&";
        str += getQueryString();
        return str;
    }
}
