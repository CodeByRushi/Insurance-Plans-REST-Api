package in.Rushikesh.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.Rushikesh.entity.Plan;
import in.Rushikesh.service.PlanService;

@RestController
public class PlanRestCotroller {
	
	@Autowired
	PlanService planService;
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> getAllCategories(){
		Map<Integer, String> planCategories = planService.getPlanCategories();
		return new ResponseEntity<>(planCategories, HttpStatus.OK);
	}
	

	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan){
		boolean savePlan = planService.savePlan(plan);
		String msg="";
		msg = savePlan ? "Plan Saved":"Plan Not Saved";
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
	}
	
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> getAllPlans(){
		List<Plan> allPlans = planService.getAllPlans();
		return new ResponseEntity<>(allPlans, HttpStatus.OK);
	}
	
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId){
		Plan plan = planService.getPlanById(planId);
		return new ResponseEntity<>(plan, HttpStatus.OK);
	}
	
	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan){
		boolean updatePlan = planService.updatePlan(plan);
		String msg="";
		msg = updatePlan ? "Plan updated":"Plan Not updated";
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
		boolean deletePlanById = planService.deletePlanById(planId);
		String msg="";
		msg = deletePlanById ? "Plan deleted":"Plan Not deleted";
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> changeStatus(@PathVariable Integer planId, @PathVariable String status)
	{
		boolean changePlanStatus = planService.changePlanStatus(planId, status);
		String msg="";
		msg = changePlanStatus ? "status Changed":"status not changed";
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
}
