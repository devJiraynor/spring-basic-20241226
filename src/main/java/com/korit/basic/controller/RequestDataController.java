package com.korit.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// http://127.0.0.1:8080/request-data/**
@RequestMapping("/request-data")
public class RequestDataController {
  
  // @RequestParam(): Query String Parameter로 매개변수를 받는 방법
  // Query String Parameter - URL에 쿼리를 추가하여 데이터를 전송하는 방법 (/path?name=value&name=value)

  // GET http://127.0.0.1:8080/request-data/request-param
  @GetMapping("/request-param")
  public String requestParam(
    @RequestParam(name="name", required= false) String name,
    @RequestParam(name="age", required=false) Integer age
  ) {
    return "이름 : " + name + " 나이 : " + age;
  }

  // @PathVariable(): request의 url 패턴에 따라 데이터를 추출하는 방법
  // GET http://127.0.0.1:8080/request-data/path-variable
  // 만약 PathVariable로 받아오는 매개변수가 선택적이라면 Path를 여러 개 지정해야함
  @GetMapping({
    "/path-variable/{name}/{ho}",
    "/path-variable/{name}/",
    "/path-variable/{name}"
  })
  public String pathVariable(
    @PathVariable("name") String name,
    @PathVariable(name="ho", required=false) String ho
  ) {
    return "이름 : " + name + ", 묘호 : " + ho;
  }

  // path variable을 이용한 방법은 다른 메서드의 url 패턴과 겹칠수 있음을 주의
  @GetMapping("/{variable}")
  public String sample(
    @PathVariable("variable") String variable
  ) {
    return variable;
  }

}
