package com.Dobe.Ferme.dto.Auth;

import lombok.Data;


@Data
public class AuthenticationRequest {

  private String email;
  private String password;
}
