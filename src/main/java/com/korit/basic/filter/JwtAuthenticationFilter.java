package com.korit.basic.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// filter:
// - 서버 로직(톰캣의 로직)과 서블릿(컨트롤러부터의 내용) 사이에서 Http Request에 대한 사전 처리를 수행하는 영역
// - filter에서 걸러진 Request는 서블릿까지 도달하지 못하고 중간에서 reject됨

@Component
// OncePerRequestFilter 추상클래스를 확장 구현하여 filter 클래스로 생성 가능
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    
    try {

      // 1. request 객체에서 token 가져오기

    } catch(Exception exception) {
      exception.printStackTrace();

    }

  }
  
  private String getToken(HttpServletRequest request) {

    
    return null;
  }

}
