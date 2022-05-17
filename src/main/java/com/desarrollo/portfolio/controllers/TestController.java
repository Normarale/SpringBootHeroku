
package com.desarrollo.portfolio.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
     @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('USUARIO') or hasRole('COLABORADOR') or hasRole('ADMINISTRADOR')")
  public String userAccess() {
    return "Usuario.";
  }

  @GetMapping("/mod")
  @PreAuthorize("hasRole('COLABORADOR')")
  public String moderatorAccess() {
    return "Colaborador.";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMINISTRADOR')")
  public String adminAccess() {
    return "Administrador.";
  }
}
