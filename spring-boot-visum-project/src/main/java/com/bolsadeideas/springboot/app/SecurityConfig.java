package com.bolsadeideas.springboot.app;




public class SecurityConfig {
/*	
	@Autowired
	private IServiceUserDao userService;
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests()
        .requestMatchers("/", "/login", "/registrar","/assets/**", "/css/**", "/fonts/**","/images/**","/js/**","/scss/**").permitAll()
        .requestMatchers("/layout/**").hasAnyRole("USER")
        .requestMatchers("/pelicula/**").hasAnyRole("USER")
        .requestMatchers("/serie/**").hasAnyRole("USER")
        .requestMatchers("/ver/**").hasAnyRole("USER")
        .requestMatchers("/home").hasAnyRole("USER")
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .permitAll()
        .and()
        .logout()
        .invalidateHttpSession(true)
        .clearAuthentication(true)
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/login?logout")
        .permitAll();

    return http.build();
	}
	
	
 
	*/
}
