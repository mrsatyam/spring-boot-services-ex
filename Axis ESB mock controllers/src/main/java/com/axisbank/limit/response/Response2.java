package com.axisbank.limit.response;

public class Response2 {
    private Header header;
    private ResponseBody2 body;

    public Response2(Header header, ResponseBody2 body) {
        this.header = header;
        this.body = body;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public ResponseBody2 getBody() {
        return body;
    }

    public void setBody(ResponseBody2 body) {
        this.body = body;
    }
}
