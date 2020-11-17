package com.lambdaschool.bwafricanmarket.services;

import com.lambdaschool.bwafricanmarket.models.ValidationError;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;

@Service(value = "helperFunctions")
public class HelperFunctionsImpl implements HelperFunctions{
    public List<ValidationError> getConstraintViolation(Throwable cause) {
        while ((cause != null )&& !(cause instanceof ConstraintViolationException)){
            cause  = cause.getCause();
        }
        List<ValidationError> listVE = new ArrayList<>();
        if (cause != null){
            javax.validation.ConstraintViolationException ex = (javax.validation.ConstraintViolationException) cause;
            for (ConstraintViolation cv : ex.getConstraintViolations()){
                ValidationError newVe = new ValidationError();
                newVe.setCode(cv.getInvalidValue().toString());
                newVe.setMessage(cv.getMessage());
                listVE.add(newVe);
            }
        }
        return listVE;
    }

}
