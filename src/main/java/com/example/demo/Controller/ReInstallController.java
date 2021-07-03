package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.ReInstallApp;
import com.example.demo.service.ReInstallService;

import reactor.core.publisher.Mono;

@RestController
public class ReInstallController {
	
	@Autowired
	public ReInstallService ris;
	
	@PostMapping("/send")
	public Mono<ReInstallApp> RequesrSent(@RequestBody ReInstallApp ria){
		
		Mono<ReInstallApp> getReInstall = ris.GetReInstall(ria);
		
		return getReInstall;
	}

}
