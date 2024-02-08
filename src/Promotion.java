public class Promotion {
    private String nom;
    private Etudiant[] listeEtudiants;

    public Promotion(String nom, Etudiant[] listeEtudiants){
        if(nom == null){
            System.out.println("Constructeur : Erreur de nom");
        } else {
            this.nom = nom;
        }
        
        if(listeEtudiants == null){
            System.out.println("Constructeur : Liste Vide");
        } else {
            this.listeEtudiants = listeEtudiants;
        }
    }

    public String getNom(){
        return(this.nom);
    }

    public void setNom(String nom){
        if(nom == null){
            System.out.println("setNom : Erreur de Nom");
        } else {
            this.nom = nom;
        }
    }

    public double moyenne(){
        double sommeMoyenne = 0;
        double moyenne = 0;

        for(int i = 0; i < this.listeEtudiants.length; i++){
            sommeMoyenne += listeEtudiants[i].moyenneGenerale();
            moyenne = sommeMoyenne/listeEtudiants.length-1;
        }

        return(moyenne);
    }

    public double moyenneMax(){
        double moyenneMax = 0;
        if(this.listeEtudiants.length != 0){
            for(int i = 0; i < listeEtudiants.length; i++){
                if(listeEtudiants[i].moyenneGenerale() > moyenneMax){
                    moyenneMax = listeEtudiants[i].moyenneGenerale();
                }
            }
        } else {
            System.out.println("moyenneMin : Le tableau ne contient aucune valeur !");
        }
        return(moyenneMax);
    }

    public double moyenneMin(){
        double moyenneMin = 20;
        if(this.listeEtudiants.length != 0){
            for (int i = 0; i < listeEtudiants.length; i++) {
                if(listeEtudiants[i].moyenneGenerale() < moyenneMin){
                    moyenneMin = listeEtudiants[i].moyenneGenerale();
                }
            }
        } else {
            System.out.println("moyenneMin : Le tableau ne contient aucune valeur !");
        }
        return(moyenneMin);
    }

    public Etudiant getMajor(){
        Etudiant major = null;
        if(this.listeEtudiants.length != 0){
            major = listeEtudiants[0];
            for (int i = 0; i < listeEtudiants.length; i++) {
                if(major.moyenneGenerale() < listeEtudiants[i].moyenneGenerale()){
                    major = this.listeEtudiants[i];
                }
            }
        } else {
            System.out.println("Major : Tableau ne contient aucune valeur");
        }
        
        return(major);
    }

    public Etudiant getEtudiant(String nom){
        Etudiant etudiantChercher = null;
        boolean trouver = false;
        if(this.listeEtudiants.length != 0){
            int i = 0;
            while (i < this.listeEtudiants.length) {
                if(listeEtudiants[i].getNom().equals(nom)){
                    etudiantChercher = listeEtudiants[i];
                    trouver = true;
                } else {
                    i++;
                }
            }
        }

        if(!trouver){
          System.out.println("Pas d'étudiant !");
        }

        return(etudiantChercher);
    }

    public double moyenneMatiere(int i) {
        double sommeMoyenne = 0;
        double moyenne = 0;

        if(this.listeEtudiants.length != 0){
            if(i > 0 && i < this.listeEtudiants[0].getMATIERES().length){
                for(int j = 0; j < this.listeEtudiants.length; j++){
                    sommeMoyenne += this.listeEtudiants[j].moyenneMatiere(i);
                }
                moyenne = sommeMoyenne/this.listeEtudiants.length;
            } else {
                System.out.println("La matière renseignée n'est pas disponible !");
            }
        } else {
            System.out.println("Le tableau est vide !");
        }
        return(moyenne);
    }

    public String toString() {
        String stringFinal;

        stringFinal = ("Promo : " + this.getNom() + "\nNombre Etudiant : " + this.listeEtudiants.length + "\nMoyenne : " + this.moyenne());

        return(stringFinal);
    }
}
