/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Compte;
import bean.Operation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SAMSUNG
 */
public class OperationService extends AbstractFacade<Operation> {

    public OperationService() {
        super(Operation.class);
    }

    public List<Operation> findOperationByRib(String rib) {
        List<Operation> all = findAll();
        List<Operation> res = new ArrayList<>();
        for (Operation operation : all) {
            if (operation.getCompte().getRib().equals(rib)) {
                res.add(operation);

            }
        }
        return res;
    }
    public void deleteByRib(String rib){
        CompteService compteService = new CompteService();
        Compte compte=new Compte(rib);
        compteService.remove(compte);
        List<Operation>operations= findOperationByRib(rib);
        for (Operation operation : operations) {
            remove(operation);
            
        }
        
        
    }

}
