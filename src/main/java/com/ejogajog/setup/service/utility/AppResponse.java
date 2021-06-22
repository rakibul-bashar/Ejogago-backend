package com.ejogajog.setup.service.utility;

import java.util.LinkedHashMap;

import org.springframework.http.HttpStatus;
/**
 * @author rakibul bashar
 */
public class AppResponse {

    public static LinkedHashMap<String, Object> apiResponse = new LinkedHashMap<>();
    public static String globalSavedMessage = "$ Record Successfully saved !!";
    public static String globalUpdatedMessage = "$ Record Successfully Updated !!";
    public static String globalNotModifiedMessage = "Sorry, $ is not updated !!";
    public static String globalExistMessage = "This name : $ already exists!!";
    public static String globalNotSavedMessage = "$ Record data not saved !!";
    public static String globalDeleteMessage = "$ Record Successfully deleted !!";
    public static String globalNotDeleteMessage = "$ Record not deleted !!";


    public static Object isBadRequest() {
		apiResponse = new LinkedHashMap<String, Object>();
        apiResponse.put("status", Boolean.FALSE);
        apiResponse.put("httpStatusCode", HttpStatus.BAD_REQUEST.value());
        apiResponse.put("message", "Request body empty !!");
        return apiResponse;
    }

    public static Object isNotSaved(String message) {
        String innerText = globalNotSavedMessage.replace("$", message);
		apiResponse = new LinkedHashMap<String, Object>();
        apiResponse.put("status", Boolean.FALSE);
        apiResponse.put("httpStatusCode", HttpStatus.ACCEPTED.value());
        apiResponse.put("message", innerText);
        return apiResponse;
    }

    public static Object isCreated(String message) {
        String innerText = globalSavedMessage.replace("$", message);
		apiResponse = new LinkedHashMap<String, Object>();
        apiResponse.put("status", Boolean.TRUE);
        apiResponse.put("httpStatusCode", HttpStatus.CREATED.value());
        apiResponse.put("message", innerText);
        return apiResponse;
    }

    public static Object isSaveWithAddressList(String message) {
        String innerText = globalSavedMessage.replace("$", message);
		apiResponse = new LinkedHashMap<String, Object>();
        apiResponse.put("status", Boolean.TRUE);
        apiResponse.put("httpStatusCode", HttpStatus.OK.value());
        apiResponse.put("message", innerText);
        return apiResponse;
    }

    public static Object isDeleted(String message) {
        String innerText = globalDeleteMessage.replace("$", message);
		apiResponse = new LinkedHashMap<String, Object>();
        apiResponse.put("status", Boolean.TRUE);
        apiResponse.put("httpStatusCode", HttpStatus.OK.value());
        apiResponse.put("message", innerText);
        return apiResponse;
    }

    public static Object isNotDeleted(String message) {
        String innerText = globalNotDeleteMessage.replace("$", message);
		apiResponse = new LinkedHashMap<String, Object>();
        apiResponse.put("status", Boolean.FALSE);
        apiResponse.put("httpStatusCode", HttpStatus.OK.value());
        apiResponse.put("message", innerText);
        return apiResponse;
    }

    public static Object isUpdated(String message) {
        String innerText = globalUpdatedMessage.replace("$", message);
		apiResponse = new LinkedHashMap<String, Object>();
        apiResponse.put("status", Boolean.TRUE);
        apiResponse.put("httpStatusCode", HttpStatus.OK.value());
        apiResponse.put("message", innerText);
        return apiResponse;
    }

    public static Object ifExist(String message) {
        String innerText = globalExistMessage.replace("$", message);
		apiResponse = new LinkedHashMap<String, Object>();
        apiResponse.put("status", Boolean.FALSE);
        apiResponse.put("httpStatusCode", HttpStatus.OK.value());
        apiResponse.put("message", innerText);
        return apiResponse;
    }

    public static Object isNotModified(String message) {
        String innerText = globalNotModifiedMessage.replace("$", message);
		apiResponse = new LinkedHashMap<String, Object>();
        apiResponse.put("status", Boolean.FALSE);
        apiResponse.put("httpStatusCode", HttpStatus.NOT_MODIFIED.value());
        apiResponse.put("message", innerText);
        return apiResponse;

    }

    public static Object isInternalServerError() {
        apiResponse = new LinkedHashMap<String, Object>();
        apiResponse.put("status", Boolean.FALSE);
		apiResponse.put("httpStatusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
        apiResponse.put("message", "Sorry, unable to save data !!");
        return apiResponse;
    }



}