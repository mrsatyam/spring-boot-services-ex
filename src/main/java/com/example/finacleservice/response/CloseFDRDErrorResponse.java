package com.example.finacleservice.response;

public record CloseFDRDErrorResponse(ErrorResponse response) {

    public record Error(String errorCode, String message) {
    }

    public record ErrorResponse(CloseFDRDResponse.Header header, Error error) {
    }
}