package com.kseolha.jsp.domain;

import lombok.*;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class Board {
    private Long bno;
    private String title;
    private String content;
    private String writer;
    private Date regdate;
    private String updatedate;
    private Integer hitcount;
    private Integer category;

    private Long prevBno;
    private Long nextBno;

    public Board(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
