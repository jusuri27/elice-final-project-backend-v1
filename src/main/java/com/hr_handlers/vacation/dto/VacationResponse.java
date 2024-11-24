package com.hr_handlers.vacation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VacationResponse {

    private Long id;
    private String doc_num;
    private String title;
    private Timestamp startDate;
    private Timestamp endDate;
    private String reason;
    private String status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Long employeeId;
}
