package com.example.scheduleproject.controller;

import com.example.scheduleproject.dto.ScheduleRequestDto;
import com.example.scheduleproject.dto.ScheduleResponseDto;
import com.example.scheduleproject.entity.Schedule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final Map<Long, Schedule> scheduleList = new HashMap<>();

    //일정 생성
    @PostMapping
    public ResponseEntity<?> createSchedule(@RequestBody ScheduleRequestDto dto) {

        // 식별자가 1씩 증가 하도록 만듦
        Long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;

        // 요청받은 데이터로 Schedule 객체 생성
        Schedule schedule = new Schedule(scheduleId, dto.getTodo(), dto.getWriter(), dto.getPassword());

        //Inmemory DB에 Schedule 메모
        scheduleList.put(scheduleId, schedule);

        if(dto.getWriter() ==null){
            return new ResponseEntity<>("작성자는 반드시 입력해주세요",HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.OK);

    }

    //일정 단건 조회  
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id) {

        Schedule schedule = scheduleList.get(id);

        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.OK);

    }

    //일정 전체 조회
    @GetMapping
    public Collection<ScheduleResponseDto> findAllSchedules() {

        List<ScheduleResponseDto> responseList = new ArrayList<>();

        for (Schedule schedule : scheduleList.values()) {
            responseList.add(new ScheduleResponseDto(schedule));
        }
        return responseList;
    }

    //일정 단건 수정
    @PatchMapping({"/{id}"})
    public ResponseEntity<?> updateScheduleById(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto dto
    ) {
        Schedule schedule = scheduleList.get(id);
        //비밀번호 검증
        if(!schedule.getPassword().equals(dto.getPassword())){
            return new ResponseEntity<>("비밀번호가 일치하지 않습니다.",HttpStatus.FORBIDDEN);
        }
        schedule.update(dto);
        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.OK);
    }

    //일정 전체 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSchedule(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto dto
    ) {
        Schedule schedule = scheduleList.get(id);
        //비밀번호 검증
        if(!schedule.getPassword().equals(dto.getPassword())){
            return new ResponseEntity<>("비밀번호가 일치하지 않습니다.",HttpStatus.FORBIDDEN);
        }
        scheduleList.remove(id);
        return new ResponseEntity<>("일정이 삭제 되었습니다.",HttpStatus.OK);
    }

}
