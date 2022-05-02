package com.clinique.src;

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
                                "' AND prenom = '" + prenom + "'), '" + email + "', '" + numAssurance + "', '"
                                + succursale + "')";
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
                                "', ssn = " + ssn + ", tel = '" + tel + "', date_de_naissance = DATE'" + dateDeNaissance
                                +
                                "', age = DEFAULT, adresse = '" + adresse + "', code_postal = '" + codePostal +
                                "', province = '" + province + "', ville = '" + ville + "', prenom_parent = '"
                                + prenomParent +
                                "', nom_parent = '" + nomParent + "', relation_avec_enfant = '" + relation +
                                "' WHERE user_id = " + userid;
                sql2 = "UPDATE patient SET email = '" + email + "', num_assurance = '" + num_assurance +
                                "', succursale = '" + succursale + "' WHERE user_id = " + userid;
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
                sql1 = "INSERT INTO utilisateur VALUES (DEFAULT, '" + password + "', '" + nom + "', '" + prenom + "', '"
                                +
                                sexe + "', " + ssn + ", '" + tel + "', DATE'" + dateDeNaissance + "', DEFAULT, '"
                                + adresse + "', '" +
                                codePostal + "', '" + province + "', '" + ville + "', '', '', '')";
                sql2 = "INSERT INTO patient VALUES ((SELECT user_id FROM utilisateur WHERE nom  = '" + nom +
                                "' AND prenom = '" + prenom + "'), '" + email + "', '" + numAssurance + "', '"
                                + succursale + "')";
                stmt.execute(sql1);
                stmt.execute(sql2);
        }

        public static void modPatient(int userid, String nom, String prenom, String sexe,
                        int ssn, String tel, String dateDeNaissance, String adresse,
                        String codePostal, String province, String ville, String email,
                        String numAssurance, String succursale) throws SQLException {

                Statement stmt = db.createStatement();
                String sql1, sql2;
                System.out.println("aaaaaaaaa");
                sql1 = "UPDATE utilisateur SET nom = '" + nom + "', prenom = '" + prenom + "', sexe = '" + sexe +
                                "', ssn = " + ssn + ", tel = '" + tel + "', date_de_naissance = DATE'" + dateDeNaissance
                                +
                                "', age = DEFAULT, adresse = '" + adresse + "', code_postal = '" + codePostal +
                                "', province = '" + province + "', ville = '" + ville + "' WHERE user_id = " + userid;
                sql2 = "UPDATE patient SET email = '" + email + "', num_assurance = '" + numAssurance +
                                "', succursale = '" + succursale + "' WHERE user_id = " + userid;
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
                                heureDebut + "', TIME'" + heureFin + "', '" + typeRv + "', '" + statut + "', " + chambre
                                + ")";
                stmt.execute(sql);
                int rv_id = getRVid(nomPatient, prenomPatient);
                int penalite = 0;
                String sql0 = "select statut from rendez_vous where id_appointment = " + rv_id;
                String statutRV = String.valueOf(stmt.execute(sql0));
                if (statutRV.equals("retard")) {
                        penalite += 14;
                }

                String sql1 = "insert into procedure_rv values (" + rv_id + ", " + procedure + ");";
                String sql2 = "insert into frais values (" + rv_id + ", " + procedure + ", " + traitement + ", '" +
                                typeRv + "', (select frais from procédure where id_procedure = " + procedure +
                                "), (select frais from traitement where id_traitement = " + traitement + "), " +
                                penalite + ", default);";
                stmt.execute(sql1);
                stmt.execute(sql2);
                addFacture(dateRv, nomPatient, prenomPatient, rv_id);
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
                                "(SELECT id_dossier FROM dossier WHERE id_dossier = " + getUserid(nom, prenom) + ")";
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

        public static ResultSet getFacture(String nom, String prenom) throws SQLException {
                Statement stmt = db.createStatement();
                String sql = "SELECT * FROM facture WHERE id_patient = " + getUserid(nom, prenom);

                return stmt.executeQuery(sql);
        }

        public static void addFacture(String dateRv, String nomPatient,
                        String prenomPatient, int rvID) throws SQLException {
                Statement stmt = db.createStatement();
                int userid = getUserid(nomPatient, prenomPatient);
                float reduction = 0;
                if (isEmployee(userid)) {
                        reduction = 50;
                }
                String sql1 = "select frais_totaux from frais where id_frais = " + rvID;
                ResultSet rs1 = stmt.executeQuery(sql1);
                rs1.next();
                int frais = Integer.parseInt(rs1.getString(1));
                float frais_totaux = frais - reduction / 100 * frais;
                String sql = "insert into facture values (default, DATE'" + dateRv + "', " + userid + ", " +
                                (int) frais_totaux + ", " + (int) reduction + ", 'yes');";
                stmt.execute(sql);
                String sql2 = "select id_facture from facture where id_patient = " + userid + ";";
                ResultSet rs2 = stmt.executeQuery(sql2);
                rs2.next();
                int facture = Integer.parseInt(rs2.getString(1));
                makePaiement(facture, dateRv);
        }

        // afficher la liste des dentistes dans chaque succursale
        public static ResultSet getDentists(String ville) throws SQLException {
                Statement stmt = db.createStatement();
                String sql = "select nom, prenom from utilisateur natural join employe where role = 'dentiste' " +
                                "AND superviseur_id = (select directeur_id from succursale where ville = '" + ville
                                + "');";
                return stmt.executeQuery(sql);
        }

        // vérifier les types de procédures disponibles
        public static ResultSet getProcedures() throws SQLException {
                Statement stmt = db.createStatement();
                String sql = "select type_de_procedure from procédure;";
                return stmt.executeQuery(sql);
        }

        // contrainte role : dentiste, receptionniste, hygieniste, directeur de
        // succursale
        public static void addayee(String nom, String prenom, String password, String sexe,
                        int ssn, String tel, String dateDeNaissance, String adresse,
                        String codePostal, String province, String ville, String type, int salaire,
                        String role, String nomSupervisor, String prenomSupervisor) throws SQLException {
                Statement stmt = db.createStatement();
                String sql1, sql2;
                sql1 = "INSERT INTO utilisateur " +
                                "VALUES (DEFAULT, '" + password + "', '" + nom + "', '" + prenom + "', '" + sexe +
                                "', " + ssn + ", '" + tel + "', '" + dateDeNaissance + "', DEFAULT, '" + adresse +
                                "', '" + codePostal + "', '" + province + "', '" + ville + "', '', '', '')";

                if (role.equals("directeur")) {
                        sql2 = "INSERT INTO employe VALUES ((SELECT user_id FROM utilisateur WHERE nom = '" + nom +
                                        "' AND prenom = '" + prenom + "'), '" + type + "', " + salaire + ", '" + role
                                        + "',null)";

                } else {
                        sql2 = "INSERT INTO employe VALUES ((SELECT user_id FROM utilisateur WHERE nom = '" + nom +
                                        "' AND prenom = '" + prenom + "'), '" + type + "', " + salaire + ", '" + role
                                        + "'," +
                                        getUserid(nomSupervisor, prenomSupervisor) + ")";
                }

                stmt.execute(sql1);
                stmt.execute(sql2);
        }

        public static void makePaiement(int id_facture, String dateRv) throws SQLException {
                Statement stmt = db.createStatement();
                String sql = "insert into paiement values (default, " + id_facture + ", date'" + dateRv
                                + "', 'mastercard');";
                stmt.execute(sql);
                String sql2 = "select id_paiement from paiement where id_facture = " + id_facture + ";";
                ResultSet resultSet = stmt.executeQuery(sql2);
                resultSet.next();
                int paiement = Integer.parseInt(resultSet.getString(1));
                makeReclamation(paiement, 65, dateRv);
        }

        public static void makeReclamation(int id_paiement, int reclamation, String dateRv) throws SQLException {
                Statement stmt = db.createStatement();
                String sql = "insert into reclamation values (default, " + id_paiement + ", " + reclamation + ", date'"
                                + dateRv + "');";
                stmt.execute(sql);
        }

        public static void makeAvis(int id_patient, int id_employe, int id_appointment, String commentaire,
                        int communication, int proprete, int valeur) throws SQLException {
                Statement stmt = db.createStatement();
                String sql = "insert into avis values (default, " + id_patient + ", " + id_employe + ", "
                                + id_appointment +
                                ", '" + commentaire + "', " + communication + ", " + proprete + ", " + valeur + ");";
                stmt.execute(sql);
        }

        public static void main(String[] args) {
                String url = "jdbc:mysql://localhost:3306/dentistry";
                String user = "root";
                String password = "password";///// Change this
                try {
                        db = DriverManager.getConnection(url, user, password);

                        GUI gc = new GUI();
                        gc.start();

                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
}
