package com.rpdly.rpdlyapi.api.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListResponse<T> extends CommonResponse {
  private List<T> list;
}
