package com.example.scheduleproject.controller;

import com.example.scheduleproject.dto.ScheduleRequestDto;
import com.example.scheduleproject.dto.ScheduleResponseDto;
import com.example.scheduleproject.entity.Schedule;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final Map<Long, Schedule> scheduleList = new HashMap<>();

    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto dto){
        // 식별자가 1씩 증가 하도록 만듦
       Long scheduleId = scheduleList.isEmpty() ? 1: Collections.max(scheduleList.keySet()) + 1;

        // 요청받은 데이터로 Schedule 객체 생성
       Schedule schedule = new Schedule(scheduleId, dto.getTodo(), dto.getWriter(), dto.getPassword());


        //Inmemory DB에 Schedule 메모
        scheduleList.put(scheduleId, schedule);

        return new ScheduleResponseDto(schedule);


    }

    @GetMapping("/{id}")
    public ScheduleResponseDto findScheduleById(@PathVariable Long id){

        Schedule schedule = scheduleList.get(id);

        return new ScheduleResponseDto(schedule);

    }

}
