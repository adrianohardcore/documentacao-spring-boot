package br.com.adrianohardcore.controller;

import java.util.NoSuchElementException;

import javax.naming.NoPermissionException;
import javax.servlet.http.HttpServletRequest;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    private static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice.class);

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoSuchElementException(NoSuchElementException e) {
        return e.getMessage();
    }
    
    @ExceptionHandler(NoPermissionException.class )
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handleForbiddenContextVariableRestriction(NoSuchElementException e) {
        return e.getMessage();
    }
    
    @ExceptionHandler(value = NotFound.class)
    public ModelAndView handleError(HttpServletRequest request, Exception e)
    {
        ModelAndView mav = new ModelAndView("/404");
        mav.addObject("exception", e);
        return mav;
    }

}
