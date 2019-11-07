package com.shen.uac.core;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * ClassName MyPasswordEncoder
 * Description TODO
 * Author shaojun
 * Date 07/11/2019 14:42
 * Version 1.0
 **/
public class MyPasswordEncoder implements PasswordEncoder {
	@Override
	public String encode(CharSequence charSequence) {
		return charSequence.toString();
	}

	@Override
	public boolean matches(CharSequence charSequence, String s) {
		return s.equals(charSequence.toString());
	}
}
