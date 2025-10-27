package com.springboot.wooden.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * PasswordEncoder 설정
 * - 프로젝트 전역에서 동일한 해시 알고리즘/강도로 사용하기 위해 Bean 등록
 * - 기본은 BCrypt, 강도(cost)는 설정값으로 주입 (기본 12)
 */
@Configuration
public class PasswordConfig {

    /**
     * BCrypt 강도(cost) — 값이 높을수록 더 느리지만 안전합니다.
     * application.yml에 security.password.bcrypt-strength: 12 처럼 지정 가능.
     */
    @Value("${security.password.bcrypt-strength:12}")
    private int bcryptStrength;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(bcryptStrength);
    }
}
