package main.java.com.clinique;

import java.sql.*;

public class DbFunctions {
    static Connection db = null;

    // check if the user is in the data base
    public static boolean check(String nom, String prenom, String password) throws SQLException {

        Statement stmt = db.createStatement();
        String sql = "SELECT COUNT(1) FROM utilisateur WHERE nom = '" + nom + "' AND prenom = '" + prenom +
                "' AND user_password = '" + password + "'";
        ResultSet nb = stmt.executeQuery(sql);

        nb.next();
        return nb.getString(1).equals("1");
    }

    // check if the user is an employee
    public static boolean isEmployee(String userid) throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "SELECT COUNT(1) FROM employe WHERE user_id = '" + userid + "'";
        ResultSet nb = stmt.executeQuery(sql);
        nb.next();
        return nb.getString(1).equals("1");
    }

    // check if the user is a patient
    public static boolean isPatient(String userid) throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "SELECT COUNT(1) FROM patient WHERE user_id = '" + userid + "'";
        ResultSet nb = stmt.executeQuery(sql);
        nb.next();
        return nb.getString(1).equals("1");

    }

    // Partie receptioniste

    // method add and mod patient for patients aged < 16
    public static void addPatient(String nom, String prenom, String password, String sexe,
            String ssn, String tel, String dateDeNaissance, String adresse,
            String codePostale, String province, String ville, String prenomParent,
            String nomParent, String relation, String email, String numAssurance,
            String succursale) throws SQLException {
        Statement stmt = db.createStatement();
        String sql1, sql2;
        sql1 = "INSERT INTO utilisateur (user_id, user_password, nom, prenom, sexe, ssn, tel, date_de_naissance, " +
                "adresse, code_postal, province, ville, prenom_parent, nom_parent, relation_avec_enfant) " +
                "VALUES ( DEFAULT'" + password + "', '" + nom + "', '" + prenom + "', '" + sexe + "', '" + ssn + "', '"
                +
                tel + "', '" + dateDeNaissance + "', '" + adresse + "', '" + codePostale + "', '" + province +
                "', '" + ville + "', '" + prenomParent + "', '" + nomParent + "', '" + relation + "')";
        sql2 = "INSERT INTO patient (user_id, email, num_assurance, succursale) " +
                "VALUES ((SELECT user_id FROM utilisateur WHERE nom = '" + nom + "' AND prenom = '" + prenom + "'), '" +
                email + "', '" + numAssurance + "', '" + succursale + "')";
        stmt.execute(sql1);
        stmt.execute(sql2);

    }

    public static void modPatient(int userid, String nom, String prenom, String sexe,
            String ssn, String tel, String dateDeNaissance, String adresse,
            String codePostale, String province, String ville, String prenomParent,
            String nomParent, String relation, String email, String num_assurance,
            String succursale) throws SQLException {
        Statement stmt = db.createStatement();
        String sql1, sql2;
        sql1 = "UPDATE utilisateur SET nom = " + nom + ", prenom = '" + prenom + "', sexe = '" + sexe +
                "', ssn = '" + ssn + "', tel = '" + tel + "', date_de_naissance = '" + dateDeNaissance +
                "', adresse = '" + adresse + "', code_postal = '" + codePostale + "', province = '" + province +
                "', ville = '" + ville + "', prenom_parent = '" + prenomParent + "', nom_parent = '" + nomParent +
                "', relation_avec_enfant = '" + relation + "' WHERE user_id = '" + userid + "'";
        sql2 = "UPDATE utilisateur SET email = " + email + ", num_assurance = '" + num_assurance +
                "', succursale = '" + succursale + "' WHERE user_id = '" + userid + "'";
        stmt.execute(sql1);
        stmt.execute(sql2);

    }

    // method add and mod patient for patients aged > 16
    public static void addPatient(String nom, String prenom, String password, String sexe,
            String ssn, String tel, String dateDeNaissance, String adresse,
            String codePostale, String province, String ville, String email,
            String numAssurance, String succursale) throws SQLException {
        Statement stmt = db.createStatement();
        String sql1, sql2;
        sql1 = "INSERT INTO utilisateur (DEFAULT, user_id, user_password, nom, prenom, " +
                "sexe, ssn, tel, date_de_naissance, adresse, code_postal, province, ville) " +
                "VALUES ('" + password + "', '" + nom + "', '" + prenom + "', '" + sexe + "', '" + ssn +
                "', '" + tel + "', '" + dateDeNaissance + "', '" + adresse + "', '" + codePostale +
                "', '" + province + "', '" + ville + "', '', '', '')";
        sql2 = "INSERT INTO patient (user_id, email, num_assurance, succursale) " +
                "VALUES ((SELECT user_id FROM utilisateur WHERE nom  = " + nom + " AND prenom = " + prenom + "), " +
                email + "', '" + numAssurance + "', '" + succursale + "')";
        stmt.execute(sql1);
        stmt.execute(sql2);
    }

    public static void modPatient(int userid, String nom, String prenom, String sexe,
            String ssn, String tel, String dateDeNaissance, String adresse,
            String codePostale, String province, String ville, String email,
            String numAssurance, String succursale) throws SQLException {
        Statement stmt = db.createStatement();
        String sql1, sql2;
        sql1 = "UPDATE utilisateur SET nom = '" + nom + "', prenom = '" + prenom + "', sexe = '" + sexe +
                "', ssn = '" + ssn + "', tel = '" + tel + "', date_de_naissance = '" + dateDeNaissance +
                "', adresse = '" + adresse + "', code_postal = '" + codePostale + "', province = '" + province +
                "', ville = '" + ville + "' WHERE user_id = '" + userid + "'";
        sql2 = "UPDATE utilisateur SET email = '" + email + "', num_assurance = '" + numAssurance +
                "', succursale = '" + succursale + "' WHERE user_id = '" + userid + "'";
        stmt.execute(sql1);
        stmt.execute(sql2);
    }

    // créer des rendez-vous
    public static void addAppointment(String succ, String nomPatient, String prenomPatient,
            String nomDentiste, String prenomDentiste, String nomHygieniste,
            String prenomHygieniste, String dateRv, String heureDebut, String heureFin,
            String typeRv, String statut, int chambre) throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "INSERT INTO rendez_vous (id_appointment, succ, id_patient, id_dentiste, id_hygieniste, " +
                "date_rv, heure_debut, heure_fin, type_rv, adresse, statut, chambre) " +
                "VALUES (DEFAULT, " + succ + "', '" + getUserid(nomPatient, prenomPatient) + "', '" +
                getUserid(nomDentiste, prenomDentiste) + "', '" + getUserid(nomHygieniste, prenomHygieniste) +
                "', '" + dateRv + "', '" + heureDebut + "', '" + heureFin + "', '" + typeRv + "', '" + statut +
                "', '" + chambre + "')";
        stmt.execute(sql);
    }

    // retourne userid
    public static String getUserid(String nom, String prenom) throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "SELECT user_id FROM utilisateur WHERE nom = '" + nom + "' AND prenom = '" + prenom + "'";
        ResultSet userid = stmt.executeQuery(sql);
        userid.next();
        return userid.getString(1);
    }

    public static ResultSet getDossiers(String nom, String prenom) throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "SELECT * FROM inscrit_dans WHERE id_dossier = " +
                "(SELECT id_dossier FROM dossier WHERE id_patient = '" + getUserid(nom, prenom) + "')";
        return stmt.executeQuery(sql);
    }

    public static void addProcedure(String typeDeProcedure, String description,
                                    String dentImplique, int frais) throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "INSERT INTO procédure (id_procedure, type_de_procedure, description, dent_implique, frais) " +
                "VALUES (DEFAULT, '" + typeDeProcedure + "', '" + description + "', '" + dentImplique +
                "', '" + frais + "')";
        stmt.execute(sql);
    }

    public static ResultSet getAppointments(String nom, String prenom) throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "SELECT * FROM rendez_vous WHERE id_patient = '" + getUserid(nom, prenom) + "'";
        return stmt.executeQuery(sql);
    }

    public static void getFacture() {

    }

    public void setFacture() {

    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dentistry";
        String user = "root";
        String password = "Password";///// Change this
        try {
            db = DriverManager.getConnection(url, user, password);

            GUI gc = new GUI();
            gc.start();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
