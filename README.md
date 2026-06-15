## 👋인사잘해팀 : HR(human resources)
### 프로젝트 소개
![인사잘해](https://github.com/user-attachments/assets/f716eb9a-44d8-495e-a3f5-ca0665107627)

> 인사 및 근태 관리를 통합한 사내 HR 프로그램!

본 프로젝트는 사내 인사 및 근태 관리를 효율화하기 위해 개발된 HR 시스템입니다.</br>
직원들은 사내 채팅, 휴가 신청, 출퇴근 기록, 게시판 활용, 급여 확인 등을 하나의 플랫폼에서 손쉽게 처리할 수 있습니다.</br>
관리자들은 직원 정보 및 근태를 체계적으로 관리할 수 있어 업무 생산성이 향상됩니다.</br>


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


## Excel 처리 및 대용량 업로드 관련 리팩토링

### 1. 엑셀 데이터 가독성 향상

- **레이아웃 조정**
  - 첫 번째 열(A열)과 첫 번째 행(1행)을 공백으로 비움
  - 2행 2열(B2 셀)부터 데이터 표시

- **시각적 강조**
  - 헤더(제목 행)에 색상 적용하여 강조
  - 바디 영역에는 셀 테두리 추가로 구분감 확보
    
### ✅ 개인별 연 급여 통계
| 변경 전 | 변경 후 |
|--------|--------|
| <img src="https://github.com/user-attachments/assets/169f1291-28ae-49b6-9186-9a6a09d12f7d" width="100%" height=500/> | <img src="https://github.com/user-attachments/assets/e3b0b92b-91a8-40c4-823d-b7c6ca2e8936" width="100%" height=500/> |

### ✅ 부서별 월 급여 통계
| 변경 전 | 변경 후 |
|--------|--------|
| <img src="https://github.com/user-attachments/assets/e4ef5f03-a10e-4bf2-8f2d-d0f75e41df77" width="100%" height=500/> | <img src="https://github.com/user-attachments/assets/eb29a935-d1f5-41df-94c6-09cd9b4939be" width="100%" height=500/> |
| 변경 전 | 변경 후 |

---
## 2. SAX 방식 도입을 통한 엑셀 파싱 리팩토링
✅ DOM 방식(변경전)
| 데이터 건수 | Max Memory | Total Memory | Free Memory | API 사용 메모리       | 수행 시간      |
| ------ | ---------- | ------------ | ----------- | ---------------- | ---------- |
| 10만 건  | 2048MB     | 512MB        | 458MB       | 403MB            | 8초         |
| 30만 건  | 2048MB     | 512MB        | 461MB       | 1227MB           | 14초        |
| 100만 건 | 2048MB     | 512MB        | ???MB       | **예상 4000MB 이상** | **예상 40초** |


✅ SAX 방식(변경후)
| 데이터 건수 | Max Memory | Total Memory | Free Memory | API 사용 메모리   | 수행 시간   |
| ------ | ---------- | ------------ | ----------- | ------------ | ------- |
| 10만 건  | 2048MB     | 512MB        | 458MB       | 12MB         | 7초      |
| 30만 건  | 2048MB     | 512MB        | 461MB       | 35MB         | 12초     |
| 100만 건 | 2048MB     | 512MB        | 460MB       | **예상 113MB** | **27초** |


💡 메모리 사용 비교
| 데이터 건수 | DOM 사용량    | SAX 사용량   | 메모리 절감률           |
| ------ | ---------- | --------- | ----------------- |
| 10만 건  | 403MB      | 12MB      | 약 **97% 절감**      |
| 30만 건  | 1227MB     | 35MB      | 약 **97.2% 절감**    |
| 100만 건 | 4000MB(예상) | 113MB(예상) | 약 **97.2% 이상 절감** |


---
## 3. 대용량 데이터 처리 성능 개선을 위한 저장 로직 리팩토링


✅ saveAll() vs foreach 성능 비교
| saveAll()         | 데이터 건수    | 수행 시간 (초) |
| ----------- | --------- | --------- |
| `saveAll()` | 100,000   | 37        |
| `saveAll()` | 300,000   | 103       |
| `saveAll()` | 1,000,000 | 325       |

| foreach         | 데이터 건수    | 수행 시간 (초) |
| ----------- | --------- | --------- |
| `foreach`  | 100,000   | 7         |
| `foreach`  | 300,000   | 22        |
| `foreach`  | 1,000,000 | 68        |

✅ foreach 10만 건씩 반복 처리 (엑셀 100만건 기준)
| 수행 횟수  | Total Memory (MB) | Free Memory (MB) | Used Memory (MB) | 실행 시간 (초) |
| ------ | ----------------- | ---------------- | ---------------- | --------- |
| 1      | 1119.000          | 446.207          | 672.793          | 8.36      |
| 2      | 1206.000          | 628.121          | 577.879          | 6.65      |
| 3      | 1402.000          | 805.998          | 596.002          | 6.55      |
| 4      | 1402.000          | 704.200          | 697.800          | 6.46      |
| 5      | 1661.000          | 646.314          | 1014.686         | 6.43      |
| 6      | 1677.000          | 563.840          | 1113.160         | 6.52      |
| 7      | 1677.000          | 679.430          | 997.570          | 6.76      |
| 8      | 1826.000          | 1163.502         | 662.498          | 6.72      |
| 9      | 1913.000          | 953.057          | 959.943          | 6.47      |
| 10     | 1967.000          | 970.107          | 996.893          | 6.63      |
| **총합** | -                 | -                | -                | **68.53** |

---
## 트러블 슈팅
### 100MB 초과로 인한 엑셀 파싱 실패 -> [블로그 정리](https://rnwns2.tistory.com/160)
### 대용량 엑셀 파일 파싱시 메모리 부족 -> [블로그 정리](https://rnwns2.tistory.com/161)
### 대용량 데이터 저장시 메모리 부족 -> [블로그 정리](https://rnwns2.tistory.com/162)

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
