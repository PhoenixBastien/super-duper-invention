DROP SCHEMA IF EXISTS Dentistry;
CREATE SCHEMA Dentistry;

Use Dentistry;

CREATE TABLE utilisateur (
  user_id SERIAL,
  user_password VARCHAR(255) NOT NULL,
  nom VARCHAR(255) NOT NULL,
  prenom VARCHAR(255) NOT NULL,
  sexe CHAR(1) NOT NULL, #Choix: 'M' ou 'F'
  CONSTRAINT checkSexe CHECK (sexe = 'M' OR sexe = 'F'),
  ssn integer UNIQUE NOT NULL,
  tel VARCHAR(255) NOT NULL,
  date_de_naissance DATE NOT NULL,
  age INTEGER GENERATED ALWAYS AS (2022 - (YEAR(date_de_naissance))) STORED,
  adresse VARCHAR(255) NOT NULL,
  code_postal VARCHAR(7) NOT NULL, #Format: 'AAA BBB' donc 7 characters
  province VARCHAR(255) NOT NULL,
  ville VARCHAR(255),
  # SI CEST UN ENFANT (15 ans et moins): AJOUTER LA CONDITION DANS JAVA POUR DEMANDER LE NOM DU PARENT SI REQUIS
  prenom_parent VARCHAR(255),
  nom_parent VARCHAR(255),
  relation_avec_enfant VARCHAR(255)
  # FIN ENFANT
);

CREATE TABLE employe (
  user_id int REFERENCES utilisateur(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
  type VARCHAR(255) NOT NULL,
  salaire integer,
  CONSTRAINT checkSalary CHECK (salaire >= 0),
  role VARCHAR(255) NOT NULL, # Choix: dentiste, receptionniste, hygieniste, directeur de succursale
  CONSTRAINT checkRole check (role = 'dentiste' OR role = 'receptionniste' OR role = 'directeur de succursale' OR role = 'hygieniste'),
  superviseur_id INTEGER REFERENCES employe(id_employe) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE succursale (
  ville VARCHAR(255),
  directeur_id INTEGER REFERENCES employe(id_employe) ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY (ville)
);

CREATE TABLE employe_succursale (
  succursale varchar(255) REFERENCES succursale(ville) ON DELETE CASCADE ON UPDATE CASCADE,
  employe integer REFERENCES employe(id_employe) ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY key (succursale, employe)
);

CREATE TABLE patient (
  user_id int REFERENCES utilisateur(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
  email VARCHAR(255) NOT NULL,
  num_assurance VARCHAR(255), #PRECISER QUE CEST UN STRING (et non int)
  succursale varchar(255) REFERENCES succursale(ville) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE facture (
  id_facture SERIAL PRIMARY KEY,
  date_demission DATE NOT NULL,
  id_patient INTEGER REFERENCES patient(id_patient) ON DELETE CASCADE ON UPDATE CASCADE,
  frais_charge_totaux INTEGER NOT NULL, # Ici on va faire un SELECT de tous les rendez_vous dune personne qui vont aller dans la  meme facture
  #a partir de la table facture_rv. Ensuite on va additionner frais_totaux de la table frais de chacun des rendez_vous associes a ce patient
  reduction INTEGER, # % entre 0 et 100 / les employes ont 50% off et les enfants ont 10% off
  CONSTRAINT checkReduction check (reduction >= 0 AND reduction <= 100),
  assurance VARCHAR(3) NOT NULL, # yes or no: To be reclaimed after payment
  CONSTRAINT checkAssurance CHECK (assurance = 'yes' OR assurance = 'no')
);

CREATE TABLE rendez_vous (
  id_appointment SERIAL PRIMARY KEY,
  succ varchar(255) REFERENCES succursale(ville) ON DELETE CASCADE ON UPDATE CASCADE,
  id_patient INTEGER REFERENCES utilisateur(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
  id_dentiste INTEGER REFERENCES utilisateur(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
  id_hygieniste INTEGER REFERENCES utilisateur(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
  date_rv DATE NOT NULL, # date'YYYY-MM-DD'
  heure_debut TIME NOT NULL, #hh:mm:ss
  heure_fin TIME, #hh:mm:ss
  type_rv VARCHAR(255) NOT NULL, #Choix: nettoyage, operation, consultation, suivi
  CONSTRAINT checkType CHECK (type_rv = 'nettoyage' OR type_rv = 'operation' OR type_rv = 'consultation' OR type_rv = 'suivi'),
  # nettoyage = 1h, operation = 2h, consultation = 30m, suivi = 45 min
  statut VARCHAR(255) NOT NULL, #Choix: prevu, termine, retard, annule
  CONSTRAINT checkStatut CHECK (statut = 'prevu' OR statut = 'termine' OR statut = 'retard' OR statut = 'annule'),
  chambre INTEGER NOT NULL, #Choix: 1 a 5
  CONSTRAINT checkChambre CHECK (chambre >= 1 AND chambre <= 5)
  # nombre de procedure??
);

CREATE TABLE avis (
  id_avis SERIAL,
  id_patient INTEGER REFERENCES patient(id_patient) ON DELETE CASCADE ON UPDATE CASCADE,
  id_employe INTEGER REFERENCES employe(id_employe) ON DELETE CASCADE ON UPDATE CASCADE,
  id_appointment INTEGER REFERENCES rendez_vous(id_appointment) ON DELETE CASCADE ON UPDATE CASCADE,
  commentaires VARCHAR(255) NOT NULL,
  communication INTEGER NOT NULL, #note sur 10
  CONSTRAINT checkCommunication CHECK (communication >= 0 AND communication <= 10),
  proprete INTEGER NOT NULL, # note SUR 10
  CONSTRAINT checkProprete CHECK (proprete >= 0 AND proprete <= 10),
  valeur INTEGER NOT NULL, # note sur 10
  CONSTRAINT checkValeur CHECK (valeur >= 0 AND valeur <= 10),
  PRIMARY KEY (id_avis, id_patient, id_employe, id_appointment)
);

CREATE TABLE facture_rv ( #permet de lister tous les rendez_vous inclues dans chaque facture
  id_appointment INTEGER REFERENCES rendez_vous(id_appointment) ON DELETE CASCADE ON UPDATE CASCADE,
  id_facture INTEGER REFERENCES facture(id_facture) ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY (id_facture, id_appointment)
);

CREATE TABLE procédure (
  id_procedure SERIAL PRIMARY KEY,
  type_de_procedure VARCHAR(255) NOT NULL,
  description VARCHAR(255),
  dent_implique VARCHAR(255),
  frais INTEGER NOT NULL
);

CREATE TABLE procedure_rv ( #permet de lister toutes les procédures effectuées dans chaque rendez_vous
  id_appointment INTEGER REFERENCES rendez_vous(id_appointment) ON DELETE CASCADE ON UPDATE CASCADE,
  id_procedure INTEGER REFERENCES procédure(id_procedure) ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY (id_appointment,id_procedure)
);

CREATE TABLE paiement (
  id_paiement SERIAL UNIQUE,
  id_facture INTEGER REFERENCES facture(id_facture) ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY (id_paiement, id_facture),
  date_paiement DATE NOT NULL, #date'2022-04-20'
  type_de_paiement VARCHAR(255) NOT NULL, # Choix: mastercard, visa, especes
  CONSTRAINT checkPaiement CHECK (type_de_paiement = 'mastercard' OR type_de_paiement = 'visa' OR  type_de_paiement = 'especes')
);

CREATE TABLE reclamation (
  id_reclamation SERIAL,
  id_paiement INTEGER REFERENCES paiement(id_paiement) ON DELETE CASCADE ON UPDATE CASCADE,
  pourcentage_reclame INTEGER,
  CONSTRAINT checkPourcentage CHECK (pourcentage_reclame >= 0 AND pourcentage_reclame <= 100),
  date_reclamation DATE NOT NULL,
  PRIMARY KEY (id_reclamation, id_paiement)
);

CREATE TABLE traitement (
  id_traitement SERIAL PRIMARY KEY,
  type_traitement VARCHAR(255) NOT NULL,
  type_rv VARCHAR(255),
  medicaments VARCHAR(255),
  symptomes VARCHAR(255),
  dents VARCHAR(255),
  commentaires VARCHAR(255),
  frais INTEGER NOT NULL,
  id_procedure INTEGER REFERENCES procédure(id_procedure) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE frais (
  id_frais INTEGER,
  id_procedure INTEGER REFERENCES procédure(id_procedure) ON DELETE CASCADE ON UPDATE CASCADE,
  id_traitement INTEGER REFERENCES traitement(id_traitement) ON DELETE CASCADE ON UPDATE CASCADE,
  code_frais VARCHAR(255),
  frais_procedure INTEGER NOT NULL,#ecrire 0 sil ny en a pas
  frais_traitement INTEGER NOT NULL, #ecrire 0 sil ny en a pas
  frais_penalite INTEGER NOT NULL,#ecrire 0 sil ny en a pas
  frais_totaux INTEGER GENERATED ALWAYS AS (frais_penalite+frais_procedure+frais_traitement) STORED,
  PRIMARY KEY (id_frais, id_procedure)
);

CREATE TABLE dossier (
  id_dossier INTEGER REFERENCES patient(id_patient) ON DELETE CASCADE ON UPDATE CASCADE,
  id_employe INTEGER REFERENCES employe(id_employe) ON DELETE CASCADE ON UPDATE CASCADE,
  PRIMARY KEY (id_dossier)
);

CREATE TABLE inscrit_dans (
  id_procedure INTEGER REFERENCES procédure(id_procedure) ON DELETE CASCADE ON UPDATE CASCADE,
  id_traitement INTEGER REFERENCES traitement(id_traitement) ON DELETE CASCADE ON UPDATE CASCADE,
  id_dossier INTEGER REFERENCES dossier(id_dossier) ON DELETE CASCADE ON UPDATE CASCADE
);

#CREATE TABLE note_dossier (
 # id_dossier INTEGER REFERENCES dossier(id_dossier) ON DELETE CASCADE ON UPDATE CASCADE,
  #id_employe INTEGER REFERENCES employe(id_employe) ON DELETE CASCADE ON UPDATE CASCADE,
  #PRIMARY KEY (id_dossier, id_employe)
#);