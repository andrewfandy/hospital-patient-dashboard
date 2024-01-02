package com.application.utils;

import com.application.model.Patient;

public class ValidationUtils {

    public static boolean isSubmitValid(Patient patient) {
        if (patient.getName().isEmpty() || patient.getAddress().isEmpty() || patient.getPatientID().isEmpty()
                || patient.getBirth() == null) {
            return false;
        }
        return true;
    }

}
