/**
 * 
 */
package com.htsvsystems.services;

import java.util.concurrent.atomic.AtomicLong;

import com.htsvsystems.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rajesh
 *
 */
@RestController
@RequestMapping("api/v1")
public class GreetingsService {
	
	 private static final String template = "Hello, %s!";
	    private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(path="service",method=RequestMethod.GET )
	public String getSampleGreetingMsg(@RequestParam ( value="name", defaultValue="Default Msg : Hello World") String name){
		return name;
	}
	
	@RequestMapping(path="greeting", method=RequestMethod.GET)
    public @ResponseBody Greeting sayHello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
	
}
