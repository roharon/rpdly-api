package com.rpdly.rpdlyapi.api.response;

import java.util.List;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Getter
@Service
public class ResponseService {

  public <T> ResponseEntity<CommonResponse> getSingleResponse(T data) {
    SingleResponse<T> response = new SingleResponse<>();
    response.setData(data);
    setSuccessResponse(response);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  public <T> ResponseEntity<CommonResponse> getListResponse(List<T> data) {
    ListResponse<T> response = new ListResponse<>();
    response.setList(data);
    setSuccessResponse(response);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  public ResponseEntity<CommonResponse> getSuccessResponse() {
    CommonResponse response = new CommonResponse();
    setSuccessResponse(response);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  public ResponseEntity<CommonResponse> getFailResponse(String msg) {
    CommonResponse response = new CommonResponse();
    response.setSuccess(false);
    response.setMsg(msg);
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  private void setSuccessResponse(CommonResponse result) {
    result.setSuccess(true);
  }
}
