package com.clinique;

import java.sql.*;

public class DbFunctions {

    //check if the user is in the database
    public static boolean check(Connection db, String nom, String prenom, String password) throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "SELECT COUNT(1) FROM utilisateur WHERE nom = '" + nom + "' AND prenom = '" + prenom +
                "' AND user_password = '" + password + "'";
        ResultSet nb = stmt.executeQuery(sql);
        nb.next();
        return nb.getString(1).equals("1");
    }

    //check if the user is an employee
    public static boolean isEmployee(Connection db, String userid) throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "SELECT COUNT(1) FROM employe WHERE user_id = '" + userid + "'";
        ResultSet nb = stmt.executeQuery(sql);
        nb.next();
        return nb.getString(1).equals("1");
    }

    //check if the user is a patient
    public boolean isPatient(Connection db, String userid) throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "SELECT COUNT(1) FROM patient WHERE user_id = " + userid;
        ResultSet nb = stmt.executeQuery(sql);
        nb.next();
        return nb.getString(1).equals("1");

    }

    //Partie receptioniste

    //method add and mod patient for patients aged < 16
    public static boolean addPatient(Connection db, String nom, String prenom, String password, String sexe,
                                     String ssn, String tel, String dateDeNaissance, String adresse,
                                     String codePostale, String province, String ville, String prenomParent,
                                     String nomParent, String relation, String email, String numAssurance,
                                     String succursale) throws SQLException {
        Statement stmt = db.createStatement();
        String sql1, sql2;
        sql1 = "INSERT INTO utilisateur VALUES (DEFAULT, '" + password + "', '" + nom + "', '" + prenom + "', '" +
                sexe + "', '" + ssn + "', '" + tel + "', '" + dateDeNaissance + "', '" + adresse + "', '" +
                codePostale + "', '" + province + "', '" + ville + "', '" + prenomParent + "', '" + nomParent +
                "', '" + relation + "')";
        sql2 = "INSERT INTO patient VALUES ((SELECT user_id FROM utilisateur WHERE nom = '" + nom +
                "' AND prenom = '" + prenom + "'), '" + email + "', '" + numAssurance + "', '" + succursale + "')";
        stmt.executeQuery(sql1);
        stmt.executeQuery(sql2);
        return true;
    }

    public static boolean modPatient(Connection db, int userid, String nom, String prenom, String sexe,
                                     String ssn, String tel, String dateDeNaissance, String adresse,
                                     String codePostale, String province, String ville, String prenomParent,
                                     String nomParent, String relation, String email, String num_assurance,
                                     String succursale) throws SQLException {
        Statement stmt = db.createStatement();
        String sql1, sql2;
        sql1 = "UPDATE utilisateur SET nom = '" + nom + "', prenom = '" + prenom + "', sexe = '" + sexe +
                "', ssn = '" + ssn + "', tel = '" + tel + "', date_de_naissance = '" + dateDeNaissance +
                "', adresse = '" + adresse + "', code_postal = '" + codePostale + "', province = '" + province +
                "', ville = '" + ville + "', prenom_parent = '" + prenomParent + "', nom_parent = '" + nomParent +
                "', relation_avec_enfant = '" + relation + "' WHERE user_id = '" + userid + "'";
        sql2 = "UPDATE utilisateur SET email = " + email + ", num_assurance = '" + num_assurance +
                "', succursale = '" + succursale + "' WHERE user_id = '" + userid + "'";
        stmt.executeQuery(sql1);
        stmt.executeQuery(sql2);
        return true;
    }

    //method add and mod patient for patients aged >= 16
    public static boolean addPatient(Connection db, String nom, String prenom, String password, String sexe,
                                     String ssn, String tel, String dateDeNaissance, String adresse,
                                     String codePostal, String province, String ville, String email,
                                     String numAssurance, String succursale) throws SQLException {
        Statement stmt = db.createStatement();
        String sql1, sql2;
        sql1 = "INSERT INTO utilisateur (user_id, user_password, nom, prenom, " +
                "sexe, ssn, tel, date_de_naissance, adresse, code_postal, province, ville) " +
                "VALUES (DEFAULT, '" + password + "', '" + nom + "', '" + prenom + "', '" + sexe + "', '" + ssn +
                "', '" + tel + "', '" + dateDeNaissance + "', '" + adresse + "', '" + codePostal +
                "', '" + province + "', '" + ville + "', '', '', '')";
        sql2 = "INSERT INTO patient (user_id, email, num_assurance, succursale) " +
                "VALUES ((SELECT user_id FROM utilisateur WHERE nom  = " + nom + " AND prenom = " + prenom + "), " +
                email + "', '" + numAssurance + "', '" + succursale + "')";
        stmt.executeQuery(sql1);
        stmt.executeQuery(sql2);
        return true;
    }

    public static boolean modPatient(Connection db, int userid, String nom, String prenom, String sexe,
                                     String ssn, String tel, String dateDeNaissance, String adresse,
                                     String codePostale, String province, String ville, String email,
                                     String numAssurance, String succursale) throws SQLException {
        Statement stmt = db.createStatement();
        String sql1, sql2;
        sql1 = "UPDATE utilisateur SET nom = '" + nom + "', prenom = '" + prenom + "', sexe = '" + sexe +
                "', ssn = '" + ssn + "', tel = '" + tel + "', date_de_naissance = '" + dateDeNaissance +
                "', adresse = '" + adresse + "', code_postal = '" + codePostale + "', province = '" + province +
                "', ville = '" + ville + "' WHERE user_id = " + userid;
        sql2 = "UPDATE utilisateur SET email = '" + email + "', num_assurance = '" + numAssurance +
                "', succursale = '" + succursale + "' WHERE user_id = " + userid;
        stmt.executeQuery(sql1);
        stmt.executeQuery(sql2);
        return true;
    }

    //créer des rendez-vous
    public static boolean addAppointment(Connection db, String succ, String nomPatient, String prenomPatient,
                                         String nomDentiste, String prenomDentiste, String nomHygieniste,
                                         String prenomHygieniste, Date dateRv, Time heureDebut, Time heureFin,
                                         String typeRv, String statut, int chambre) throws SQLException {
        Statement stmt= db.createStatement();
        String sql = "INSERT INTO rendez_vous VALUES (DEFAULT, '" + succ + "', " +
                getUserid(db, nomPatient, prenomPatient) + ", '" + getUserid(db, nomDentiste, prenomDentiste) +
                "', '" + getUserid(db, nomHygieniste, prenomHygieniste) + "', date'" + dateRv + "', '" + heureDebut +
                "', '" + heureFin + "', '" + typeRv + "', '" + statut + "', '" + chambre + "')";
        stmt.executeQuery(sql);
        return true;
    }

    // retourne userid
    public static String getUserid(Connection db, String nom, String prenom) throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "SELECT user_id FROM utilisateur WHERE nom = '" + nom + "' AND prenom = '" + prenom + "'";
        ResultSet userid = stmt.executeQuery(sql);
        userid.next();
        return userid.getString(1);
    }

    public static ResultSet getDossier(Connection db, String nom, String prenom) throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "SELECT * FROM inscrit_dans WHERE id_dossier = " +
                "(SELECT id_dossier FROM dossier WHERE id_patient = '" + getUserid(db, nom, prenom) + "')";
        return stmt.executeQuery(sql);
    }

    public static boolean addProcedure(Connection db, String typeDeProcedure, String description,
                                       String dentImplique, int frais) throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "INSERT INTO procédure (id_procedure, type_de_procedure, description, dent_implique, frais) " +
                "VALUES (DEFAULT, '" + typeDeProcedure + "', '" + description + "', '" + dentImplique +
                "', " + frais + ")";
        stmt.executeQuery(sql);
        return true;
    }

    public static ResultSet getAppointments(Connection db, String nom, String prenom) throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "SELECT * FROM rendez_vous WHERE id_patient = '" + getUserid(db, nom, prenom) + "'";
        return stmt.executeQuery(sql);
    }

    public static void getFacture() {

    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dentistry";
        String user = "root";
        String password = "MyPassword$";
        try {
            Connection db = DriverManager.getConnection(url, user, password);

            ResultSet dossier = getDossier(db, "Ant", "Man");
            dossier.next();
            System.out.println(dossier.getString(1));
//            try {
//                if (check(db, "Ant", "Man", "AntMan")) {
//                    System.out.println("vfjjndfvjndfvsjnfsvjfivdsfidsv");
//                }
//            } catch (Exception e) {
//                System.out.println("Uh oh");
//            }





//            Statement statement = db.createStatement();
//            ResultSet utilisateurs = statement.executeQuery("SELECT * FROM utilisateur");//users table
//
//            while(utilisateurs.next())//pour chaque ligne
//                System.out.println(utilisateurs.getString(1)
//                        + "  " + utilisateurs.getString(2)
//                        + "  " + utilisateurs.getString(3));
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
