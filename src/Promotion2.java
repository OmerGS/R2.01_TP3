public class Promotion2 {
    private String nom;
    private Etudiant[] listeEtudiants;
    private int nbInscrits; // nouvel attribut pour suivre le nombre d'étudiants inscrits

    // Premier constructeur modifié pour initialiser nbInscrits avec la taille de listeEtudiants
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

    // Nouveau constructeur prenant seulement le nom de la promotion et une taille maximum pour le tableau
    public Promotion2(String nom, int tailleMax) {
        if (nom == null) {
            System.out.println("Constructeur : Erreur de nom");
        } else {
            this.nom = nom;
            this.listeEtudiants = new Etudiant[tailleMax]; // Initialisation du tableau avec la taille maximum
            this.nbInscrits = 0; // Aucun étudiant inscrit au départ
        }
    }

    // Méthode pour inscrire un nouvel étudiant
    public void inscrire(Etudiant etudiant) {
        if (this.nbInscrits < this.listeEtudiants.length) {
            this.listeEtudiants[this.nbInscrits] = etudiant;
            this.nbInscrits++;
        } else {
            System.out.println("Impossible d'inscrire plus d'étudiants, le tableau est plein.");
        }
    }

    // Méthode pour obtenir le nom de la promotion
    public String getNom() {
        return this.nom;
    }

    // Méthode pour définir le nom de la promotion
    public void setNom(String nom) {
        if (nom == null) {
            System.out.println("setNom : Erreur de Nom");
        } else {
            this.nom = nom;
        }
    }

    // Méthode moyenne modifiée pour utiliser nbInscrits au lieu de la longueur du tableau
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

    // Méthodes non modifiées

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

    public String toString() {
        String stringFinal;

        stringFinal = ("Promo : " + this.getNom() + "\nNombre Etudiant : " + this.nbInscrits + "\nMoyenne : " + this.moyenne());

        return stringFinal;
    }
}
