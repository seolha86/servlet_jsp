package com.kseolha.jsp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class PageDto {
    private int pageCount = 10;
    private int startPage;
    private int endPage;
    private int total;
    private boolean prev;
    private boolean next;
    private boolean doublePrev;
    private boolean doubleNext;
    private Criteria cri;

    public PageDto(int total, Criteria cri) {
        this(10, total, cri);
    }

    public PageDto(int pageCount, int total, Criteria cri) {
        this.pageCount = pageCount;
        this.total = total;
        this.cri = cri;

        endPage = (cri.getPageNum() + (pageCount - 1)) / pageCount * pageCount;
        startPage = endPage - (pageCount - 1);

        int realEnd = (total + (cri.getAmount() - 1)) / cri.getAmount();

        if (endPage > realEnd) {
            endPage = realEnd;
        }

        prev = cri.getPageNum() > 1;
        next = cri.getPageNum() < realEnd;

        doublePrev = startPage > 1;
        doubleNext = endPage < realEnd;
    }
}
