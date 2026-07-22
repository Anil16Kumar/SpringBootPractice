package com.Studentcrud.dto;

public record StudentRequest(

        String studentName,
        String course,
        Double courseFee
) {}
