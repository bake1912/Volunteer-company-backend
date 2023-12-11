package com.ua.volunteer.company.repository;

import com.ua.jooq.Tables;
import com.ua.volunteer.company.entity.Response;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResponseRepository {

    @Autowired
    private DSLContext dsl;

    public List<Response> getAllResponses() {
        return dsl.select().from(Tables.RESPONSE).fetchInto(Response.class);
    }

    public Response getResponse(Integer id) {
        return dsl.select().from(Tables.RESPONSE).where(Tables.RESPONSE.ID.eq(id)).fetchOneInto(Response.class);
    }

    public Response createResponse(Response response) {
        return dsl.insertInto(Tables.RESPONSE)
                .set(Tables.RESPONSE.RESPONSE_TEXT, response.getResponseText())
                .set(Tables.RESPONSE.STATUS_NAME, response.getStatusName())
                .set(Tables.RESPONSE.REQUEST_ID, response.getRequestId())
                .returning()
                .fetchOneInto(Response.class);
    }
}
