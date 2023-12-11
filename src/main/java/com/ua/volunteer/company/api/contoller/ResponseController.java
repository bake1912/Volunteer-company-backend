package com.ua.volunteer.company.api.contoller;

import com.ua.volunteer.company.entity.Response;
import com.ua.volunteer.company.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResponseController {

    @Autowired
    private ResponseRepository responseRepository;

    @GetMapping("/volunteers/response")
    public List<Response> getAllResponses() {
        return responseRepository.getAllResponses();
    }

    @GetMapping("/volunteers/response/{id}")
    public Response getResponse(@PathVariable("id") Integer id) {
        return responseRepository.getResponse(id);
    }

    @PostMapping("/volunteers/response")
    public Response createResponse(@RequestBody Response response) {
        return responseRepository.createResponse(response);
    }

}
