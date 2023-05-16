package com.exciting.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ChatDTO {
	int alarm_id;
	String member_id;
	Date postdate;
}
