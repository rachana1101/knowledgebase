package com.datastructure.problems.amazon.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class SortObjects {
	
	public static void main(String argv[]){
		ArrayList<User> users = new ArrayList<User>();
		User user1 = new User("rachana",2, new Date());
		User user2 = new User("mamta",1, new Date("01-01-2012"));
		User user3 = new User("pratush",3, new Date("01-01-2011"));
		users.add(user1);
		users.add(user2);
		users.add(user3);
		for(User u:users) {
			System.out.println(u.rank);
		}
		Collections.sort(users);
		for(User u:users) {
			System.out.println(u.rank);
		}
		
	}
}

class User implements Comparable<User>{
	public String name;
	public int rank;
	public Date bof;
	
	public User(String name, int rank, Date bof) {
		this.name = name;
		this.rank = rank;
		this.bof = bof;
	}

	public int compareTo(User o) {
		return (int) (this.bof.getTime()-o.bof.getTime());
	}
}
