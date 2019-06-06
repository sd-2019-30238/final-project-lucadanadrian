package com.finalproject.demo.service;

import com.finalproject.demo.dao.ValidationCodeDAO;
import com.finalproject.demo.model.ValidationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ValidationCodeService {
    @Autowired
    private ValidationCodeDAO validationCodeDAO;

    public List<ValidationCode> getSavedTickets() {
        return validationCodeDAO.selectAll();
    }

    public List<ValidationCode> selectByCode(String code) {
        return validationCodeDAO.selectByCode(code);

    }

    public void acceptTicketCode(int id) {
        ValidationCode validationCode = validationCodeDAO.selectById(id);
        validationCode.setValidated("Validated");
        validationCode.equals(validationCode);
        for(ValidationCode vc:validationCodeDAO.selectByCode(validationCode.getCode())){
            System.out.println(vc.getId());
        }
    }

    public void deleteTicketCode(int id) {
        validationCodeDAO.deleteFromTable(id);
    }
}

