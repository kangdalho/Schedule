package com.example.scheduleproject.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@NoArgsConstructor
@Getter
public class ScheduleRequestDto {

    private String todo;
    private String writer;
    private String password;

}
