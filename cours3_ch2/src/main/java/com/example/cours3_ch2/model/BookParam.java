package com.example.cours3_ch2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookParam {

    String category;
    String issuedYear;
    String issuedMonth;
    String issuedDay;
}
