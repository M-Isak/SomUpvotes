package com.somupvotes.service;







import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class UserDetailsServiceTest {

	@Test
	public void validate_encrypted_password() {
		//fail("Not yet implemented");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "som123";
		 String encodedPassword = encoder.encode(rawPassword);
		 System.out.println(encodedPassword);
		 
		assertThat(rawPassword, CoreMatchers.not(encodedPassword));
	}

}
