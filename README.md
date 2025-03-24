|기능|Method|URL|Request|response|상태코드|
|---|---|---|---|---|---|
|일정등록|POST|/schedules|요청 body{"todo":할 일,"writer":"작성자","password":"비밀번호"}|등록된 일정 정보{"id":1,"todo":"할일,"writer":"작성자","createDate":"작성 시간","upadateDate":"수정 시간"|200:생성됨|
|일정조회|GET|/schedule/{id}|요청 param {id: 1}|단건 응답 정보{ "id": 1, "todo": "할 일", "writer": "작성자","createDate":"작성 시간","upadateDate":"수정 시간"|200:성공|
