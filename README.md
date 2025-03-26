📌**일정표 API**

|기능|Method|URL|Request|response|상태코드|
|---|---|---|---|---|---|
|일정등록|POST|/schedules|요청 body<br>{<br>"todo":"할 일",<br>"writer":"작성자",<br>"password":"비밀번호"<br>}|등록된 일정 정보<br>{<br>"id":1,<br>"todo":"할일,<br>"writer":"작성자",<br>"createDate":"작성 시간",<br>"upadateDate":"수정 시간"<br>}|200:생성됨|
|일정조회|GET|/schedule/{id}|path {id: 1}|단건 응답 정보<br>{<br>"id": 1,<br>"todo": "할 일",<br>"writer": "작성자",<br>"createDate":"작성 시간",<br>"upadateDate":"수정 시간"<br>}|200:성공|
|일정목록조회|GET|/schedule|X|다건 응답 정보 <br>[<br>{<br>"id": 1,<br>"todo": "할 일",<br>"writer": "작성자",<br>"createDate":"작성 시간",<br>"upadateDate":"수정 시간"<br>},<br>{<br>"id": 2,<br>"todo": "또 다른 할 일"<br>.... <br>}<br>] |200:성공|
|일정단건수정|PATCH|/schedules/{id}|path {id: 1}<br>요청 body<br>{<br>"todo":"수정된 할 일",<br>"writer":"수정된 작성자"<br>"password":"비밀번호"<br>}|단건 수정 정보<br>{<br>"id": 1,<br>"todo": "수정된 할 일",<br>"writer": "수정된 작성자",<br>"createDate":"작성 시간",<br>"upadateDate":"수정 시간"<br>}|200:성공|
|일정삭제|DELETE|/schedule/{id}|path {id: 1}<br>요청 body<br>{<br>"password":"비밀번호"<br>}|삭제완료메시지|200:성공|


📌**일정표 ERD**
<br>
<br> ![Schedule ERD](https://github.com/kangdalho/Schedule/blob/main/ScheduleERD.PNG?raw=true)
