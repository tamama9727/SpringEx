package com.gunn.ex.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gunn.ex.lifecycle.model.Person;

//@Controller
@RestController //controller + responseBody
public class Ex01RestController {

	@RequestMapping("lifecycle/ex01/3")
	public String printString() {
		
		return "RestController Test";
	}
	
	@RequestMapping("lifecycle/ex01/4")
	public Person printObject() {
		Person person = new Person();
		person.setName("권성진");
		person.setAge(25);
		
		return person;
	}
	
	@RequestMapping("lifecycle/ex01/5")
	public ResponseEntity<Person> entity(){
		Person person = new Person();
		person.setName("권성진");
		person.setAge(25);
		
		//데이터를 전달할때 response의 status 코드를 추가로 전달
		//전상 status 코드 200 OK
		
		ResponseEntity<Person> entity = new ResponseEntity(person, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
		
	}
}
