## 👋인사잘해팀 : HR(human resources)
### 프로젝트 소개
![인사잘해](https://github.com/user-attachments/assets/f716eb9a-44d8-495e-a3f5-ca0665107627)

> 인사 및 근태 관리를 통합한 사내 HR 프로그램!

본 프로젝트는 사내 인사 및 근태 관리를 효율화하기 위해 개발된 HR 시스템입니다.
직원들은 사내 채팅, 휴가 신청, 출퇴근 기록, 게시판 활용, 급여 확인 등을 하나의 플랫폼에서 손쉽게 처리할 수 있습니다.
관리자들은 직원 정보 및 근태를 체계적으로 관리할 수 있어 업무 생산성이 향상됩니다.

---

### [배포 사이트 바로가기↗︎](http://34.47.90.224:3000/)
**접속 가능한 계정**
- 일반사용자
  - **ID** : 20241216
  - **PW** : 123123123
- 관리자
  - **ID** : admin
  - **PW** : 123123123

---

### API 문서
**Swagger-UI** : http://34.47.90.224:8080/swagger-ui/index.html

---

### 개발 기간
- 2024.11.18 ~ 2024.12.13

---

### 팀원 소개
| 이름 (Name) | 역할 (Role)  | 담당 도메인 (Domain) | 
  |-----------|------------|-----------------|
| 정현        | 팀장 (Leader) | 사원              | 
| 한현        | 팀원 (Member) | 메신저             | 
| 이서율       | 팀원 (Member) | 게시판             |  
| 송진욱       | 팀원 (Member) | 근태/휴가/일정        | 
| 김준수       | 팀원 (Member) | 급여              | 

---

### 기술 스택
- **Frontend** : React, Bootstrap, HTML, CSS, Javascript
- **Backend** : Java, JPA, Spring Boot, Spring Security, JWT, Websocket, STOMP, MyBatis, QueryDSL
- **Storage** : AWS S3, MariaDB
- **Deployment**: GCP, Nginx

---

### 와이어프레임
![와이어프레임](https://github.com/user-attachments/assets/794f6b45-ce24-4aec-a9ec-80a0aacc2d6e)

---

### ERD
![인사잘해_ERD_](https://github.com/user-attachments/assets/c9493a0d-0411-441d-9352-c25bdf94b6f6)


---
### 📌담당한 기능
## 급여
## 1. 급여 데이터 엑셀 다운로드  
- 부서별, 개인별 선택 가능  
- 연도별, 월별 선택 가능  
- 선택된 조건에 맞는 집계 데이터를 엑셀 파일로 다운로드  

### (월별, 개인) - 엑셀 통계
https://github.com/user-attachments/assets/12ad22be-4f3e-475d-978e-51e60c323b68

### (연도별, 부서) - 엑셀 통계
https://github.com/user-attachments/assets/ebc3df87-b2f5-43fd-b899-1f6a3462bd00

## 2. 급여 엑셀 업로드
- 엑셀 파일을 통해 급여 추가 대상 사원의 정보를 입력  
- 추가 화면을 통한 단건 추가가 아닌 대량 데이터 업로드 지원

https://github.com/user-attachments/assets/0af9bb94-8a02-4095-a226-c97118826251

## 3. 급여 검색  
- 조회 기간, 직급, 부서, 이름을 기준으로 급여 데이터 검색 지원
![급여관리_조건조회](https://github.com/user-attachments/assets/9d4ed6eb-c80d-494a-8452-61bb4137eec8)

## 4. 급여 등록
- 직급 및 부서 선택 시 해당 조건에 맞는 직원 조회  
- 지급 총액 및 공제 총액 입력 시 실지급액 자동 계산
![급여관리_추가](https://github.com/user-attachments/assets/6e15d851-e3c8-438a-be66-1154a74b8ae4)

## 5. 급여 삭제
- 체크 박스를 통해 선택된 급여 데이터 삭제  
- 전체 선택 기능을 통해 현재 페이지의 급여 데이터 일괄 삭제 
![급여관리_삭제](https://github.com/user-attachments/assets/994f78c9-9f90-4e19-86c3-6485fc07c7c0)

### 📌주요 기능
##### 홈
![hr-handlers_10](https://github.com/user-attachments/assets/5600f126-6579-4f80-a54a-f55dec33115f)


##### 사원
![hr-handlers_11](https://github.com/user-attachments/assets/d9ccfe1e-89ad-4343-84d6-88574f2efc1b)

![hr-handlers_12](https://github.com/user-attachments/assets/41329fa7-6540-4d1d-b025-c63eec56e16e)


##### 근태
![hr-handlers_14](https://github.com/user-attachments/assets/ac5b86c4-a701-4e38-87fc-2674dfca00be)


##### 일정
![hr-handlers_16](https://github.com/user-attachments/assets/bcb42850-8533-4a30-9455-1ac19d56f22b)


##### 휴가
![hr-handlers_15](https://github.com/user-attachments/assets/0a24fa4f-5a50-463d-8320-d96d1d5b60cf)


##### 게시판
![image](https://github.com/user-attachments/assets/205892f3-34f4-4959-826f-4d2ca5063b8f)
![image](https://github.com/user-attachments/assets/5f52c282-f22c-463d-846a-f06d38e85da5)
![image](https://github.com/user-attachments/assets/6ae15232-d647-43d3-a669-41cefd1a74ff)


##### 메신저
![image](https://github.com/user-attachments/assets/36d9e459-8060-49e9-9c7a-71ce462e61b4)
