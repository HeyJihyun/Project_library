package kr.ac.kopo.library.manager.service;

import kr.ac.kopo.library.manager.dao.ManagerDAO;

public class ManagerService {

    ManagerDAO managerDao = null;

    public ManagerService() {
        managerDao = new ManagerDAO();
    }

    public boolean managerCheck(String id) {
        return managerDao.managerCheck(id);
    }

}
