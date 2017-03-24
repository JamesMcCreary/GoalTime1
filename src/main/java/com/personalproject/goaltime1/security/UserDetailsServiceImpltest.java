package com.personalproject.goaltime1.security;

//@Service
public class UserDetailsServiceImpltest { //implements UserDetailsServiceImpl {

    /*
    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User account = accountService.findByUsername(username);
        if (account == null) {
            return null;
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

        for (Role role : account.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getCode()));
        }

        User userDetails = new User(account.getUsername(), account.getPassword(), account.isEnabled(),
                !account.isExpired(), !account.isCredentialsexpired(), !account.isLocked(), grantedAuthorities);

        return userDetails;
    }
     */
}