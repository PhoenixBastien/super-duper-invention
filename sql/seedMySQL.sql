use Dentistry;

INSERT INTO utilisateur VALUES (DEFAULT,'AntMan','Man','Ant','M',11111,'111-111-1111',DATE'1973-11-22',DEFAULT,'2015 wasp','AAA MMM','California','San Francisco','','','');
INSERT INTO utilisateur VALUES (DEFAULT, 'Vision', 'Maximoff', 'Vision', 'M', 22222, '222-222-2222', DATE'2019-10-29',DEFAULT, '1800 Palos Verdes Drive', 'VVV MMM', 'California', 'Palos Verdes', 'Ultron', 'Stark', 'Createur');
INSERT INTO utilisateur VALUES (DEFAULT,'TeenageGroot', 'Groot', 'Teenage', 'M', 33333, '333-333-3333', DATE'2018-04-04',DEFAULT, '2014 iamgroot', 'TTT GGG', 'Branch World', 'Planet X', 'Rocket', 'The raccoon', 'Gardien');
INSERT INTO utilisateur VALUES (DEFAULT,'SpiderMan', 'Man', 'Spider', 'M', 44444, '444-444-4444', DATE'2008-09-27',DEFAULT, '2001 webshooter', 'SSS MMM', 'Queens', 'Forest Hills','May','Parker','Tante');
INSERT INTO utilisateur VALUES (DEFAULT, 'Gamora', 'Quill', 'Gamora', 'F', 55555, '555-555-5555', DATE'1992-01-10',DEFAULT, '23 daugther of Thanos', 'GGG QQQ', 'Zehoberei', 'Galaxy','','','');
INSERT INTO utilisateur VALUES (DEFAULT, 'Nebula', 'Robot', 'Nebula', 'F', 66666, '666-666-6666', DATE'1991-06-18',DEFAULT, '98 other daugther of Thanos', 'NNN RRR', 'The Lab', 'Dying Star','','','');
INSERT INTO utilisateur VALUES (DEFAULT,'Mantis', 'Drax', 'Mantis', 'F', 77777, '777-777-7777', DATE'1989-03-10',DEFAULT, '32 ego', 'MMM DDD', 'Celestial Realm', 'Egos Mind','','','');
INSERT INTO utilisateur VALUES (DEFAULT,'BlackWidow', 'Widow', 'Black', 'F', 88888, '888-888-8888', DATE'1984-11-22', DEFAULT,'123 Redhead street', 'BBB WWW', 'Stalingrad', 'Alianovna','','','');
INSERT INTO utilisateur VALUES (DEFAULT, 'NickFury', 'Fury', 'Nick', 'M', 99999, '999-999-9999', DATE'1951-05-30',DEFAULT, '4 shield', 'NNN FFF', 'Alabama', 'Huntsville','','','');
INSERT INTO utilisateur VALUES (DEFAULT,'WarMachine', 'Machine', 'War', 'M', 101010, '101-101-1010', DATE'1968-10-08',DEFAULT, '89 military base', 'WWW MMM', 'New York', 'Queens','','','');
INSERT INTO utilisateur VALUES (DEFAULT, 'Hulk', 'Green', 'Hulk', 'M', 111111, '111-011-1111', DATE'2011-12-18',DEFAULT, '33 the lab street', 'HHH GGG', 'Ohio', 'Dayton','Bruce','Banner','Alter ego');
INSERT INTO utilisateur VALUES (DEFAULT,'Drax', 'Bautitas', 'Drax', 'M', 121212, '121-121-1212', DATE'1970-08-25',DEFAULT, '84 The Destroyer', 'DDD BBB', 'California', 'Burbank','','','');
INSERT INTO utilisateur VALUES (DEFAULT,'IronMan', 'Man', 'Iron', 'M', 131313, '131-131-1313', DATE'1970-05-29',DEFAULT, '73 stark tower', 'III MMM', 'New York', 'Long Island','','','');
INSERT INTO utilisateur VALUES (DEFAULT,'Hawkeye', 'Barton', 'Hawkeye', 'M', 141414, '141-141-1414', DATE'1971-03-29',DEFAULT, '100 ranch', 'HHH BBB', 'Iowa', 'Waverly','','','');
INSERT INTO utilisateur VALUES (DEFAULT, 'BlackPanther', 'Panther', 'Black', 'M', 151515, '151-151-1515', DATE'1976-04-02',DEFAULT, '54 panthers tree', 'BBB PPP', 'Africa', 'Wakanda','','','');
INSERT INTO utilisateur VALUES (DEFAULT,'DoctorStrange', 'Strange', 'Doctor', 'M', 161616, '161-161-1616', DATE'1969-09-19',DEFAULT, '54 first street', 'DDD SSS', 'New Jersey', 'New York','','','');
INSERT INTO utilisateur VALUES (DEFAULT,'Thanos', 'Purple', 'Thanos', 'M', 171717, '171-171-1717', DATE'1982-01-01',DEFAULT, '100 the mad titan', 'TTT PPP', 'Planet Titan', 'Infinity Gauntlet','','','');
INSERT INTO utilisateur VALUES (DEFAULT, 'AncientOne', 'One', 'Ancient', 'F', 181818, '181-181-1818', DATE'2000-10-29',DEFAULT, '500 timestone', 'HHH KKK', 'Himalayas', 'Kamar-Taj','','','');
INSERT INTO utilisateur VALUES (DEFAULT,'Starlord', 'Lord', 'Star', 'M', 191919, '191-191-1919', DATE'1972-05-12',DEFAULT, '395 demigod', 'PPP QQQ', 'New Jersey', 'New York','','','');

INSERT INTO employe VALUES ((select user_id from utilisateur where prenom  = 'Nebula'), 'Temps plein', 1006000, 'directeur de succursale',null);
INSERT INTO employe VALUES ((select user_id from utilisateur where prenom  = 'Black'AND nom='Panther'), 'Temps plein', 1002000, 'directeur de succursale',null);
INSERT INTO employe VALUES ((select user_id from utilisateur where prenom  = 'Drax'), 'Temps partiel', 93000, 'receptionniste',1);
INSERT INTO employe VALUES ((select user_id from utilisateur where prenom  = 'Ancient'), 'Temps plein', 100000, 'receptionniste',1);
INSERT INTO employe VALUES ((select user_id from utilisateur where prenom  = 'Ant'), 'Temps plein', 50000, 'receptionniste',2);
INSERT INTO employe VALUES ((select user_id from utilisateur where prenom  = 'Thanos'), 'Temps plein', 1000000, 'dentiste', 1);
INSERT INTO employe VALUES ((select user_id from utilisateur where prenom  = 'Iron'), 'Temps partiel', 100000, 'dentiste',2);
INSERT INTO employe VALUES ((select user_id from utilisateur where prenom  = 'Gamora'), 'Temps plein', 100000, 'dentiste',2);
INSERT INTO employe VALUES ((select user_id from utilisateur where prenom  = 'Hawkeye'), 'Temps plein', 1000, 'dentiste', 1);
INSERT INTO employe VALUES ((select user_id from utilisateur where prenom  = 'War'),'Temps plein', 106000, 'hygieniste',2);
INSERT INTO employe VALUES ((select user_id from utilisateur where prenom  = 'Doctor'), 'Temps partiel', 200000, 'hygieniste',2);
INSERT INTO employe VALUES ((select user_id from utilisateur where prenom  = 'Nick'), 'Temps plein', 100000, 'hygieniste',1);
INSERT INTO employe VALUES ((select user_id from utilisateur where prenom  = 'Star'), 'Temps plein', 550000, 'hygieniste',1);

INSERT INTO succursale VALUES ('Wakanda', 2);
INSERT INTO succursale VALUES ('New York', 1);

INSERT INTO employe_succursale VALUES ('Wakanda', 2); #BlackPanther
INSERT INTO employe_succursale VALUES ('Wakanda', 5); #AntMan
INSERT INTO employe_succursale VALUES ('Wakanda', 7); #Gamora
INSERT INTO employe_succursale VALUES ('Wakanda', 8); #DoctorStrange
INSERT INTO employe_succursale VALUES ('Wakanda', 10); #IronMan
INSERT INTO employe_succursale VALUES ('Wakanda', 11); #WarMachine
INSERT INTO employe_succursale VALUES ('New York', 1); #Thanos
INSERT INTO employe_succursale VALUES ('New York', 3); #Drax
INSERT INTO employe_succursale VALUES ('New York', 4); #StarLord
INSERT INTO employe_succursale VALUES ('New York', 6); #Nebula
INSERT INTO employe_succursale VALUES ('New York', 9); #AncientOne
INSERT INTO employe_succursale VALUES ('New York', 12); #Hawkeye
INSERT INTO employe_succursale VALUES ('New York', 13); #NickFury

INSERT INTO patient VALUES ((select user_id from utilisateur where prenom  = 'Vision'), 'ultron@marvel.com', 'U1', 'Wakanda');
INSERT INTO patient VALUES ((select user_id from utilisateur where prenom  = 'Teenage'), 'rocket@marvel.com', 'TG2', 'Wakanda');
INSERT INTO patient VALUES ((select user_id from utilisateur where prenom  = 'Spider'), 'may@marvel.com', '', 'Wakanda'); #Pas dassurance
INSERT INTO patient VALUES ((select user_id from utilisateur where prenom  = 'Mantis'), 'mantis@marvel.com', 'M1', 'Wakanda');
INSERT INTO patient VALUES ((select user_id from utilisateur where prenom  = 'Black'AND nom='Widow'), 'blackwidow@marvel.com', 'B1', 'New York'); #Pas dassurance
INSERT INTO patient VALUES ((select user_id from utilisateur where prenom  = 'Hulk'), 'bruce@marvel.com', '', 'New York');
INSERT INTO patient VALUES ((select user_id from utilisateur where prenom  = 'Ancient'), 'ancientone@marvel.com', 'A5', 'New York');
INSERT INTO patient VALUES ((select user_id from utilisateur where prenom  = 'War'), 'warmachine@marvel.com', 'W5', 'Wakanda');
INSERT INTO patient VALUES ((select user_id from utilisateur where prenom  = 'Nick'), 'nick@marvel.com', 'N8', 'New York');
INSERT INTO patient VALUES ((select user_id from utilisateur where prenom  = 'Thanos'), 'purpletitan@marvel.com', 'T2', 'New York');
INSERT INTO patient VALUES ((select user_id from utilisateur where prenom  = 'Ant'), 'antman@marvel.com', 'A8', 'Wakanda');
INSERT INTO patient VALUES ((select user_id from utilisateur where prenom  = 'Drax'), 'drax@marvel.com', 'D9', 'New York');

INSERT INTO rendez_vous VALUES (DEFAULT, 'Wakanda', (select user_id from utilisateur where prenom  = 'Vision'), 6, 10, date'2022-04-20', time'08:00', time'09:00', 'nettoyage', 'termine', 1);
INSERT INTO rendez_vous VALUES (DEFAULT, 'Wakanda', (select user_id from utilisateur where prenom  = 'Teenage'), 6, 11, date'2022-04-20', time'09:00', time'10:00', 'nettoyage', 'prevu', 1);
INSERT INTO rendez_vous VALUES (DEFAULT, 'Wakanda', (select user_id from utilisateur where prenom  = 'Spider'), 9, 11, date'2022-04-20', time'08:00', time'09:00', 'nettoyage', 'termine', 2);
INSERT INTO rendez_vous VALUES (DEFAULT, 'Wakanda', (select user_id from utilisateur where prenom  = 'Mantis'), 9, 10, date'2022-04-20', time'09:00', time'11:00', 'operation', 'retard', 2);
INSERT INTO rendez_vous VALUES (DEFAULT, 'New York', (select user_id from utilisateur where prenom  = 'Black' and nom = 'Widow'), 8, 13, date'2022-04-20', time'08:00', time'09:00', 'nettoyage', 'prevu', 1);
INSERT INTO rendez_vous VALUES (DEFAULT, 'New York', (select user_id from utilisateur where prenom  = 'Hulk'), 7, 12, date'2022-04-20', time'08:00', time'09:00', 'nettoyage', 'prevu', 2);
INSERT INTO rendez_vous VALUES (DEFAULT, 'New York', (select user_id from utilisateur where prenom  = 'Ancient'), 7, 13, date'2022-04-20', time'09:00', time'09:30', 'consultation', 'prevu', 2);
INSERT INTO rendez_vous VALUES (DEFAULT, 'New York', (select user_id from utilisateur where prenom  = 'War'), 8, 12, date'2022-04-20', time'09:00', time'09:45', 'suivi', 'prevu', 1);
INSERT INTO rendez_vous VALUES (DEFAULT, 'New York', (select user_id from utilisateur where prenom  = 'Nick'), 8, 13, date'2022-04-20', time'10:00', time'11:00', 'nettoyage', 'prevu', 1);
INSERT INTO rendez_vous VALUES (DEFAULT, 'Wakanda', (select user_id from utilisateur where prenom  = 'Thanos'), 6, 10, date'2022-04-20', time'13:00', time'13:30', 'consultation', 'prevu', 1);
INSERT INTO rendez_vous VALUES (DEFAULT, 'Wakanda', (select user_id from utilisateur where prenom  = 'Ant'), 9, 11, date'2022-04-20', time'13:00', time'14:00', 'nettoyage', 'prevu', 2);
INSERT INTO rendez_vous VALUES (DEFAULT, 'New York', (select user_id from utilisateur where prenom  = 'Drax'), 8, 12, date'2022-04-20', time'11:00', time'12:00', 'nettoyage', 'prevu', 1);

INSERT INTO procédure VALUES (DEFAULT, 'reparation carie', 'reparer une carie', 'molaire droite', 300);
INSERT INTO procédure VALUES (DEFAULT, 'detartage', 'nettoyer les dents', 'toutes', 200);
INSERT INTO procédure VALUES (DEFAULT, 'traitement de canal', 'retirer la pulpe infectee', 'dent de sagesse', 500);
INSERT INTO procédure VALUES (DEFAULT, 'implants dentaires', 'ajout dune racine artificielle', 'canine', 600);
INSERT INTO procédure VALUES (DEFAULT, 'blanchiment des dents', 'blanchir les dents', 'bouche', 500);
INSERT INTO procédure VALUES (DEFAULT, 'suivi', 'sassurer que tout va bien', '', 50);
INSERT INTO procédure VALUES (DEFAULT, 'consultation', 'presenter un traitement', '', 50);

INSERT INTO traitement VALUES (DEFAULT, 'soulager la douleur', 'operation', 'acetaminophene', 'douleur et fievre', 'molaires', 'a prendre 4 fois par jour', 30, 1);
INSERT INTO traitement VALUES (DEFAULT, 'calmant', 'operation', 'ibuprophene', 'sensibilite', 'canines', 'ne pas croquer', 20, 3);
INSERT INTO traitement VALUES (DEFAULT, 'nettoyer les dents', 'operation', 'rince-bouche', '', 'bouche', 'gargariser 5 minutes', 50, 4);
INSERT INTO traitement VALUES (DEFAULT, 'creme analgesique', 'operation', 'creme', 'douleur accrue', 'gencive', 'appliquer au besoin', 72, 1);
INSERT INTO traitement VALUES (DEFAULT, 'produit blanchissant', 'suivi', 'nouvelle coquille', '', 'dents', 'ne pas enlever', 100, 5);

INSERT INTO procedure_rv VALUES (1, 2);
INSERT INTO procedure_rv VALUES (2, 2);
INSERT INTO procedure_rv VALUES (3, 2);
INSERT INTO procedure_rv VALUES (4, 1);
INSERT INTO procedure_rv VALUES (4, 3);
INSERT INTO procedure_rv VALUES (5, 2);
INSERT INTO procedure_rv VALUES (6, 2);
INSERT INTO procedure_rv VALUES (7, 5);
INSERT INTO procedure_rv VALUES (8, 6);
INSERT INTO procedure_rv VALUES (9, 2);
INSERT INTO procedure_rv VALUES (10, 7);
INSERT INTO procedure_rv VALUES (11, 2);
INSERT INTO procedure_rv VALUES (12, 2);

INSERT INTO frais VALUES (1, 2, NULL, 'nettoyage', 200, 0,0,default);
INSERT INTO frais VALUES (2, 2, NULL, 'nettoyage', 200, 0, 0,default);
INSERT INTO frais VALUES (3, 2, NULL, 'nettoyage', 200, 0, 0,default);
INSERT INTO frais VALUES (4, 1, 1, 'operation et acetaminophene', 300, 30, 14,default);
INSERT INTO frais VALUES (4, 3, 2, 'traitement de canal et calmant', 500, 20, 14,default);
INSERT INTO frais VALUES (5, 2, NULL, 'nettoyage', 200, 0, 0,default);
INSERT INTO frais VALUES (6, 2, NULL, 'nettoyage', 200, 0, 0,default);
INSERT INTO frais VALUES (7, 5, 5, 'blanchiment des dents et produit blanchisseur', 500, 100, 0,default);
INSERT INTO frais VALUES (8, 6, NULL, 'suivi', 50, 0, 0,default);
INSERT INTO frais VALUES (9, 2, NULL, 'nettoyage', 200, 0, 0,default);
INSERT INTO frais VALUES (10, 7, NULL, 'consultation', 50, 0, 0,default);
INSERT INTO frais VALUES (11, 2, NULL, 'nettoyage', 200, 0, 0,default);
INSERT INTO frais VALUES (12, 2, NULL, 'nettoyage', 200, 0, 0,default);

INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', (select user_id from utilisateur where prenom  = 'Vision'), 180, 10, 'yes');#Rabais enfant, le prix est 200$-10% = 270$
INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', (select user_id from utilisateur where prenom  = 'Teenage'), 180, 10, 'yes');#Rabais enfant
INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', (select user_id from utilisateur where prenom  = 'Spider'), 180, 10, 'no');#Rabais enfant
INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', (select user_id from utilisateur where prenom  = 'Mantis'), 878, 0, 'yes');
INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', (select user_id from utilisateur where prenom  = 'Black' and nom = 'Widow'), 200, 0, 'yes');
INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', (select user_id from utilisateur where prenom  = 'Hulk'), 200, 0, 'no');
INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', (select user_id from utilisateur where prenom  = 'Ancient'), 300, 50, 'yes');#Reduction de 50% car rabais employé
INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', (select user_id from utilisateur where prenom  = 'War'), 25, 50, 'yes');#Rabais employé
INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', (select user_id from utilisateur where prenom  = 'Nick'), 100, 50, 'yes');#Rabais employé
INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', (select user_id from utilisateur where prenom  = 'Thanos'), 25, 50, 'yes');#Rabais employé
INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', (select user_id from utilisateur where prenom  = 'Ant'), 100, 50, 'yes');#Rabais employé
INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', (select user_id from utilisateur where prenom  = 'Drax'), 100, 50, 'yes');#Rabais employé

INSERT INTO facture_rv VALUES (1, 1);
INSERT INTO facture_rv VALUES (2, 2);
INSERT INTO facture_rv VALUES (3, 3);
INSERT INTO facture_rv VALUES (4, 4);
INSERT INTO facture_rv VALUES (5, 5);
INSERT INTO facture_rv VALUES (6, 6);
INSERT INTO facture_rv VALUES (7, 7);
INSERT INTO facture_rv VALUES (8, 8);
INSERT INTO facture_rv VALUES (9, 9);
INSERT INTO facture_rv VALUES (10, 10);
INSERT INTO facture_rv VALUES (11, 11);
INSERT INTO facture_rv VALUES (12, 12);

INSERT INTO avis VALUES (DEFAULT, (select user_id from utilisateur where prenom  = 'Vision'), 6, 1, 'tres gentil', 10, 4, 10);
INSERT INTO avis VALUES (DEFAULT, (select user_id from utilisateur where prenom  = 'Teenage'), 11, 2, 'super service', 9, 10, 6);
INSERT INTO avis VALUES (DEFAULT, (select user_id from utilisateur where prenom  = 'Spider'), 9, 3, 'belle ambiance', 8, 9, 7);
INSERT INTO avis VALUES (DEFAULT, (select user_id from utilisateur where prenom  = 'Mantis'), 10, 4, 'wow', 10, 8, 8);
INSERT INTO avis VALUES (DEFAULT, (select user_id from utilisateur where prenom  = 'Black' and nom = 'Widow'), 13, 5, 'tres professionnel', 7, 9, 7);
INSERT INTO avis VALUES (DEFAULT, (select user_id from utilisateur where prenom  = 'Hulk'), 12, 6, 'un peu de retard', 9, 8, 9);
INSERT INTO avis VALUES (DEFAULT, (select user_id from utilisateur where prenom  = 'Ancient'), 7, 7, 'excellent', 10, 7, 5);
INSERT INTO avis VALUES (DEFAULT, (select user_id from utilisateur where prenom  = 'War'), 8, 8, 'tres dynamique', 7, 10, 8);
INSERT INTO avis VALUES (DEFAULT, (select user_id from utilisateur where prenom  = 'Nick'), 8, 9, 'merci', 9, 8, 10);
INSERT INTO avis VALUES (DEFAULT, (select user_id from utilisateur where prenom  = 'Thanos'), 6, 10, 'belle experience', 6, 9, 9);
INSERT INTO avis VALUES (DEFAULT, (select user_id from utilisateur where prenom  = 'Ant'), 9, 11, 'je recommande', 10, 10, 8);
INSERT INTO avis VALUES (DEFAULT, (select user_id from utilisateur where prenom  = 'Drax'), 12, 12, 'bon service', 9, 7, 9);

INSERT INTO paiement VALUES (DEFAULT, 1, DATE'2022-04-20', 'mastercard');
INSERT INTO paiement VALUES (DEFAULT, 2, DATE'2022-04-20', 'visa');
INSERT INTO paiement VALUES (DEFAULT, 3, DATE'2022-04-20', 'visa');
INSERT INTO paiement VALUES (DEFAULT, 4, DATE'2022-04-20', 'mastercard');
INSERT INTO paiement VALUES (DEFAULT, 5, DATE'2022-04-20', 'especes');
INSERT INTO paiement VALUES (DEFAULT, 6, DATE'2022-04-20', 'mastercard');
INSERT INTO paiement VALUES (DEFAULT, 7, DATE'2022-04-20', 'visa');
INSERT INTO paiement VALUES (DEFAULT, 8, DATE'2022-04-20', 'mastercard');
INSERT INTO paiement VALUES (DEFAULT, 9, DATE'2022-04-20', 'especes');
INSERT INTO paiement VALUES (DEFAULT, 10, DATE'2022-04-20', 'visa');
INSERT INTO paiement VALUES (DEFAULT, 11, DATE'2022-04-20', 'mastercard');
INSERT INTO paiement VALUES (DEFAULT, 12, DATE'2022-04-20', 'mastercard');

INSERT INTO reclamation VALUES (DEFAULT, 1, 60, DATE'2022-04-20');
INSERT INTO reclamation VALUES (DEFAULT, 2, 60, DATE'2022-04-20');
INSERT INTO reclamation VALUES (DEFAULT, 4, 70, DATE'2022-04-20');
INSERT INTO reclamation VALUES (DEFAULT, 5, 50, DATE'2022-04-20');
INSERT INTO reclamation VALUES (DEFAULT, 7, 30, DATE'2022-04-20');
INSERT INTO reclamation VALUES (DEFAULT, 8, 30, DATE'2022-04-20');
INSERT INTO reclamation VALUES (DEFAULT, 9, 45, DATE'2022-04-20');
INSERT INTO reclamation VALUES (DEFAULT, 10, 80, DATE'2022-04-20');
INSERT INTO reclamation VALUES (DEFAULT, 11, 68, DATE'2022-04-20');
INSERT INTO reclamation VALUES (DEFAULT, 12, 55, DATE'2022-04-20');

INSERT INTO dossier VALUES ((select user_id from utilisateur where prenom  = 'Vision'), 6);
INSERT INTO dossier VALUES ((select user_id from utilisateur where prenom  = 'Teenage'), 11);
INSERT INTO dossier VALUES ((select user_id from utilisateur where prenom  = 'Spider'), 9);
INSERT INTO dossier VALUES ((select user_id from utilisateur where prenom  = 'Mantis'), 10);
INSERT INTO dossier VALUES ((select user_id from utilisateur where prenom  = 'Black' and nom = 'Widow'), 13);
INSERT INTO dossier VALUES ((select user_id from utilisateur where prenom  = 'Hulk'), 12);
INSERT INTO dossier VALUES ((select user_id from utilisateur where prenom  = 'Ancient'), 7);
INSERT INTO dossier VALUES ((select user_id from utilisateur where prenom  = 'War'), 8);
INSERT INTO dossier VALUES ((select user_id from utilisateur where prenom  = 'Nick'), 6);
INSERT INTO dossier VALUES ((select user_id from utilisateur where prenom  = 'Thanos'), 9);
INSERT INTO dossier VALUES ((select user_id from utilisateur where prenom  = 'Ant'), 12);
INSERT INTO dossier VALUES ((select user_id from utilisateur where prenom  = 'Drax'), 12);

INSERT INTO inscrit_dans VALUES (2, NULL, (select user_id from utilisateur where prenom  = 'Vision'));
INSERT INTO inscrit_dans VALUES (2, NULL, (select user_id from utilisateur where prenom  = 'Teenage'));
INSERT INTO inscrit_dans VALUES (2, NULL, (select user_id from utilisateur where prenom  = 'Spider'));
INSERT INTO inscrit_dans VALUES (1, 1, (select user_id from utilisateur where prenom  = 'Mantis'));
INSERT INTO inscrit_dans VALUES (3, 2, (select user_id from utilisateur where prenom  = 'Mantis'));
INSERT INTO inscrit_dans VALUES (2, NULL, (select user_id from utilisateur where prenom  = 'Black' and nom = 'Widow'));
INSERT INTO inscrit_dans VALUES (2, NULL, (select user_id from utilisateur where prenom  = 'Hulk'));
INSERT INTO inscrit_dans VALUES (5, 5, (select user_id from utilisateur where prenom  = 'Ancient'));
INSERT INTO inscrit_dans VALUES (6, NULL, (select user_id from utilisateur where prenom  = 'War'));
INSERT INTO inscrit_dans VALUES (2, NULL, (select user_id from utilisateur where prenom  = 'Nick'));
INSERT INTO inscrit_dans VALUES (7, NULL, (select user_id from utilisateur where prenom  = 'Thanos'));
INSERT INTO inscrit_dans VALUES (2, NULL, (select user_id from utilisateur where prenom  = 'Ant'));
INSERT INTO inscrit_dans VALUES (2, NULL, (select user_id from utilisateur where prenom  = 'Drax'));
