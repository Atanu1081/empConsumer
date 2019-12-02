package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pojoClasses.EmpDetailsRequest;
import pojoClasses.EmpDetailsResponse;

@SpringBootApplication
public class EmpConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpConsumerApplication.class, args);
	}


	@Bean
	CommandLineRunner lookup (SOAPConnector connector)
	{
		return args -> {

			String name = "Karthik";
			if (args.length>0)
			{
				name=args[0];
			}

			EmpDetailsRequest request = new EmpDetailsRequest();
			request.setName(name);
			EmpDetailsResponse response = (EmpDetailsResponse)connector.callWebService("http://localhost:7777/service/emp-details",request);
			System.err.println("Got response as below : ");
			System.out.println(response.getEmployee().getName());
			System.out.println(response.getEmployee().getTeam());
			System.out.println(response.getEmployee().getYearOfExperience());

		};

	}

}
