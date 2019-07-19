package com.example.sysone.exceptions.handlers;

import com.example.sysone.exceptions.NoValidNameOpcional;
import com.example.sysone.exceptions.NoValidaNameAuto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionServiceAutomovil {

    private static final Logger  log = LoggerFactory.getLogger(ExceptionServiceAutomovil.class);

    @ExceptionHandler(value = NoValidaNameAuto.class)
    @ResponseBody
    public ResponseEntity<?> noValidName(NoValidaNameAuto ex){
        log.debug( ex.getMessage() );
        return new ResponseEntity<>("Nombre de auto no valido", HttpStatus.NOT_FOUND);
    }




}
