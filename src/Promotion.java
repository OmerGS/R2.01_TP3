/**
 * La classe Promotion représente une promotion d'étudiants.
 * @author O.Gunes
 */
public class Promotion {
    private String nom; // Le nom de la promotion
    private Etudiant[] listeEtudiants; // La liste des étudiants de la promotion

    /**
     * Constructeur de la classe Promotion.
     *
     * @param nom             Le nom de la promotion.
     * @param listeEtudiants  La liste des étudiants de la promotion.
     */
    public Promotion(String nom, Etudiant[] listeEtudiants) {
        if (nom == null) {
            System.out.println("Constructeur : Erreur de nom");
        } else {
            this.nom = nom;
        }

        if (listeEtudiants == null) {
            System.out.println("Constructeur : Liste Vide");
        } else {
            this.listeEtudiants = listeEtudiants;
        }
    }

    /**
     * Méthode permettant d'obtenir le nom de la promotion.
     *
     * @return Le nom de la promotion.
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Méthode permettant de définir le nom de la promotion.
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
     * Méthode permettant de calculer la moyenne générale de la promotion.
     *
     * @return La moyenne générale de la promotion.
     */
    public double moyenne() {
        double sommeMoyenne = 0;
        double moyenne = 0;

        for (int i = 0; i < this.listeEtudiants.length; i++) {
            sommeMoyenne += listeEtudiants[i].moyenneGenerale();
            moyenne = sommeMoyenne / listeEtudiants.length - 1;
        }

        return moyenne;
    }

    /**
     * Méthode permettant de trouver la moyenne maximale parmi les étudiants de la promotion.
     *
     * @return La moyenne maximale parmi les étudiants de la promotion.
     */
    public double moyenneMax() {
        double moyenneMax = 0;
        if (this.listeEtudiants.length != 0) {
            for (int i = 0; i < listeEtudiants.length; i++) {
                if (listeEtudiants[i].moyenneGenerale() > moyenneMax) {
                    moyenneMax = listeEtudiants[i].moyenneGenerale();
                }
            }
        } else {
            System.out.println("moyenneMin : Le tableau ne contient aucune valeur !");
        }
        return moyenneMax;
    }

    /**
     * Méthode permettant de trouver la moyenne minimale parmi les étudiants de la promotion.
     *
     * @return La moyenne minimale parmi les étudiants de la promotion.
     */
    public double moyenneMin() {
        double moyenneMin = 20;
        if (this.listeEtudiants.length != 0) {
            for (int i = 0; i < listeEtudiants.length; i++) {
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
     * Méthode permettant de trouver l'étudiant ayant la meilleure moyenne dans la promotion.
     *
     * @return L'étudiant ayant la meilleure moyenne dans la promotion.
     */
    public Etudiant getMajor() {
        Etudiant major = null;
        if (this.listeEtudiants.length != 0) {
            major = listeEtudiants[0];
            for (int i = 0; i < listeEtudiants.length; i++) {
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
     * Méthode permettant de trouver un étudiant dans la promotion en fonction de son nom.
     *
     * @param nom Le nom de l'étudiant à rechercher.
     * @return L'étudiant correspondant au nom spécifié, ou null si aucun étudiant trouvé.
     */
    public Etudiant getEtudiant(String nom) {
        Etudiant etudiantChercher = null;
        boolean trouver = false;
        if (this.listeEtudiants.length != 0) {
            int i = 0;
            while (i < this.listeEtudiants.length) {
                if (listeEtudiants[i].getNom().equals(nom)) {
                    etudiantChercher = listeEtudiants[i];
                    trouver = true;
                    break;
                } else {
                    i++;
                }
            }
        }

        if (!trouver) {
            System.out.println("Pas d'étudiant !");
        }

        return etudiantChercher;
    }

    /**
     * Méthode permettant de calculer la moyenne dans une matière spécifique de la promotion.
     *
     * @param i L'indice de la matière pour laquelle calculer la moyenne.
     * @return La moyenne dans la matière spécifiée.
     */
    public double moyenneMatiere(int i) {
        double sommeMoyenne = 0;
        double moyenne = 0;

        if (this.listeEtudiants.length != 0) {
            if (i > 0 && i < this.listeEtudiants[0].getMATIERES().length) {
                for (int j = 0; j < this.listeEtudiants.length; j++) {
                    sommeMoyenne += this.listeEtudiants[j].moyenneMatiere(i);
                }
                moyenne = sommeMoyenne / this.listeEtudiants.length;
            } else {
                System.out.println("La matière renseignée n'est pas disponible !");
            }
        } else {
            System.out.println("Le tableau est vide !");
        }
        return moyenne;
    }

    /**
     * Méthode permettant de représenter la promotion sous forme de chaîne de caractères.
     *
     * @return Une chaîne de caractères représentant la promotion.
     */
    public String toString() {
        String stringFinal;

        stringFinal = ("Promo : " + this.getNom() + "\nNombre Etudiant : " + this.listeEtudiants.length + "\nMoyenne : " + this.moyenne());

        return stringFinal;
    }
}
