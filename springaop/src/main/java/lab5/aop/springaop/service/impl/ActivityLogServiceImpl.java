package lab5.aop.springaop.service.impl;

import lab5.aop.springaop.entity.ActivityLog;
import lab5.aop.springaop.helper.ExecutionTime;
import lab5.aop.springaop.repository.ActivityLogRepo;
import lab5.aop.springaop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {
  private final ActivityLogRepo repo;

  @ExecutionTime
  @Override
  public List<ActivityLog> findAll() {
    var result = new ArrayList<ActivityLog>();
    try {
      var data = repo.findAll();
      data.forEach(result::add);
    } catch (Exception exception) {
      exception.printStackTrace();
    }
    return result;
  }

  @Override
  public void save(ActivityLog activityLog) {
    repo.save(activityLog);
  }
}
