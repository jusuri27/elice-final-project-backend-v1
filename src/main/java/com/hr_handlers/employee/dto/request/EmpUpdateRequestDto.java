package com.hr_handlers.employee.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmpUpdateRequestDto {
    private String email;
    private String phone;
    private String introduction;
    private String profileImageUrl;
}