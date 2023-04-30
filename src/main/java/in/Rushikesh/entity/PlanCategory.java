package in.Rushikesh.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PLAN_CATEGORY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanCategory {
	@Id
	@GeneratedValue
	@Column(name = "CATEGORY_ID")
	private Integer categoryId;

	@Column(name = "CATEGORY_NAME")
	private String categoryName;

	@Column(name = "ACTIVE_SW")
	private String active_sw;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "CREATED_AT", updatable = false)
	@CreationTimestamp
	private LocalDate createdAt;

	@Column(name = "UPDATED_AT", insertable = false)
	@UpdateTimestamp
	private LocalDate updatedAt;

}
