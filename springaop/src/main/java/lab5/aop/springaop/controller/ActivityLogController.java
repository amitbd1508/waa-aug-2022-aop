package lab5.aop.springaop.controller;

import lab5.aop.springaop.entity.ActivityLog;
import lab5.aop.springaop.repository.ActivityLogRepo;
import lab5.aop.springaop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/activity-logs")
public class ActivityLogController {
  private final ActivityLogService service;

  @GetMapping
  public ResponseEntity<List<ActivityLog>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }
}
