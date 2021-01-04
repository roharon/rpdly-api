package com.rpdly.rpdlyapi.api.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResponse {
  private boolean success;

  @JsonInclude(Include.NON_NULL)
  private String msg;
}
