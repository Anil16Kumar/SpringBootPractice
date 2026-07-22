package com.Studentcrud.dto;

public record StudentResponse(

        long studentId,
        String studentName,
        String course,
        Double courseFee
) {}
