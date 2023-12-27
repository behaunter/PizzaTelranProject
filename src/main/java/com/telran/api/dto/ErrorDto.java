package com.telran.api.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class ErrorDto {
    public String timestamp;
    public int status;
    public String error;
    public String path;
}
