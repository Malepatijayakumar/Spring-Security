package com.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor 
public class CustomerDTO {
	private Long id;
	@NonNull
	private String email;
	@NonNull
	private String pwd;
	@NonNull
	private String role;
}