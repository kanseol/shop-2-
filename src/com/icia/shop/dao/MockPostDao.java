package com.icia.shop.dao;

import java.time.*;
import java.util.*;
import java.util.stream.*;

import com.icia.shop.entity.*;

public class MockPostDao {
	private static List<Post> list = new ArrayList<>();
	
	static {
		for(int i=10; i>0; i--) {
			list.add(new Post(i, i+"번째 글", "연습용 글이에요", "spring", LocalDateTime.now(), 0));
		}
	}

	public static List<Post> finaAll() {
		return list.stream().sorted(Comparator.comparing(Post::getPno).reversed())
				.collect(Collectors.toList());
	}
	
	public static Post findById(int pno) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getPno()==pno) {
				list.get(i).setReadCnt(list.get(i).getReadCnt()+1);
				return list.get(i);
			}
		}
		return null;
	}
	
	public static void insert(Post post) {
		post.setPno(list.size()+1);
		list.add(post);
	}

	public static void delete(int pno) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getPno()==pno)
				list.remove(i);
		}
	}

	public static int max() {
		int max = 0;
		for(Post post:list) {
			if(post.getPno()>max) 
				max=post.getPno();
		}
		return max;
	}
	
	public static void update(int pno, String title, String content) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getPno()==pno) {
				list.get(i).setTitle(title);
				list.get(i).setContent(content);
			}
		}
	}

}
