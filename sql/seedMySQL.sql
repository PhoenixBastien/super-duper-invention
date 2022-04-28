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

INSERT INTO employe VALUES ((select user_id from utilisateur where nom  = 'Nebula'), 'Temps plein', 1006000, 'directeur de succursale',null);
INSERT INTO employe VALUES ((select user_id from utilisateur where nom  = 'Black'AND prenom='Panther'), 'Temps plein', 1002000, 'directeur de succursale',null);
INSERT INTO employe VALUES ((select user_id from utilisateur where nom  = 'Drax'), 'Temps partiel', 93000, 'receptionniste',1);
INSERT INTO employe VALUES ((select user_id from utilisateur where nom  = 'Ancient'), 'Temps plein', 100000, 'receptionniste',1);
INSERT INTO employe VALUES ((select user_id from utilisateur where nom  = 'Ant'), 'Temps plein', 50000, 'receptionniste',2);
INSERT INTO employe VALUES ((select user_id from utilisateur where nom  = 'Thanos'), 'Temps plein', 1000000, 'dentiste', 1);
INSERT INTO employe VALUES ((select user_id from utilisateur where nom  = 'Iron'), 'Temps partiel', 100000, 'dentiste',2);
INSERT INTO employe VALUES ((select user_id from utilisateur where nom  = 'Gamora'), 'Temps plein', 100000, 'dentiste',2);
INSERT INTO employe VALUES ((select user_id from utilisateur where nom  = 'Hawkeye'), 'Temps plein', 1000, 'dentiste', 1);
INSERT INTO employe VALUES ((select user_id from utilisateur where nom  = 'War'),'Temps plein', 106000, 'hygieniste',2);
INSERT INTO employe VALUES ((select user_id from utilisateur where nom  = 'Doctor'), 'Temps partiel', 200000, 'hygieniste',2);
INSERT INTO employe VALUES ((select user_id from utilisateur where nom  = 'Nick'), 'Temps plein', 100000, 'hygieniste',1);
INSERT INTO employe VALUES ((select user_id from utilisateur where nom  = 'Star'), 'Temps plein', 550000, 'hygieniste',1);

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

INSERT INTO patient VALUES ((select user_id from utilisateur where nom  = 'Vision'), 'ultron@marvel.com', 'U1', 'Wakanda');
INSERT INTO patient VALUES ((select user_id from utilisateur where nom  = 'Teenage'), 'rocket@marvel.com', 'TG2', 'Wakanda');
INSERT INTO patient VALUES ((select user_id from utilisateur where nom  = 'Spider'), 'may@marvel.com', '', 'Wakanda'); #Pas dassurance
INSERT INTO patient VALUES ((select user_id from utilisateur where nom  = 'Mantis'), 'mantis@marvel.com', 'M1', 'Wakanda');
INSERT INTO patient VALUES ((select user_id from utilisateur where nom  = 'Black'AND prenom='Widow'), 'blackwidow@marvel.com', 'B1', 'New York'); #Pas dassurance
INSERT INTO patient VALUES ((select user_id from utilisateur where nom  = 'Hulk'), 'bruce@marvel.com', '', 'New York');
INSERT INTO patient VALUES ((select user_id from utilisateur where nom  = 'Ancient'), 'ancientone@marvel.com', 'A5', 'New York');
INSERT INTO patient VALUES ((select user_id from utilisateur where nom  = 'War'), 'warmachine@marvel.com', 'W5', 'Wakanda');
INSERT INTO patient VALUES ((select user_id from utilisateur where nom  = 'Nick'), 'nick@marvel.com', 'N8', 'New York');
INSERT INTO patient VALUES ((select user_id from utilisateur where nom  = 'Thanos'), 'purpletitan@marvel.com', 'T2', 'New York');
INSERT INTO patient VALUES ((select user_id from utilisateur where nom  = 'Ant'), 'antman@marvel.com', 'A8', 'Wakanda');
INSERT INTO patient VALUES ((select user_id from utilisateur where nom  = 'Drax'), 'drax@marvel.com', 'D9', 'New York');

INSERT INTO rendez_vous VALUES (DEFAULT, 'Wakanda', 1, 6, 10, date'2022-04-20', time'08:00', time'09:00', 'nettoyage', 'termine', 1);
INSERT INTO rendez_vous VALUES (DEFAULT, 'Wakanda', 2, 6, 11, date'2022-04-20', time'09:00', time'10:00', 'nettoyage', 'prevu', 1);
INSERT INTO rendez_vous VALUES (DEFAULT, 'Wakanda', 3, 9, 11, date'2022-04-20', time'08:00', time'09:00', 'nettoyage', 'termine', 2);
INSERT INTO rendez_vous VALUES (DEFAULT, 'Wakanda', 4, 9, 10, date'2022-04-20', time'09:00', time'11:00', 'operation', 'retard', 2);
INSERT INTO rendez_vous VALUES (DEFAULT, 'New York', 5, 8, 13, date'2022-04-20', time'08:00', time'09:00', 'nettoyage', 'prevu', 1);
INSERT INTO rendez_vous VALUES (DEFAULT, 'New York', 6, 7, 12, date'2022-04-20', time'08:00', time'09:00', 'nettoyage', 'prevu', 2);
INSERT INTO rendez_vous VALUES (DEFAULT, 'New York', 7, 7, 13, date'2022-04-20', time'09:00', time'09:30', 'consultation', 'prevu', 2);
INSERT INTO rendez_vous VALUES (DEFAULT, 'New York', 8, 8, 12, date'2022-04-20', time'09:00', time'09:45', 'suivi', 'prevu', 1);
INSERT INTO rendez_vous VALUES (DEFAULT, 'New York', 9, 8, 13, date'2022-04-20', time'10:00', time'11:00', 'nettoyage', 'prevu', 1);
INSERT INTO rendez_vous VALUES (DEFAULT, 'Wakanda', 10, 6, 10, date'2022-04-20', time'13:00', time'13:30', 'consultation', 'prevu', 1);
INSERT INTO rendez_vous VALUES (DEFAULT, 'Wakanda', 11, 9, 11, date'2022-04-20', time'13:00', time'14:00', 'nettoyage', 'prevu', 2);
INSERT INTO rendez_vous VALUES (DEFAULT, 'New York', 12, 8, 12, date'2022-04-20', time'11:00', time'12:00', 'nettoyage', 'prevu', 1);

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

INSERT INTO frais VALUES (DEFAULT, 2, NULL, 'nettoyage', 200, 0,0,default);
INSERT INTO frais VALUES (DEFAULT, 2, NULL, 'nettoyage', 200, 0, 0,default);
INSERT INTO frais VALUES (DEFAULT, 2, NULL, 'nettoyage', 200, 0, 0,default);
INSERT INTO frais VALUES (DEFAULT, 1, 1, 'operation et acetaminophene', 300, 30, 14,default);
INSERT INTO frais VALUES (DEFAULT, 3, 2, 'traitement de canal et calmant', 500, 20, 14,default);
INSERT INTO frais VALUES (DEFAULT, 2, NULL, 'nettoyage', 200, 0, 0,default);
INSERT INTO frais VALUES (DEFAULT, 2, NULL, 'nettoyage', 200, 0, 0,default);
INSERT INTO frais VALUES (DEFAULT, 5, 5, 'blanchiment des dents et produit blanchisseur', 500, 100, 0,default);
INSERT INTO frais VALUES (DEFAULT, 6, NULL, 'suivi', 50, 0, 0,default);
INSERT INTO frais VALUES (DEFAULT, 2, NULL, 'nettoyage', 200, 0, 0,default);
INSERT INTO frais VALUES (DEFAULT, 7, NULL, 'consultation', 50, 0, 0,default);
INSERT INTO frais VALUES (DEFAULT, 2, NULL, 'nettoyage', 200, 0, 0,default);
INSERT INTO frais VALUES (DEFAULT, 2, NULL, 'nettoyage', 200, 0, 0,default);

INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', 1, 180, 10, 'yes');#Rabais enfant, le prix est 200$-10% = 270$
INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', 2, 180, 10, 'yes');#Rabais enfant
INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', 3, 180, 10, 'no');#Rabais enfant
INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', 4, 878, 0, 'yes');
INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', 5, 200, 0, 'yes');
INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', 6, 200, 0, 'no');
INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', 7, 300, 50, 'yes');#Reduction de 50% car rabais employé
INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', 8, 25, 50, 'yes');#Rabais employé
INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', 9, 100, 50, 'yes');#Rabais employé
INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', 10, 25, 50, 'yes');#Rabais employé
INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', 11, 100, 50, 'yes');#Rabais employé
INSERT INTO facture VALUES (DEFAULT, DATE'2022-04-20', 12, 100, 50, 'yes');#Rabais employé

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

INSERT INTO avis VALUES (DEFAULT, 1, 6, 1, 'tres gentil', 10, 4, 10);
INSERT INTO avis VALUES (DEFAULT, 2, 11, 2, 'super service', 9, 10, 6);
INSERT INTO avis VALUES (DEFAULT, 3, 9, 3, 'belle ambiance', 8, 9, 7);
INSERT INTO avis VALUES (DEFAULT, 4, 10, 4, 'wow', 10, 8, 8);
INSERT INTO avis VALUES (DEFAULT, 5, 13, 5, 'tres professionnel', 7, 9, 7);
INSERT INTO avis VALUES (DEFAULT, 6, 12, 6, 'un peu de retard', 9, 8, 9);
INSERT INTO avis VALUES (DEFAULT, 7, 7, 7, 'excellent', 10, 7, 5);
INSERT INTO avis VALUES (DEFAULT, 8, 8, 8, 'tres dynamique', 7, 10, 8);
INSERT INTO avis VALUES (DEFAULT, 9, 8, 9, 'merci', 9, 8, 10);
INSERT INTO avis VALUES (DEFAULT, 10, 6, 10, 'belle experience', 6, 9, 9);
INSERT INTO avis VALUES (DEFAULT, 11, 9, 11, 'je recommande', 10, 10, 8);
INSERT INTO avis VALUES (DEFAULT, 12, 12, 12, 'bon service', 9, 7, 9);

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

INSERT INTO dossier VALUES (1, 6);
INSERT INTO dossier VALUES (2, 11);
INSERT INTO dossier VALUES (3, 9);
INSERT INTO dossier VALUES (4, 10);
INSERT INTO dossier VALUES (5, 13);
INSERT INTO dossier VALUES (6, 12);
INSERT INTO dossier VALUES (7, 7);
INSERT INTO dossier VALUES (8, 8);
INSERT INTO dossier VALUES (9, 6);
INSERT INTO dossier VALUES (10, 9);
INSERT INTO dossier VALUES (11, 12);
INSERT INTO dossier VALUES (12, 12);

INSERT INTO inscrit_dans VALUES (2, NULL, 1);
INSERT INTO inscrit_dans VALUES (2, NULL, 2);
INSERT INTO inscrit_dans VALUES (2, NULL, 3);
INSERT INTO inscrit_dans VALUES (1, 1, 4);
INSERT INTO inscrit_dans VALUES (3, 2, 4);
INSERT INTO inscrit_dans VALUES (2, NULL, 5);
INSERT INTO inscrit_dans VALUES (2, NULL, 6);
INSERT INTO inscrit_dans VALUES (5, 5, 7);
INSERT INTO inscrit_dans VALUES (6, NULL, 8);
INSERT INTO inscrit_dans VALUES (2, NULL, 9);
INSERT INTO inscrit_dans VALUES (7, NULL, 10);
INSERT INTO inscrit_dans VALUES (2, NULL, 11);
INSERT INTO inscrit_dans VALUES (2, NULL, 12);
