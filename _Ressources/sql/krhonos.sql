-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 02 oct. 2018 à 14:48
-- Version du serveur :  10.1.33-MariaDB
-- Version de PHP :  7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `krhonos`
--

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Structure de la table `salarie`
--

CREATE TABLE `salarie` (
  `id` bigint(20) NOT NULL,
  `salarie_nom` varchar(255) NOT NULL,
  `salarie_nom_naissance` varchar(255) DEFAULT NULL,
  `salarie_prenom` varchar(255) NOT NULL,
  `salarie_num_secu` bigint(20) NOT NULL,
  `salarie_cle_secu` int(2) NOT NULL,
  `salarie_adresse` varchar(255) NOT NULL,
  `salarie_code_postal` int(5) NOT NULL,
  `salarie_ville` varchar(255) NOT NULL,
  `salarie_telephone` bigint(10) NOT NULL,
  `salarie_mail` varchar(255) NOT NULL,
  `salarie_date_naissance` datetime NOT NULL,
  `salarie_cp_naissance` int(5) NOT NULL,
  `salarie_ville_naissance` varchar(255) NOT NULL,
  `salarie_date_entree` datetime NOT NULL,
  `civilite_id` int(2) NOT NULL,
  `fam_id` int(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `salarie`
--

INSERT INTO `salarie` (`id`, `salarie_nom`, `salarie_nom_naissance`, `salarie_prenom`, `salarie_num_secu`, `salarie_cle_secu`, `salarie_adresse`, `salarie_code_postal`, `salarie_ville`, `salarie_telephone`, `salarie_mail`, `salarie_date_naissance`, `salarie_cp_naissance`, `salarie_ville_naissance`, `salarie_date_entree`, `civilite_id`, `fam_id`) VALUES
(21, 'Le', '', 'Mathis', 1701197302137, 12, '62 Rue Abel-Rabaud', 34070, 'MONTPELLIER', 621460129, 'le.mathis@fakemail.com', '1970-11-19 00:00:00', 973, 'GUYANE', '1997-12-28 00:00:00', 1, 2),
(20, 'Vasseur', '', 'Maxime', 1750145234138, 43, '47 Rue Grétry', 34080, 'MONTPELLIER', 651267626, 'vasseur.maxime@fakemail.com', '1975-01-11 00:00:00', 45100, 'ORLEANS', '1997-09-14 00:00:00', 1, 2),
(19, 'Le roux', 'Marie', 'Emilie', 2600992802431, 5, '145 Rue Evette', 34230, 'SAINT PARGOIRE', 608179619, 'le roux.emilie@fakemail.com', '1960-09-12 00:00:00', 92000, 'NANTERRE', '1997-02-02 00:00:00', 2, 2),
(18, 'Caron', '', 'Françoise', 2871075110074, 1, 'Villa Jamot', 34070, 'MONTPELLIER', 658297925, 'caron.françoise@fakemail.com', '1987-10-13 00:00:00', 75010, 'PARIS EME ARRONDISSEMENT', '1996-04-11 00:00:00', 2, 1),
(17, 'Renault', '', 'Nicolas', 1790811262033, 45, '119 Rue Godot-de-Mauroy', 34090, 'MONTPELLIER', 639573663, 'renault.nicolas@fakemail.com', '1979-08-10 00:00:00', 11100, 'NARBONNE', '1995-08-06 00:00:00', 1, 1),
(16, 'Hebert', '', 'Manon', 2820748095023, 70, '168 Rue Delouvain', 34570, 'SAINT PAUL ET VALMALLE', 674451670, 'hebert.manon@fakemail.com', '1982-07-13 00:00:00', 48000, 'MENDE', '1993-08-16 00:00:00', 2, 1),
(15, 'Fouquet', '', 'Enzo', 1800712202076, 61, '47 Rue Fernand-Labori', 34170, 'CASTELNAU LE LEZ', 666335367, 'fouquet.enzo@fakemail.com', '1980-07-13 00:00:00', 12000, 'RODEZ', '1992-04-21 00:00:00', 1, 2),
(14, 'Pottier', '', 'Arthur', 1700865286015, 72, '193 Rue Guénégaud', 34830, 'CLAPIERS', 661166139, 'pottier.arthur@fakemail.com', '1970-08-04 00:00:00', 65100, 'LOURDES', '1991-09-13 00:00:00', 1, 2),
(13, 'Andre', '', 'Dorian', 1830381004079, 44, '150 Rue Xavier-Privas', 34170, 'CASTELNAU LE LEZ', 687056510, 'andre.dorian@fakemail.com', '1983-03-18 00:00:00', 81000, 'ALBI', '1991-01-09 00:00:00', 1, 1),
(12, 'Leconte', '', 'Alicia', 2720294080021, 78, '90 Rue Desprez', 34660, 'COURNONTERAL', 628309330, 'leconte.alicia@fakemail.com', '1972-02-13 00:00:00', 94300, 'VINCENNES', '1990-10-08 00:00:00', 2, 1),
(11, 'Fischer', '', 'Gilbert', 1650134172194, 15, '190 Rue Fromentin', 34990, 'JUVIGNAC', 691620872, 'fischer.gilbert@fakemail.com', '1965-01-18 00:00:00', 34000, 'MONTPELLIER', '1990-01-13 00:00:00', 1, 1),
(10, 'Blin', 'Baron', 'Clotilde', 2721169387030, 20, '82 Rue Chapon', 34170, 'CASTELNAU LE LEZ', 611511013, 'blin.clotilde@fakemail.com', '1972-11-03 00:00:00', 69001, 'LYON', '2014-05-14 00:00:00', 2, 2),
(9, 'Munoz', '', 'Pauline', 2821071475121, 27, '142 Rue du Chalet', 34820, 'TEYRAN', 643510146, 'munoz.pauline@fakemail.com', '1982-10-30 00:00:00', 71100, 'SAINT REMY', '2014-02-24 00:00:00', 2, 1),
(8, 'Robin', '', 'Anaïs', 2870230189229, 18, '49 Rue Belidor', 34980, 'ST CLEMENT DE RIVIERE', 640944515, 'robin.anais@fakemail.com', '1987-02-02 00:00:00', 30000, 'NIMES', '2005-11-14 00:00:00', 2, 1),
(7, 'Louis', '', 'Baptiste', 1620564102138, 20, '136 Rue Darcy', 34790, 'GRABELS', 601106285, 'louis.baptiste@fakemail.com', '1962-05-26 00:00:00', 64100, 'BAYONNE', '2000-08-08 00:00:00', 1, 1),
(6, 'Auger', '', 'Alice', 2740929019131, 75, '130 Rue Georges-Leclanché', 34660, 'COURNONTERAL', 631563947, 'auger.alice@fakemail.com', '1974-09-13 00:00:00', 29200, 'BREST', '1997-11-19 00:00:00', 2, 1),
(5, 'Chevalier', 'Cornu', 'Agathe', 2790734172396, 46, '142 Avenue Carnot', 34170, 'CASTELNAU LE LEZ', 605324046, 'chevalier.agathe@fakemail.com', '1979-07-28 00:00:00', 34000, 'MONTPELLIER', '1995-03-18 00:00:00', 2, 2),
(4, 'Fortin', 'Dumont', 'Solene', 2690460157190, 54, '57 Rue Caron', 34830, 'CLAPIERS', 660755650, 'fortin.solene@fakemail.com', '1969-04-09 00:00:00', 60600, 'CLERMONT', '1995-02-01 00:00:00', 2, 2),
(3, 'Maire', '', 'Alexis', 1790794067030, 52, '155 Rue Gaston-Pinot', 34000, 'MONTPELLIER', 693832159, 'maire.alexis@fakemail.com', '1979-07-07 00:00:00', 94160, 'ST MANDE', '1994-03-04 00:00:00', 1, 1),
(2, 'Merle', '', 'Adrian', 1850754395020, 29, '154 Rue Dieu', 34990, 'JUVIGNAC', 670058169, 'merle.adrian@fakemail.com', '1985-07-01 00:00:00', 54000, 'NANCY', '1991-11-14 00:00:00', 1, 2),
(1, 'Caron', '', 'Florian', 1700926362113, 24, 'Villa Emile-Loubet', 34090, 'MONTPELLIER', 655286709, 'caron.florian@fakemail.com', '1970-09-17 00:00:00', 26000, 'VALENCE', '1990-09-21 00:00:00', 1, 1),
(22, 'Morvan', '', 'Gaspard', 1771183069038, 55, '46 Rue des Cévennes', 34790, 'GRABELS', 661931099, 'morvan.gaspard@fakemail.com', '1977-11-17 00:00:00', 83400, 'HYERES', '1998-05-11 00:00:00', 1, 1),
(23, 'Denis', '', 'Lena', 2701173008043, 18, '18 Impasse Grimaud', 34380, 'NOTRE DAME DE LONDRES', 605218160, 'denis.lena@fakemail.com', '1970-11-26 00:00:00', 73100, 'AIX LES BAINS', '2001-02-05 00:00:00', 2, 1),
(24, 'Peron', '', 'Laura', 2790631555022, 53, '27 Place du Bataillon-du-Pacifique', 34190, 'MOULES ET BAUCELS', 603096905, 'peron.laura@fakemail.com', '1979-06-01 00:00:00', 31000, 'TOULOUSE', '2001-02-13 00:00:00', 2, 1),
(25, 'Serre', 'Gillet', 'Amélie', 2710734032014, 73, '130 Rue Fourneyron', 34000, 'MONTPELLIER', 631995282, 'serre.amelie@fakemail.com', '1971-07-02 00:00:00', 34500, 'BEZIERS', '2001-11-20 00:00:00', 2, 2),
(26, 'Tanguy', '', 'Lorenzo', 1820878172034, 12, '140 Passage Barrault', 34880, 'LAVERUNE', 661052963, 'tanguy.lorenzo@fakemail.com', '1982-08-09 00:00:00', 78700, 'CONFLANS ST HONORINE', '2002-04-05 00:00:00', 1, 1),
(27, 'Leon', 'Louis', 'Ambre', 2880734301081, 27, '93 Rue des Degrés', 34690, 'FABREGUES', 678639973, 'leon.ambre@fakemail.com', '1988-07-23 00:00:00', 34200, 'SETE', '2003-02-27 00:00:00', 2, 2),
(28, 'Toussaint', '', 'Inès', 2680615162150, 76, '73 Place Henri-Langlois', 34070, 'RESTINCLIERES', 624508369, 'toussaint.ines@fakemail.com', '1968-06-20 00:00:00', 15400, 'RIOM ES MONTAGNE', '2003-04-01 00:00:00', 2, 1),
(29, 'Leleu', '', 'Bruno', 1770509160048, 90, '130 Boulevard Adolphe-Pinard', 34570, 'PIGNAN', 644115007, 'leleu.bruno@fakemail.com', '1977-05-28 00:00:00', 9300, 'LAVELANET', '2004-10-06 00:00:00', 1, 1),
(30, 'Flament', 'Jacquemin', 'Léane', 2790715014049, 20, 'Villa Gabriel', 34190, 'GANGES', 689180761, 'flament.leane@fakemail.com', '1979-07-10 00:00:00', 15000, 'AURILLAC', '2005-03-09 00:00:00', 2, 2),
(31, 'Lacoste', 'Michaud', 'Agathe', 2770834199022, 15, '43 Rue Censier', 34070, 'MONTPELLIER', 656805937, 'lacoste.agathe@fakemail.com', '1977-08-17 00:00:00', 34120, 'PEZENAS', '2005-07-08 00:00:00', 2, 2),
(32, 'Blanchard', '', 'Antoine', 1560583137322, 22, 'Villa Hallé', 34170, 'CASTELNAU LE LEZ', 639101021, 'blanchard.antoine@fakemail.com', '1956-05-31 00:00:00', 83000, 'TOULON', '2008-02-02 00:00:00', 1, 2),
(33, 'Tellier', '', 'Margaux', 2810590010048, 23, '180 Rue Belidor', 34080, 'MONTPELLIER', 622370575, 'tellier.margaux@fakemail.com', '1981-05-06 00:00:00', 90000, 'BELFORT', '2008-12-19 00:00:00', 2, 1),
(34, 'Pereira', '', 'Victor', 1560124322060, 46, '122 Rue Gassendi', 34150, 'ST JEAN DE FOS', 612910793, 'pereira.victor@fakemail.com', '1956-01-15 00:00:00', 24000, 'PERIGUEUX', '2009-04-30 00:00:00', 1, 1),
(35, 'Pruvost', '', 'Carla', 2831113103026, 11, '195 Rue Balny-d\'Avricourt', 34280, 'LA GRANDE MOTTE', 633039740, 'pruvost.carla@fakemail.com', '1983-11-15 00:00:00', 13300, 'SALON DE PROVENCE', '2010-02-10 00:00:00', 2, 1),
(36, 'Schmitt', '', 'Lana', 2580930007014, 48, '163 Avenue du Général-Maistre', 34170, 'CASTELNAU LE LEZ', 632856417, 'schmitt.lana@fakemail.com', '1958-09-06 00:00:00', 30000, 'ALES', '2011-07-12 00:00:00', 2, 1),
(37, 'Perez', 'Fabre', 'Fanny', 2800181163012, 62, '121 Avenue de l\'Ermitage', 34570, 'MONTARNAUD', 635561263, 'perez.fanny@fakemail.com', '1980-01-01 00:00:00', 81200, 'MAZAMET', '2012-01-13 00:00:00', 2, 2),
(38, 'Le goff', '', 'Elsa', 2831295210011, 50, '116 Avenue du Général-Dodds', 34070, 'MONTPELLIER', 672626590, 'le goff.elsa@fakemail.com', '1983-12-01 00:00:00', 95880, 'ENGHIEN LES BAINS', '2013-04-27 00:00:00', 2, 1),
(39, 'Guillou', '', 'Anthony', 1551275073140, 76, '197 Rue de Florence', 34730, 'PRADES LE LEZ', 680076910, 'guillou.anthony@fakemail.com', '1955-12-23 00:00:00', 92150, 'SURESNES', '2015-07-29 00:00:00', 1, 1),
(40, 'Etienne', '', 'Ethan', 1700912145014, 27, '152 Avenue du Général-Sarrail', 34160, 'CASTRIES', 699453084, 'etienne.ethan@fakemail.com', '1970-09-06 00:00:00', 12100, 'MILLAU', '2015-07-30 00:00:00', 1, 2),
(41, 'Roques', '', 'Angelina', 2870104209019, 23, '143 Rue du Général-Archinard', 34090, 'MONTPELLIER', 692155756, 'roques.angelina@fakemail.com', '1987-01-26 00:00:00', 4200, 'SISTERON', '2015-11-24 00:00:00', 2, 1),
(42, 'Pons', '', 'Eléna', 2850934172468, 3, '146 Boulevard des Frères-Voisin', 34070, 'MONTPELLIER', 647011831, 'pons.elena@fakemail.com', '1985-09-29 00:00:00', 34000, 'MONTPELLIER', '2016-03-05 00:00:00', 2, 1),
(43, 'Jacquemin', 'Moreno', 'Emma', 2680792012167, 71, '3 Rue Chambiges', 34830, 'CLAPIERS', 620851581, 'jacquemin.emma@fakemail.com', '1968-07-22 00:00:00', 92100, 'BOULOGNE BILLANCOURT', '2016-03-25 00:00:00', 2, 2),
(44, 'Briand', '', 'Valentine', 2880684087082, 36, '107 Rue Danielle-Casanova', 34230, 'SAINT PARGOIRE', 673107827, 'briand.valentine@fakemail.com', '1988-06-18 00:00:00', 84100, 'ORANGE', '2016-09-02 00:00:00', 2, 1),
(45, 'Mary', '', 'Sara', 2620721464058, 83, '138 Rue de Babylone', 34190, 'GANGES', 601929932, 'mary.sara@fakemail.com', '1962-07-09 00:00:00', 21700, 'NUITS ST GEORGES', '2017-02-01 00:00:00', 2, 1),
(46, 'Lejeune', 'Leblanc', 'Eloïse', 2690982121063, 68, '195 Rue du Capitaine-Olchanski', 34080, 'MONTPELLIER', 650308880, 'lejeune.eloise@fakemail.com', '1969-09-17 00:00:00', 82000, 'MONTAUBAN', '2017-02-21 00:00:00', 2, 2),
(47, 'Renard', '', 'Benjamin', 1940660159410, 86, '40 Rue Frédéric-Brunet', 34090, 'MONTPELLIER', 698139890, 'renard.benjamin@fakemail.com', '1994-06-22 00:00:00', 60200, 'COMPIEGNE', '2018-05-17 00:00:00', 1, 1),
(48, 'Lopes', '', 'Guillaume', 1690634172111, 79, '186 Passage Dagorno', 34170, 'CASTELNAU LE LEZ', 632929187, 'lopes.guillaume@fakemail.com', '1969-06-09 00:00:00', 34000, 'MONTPELLIER', '2018-06-17 00:00:00', 1, 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `salarie`
--
ALTER TABLE `salarie`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
