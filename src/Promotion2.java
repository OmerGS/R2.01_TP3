/**
 * La classe Promotion2 représente une promotion d'étudiants.
 * @author O.Gunes
 */
public class Promotion2 {
    private String nom; // Le nom de la promotion
    private Etudiant[] listeEtudiants; // La liste des étudiants inscrits
    private int nbInscrits; // Le nombre d'étudiants inscrits dans la promotion

    /**
     * Constructeur pour initialiser une promotion avec un nom et une liste d'étudiants.
     *
     * @param nom            Le nom de la promotion.
     * @param listeEtudiants La liste des étudiants de la promotion.
     */
    public Promotion2(String nom, Etudiant[] listeEtudiants) {
        if (nom == null) {
            System.out.println("Constructeur : Erreur de nom");
        } else {
            this.nom = nom;
        }

        if (listeEtudiants == null) {
            System.out.println("Constructeur : Liste Vide");
        } else {
            this.listeEtudiants = listeEtudiants;
            this.nbInscrits = listeEtudiants.length;
        }
    }

    /**
     * Constructeur pour initialiser une promotion avec un nom et une taille maximale pour le tableau des étudiants.
     *
     * @param nom       Le nom de la promotion.
     * @param tailleMax La taille maximale pour le tableau des étudiants.
     */
    public Promotion2(String nom, int tailleMax) {
        if (nom == null) {
            System.out.println("Constructeur : Erreur de nom");
        } else {
            this.nom = nom;
            this.listeEtudiants = new Etudiant[tailleMax]; // Initialisation du tableau avec la taille maximum
            this.nbInscrits = 0; // Aucun étudiant inscrit au départ
        }
    }

    /**
     * Méthode pour inscrire un nouvel étudiant dans la promotion.
     *
     * @param etudiant L'étudiant à inscrire.
     */
    public void inscrire(Etudiant etudiant) {
        if (this.nbInscrits < this.listeEtudiants.length) {
            this.listeEtudiants[this.nbInscrits] = etudiant;
            this.nbInscrits++;
        } else {
            System.out.println("Impossible d'inscrire plus d'étudiants, le tableau est plein.");
        }
    }

    /**
     * Méthode pour obtenir le nom de la promotion.
     *
     * @return Le nom de la promotion.
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Méthode pour définir le nom de la promotion.
     *
     * @param nom Le nouveau nom de la promotion.
     */
    public void setNom(String nom) {
        if (nom == null) {
            System.out.println("setNom : Erreur de Nom");
        } else {
            this.nom = nom;
        }
    }

    /**
     * Méthode pour calculer la moyenne générale de la promotion.
     *
     * @return La moyenne générale de la promotion.
     */
    public double moyenne() {
        double sommeMoyenne = 0;
        double moyenne = 0;

        for (int i = 0; i < this.nbInscrits; i++) {
            sommeMoyenne += listeEtudiants[i].moyenneGenerale();
        }
        if (this.nbInscrits > 0) {
            moyenne = sommeMoyenne / this.nbInscrits;
        }
        return moyenne;
    }

    /**
     * Méthode pour obtenir la moyenne maximale parmi les étudiants inscrits.
     *
     * @return La moyenne maximale parmi les étudiants inscrits.
     */
    public double moyenneMax() {
        double moyenneMax = 0;
        if (this.nbInscrits != 0) {
            for (int i = 0; i < this.nbInscrits; i++) {
                if (listeEtudiants[i].moyenneGenerale() > moyenneMax) {
                    moyenneMax = listeEtudiants[i].moyenneGenerale();
                }
            }
        } else {
            System.out.println("moyenneMax : Le tableau ne contient aucune valeur !");
        }
        return moyenneMax;
    }

    /**
     * Méthode pour obtenir la moyenne minimale parmi les étudiants inscrits.
     *
     * @return La moyenne minimale parmi les étudiants inscrits.
     */
    public double moyenneMin() {
        double moyenneMin = 20;
        if (this.nbInscrits != 0) {
            for (int i = 0; i < this.nbInscrits; i++) {
                if (listeEtudiants[i].moyenneGenerale() < moyenneMin) {
                    moyenneMin = listeEtudiants[i].moyenneGenerale();
                }
            }
        } else {
            System.out.println("moyenneMin : Le tableau ne contient aucune valeur !");
        }
        return moyenneMin;
    }

    /**
     * Méthode pour obtenir l'étudiant avec la meilleure moyenne dans la promotion.
     *
     * @return L'étudiant avec la meilleure moyenne.
     */
    public Etudiant getMajor() {
        Etudiant major = null;
        if (this.nbInscrits != 0) {
            major = listeEtudiants[0];
            for (int i = 0; i < this.nbInscrits; i++) {
                if (major.moyenneGenerale() < listeEtudiants[i].moyenneGenerale()) {
                    major = this.listeEtudiants[i];
                }
            }
        } else {
            System.out.println("Major : Tableau ne contient aucune valeur");
        }

        return major;
    }

    /**
     * Méthode pour obtenir un étudiant par son nom.
     *
     * @param nom Le nom de l'étudiant à rechercher.
     * @return L'étudiant correspondant au nom spécifié, ou null si aucun étudiant ne correspond.
     */
    public Etudiant getEtudiant(String nom) {
        Etudiant etudiantCherche = null;
        boolean trouve = false;
        if (this.nbInscrits != 0) {
            for (int i = 0; i < this.nbInscrits; i++) {
                if (listeEtudiants[i].getNom().equals(nom)) {
                    etudiantCherche = listeEtudiants[i];
                    trouve = true;
                    break; // Sortir de la boucle dès que l'étudiant est trouvé
                }
            }
        }

        if (!trouve) {
            System.out.println("Pas d'étudiant !");
        }

        return etudiantCherche;
    }

    /**
     * Méthode pour calculer la moyenne dans une matière spécifique de la promotion.
     *
     * @param i L'index de la matière pour laquelle calculer la moyenne.
     * @return La moyenne dans la matière spécifiée.
     */
    public double moyenneMatiere(int i) {
        double sommeMoyenne = 0;
        double moyenne = 0;

        if (this.nbInscrits != 0) {
            if (i > 0 && i < this.listeEtudiants[0].getMATIERES().length) {
                for (int j = 0; j < this.nbInscrits; j++) {
                    sommeMoyenne += this.listeEtudiants[j].moyenneMatiere(i);
                }
                moyenne = sommeMoyenne / this.nbInscrits;
            } else {
                System.out.println("La matière renseignée n'est pas disponible !");
            }
        } else {
            System.out.println("Le tableau est vide !");
        }
        return moyenne;
    }

    /**
     * Méthode pour obtenir une représentation en chaîne de caractères de la promotion.
     *
     * @return Une représentation en chaîne de caractères de la promotion.
     */
    public String toString() {
        String stringFinal;

        stringFinal = ("Promo : " + this.getNom() + "\nNombre Etudiant : " + this.nbInscrits + "\nMoyenne : " + this.moyenne());

        return stringFinal;
    }
}
