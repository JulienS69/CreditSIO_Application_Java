package CreditSio.Controller;




public class Person {


    String Numéro, Nom, Prenom, Rue, CP, Ville, Téléphone, Mail;

    public Person (String Numéro, String Nom, String Prenom, String Rue, String CP, String Ville, String Téléphone, String Mail){
        this.Numéro = Numéro;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Rue = Rue;
        this.CP = CP;
        this.Ville = Ville;
        this.Téléphone = Téléphone;
        this.Mail = Mail;
    }

    public String getNuméro() {
        return Numéro;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getRue() {
        return Rue;
    }

    public String getCP() {
        return CP;
    }

    public String getVille() {
        return Ville;
    }

    public String getTéléphone() {
        return Téléphone;
    }

    public String getMail() {
        return Mail;
    }

    public void setNuméro(String numéro) {
        Numéro = numéro;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public void setRue(String rue) {
        Rue = rue;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public void setVille(String ville) {
        Ville = ville;
    }

    public void setTéléphone(String téléphone) {
        Téléphone = téléphone;
    }

    public void setMail(String mail) {
        Mail = mail;
    }
}
