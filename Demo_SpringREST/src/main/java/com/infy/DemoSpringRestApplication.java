package com.infy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringRestApplication.class, args);
	}

}
/*
reminder not to copy newline after http messages
db table: customer_db

get all:
http://localhost:8765/infybank/customers
get:
http://localhost:8765/infybank/customers/1

post:
http://localhost:8765/infybank/customers
body:JSON:
{
"customerId" : 4, 
"emailId" : "Alexander@infy.com", 
"name" : "Alexander"
}

update:
http://localhost:8765/infybank/customers/2
{
"emailId" : "Tim123@infy.com"
}

delete:
http://localhost:8765/infybank/customers/4
*/