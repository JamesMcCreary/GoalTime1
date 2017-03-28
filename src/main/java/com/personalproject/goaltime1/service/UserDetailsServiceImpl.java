package com.personalproject.goaltime1.service;

import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl /*implements UserDetailsService*/ {

    //    @Autowired
    //    private UserRepository userRepository;
    //
    //    @Override
    //    @Transactional(readOnly = true)
    //    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //
    //        User user = userRepository.findByUsername(username);
    //
    //        Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
    //        for (Role role : user.getRoles()){
    //            grantedAuthorities.add(new SimpleGrantedAuthority(role.getCode()));
    //        }
    //
    //        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    //    }

}
