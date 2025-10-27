package com.springboot.wooden.controller;

import com.springboot.wooden.dto.LoginRequestDto;
import com.springboot.wooden.dto.LoginResponseDTO;
import com.springboot.wooden.service.LoginService;
import com.springboot.wooden.service.LoginServiceImpl.AuthenticationFailedException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000") // React 3000 포트 CORS 허용
@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    /**
     * 로그인 요청 처리
     * 프론트 요청 예시:
     * {
     *   "id": "admin",
     *   "pw": "1234"
     * }
     */
    @PostMapping
    public LoginResponseDTO login(@RequestBody LoginRequestDto request) {

        try {
            // 서비스 호출 (이메일/비밀번호 검증)
            LoginResponseDTO response = loginService.login(request);

            // 로그인 성공 시 응답
            return new LoginResponseDTO(
                    true,
                    response.getMessage(), // "로그인 성공"
                    response.getName()
            );

        } catch (AuthenticationFailedException e) {
            // 이메일/비밀번호 불일치 시
            return new LoginResponseDTO(false, "이메일 또는 비밀번호가 올바르지 않습니다.", null);
        } catch (Exception e) {
            // 그 외 예외 (서버 오류 등)
            return new LoginResponseDTO(false, "서버 오류가 발생했습니다.", null);
        }
    }
}
