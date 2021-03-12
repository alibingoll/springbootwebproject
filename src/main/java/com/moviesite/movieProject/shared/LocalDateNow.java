package com.moviesite.movieProject.shared;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public  final class LocalDateNow {
    private LocalDateTime myDateObj = LocalDateTime.now();
    private DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private String formattedDate = myDateObj.format(myFormatObj);

    public String now(){
        return formattedDate;
    }

}
