
package com.desarrollo.portfolio.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desarrollo.portfolio.models.User;
import com.desarrollo.portfolio.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;




@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
  UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("El usuaro no existe: " + username));

    return UserDetailsImpl.build(user);
  }

}
