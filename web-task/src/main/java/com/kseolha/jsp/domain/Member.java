package com.kseolha.jsp.domain;

import lombok.*;

import java.util.Date;

@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode @RequiredArgsConstructor

public class Member {
    @NonNull
    private String id;
    @NonNull
    private String pw;
    @NonNull
    private String name;
    private Date regdate;
}
