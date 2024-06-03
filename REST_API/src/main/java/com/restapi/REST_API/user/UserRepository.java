package com.restapi.REST_API.user;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserRepository {

	@Autowired
	private UserDaoService daoService;
	
	@Autowired
    private MessageSource messageSource;
	
    @GetMapping(path="/users")
    public List<User> findAll() {
     return daoService.findAllUsers();
    }
	
    @GetMapping("/users/{id}")
    public EntityModel<User> findById(@PathVariable Integer id) {
     User user= daoService.findOne(id);
         if(user==null)
         {
        	 throw new UserNotFoundException("id:"+id);
         }
         EntityModel<User> entityModel=EntityModel.of(user);
         WebMvcLinkBuilder link= linkTo(methodOn(this.getClass()).findAll());
         entityModel.add(link.withRel("all-users"));
         return entityModel;
    }
    
    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
       User savedUser= daoService.createUser(user);	
       URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
       return ResponseEntity.created(location).build();
       }
    
    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable Integer id) {
     daoService.deleteOne(id);  
    }
    
    @GetMapping("/hello-world-internatinalized")
    public String hellowWorld() {
     Locale local =LocaleContextHolder.getLocale();
     return  messageSource.getMessage("good.morning.message", null, "Default Message", local);
    }
    
}

