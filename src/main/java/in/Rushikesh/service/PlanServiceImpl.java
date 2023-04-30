package in.Rushikesh.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.Rushikesh.entity.Plan;
import in.Rushikesh.entity.PlanCategory;
import in.Rushikesh.repo.PlanCategoryRepo;
import in.Rushikesh.repo.PlanMasterRepo;

@Service
public class PlanServiceImpl implements PlanService {
	
	@Autowired
	PlanCategoryRepo planCategoryRepo;

	@Autowired
	PlanMasterRepo planRepo;
	
	@Override
	public Map<Integer, String> getPlanCategories() {
		List<PlanCategory> list = planCategoryRepo.findAll();
		Map<Integer, String> map = new HashMap<>();
		list.forEach(plan->{
			map.put(plan.getCategoryId(),plan.getCategoryName());
		});
		return map;
	}

	@Override
	public boolean savePlan(Plan plan) {
		Plan saved = planRepo.save(plan);
		return saved.getPlanId()!=null;
	}

	@Override
	public List<Plan> getAllPlans() {
		return planRepo.findAll();
	}

	@Override
	public Plan getPlanById(Integer planId) {
		Optional<Plan> findById = planRepo.findById(planId);
		if(findById.isPresent())
			return findById.get();
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		planRepo.save(plan);
		return plan.getPlanId()!=null;
	}

	@Override
	public boolean deletePlanById(Integer planId) {
		boolean status = false;
		
		try{
			planRepo.deleteById(planId);
			status = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean changePlanStatus(Integer planId, String status) {
		Optional<Plan> findById = planRepo.findById(planId);
		if(findById.isPresent()) {
			Plan plan = findById.get();
			plan.setActiveSw(status);
			planRepo.save(plan);
			return true;
		}
		return false;
	}

}
