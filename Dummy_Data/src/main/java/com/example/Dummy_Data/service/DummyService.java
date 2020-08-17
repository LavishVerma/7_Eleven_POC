package com.example.Dummy_Data.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.Dummy_Data.model.CRUDentity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import reactor.core.publisher.Mono;

@Service
public class DummyService {
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@HystrixCommand(fallbackMethod = "sendDummyDatadefaultAction")
	public Boolean sendDummyData(int number) 
	{
		CRUDentity[] data=GenerateDummyData(number);
		
		
		Mono<Boolean> result= webClientBuilder.build()
		.post()
		.uri("http://CRUDMS/crud/dummy")
		.contentType(MediaType.APPLICATION_JSON)
		.bodyValue(data)
		.retrieve()
		.bodyToMono(Boolean.class);
		
		return result.block();
		
		
	}
	
	public Boolean sendDummyDatadefaultAction(int n)
	{
		return false;
	}
	
	static public CRUDentity[] GenerateDummyData(int number) 
	{
	
		String[] status = {"Recovered", "Hospitalized", "Dead", "Home-Qurantined"};
		String[] state = { "Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu and Kashmir","Jharkhand","Karnataka","Kerala","Madhya Pradesh", "Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttarakhand","Uttar Pradesh","West Bengal","Andaman and Nicobar Islands","Chandigarh","Dadra and Nagar Haveli","Daman and Diu","Delhi","Lakshadweep","Puducherry"};
		String[] cities = { "Amritsar","Barnala",
				"Bathinda",
				"Firozpur",
				"Faridkot",
				"Fatehgarh Sahib",
				"Fazilka",
				"Gurdaspur",
				"Hoshiarpur",
				"Jalandhar",
				"Kapurthala",
				"Ludhiana",
				"Mansa",
				"Moga",
				"Sri Muktsar Sahib",
				"Pathankot",
				"Patiala",
				"Rupnagar",
				"Ajitgarh (Mohali)",
				"Sangrur",
				"Nawanshahr",
				"Tarn Taran"};
		String[] name = { "Anderson", "Ashwoon", "Aikin", "Bateman", "Bongard", "Bowers", "Boyd", "Cannon", "Cast", "Deitz", "Dewalt", "Ebner", "Frick", "Hancock", "Haworth", "Hesch", "Hoffman", "Kassing", "Knutson", "Lawless", "Lawicki", "Mccord", "McCormack", "Miller", "Myers", "Nugent", "Ortiz", "Orwig", "Ory", "Paiser", "Pak", "Pettigrew", "Quinn", "Quizoz", "Ramachandran", "Resnick", "Sagar", "Schickowski", "Schiebel", "Sellon", "Severson", "Shaffer", "Solberg", "Soloman", "Sonderling", "Soukup", "Soulis", "Stahl", "Sweeney", "Tandy", "Trebil", "Trusela", "Trussel", "Turco", "Uddin", "Uflan", "Ulrich", "Upson", "Vader", "Vail", "Valente", "Van Zandt", "Vanderpoel", "Ventotla", "Vogal", "Wagle", "Wagner", "Wakefield", "Weinstein", "Weiss", "Woo", "Yang", "Yates", "Yocum", "Zeaser", "Zeller", "Ziegler", "Bauer", "Baxster", "Casal", "Cataldi", "Caswell", "Celedon", "Chambers", "Chapman", "Christensen", "Darnell", "Davidson", "Davis", "DeLorenzo", "Dinkins", "Doran", "Dugelman", "Dugan", "Duffman", "Eastman", "Ferro", "Ferry", "Fletcher", "Fietzer", "Hylan", "Hydinger", "Illingsworth", "Ingram", "Irwin", "Jagtap", "Jenson", "Johnson", "Johnsen", "Jones", "Jurgenson", "Kalleg", "Kaskel", "Keller", "Leisinger", "LePage", "Lewis", "Linde", "Lulloff", "Maki", "Martin", "McGinnis", "Mills", "Moody", "Moore", "Napier", "Nelson", "Norquist", "Nuttle", "Olson", "Ostrander", "Reamer", "Reardon", "Reyes", "Rice", "Ripka", "Roberts", "Rogers", "Root", "Sandstrom", "Sawyer", "Schlicht", "Schmitt", "Schwager", "Schutz", "Schuster", "Tapia", "Thompson", "Tiernan", "Tisler" };


		CRUDentity list[] = new CRUDentity[number];
		
		for(int i=0;i<number;i++) {
			list[i]=new CRUDentity();
			
			list[i].setAge((int)(Math.random()*100+1));
			list[i].setCurrentstatus(status[(int)(Math.random()*status.length)]);
			list[i].setDate((int)(Math.random()*31+1)+"-"+(int)(Math.random()*12+1)+"-"+(int)(Math.random()*100+1900));
			list[i].setDetectedcity(cities[(int)(Math.random()*status.length)]);
			list[i].setName(name[(int)(Math.random()*status.length)]);
			list[i].setDetectedstate(state[(int)(Math.random()*status.length)]);
				
		}
       return list;
		
		
	}

}
