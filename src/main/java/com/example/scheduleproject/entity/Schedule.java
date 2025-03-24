package com.example.scheduleproject.entity;



import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Schedule {

    private Long id;
    private String todo;
    private String writer;
    private String  password;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;


    public Schedule(Long scheduleId, String todo, String writer, String password) {
        this.id = scheduleId;
        this.todo = todo;
        this.writer = writer;
        this.password = password;
        this.createDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();


    }
}
