package lab5.aop.springaop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityLog {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private long date;

  private String operation;

  private long duration;
}
