package team.okky.personnel_management.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team.okky.personnel_management.domain.Manager;
import team.okky.personnel_management.repository.ManagerRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MangerServiceImpl implements ManagerService{

    private final ManagerRepository managerRepository;

    /**
     * 인사담당관 등록하기
     * @param manager
     */
    @Override
    @Transactional(readOnly = false)
    public void save(Manager manager){
        managerRepository.save(manager);
    }

}