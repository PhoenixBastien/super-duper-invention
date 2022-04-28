package main.java.com.clinique;

import java.sql.*;

public class DbFunctions {
    static Connection db = null;

    // check if the user is in the data base
    public static boolean check(String nom, String prenom, String password) throws SQLException {

        Statement stmt = db.createStatement();
        String sql = "SELECT COUNT(1) FROM utilisateur WHERE nom = '" + nom +
                "' AND prenom = '" + prenom + "' AND user_password = '" + password + "'";
        ResultSet nb = stmt.executeQuery(sql);
        nb.next();
        return nb.getString(1).equals("1");
    }

    // check if the user is an employee
    public static boolean isEmployee(int userid) throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "SELECT COUNT(1) FROM employe WHERE user_id = " + userid;
        ResultSet nb = stmt.executeQuery(sql);
        nb.next();
        return nb.getString(1).equals("1");
    }

    // check if the user is a patient
    public static boolean isPatient(int userid) throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "SELECT COUNT(1) FROM patient WHERE user_id = " + userid;
        ResultSet nb = stmt.executeQuery(sql);
        nb.next();
        return nb.getString(1).equals("1");

    }

    // Partie receptioniste

    // method add and mod patient for patients aged < 16
    public static void addPatient(String nom, String prenom, String password, String sexe,
                                  int ssn, String tel, String dateDeNaissance, String adresse,
                                  String codePostal, String province, String ville, String prenomParent,
                                  String nomParent, String relation, String email, String numAssurance,
                                  String succursale) throws SQLException {
        Statement stmt = db.createStatement();
        String sql1, sql2;
        sql1 = "INSERT INTO utilisateur " +
                "VALUES (DEFAULT, '" + password + "', '" + nom + "', '" + prenom + "', '" + sexe +
                "', " + ssn + ", '" + tel + "', '" + dateDeNaissance + "', DEFAULT, '" + adresse +
                "', '" + codePostal + "', '" + province + "', '" + ville + "', '" + prenomParent +
                "', '" + nomParent + "', '" + relation + "')";
        sql2 = "INSERT INTO patient VALUES ((SELECT user_id FROM utilisateur WHERE nom = '" + nom +
                "' AND prenom = '" + prenom + "'), '" + email + "', '" + numAssurance + "', '" + succursale + "')";
        stmt.execute(sql1);
        stmt.execute(sql2);
    }

    public static void modPatient(int userid, String nom, String prenom, String sexe,
                                  int ssn, String tel, String dateDeNaissance, String adresse,
                                  String codePostal, String province, String ville, String prenomParent,
                                  String nomParent, String relation, String email, String num_assurance,
                                  String succursale) throws SQLException {
        Statement stmt = db.createStatement();
        String sql1, sql2;
        sql1 = "UPDATE utilisateur SET nom = '" + nom + "', prenom = '" + prenom + "', sexe = '" + sexe +
                "', ssn = " + ssn + ", tel = '" + tel + "', date_de_naissance = DATE'" + dateDeNaissance +
                "', age = DEFAULT, adresse = '" + adresse + "', code_postal = '" + codePostal +
                "', province = '" + province + "', ville = '" + ville + "', prenom_parent = '" + prenomParent +
                "', nom_parent = '" + nomParent + "', relation_avec_enfant = '" + relation +
                "' WHERE user_id = " + userid;
        sql2 = "UPDATE patient SET email = '" + email + "', num_assurance = '" + num_assurance +
                "', succursale = '" + succursale + "' WHERE id_patient = " + userid;
        stmt.execute(sql1);
        stmt.execute(sql2);
    }

    // method add and mod patient for patients aged > 16
    public static void addPatient(String nom, String prenom, String password, String sexe,
                                  int ssn, String tel, String dateDeNaissance, String adresse,
                                  String codePostal, String province, String ville, String email,
                                  String numAssurance, String succursale) throws SQLException {
        Statement stmt = db.createStatement();
        String sql1, sql2;
        sql1 = "INSERT INTO utilisateur VALUES (DEFAULT, '" + password + "', '" + nom + "', '" + prenom + "', '" +
                sexe + "', " + ssn + ", '" + tel + "', DATE'" + dateDeNaissance + "', DEFAULT, '" + adresse + "', '" +
                codePostal + "', '" + province + "', '" + ville + "', '', '', '')";
        sql2 = "INSERT INTO patient VALUES ((SELECT user_id FROM utilisateur WHERE nom  = '" + nom +
                "' AND prenom = '" + prenom + "'), '" + email + "', '" + numAssurance + "', '" + succursale + "')";
        stmt.execute(sql1);
        stmt.execute(sql2);
    }

    public static void modPatient(int userid, String nom, String prenom, String sexe,
                                  int ssn, String tel, String dateDeNaissance, String adresse,
                                  String codePostal, String province, String ville, String email,
                                  String numAssurance, String succursale) throws SQLException {
        Statement stmt = db.createStatement();
        String sql1, sql2;
        sql1 = "UPDATE utilisateur SET nom = '" + nom + "', prenom = '" + prenom + "', sexe = '" + sexe +
                "', ssn = " + ssn + ", tel = '" + tel + "', date_de_naissance = DATE'" + dateDeNaissance +
                "', age = DEFAULT, adresse = '" + adresse + "', code_postal = '" + codePostal +
                "', province = '" + province + "', ville = '" + ville + "' WHERE user_id = " + userid;
        sql2 = "UPDATE patient SET email = '" + email + "', num_assurance = '" + numAssurance +
                "', succursale = '" + succursale + "' WHERE id_patient = " + userid;
        stmt.execute(sql1);
        stmt.execute(sql2);
    }

    public static int getRVid(String nom, String prenom) throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "SELECT id_appointment FROM rendez_vous WHERE id_patient = " + getUserid(nom, prenom);
        ResultSet id_appointment = stmt.executeQuery(sql);
        id_appointment.next();
        return Integer.parseInt(id_appointment.getString(1));
    }

    // créer des rendez-vous
    public static void addAppointment(String succ, String nomPatient, String prenomPatient, String nomDentiste,
                                      String prenomDentiste, String nomHygieniste, String prenomHygieniste,
                                      String dateRv, String heureDebut, String heureFin, String typeRv,
                                      String statut, int chambre, int procedure, int traitement) throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "INSERT INTO rendez_vous VALUES (DEFAULT, '" + succ + "', " +
                getUserid(nomPatient, prenomPatient) + ", " + getUserid(nomDentiste, prenomDentiste) +
                ", " + getUserid(nomHygieniste, prenomHygieniste) + ", DATE'" + dateRv + "', TIME'" +
                heureDebut + "', TIME'" + heureFin + "', '" + typeRv + "', '" + statut + "', " + chambre + ")";
        stmt.execute(sql);
        int rv_id = getRVid(nomPatient, prenomPatient);
        int penalite = 0;
        String sql0 = "select statut from rendez_vous where id_appointment = " + rv_id;
        String statutRV = String.valueOf(stmt.execute(sql0));
        if (statutRV.equals("retard")){
            penalite += 14;
        }

        String sql1 = "insert into procedure_rv values (" + rv_id + ", " + procedure + ");";
        String sql2 = "insert into frais values (default, " + procedure + ", " + traitement + ", '" +
                typeRv + "', (select frais from procédure where id_procedure = " + procedure +
                "), (select frais from traitement where id_traitement = " + traitement + "), " +
                penalite + ", default);";
        stmt.execute(sql1);
        stmt.execute(sql2);
        addFacture(dateRv,nomPatient,prenomPatient,rv_id);
    }

    // retourne userid
    public static int getUserid(String nom, String prenom) throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "SELECT user_id FROM utilisateur WHERE nom = '" + nom + "' AND prenom = '" + prenom + "'";
        ResultSet userid = stmt.executeQuery(sql);
        userid.next();
        return Integer.parseInt(userid.getString(1));
    }

    public static ResultSet getDossier(String nom, String prenom) throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "SELECT * FROM inscrit_dans WHERE id_dossier = " +
                "(SELECT id_dossier FROM dossier WHERE id_patient = " + getUserid(nom, prenom) + ")";
        ResultSet dossier = stmt.executeQuery(sql);
        dossier.next();
        return dossier;
    }

    public static void addProcedure(String typeDeProcedure, String description,
                                    String dentImplique, int frais) throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "INSERT INTO procédure VALUES (DEFAULT, '" + typeDeProcedure +
                "', '" + description + "', '" + dentImplique + "', " + frais + ")";
        stmt.execute(sql);
    }

    public static ResultSet getAppointments(String nom, String prenom) throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "SELECT * FROM rendez_vous WHERE id_patient = " + getUserid(nom, prenom);
        return stmt.executeQuery(sql);
    }

    public static void getFacture() {

    }

    public void setFacture() {

    }

    public static void addFacture(String dateRv, String nomPatient,
                                  String prenomPatient, int rvID) throws SQLException {
        Statement stmt = db.createStatement();
        int userid = getUserid(nomPatient,prenomPatient);
        float reduction = 0;
        if(isEmployee(userid)){
            reduction = 50;
        }
        String sql1 = "select frais_totaux from frais where id_frais = "+rvID;
        int frais = Integer.parseInt(String.valueOf(stmt.execute(sql1)));
        float frais_totaux = frais - reduction/100*frais;
        String sql = "insert into facture ((select id_facture from frais where id_procedure = " +
                "(select id_procedure from procédure where)), DATE'" + dateRv + "', " + userid + ", " +
                frais_totaux + ", " + reduction + ")";
        stmt.execute(sql);
    }

    // afficher la liste des dentistes dans chaque succursale
    public static ResultSet getDentists(String ville) throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "select nom, prenom from utilisateur natural join employe where role = 'dentiste' " +
                "AND superviseur_id = (select directeur_id from succursale where ville = '" + ville + "');";
        return stmt.executeQuery(sql);
    }

    // vérifier les types de procédures disponibles
    public static ResultSet getProcedures() throws SQLException {
        Statement stmt = db.createStatement();
        String sql = "select type_de_procedure from procédure;";
        return stmt.executeQuery(sql);
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dentistry";
        String user = "root";
        String password = "MyPassword$";///// Change this
        try {
            db = DriverManager.getConnection(url, user, password);

            //test addPatient sans parent
            addPatient("nom","prenom","password","M",653589, "tel",
                    "2018-04-04", "adresse","AAA BBB", "province",
                    "ville","email", "numAssurance", "succursale");

            //test addPatient avec parent
            addPatient("nom2","prenom2","password2","M",653889, "tel",
                    "2018-04-04", "adresse","AAA BBB", "province",
                    "ville","prenomParent","nomParent","relation",
                    "email","numAssurance", "succursale");

            //test modPatient sans parent
            modPatient(getUserid("nom","prenom"),"nom3","prenom3","M",653589,
                    "tel", "2018-04-04", "adresse","AAA BBB", "province",
                    "ville","email", "numAssurance", "succursale");

            //test modPatient avec parent
            modPatient(getUserid("nom2","prenom2"),"nom4","prenom4","M",658589,
                    "tel", "2018-04-04", "adresse","AAA BBB", "province",
                    "ville","prenomParent","nomParent","relation", "email",
                    "numAssurance", "succursale");

            //test add appoinment
            addAppointment("Wakanda", "nom4", "prenom4", "Thanos",
                    "Purple", "Nick", "Fury", "2022-04-20",
                    "08:00","09:00", "operation","prevu",5,
                    1, 1);

//            GUI gc = new GUI();
//            gc.start();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
