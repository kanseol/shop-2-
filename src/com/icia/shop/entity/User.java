package com.icia.shop.entity;

import java.time.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	private String username;
	private String password;
	private String irum;
	private String email;
	@Builder.Default
	private LocalDate joinday = LocalDate.now();
}
