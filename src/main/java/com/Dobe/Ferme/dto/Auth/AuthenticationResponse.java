package com.Dobe.Ferme.dto.Auth;

import com.Dobe.Ferme.dto.UtilisateurDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

  private String firstName;
  private String lastName;
  private List<String> role;
  private String token;


}
