package team.okky.personnel_management.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Long deptId;
    private String deptName;
    private String deptChargeName;
    private String deptAddress;

    public Department(String deptName, String deptChargeName, String deptAddress) {
        this.deptName = deptName;
        this.deptChargeName = deptChargeName;
        this.deptAddress = deptAddress;
    }
}
