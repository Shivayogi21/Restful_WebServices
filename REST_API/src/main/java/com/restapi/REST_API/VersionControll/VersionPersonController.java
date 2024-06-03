package com.restapi.REST_API.VersionControll;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionPersonController {

	@GetMapping("/v1/Person")
	public PersonV1 getFirstVersionPerson() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("/v2/Person")
	public PersonV2 getSecondVersionPerson() {
		return new PersonV2(new Name("Bob","Charlie"));
	}
	
	@GetMapping(path="/Person",params="version=1")
	public PersonV1 getFirstVersionPersonRequestParam() {
		return new PersonV1("Bob Charlie");
	}
	@GetMapping(path="/Person",params="version=2")
	public PersonV1 getSecondVersionPersonRequestParam() {
		return new PersonV1("Bob Charlie");
	}
	@GetMapping(path="/Person/header",headers="X-API-VERSION=1")
	public PersonV1 getFirstVersionPersonRequestHeader() {
		return new PersonV1("Bob Charlie");
	}
	@GetMapping(path="/Person/header",headers="X-API-VERSION=2")
	public PersonV1 getSecondVersionPersonRequestHeader() {
		return new PersonV1("Bob Charlie");
	}
}
