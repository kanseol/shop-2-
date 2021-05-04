package com.icia.shop.entity;

import java.time.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
	private int pno;
	private String title;
	private String content;
	private String writer;
	@Builder.Default
	private LocalDateTime writeTime = LocalDateTime.now();
	@Builder.Default
	private int readCnt = 0;
}
