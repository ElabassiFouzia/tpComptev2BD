package service;

import bean.Compte;
import java.util.List;
import java.util.ArrayList;
import util.searchUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SAMSUNG
 */
public class CompteService extends AbstractFacade<Compte> {

    public List<Compte> searchByCriteria (String rib, Double soldeMin,Double soldeMax){
        String query =constractQuery(rib,soldeMin,soldeMax);
        return getEntityManager().createQuery(query).getResultList();
    }
    private String constractQuery(String rib, Double soldeMin, Double soldeMax) {
        String query = "SELECT c FROM Compte c WHERE 1=1";
        //dans la requete precedente il faut selecter le c from la class qui se ytrouve dans le bean
        if (rib != null && !rib.equals("")) {
            query += " AND c.rib='" + rib + "'";
            return query;
        }
        if (soldeMin != null && !soldeMin.equals("")) {
            query += " AND c.solde>='" + soldeMin + "'";

        }
        if (soldeMax != null && !soldeMax.equals("")) {
            query += " AND c.solde<='" + soldeMax + "'";

        }
        System.out.println("voici query==>"+query);
        return query;

    }

    public CompteService() {
        super(Compte.class);
    }

    public Compte ouvrirCompte(String rib, double soldeInitial) {
        Compte c = new Compte();
        c.setRib(rib);
        c.setSolde(soldeInitial);
        c.setOuvert(true);
        if (c.getSolde() >= 0 && c.getSolde() < 200) {
            c.setClasse('D');
        } else if (c.getSolde() >= 200 && c.getSolde() < 1000) {
            c.setClasse('C');
        } else if (c.getSolde() >= 1000 && c.getSolde() < 6000) {
            c.setClasse('B');
        } else {
            c.setClasse('A');
        }
        create(c);
        return c;

    }

    int fermerCompte(Compte c) {
        if (c.isOuvert() == false) {
            return -1;
        } else if (c.getSolde() != 0) {
            return -2;
        } else {
            c.setOuvert(false);
            edit(c);
            return 1;
        }

    }

    public int crediter(String rib, double montantCredit) {
        Compte c = find(rib);
        if (c == null) {
            return -2;
        } else if (c.isOuvert() == false) {
            return -1;
        } else if (c.getSolde() < montantCredit) {
            return -2;
        } else {
            double nvSolde = c.getSolde() + montantCredit;
            c.setSolde(nvSolde);
            edit(c);
            return 1;

        }
    }

    public int debiter(String rib, double montantDebit) {
        Compte c = find(rib);
        if (c == null) {
            return -5;
        } else if (c.isOuvert() == false) {
            return -1;
        } else if (c.getSolde() < montantDebit) {
            return -2;
        } else if ((c.getSolde() - montantDebit) <= 100) {
            return -3;
        } else if (montantDebit <= 6000) {
            return -4;
        } else {
            double nvSolde = c.getSolde() - montantDebit;
            c.setSolde(nvSolde);
            edit(c);
            return 1;
        }
    }

    public int transferer(Compte compteSource, Compte compteDestination, double montant) {
        if (compteSource.isOuvert() == false || compteDestination.isOuvert() == false) {
            return -1;
        } else if (compteSource.getSolde() < montant) {
            return -2;
        } else {
            compteSource.setSolde(compteSource.getSolde() - montant);
            compteDestination.setSolde(compteDestination.getSolde() + montant);
            return 1;
        }
    }

    public List<Compte> findBySolde(double soldeMin, List<Compte> comptes) {
        List<Compte> resultat = new ArrayList();
        for (int i = 0; i < comptes.size(); i++) {
            Compte c = comptes.get(i);
            if (c.getSolde() > c.soldeMin) {
                resultat.add(c);
            }

        }
        return resultat;
    }

    public int findByIndex(String rib, List<Compte> comptes) {

        for (int i = 0; i < comptes.size(); i++) {
            Compte c = comptes.get(i);
            if (c.getRib().equals(rib)) {
                return i;
            }

        }
        return -1;
    }

    public int deleteByRib(String rib, List<Compte> comptes) {

        int indice = findByIndex(rib, comptes);
        if (indice != 0) {
            comptes.remove(indice);
            return 1;
        }
        return -1;

    }

    public void save(Compte compte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
