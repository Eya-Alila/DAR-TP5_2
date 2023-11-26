package rmiClient;

import rmiService.IBanque;
import metier.Compte;
import java.rmi.Naming;

public class BanqueClient {
    public static void main(String []args){
        try {
            String resultat;

            // Obtenir une référence à l'objet distant du serveur RMI
            IBanque banque = (IBanque) Naming.lookup("rmi://localhost:1099/BanqueService");

            // l'Utilisation de la  méthode creerCompte de l'interface IBanque
            Compte compte = new Compte(1234,3500.00);
            resultat= banque.creerCompte(compte);

            // vérifier que le compte a été créé avec succès
            System.out.println(resultat);


            // l'Utilisation de la  méthode getInfoCompte de l'interface IBanque si le code existe dans les comptes
            resultat = banque.getInfoCompte(1234);

            // Affichage des informations du compte
            System.out.println(resultat);

            // l'Utilisation de la  méthode getInfoCompte de l'interface IBanque si le code n'existe pas
            resultat = banque.getInfoCompte(5678);

            // Affichage pour vérifier l'existance du compte
            System.out.println(resultat);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}











