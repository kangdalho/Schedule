package com.example.scheduleproject.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@Getter
public class ScheduleRequestDto {

    private String todo;
    private String writer;
    private String password;

}
