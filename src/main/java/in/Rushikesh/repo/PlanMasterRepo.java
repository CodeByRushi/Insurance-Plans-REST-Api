package in.Rushikesh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import in.Rushikesh.entity.Plan;

public interface PlanMasterRepo extends JpaRepository<Plan, Integer>{

}
