import java.util.Random;

public class ScenarioPromotion {
    static double[] coefficients = {3, 2, 1, 2, 3};
    static String[] matieres = {"Math", "Chimie", "Histoire", "Philo", "Francais"};
    
    static Promotion but1;
    static Promotion but2;
    static Promotion but3;

    public static void main(String[] args) {
        but1 = new Promotion("but1info", creationTableauEtudiant());
        but2 = new Promotion("but2info", creationTableauEtudiant());
        but3 = new Promotion("but3info", creationTableauEtudiant());

        testConstructeur();
        separationMethode();
        testGetMajor();
        separationMethode();
        testGetNom();
        separationMethode();
        testSetNom();
    }

    private static void separationMethode(){
        System.out.println(" ------------------------- ");
    }

    private static void separationTest(){
        System.out.println(" ********************** ");
    }


// ! ----------------------------------------------------------


    public static void testConstructeur(){
        System.out.println("*** testConstructeur ***");
        Promotion promo;
        Etudiant[] liste = null;

        separationTest();
        System.out.println("Test n1 : Cas Erreur");
        //Cas Erreur
        promo = new Promotion("nom", liste);
        testCasConstructeur(promo, liste);

        separationTest();
        liste = creationTableauEtudiant();

        System.out.println("Test n2 : Cas Normal");
        //Cas Normal
        promo = new Promotion("nom", liste);
        testCasConstructeur(promo, liste);

        separationTest();

        System.out.println("Test n3 : Cas Erreur");
        //Cas Erreur
        promo = new Promotion(null, liste);
        testCasConstructeur(promo, liste);

        separationTest();

        System.out.println("Test n4 : Cas Normal");
        //Cas Normal
        promo = new Promotion("but1", liste);
        testCasConstructeur(promo, liste);
    }

    private static void testCasConstructeur(Promotion promo, Etudiant[] liste) {
        boolean toutOk = true;
        if (liste == null) {
            System.out.println("Tableau Null");
            toutOk = false;
        } else if (liste.length == 0) {
            System.out.println("Tableau Vide");
            toutOk = false;
        }

        if(promo.getNom() == null){
            System.out.println("Nom Null");
            toutOk = false;
        }

        if(toutOk){
            System.out.println("Reussi");
        } else {
            System.out.println("Echec");
        }
    }
    
    public static void testGetMajor(){
        System.out.println(" *** testGetMajor ***");
        System.out.println("Major de BUT 1 Info : " + but1.getMajor().getNom());
        System.out.println("Major de BUT 2 Info : " + but2.getMajor().getNom());
        System.out.println("Major de BUT 3 Info : " + but3.getMajor().getNom());
    }
    
    public static void testGetNom(){
        Promotion promo;
        Etudiant[] liste = creationTableauEtudiant();

        System.out.println("Test n1 : Cas Normal !");
        String nom = "BUT1Info";
        promo = new Promotion(nom, liste);
        testCasGetNom(promo, nom);

        separationTest();

        System.out.println("Test n2 : Cas Normal !");
        nom = "BUT2Info";
        promo = new Promotion(nom, liste);
        testCasGetNom(promo, nom);

        separationTest();

        System.out.println("Test n3 : Cas Erreur !");
        nom = "BUT3Info";
        promo = new Promotion(nom, liste);
        testCasGetNom(promo, "IUT3Info");
    }

    public static void testCasGetNom(Promotion promo, String nom){
        if(nom.equals(promo.getNom())){
            System.out.println("Reussi");
        } else {
            System.out.println("Echoue");
        }
    }

    public static void testSetNom(){
        Promotion promo;
        Etudiant[] liste = creationTableauEtudiant();
        String ancienNom = "DUT";
        String nouveauNom = "BUT";

        System.out.println("Test n1 : Cas Normal !");
        promo = new Promotion(ancienNom, liste);
        promo.setNom(nouveauNom);
        testCasSetNom(promo, ancienNom, nouveauNom);

        System.out.println("Test n2 : Cas Limite !");
        promo = new Promotion(ancienNom, liste);
        promo.setNom(ancienNom);
        testCasSetNom(promo, ancienNom, ancienNom);

        System.out.println("Test n2 : Cas Erreur !");
        promo = new Promotion(ancienNom, liste);
        promo.setNom("A");
        testCasSetNom(promo, ancienNom, "B");
    }

    public static void testCasSetNom(Promotion promo, String ancienNom, String nouveauNom){
        if(promo.getNom().equals(nouveauNom) || promo.getNom().equals(ancienNom)){
            System.out.println("Reussi");
        } else {
            System.out.println("Echec");
        }

        if(ancienNom.equals(nouveauNom)){
            System.out.println("setNom : Ancien nom est egale au nouveau nom");
        }
    }












    private static final String[] prenoms = {"Jean", "Marie", "Pierre", "Sophie", "Emma", "Louis", "Charlotte", "Lucas", "Brayan", "Romain", "Omer", "Mael", "No\u00E9", "Rayanne", "Benjamin"};
    private static final String[] nomsDeFamille = {"Dubois", "Martin", "Lefevre", "Bernard", "Durand", "Petit", "Thomas", "Leroy", "Campion", "Coignard", "Mellah", "Gunes", "Parcolet", "Saunders"};
    private static final Random random = new Random();

    private static String generateNomPersonne() {
        String prenom = prenoms[random.nextInt(prenoms.length)];
        String nomDeFamille = nomsDeFamille[random.nextInt(nomsDeFamille.length)];
        return(prenom + " " + nomDeFamille);
    }

    public static Etudiant[] creationTableauEtudiant(){
        Etudiant[] listeEtudiantBut1 = new Etudiant[100];
        
        for(int i = 0; i < listeEtudiantBut1.length; i++){
            String nom = generateNomPersonne();
            listeEtudiantBut1[i] = new Etudiant(nom, matieres, coefficients, 3);
        }
        return(listeEtudiantBut1);
    }
}
