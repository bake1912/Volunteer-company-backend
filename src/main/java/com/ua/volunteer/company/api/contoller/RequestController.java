package com.ua.volunteer.company.api.contoller;

import com.ua.volunteer.company.DTO.RequestItemDTO;
import com.ua.volunteer.company.entity.Request;
import com.ua.volunteer.company.entity.RequestItem;
import com.ua.volunteer.company.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RequestController {

    @Autowired
    private RequestRepository  requestRepository;

    @GetMapping("/volunteers/request")
    public List<Request> getAllRequests(){
        return requestRepository.getAllRequests();
    }

    @GetMapping("/volunteers/request/{id}")
    public Request getRequest(@PathVariable("id") Integer id){
        return requestRepository.getRequest(id);
    }

    @PostMapping("/volunteers/request")
    public Request createRequest(@RequestBody Request request){
        return requestRepository.createRequest(request);
    }

    @PostMapping("/volunteers/request/{id}/item")
    public List<RequestItem> addRequestItems(@RequestBody RequestItemDTO requestItemDTO,
                                             @PathVariable("id") Integer requestId){
         return requestRepository.addRequestItem(requestItemDTO.getItemsId(),requestId);
    }
    @GetMapping("/volunteers/request/{id}/item")
    public List<RequestItem> getAllReqItems(@PathVariable("id") Integer id){
        return requestRepository.getAllRequestItems(id);
    }

}
