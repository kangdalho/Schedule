package com.example.scheduleproject.dto;


import com.example.scheduleproject.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {

    private Long id;
    private String todo;
    private String writer;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public ScheduleResponseDto(Schedule schedule){
        this.id = schedule.getId();
        this.todo = schedule.getTodo();
        this.writer = schedule.getWriter();
        this.createDate = schedule.getCreateDate();
        this.updateDate = schedule.getUpdateDate();
    }

}
