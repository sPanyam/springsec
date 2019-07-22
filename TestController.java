package com.example.demo;

import com.example.demo.components.Book;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.awt.*;

@RestController
@RequestMapping("/getTicket")
@Api(value = "TestApi", produces = MediaType.ALL_VALUE)
public class TestController {

    @Autowired
    Book book;

    @RequestMapping( value = "/{input}" ,method = RequestMethod.GET)
    @ApiOperation(value = "Gets product with specific id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = String.class )})
    public String speedingFine(@PathVariable String input) throws Exception{
       if (true)
           throw new Exception("");
        return "Default method for " + input ;
    }

    @RequestMapping(value = "/over100" , method = RequestMethod.GET)
    public @ResponseBody Book speedingFine(){
        return getBookDetails();
    }

    @RequestMapping(value = "/bookDetails" , method = RequestMethod.GET)
    public @ResponseBody Book getBookDetails(){

        book.setId("100x");
        book.setName("Saicharitha");

        return book;
    }
}
