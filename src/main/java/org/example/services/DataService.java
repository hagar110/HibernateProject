package org.example.services;

import org.example.Dao.DataDao;
import org.example.Dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    DataDao dataDao;
    @Autowired

    public DataService(DataDao dataDao) {
        this.dataDao = dataDao;
    }
   public void deleteData(String phoneNUmber){
        dataDao.deleteUserData(phoneNUmber);
    }
   public void updateData(String newPhoneNUmber,String oldPhoneNUmber){
        dataDao.updateUserData(oldPhoneNUmber,newPhoneNUmber);
    }
}
