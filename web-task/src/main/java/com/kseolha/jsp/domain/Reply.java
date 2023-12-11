package com.kseolha.jsp.domain;

import lombok.*;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
public class Reply {
    private Long rno;
    @NonNull
    private String content;
    private Date regdate;
    @NonNull
    private String writer;
    @NonNull
    private Long bno;
}
