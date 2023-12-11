package com.ua.volunteer.company.repository;

import com.ua.jooq.Tables;
import com.ua.volunteer.company.entity.Item;
import com.ua.volunteer.company.entity.Request;
import com.ua.volunteer.company.entity.RequestItem;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RequestRepository {

    @Autowired
    private DSLContext dsl;

    public List<Request> getAllRequests(){
        List<Request> requests = dsl.select().from(Tables.REQUEST).fetchInto(Request.class);
        return requests;
    }

    public Request getRequest (Integer id){
        Request request = dsl.select().from(Tables.REQUEST).where(Tables.REQUEST.ID.eq(id))
                .fetchOneInto(Request.class);
        return request;
    }

    public Request createRequest(Request request){
        Request returnedRequest =dsl.insertInto(Tables.REQUEST)
                .set(Tables.REQUEST.REQUEST_DATE, LocalDate.now())
                .set(Tables.REQUEST.DESCRIPTION,request.getDescription())
                .set(Tables.REQUEST.USER_ID,request.getUserId())
                .set(Tables.REQUEST.DELAY_NAME,request.getDelayName())
                .set(Tables.REQUEST.FOR_WHOM_NAME,request.getForWhomName())
                .returning()
                .fetchOneInto(Request.class);
        return returnedRequest;
    }

    public List<RequestItem> addRequestItem(Integer[] itemIdList, Integer requestId){
        List<RequestItem> requestItems = new ArrayList<>();
        for(Integer itemId:itemIdList){
            Integer id = dsl.select(Tables.CLOTHINGITEM.ID)
                    .from(Tables.CLOTHINGITEM)
                    .where(Tables.CLOTHINGITEM.ID.eq(itemId))
                    .fetchOne()
                    .into(Integer.class);
            RequestItem requestItem =  dsl.insertInto(Tables.REQUESTITEM)
                    .set(Tables.REQUESTITEM.ITEM_ID,id)
                    .set(Tables.REQUESTITEM.REQUEST_ID,requestId)
                    .returning()
                    .fetchOneInto(RequestItem.class);
            requestItems.add(requestItem);
        }
    return requestItems;
    }

    public List<RequestItem>getAllRequestItems(Integer id){
        return dsl.select().from(Tables.REQUESTITEM).where(Tables.REQUESTITEM.REQUEST_ID.eq(id)).fetchInto(RequestItem.class);
    }
}
