package lab5.aop.springaop.service;

import lab5.aop.springaop.entity.ActivityLog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivityLogService {
  List<ActivityLog> findAll();
  void save(ActivityLog activityLog);
}
