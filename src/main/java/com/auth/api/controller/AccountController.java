package com.auth.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



//HTTP verbs
//POST , GET , PUT , DELETE, PATCH
@RestController
@RequestMapping("/v2")
public class AccountController {
	
	  @Value("${server.port}")
	   private int port;
	
		/*
		 * @LoadBalanced
		 * 
		 * @Bean RestTemplate restTemplate() { return new RestTemplate(); }
		 * 
		 * @Autowired private RestTemplate restTemplate;
		 */
		

	//www.amazon.com/v23/friends
	@GetMapping("/accounts/{aid}")
	public AccountVO findAccount(@PathVariable String aid) {
		System.out.println("Request is served from port number ["+port+"]");
		AccountVO accountVO=new AccountVO();
		accountVO.setPort(port);
		accountVO.setAc(aid);
		accountVO.setBalance(1222);
		accountVO.setMobile("+919873003702");
		accountVO.setEmail("technohunk444@gmail.com");
		accountVO.setName("Nagendra Kumar");
		return accountVO; 
	}
	
	@DeleteMapping("/accounts/{aid}")
	@PreAuthorize("hasRole('ADMIN')")
	public ApplicationResponseVO deleteAccount(@PathVariable String aid) {
		ApplicationResponseVO applicationResponseVO=new ApplicationResponseVO();
		applicationResponseVO.setCode("C900");
		applicationResponseVO.setMessage("Account is created successfully!!!");
		return applicationResponseVO; 
	}
	
	//@RequestBody ->> This annotation which reads JSON/XML data from
	//incoming request body and map with Java Object
	@PostMapping("/accounts")
	@PreAuthorize("hasRole('ADMIN')")
	public ApplicationResponseVO createAccount(@RequestBody AccountVO accountVO) {
		ApplicationResponseVO applicationResponseVO=new ApplicationResponseVO();
		applicationResponseVO.setCode("C900");
		applicationResponseVO.setMessage("Account is created successfully!!!");
		return applicationResponseVO; 
	}
	
	@GetMapping("/")
	public List<AccountVO> findAccounts() {
		AccountVO accountVO=new AccountVO();
		accountVO.setAc("A100");
		accountVO.setBalance(1222);
		accountVO.setEmail("technohunk444@gmail.com");
		accountVO.setName("Nagendra Kumar");
		return Arrays.asList(accountVO);
	}

}
