package dev.hnbui.redis_session.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class HomeController {
  private final String HOME_VIEW_COUNT = "HOME_VIEW_COUNT";

  @GetMapping("/")
  public String home(Principal principal, HttpSession session) {
    incrementCount(session, HOME_VIEW_COUNT);
    return "Hello World! " + principal.getName();
  }

  @GetMapping("/count")
  public String count(HttpSession session) {
    var homeViewCount = session.getAttribute(HOME_VIEW_COUNT) == null ? 0 : (Integer) session.getAttribute(HOME_VIEW_COUNT);
    return "HOME_VIEW_COUNT: " + homeViewCount;
  }

  private void incrementCount(HttpSession session, String key) {
    var homeViewCount = session.getAttribute(key) == null ? 0 : (Integer) session.getAttribute(key);
    session.setAttribute(key, homeViewCount + 1);
  }
}
