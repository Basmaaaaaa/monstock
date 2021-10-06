package com.stock.gestionstock.handlers;

import com.stock.gestionstock.exception.ErrorsCodes;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

//errorsDto=un objet envoyer lorsque je catche une exception
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ErrorsDto {
    private Integer httpCode;
    private ErrorsCodes odes;
    private  String message;
    private List<String> errors=new ArrayList<>();




}
