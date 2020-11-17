package com.lambdaschool.bwafricanmarket.services;


import com.lambdaschool.bwafricanmarket.models.ValidationError;

import java.util.List;

public interface HelperFunctions {
    List<ValidationError> getConstraintViolation(Throwable cause);
}
