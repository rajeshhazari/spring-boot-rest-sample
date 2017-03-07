/**
 * 
 */
package com.rajesh.services.sample;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajesh.service.response.model.Greeting;

/**
 * @author rajesh
 *
 */
@RestController
public class SampleRestService {
	
	 private static final String template = "Hello, %s!";
	    private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(path="/sample/service",method=RequestMethod.GET )
	public String getSampleGreetingMsg(@RequestParam ( value="name", defaultValue="Defalut Msg : Hello World") String name){
		return name;
	}
	
	@RequestMapping(path="/service/greeting", method=RequestMethod.GET)
    public @ResponseBody Greeting sayHello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
	
}
