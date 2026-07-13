package com.forma.api.infrastructure.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrefValidator implements ConstraintValidator<ValidCref, String> {
    private static final Pattern CREF_PATTERN =
            Pattern.compile("^\\d{6}-[GP]\\/(AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MT|MS|MG|PA|PB|PR|PE|PI|RJ|RN|RS|RO|RR|SC|SP|SE|TO)$");

    @Override
    public boolean isValid(String cref, ConstraintValidatorContext context) {
        boolean result = true;
        if (cref == null || cref.isBlank()) {
            return true;
        }

        return CREF_PATTERN.matcher(cref).matches();
    }
}
