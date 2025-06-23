package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootLongchain4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLongchain4jApplication.class, args);
	}

	@Bean
	    public CommandLineRunner loadDepartments(DepartmentRepository repository) {
	        return args -> {
	            repository.saveAll(List.of(
	                new Department(null, "Computer Science", "Dr. Meena", "Focuses on algorithms and programming"),
	                new Department(null, "Information Technology", "Dr. Rahul", "Covers networks and system admin"),
	                new Department(null, "Electronics", "Dr. Kavita", "Electronics circuits and embedded systems"),
	                new Department(null, "Mechanical", "Dr. Anil", "Mechanical design and thermodynamics"),
	                new Department(null, "Civil", "Dr. Arjun", "Construction and structural engineering"),
	                new Department(null, "Electrical", "Dr. Praveen", "Power systems and control"),
	                new Department(null, "AI & ML", "Dr. Sneha", "Artificial Intelligence and Machine Learning"),
	                new Department(null, "Data Science", "Dr. Nitin", "Big Data and Analytics"),
	                new Department(null, "Cyber Security", "Dr. Priya", "Digital security and encryption"),
	                new Department(null, "Robotics", "Dr. Sameer", "Robot design and automation"),

	                new Department(null, "Physics", "Dr. Sudha", "Modern physics and quantum mechanics"),
	                new Department(null, "Chemistry", "Dr. Ramesh", "Organic and inorganic chemistry"),
	                new Department(null, "Mathematics", "Dr. Latha", "Pure and applied mathematics"),
	                new Department(null, "English", "Dr. Shalini", "Communication and literature"),
	                new Department(null, "Economics", "Dr. Varun", "Micro and macro economics"),
	                new Department(null, "History", "Dr. Preeti", "Indian and world history"),
	                new Department(null, "Psychology", "Dr. Suresh", "Human behavior and cognition"),
	                new Department(null, "Philosophy", "Dr. Mahesh", "Logic and ethics"),
	                new Department(null, "Political Science", "Dr. Shweta", "Politics and public administration"),
	                new Department(null, "Sociology", "Dr. Rekha", "Social structures and institutions"),

	                new Department(null, "Commerce", "Dr. Manish", "Accounting and business studies"),
	                new Department(null, "Business Administration", "Dr. Deepa", "Management and entrepreneurship"),
	                new Department(null, "Environmental Science", "Dr. Ganesh", "Sustainability and ecology"),
	                new Department(null, "Biotechnology", "Dr. Neha", "Genetics and bioengineering"),
	                new Department(null, "Zoology", "Dr. Alok", "Animal biology"),
	                new Department(null, "Botany", "Dr. Savitha", "Plant biology"),
	                new Department(null, "Microbiology", "Dr. Usha", "Microscopic organisms"),
	                new Department(null, "Geography", "Dr. Ritu", "Earth and spatial sciences"),
	                new Department(null, "Geology", "Dr. Pavan", "Rocks and earth formation"),
	                new Department(null, "Statistics", "Dr. Amit", "Probability and data analysis"),

	                new Department(null, "Library Science", "Dr. Rashmi", "Cataloging and information systems"),
	                new Department(null, "Public Health", "Dr. Karthik", "Community health and policy"),
	                new Department(null, "Nursing", "Dr. Haritha", "Healthcare and nursing practices"),
	                new Department(null, "Pharmacy", "Dr. Vinod", "Medicinal chemistry and drug delivery"),
	                new Department(null, "Physiotherapy", "Dr. Shree", "Rehabilitation and therapy"),
	                new Department(null, "Education", "Dr. Yogesh", "Teaching and pedagogy"),
	                new Department(null, "Fine Arts", "Dr. Radhika", "Painting and sculpture"),
	                new Department(null, "Performing Arts", "Dr. Raj", "Dance and theatre"),
	                new Department(null, "Fashion Technology", "Dr. Anusha", "Apparel and textile design"),
	                new Department(null, "Interior Design", "Dr. Shruti", "Space and architecture design"),

	                new Department(null, "Law", "Dr. Krish", "Constitution and legal systems"),
	                new Department(null, "Journalism", "Dr. Vandana", "News and media studies"),
	                new Department(null, "Mass Communication", "Dr. Tarun", "Advertising and PR"),
	                new Department(null, "Hotel Management", "Dr. Sunil", "Hospitality and tourism"),
	                new Department(null, "Culinary Arts", "Dr. Meera", "Food science and cooking"),
	                new Department(null, "Travel & Tourism", "Dr. Akash", "Tour operations and travel laws"),
	                new Department(null, "Animation", "Dr. Tina", "2D and 3D animation design"),
	                new Department(null, "Gaming", "Dr. Dheeraj", "Game development and design"),
	                new Department(null, "Aerospace", "Dr. Aditya", "Aircraft and space systems"),
	                new Department(null, "Marine Engineering", "Dr. Pratik", "Ships and underwater tech")
	            ));
	        };
}}
