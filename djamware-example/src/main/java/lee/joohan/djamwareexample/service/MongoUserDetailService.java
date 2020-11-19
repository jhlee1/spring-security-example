package lee.joohan.djamwareexample.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lee.joohan.djamwareexample.domain.Account;
import lee.joohan.djamwareexample.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Joohan Lee on 2019/10/23
 */

@Service
@RequiredArgsConstructor
public class MongoUserDetailService implements UserDetailsService {
private final AccountRepository accountRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Account account = Optional.ofNullable(accountRepository.findByUsername(username))
        .orElseThrow(() -> new UsernameNotFoundException("The user not found."));

    List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("user"));

    return new User(account.getUsername(), account.getPassword(), authorities);
  }
}
