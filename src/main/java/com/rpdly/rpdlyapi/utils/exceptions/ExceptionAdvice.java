package com.rpdly.rpdlyapi.utils.exceptions;

import com.rpdly.rpdlyapi.api.response.CommonResponse;
import com.rpdly.rpdlyapi.api.response.ResponseService;
import org.slf4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

  static ResponseService responseService;
  static MessageSource messageSource;
  Logger logger;

  @ExceptionHandler(EmailSignInFailedException.class)
  protected ResponseEntity<CommonResponse> emailSignInFailed(Exception e, WebRequest request) {
    logger.info(e.getMessage());
    return responseService.getFailResponse(getMessage("emailSignInFailed.msg"));
  }

  @ExceptionHandler(EmailSignUpFailedException.class)
  protected ResponseEntity<CommonResponse> emailSignUpFailed(Exception e, WebRequest request) {
    logger.info(e.getMessage());
    return responseService.getFailResponse(getMessage("emailSignUpFailed.msg"));
  }

  private String getMessage(String code) {
    return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
  }
}
