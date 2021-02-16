package team.okky.personnel_management.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import team.okky.personnel_management.utils.dto.PageRequestDTO;
import team.okky.personnel_management.utils.dto.PageResultDTO;

import java.util.List;

@Controller
@ResponseBody
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    /**
     * 사원 목록 메인 뷰, 사원&부서이름 검색
     * @param name
     * @param deptName
     * @param pageNo
     * @return 검색된 사원 목록
     */
    @GetMapping("/employee")
    public EmployeeDTO.IndexWithPage viewByName(@RequestParam(required = false) String name,
                                                @RequestParam(required = false) String deptName,
                                                @RequestParam(value = "page", defaultValue = "1") Integer pageNo){
        List<EmployeeDTO.Index> list = null;
        PageResultDTO pageResultDTO = null;
        PageRequestDTO pageRequestDTO = new PageRequestDTO(pageNo);

        if(name != null){
            list = employeeService.viewAllByName(name, pageRequestDTO);
            pageResultDTO = employeeService.viewPageByName(name, pageNo);
        }
        else if(deptName != null){
            list = employeeService.viewAllByDept(deptName, pageRequestDTO);
            pageResultDTO = employeeService.viewPageByDeptName(deptName, pageNo);
        }
        else{
            list = employeeService.viewAll(pageRequestDTO);
            pageResultDTO = employeeService.viewPage(pageNo);
        }
        return EmployeeDTO.IndexWithPage.builder()
                .list(list)
                .pageResultDTO(pageResultDTO)
                .build();
    }

    /**
     * 사원 추가
     * @param addForm
     */
    @PostMapping("/employee")
    public void viewAddEmployee(@RequestBody EmployeeDTO.AddForm addForm){
        employeeService.createEmployee(addForm);
    }

    /**
     * 사원 정보 변경
     * @param updateForm
     */
    @PutMapping("/employee")
    public void viewUpdateEmployee(@RequestBody EmployeeDTO.UpdateForm updateForm){
        employeeService.updateEmployee(updateForm);
    }

}
