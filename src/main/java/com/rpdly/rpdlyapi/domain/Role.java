package com.rpdly.rpdlyapi.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

  GUEST("ROLE_GUEST", "guest"),
  USER("ROLE_USER", "default_user");

  private final String key;
  private final String title;
}
