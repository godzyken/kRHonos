-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 08 oct. 2018 à 15:44
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
-- Structure de la table `absence`
--

CREATE TABLE `absence` (
  `absence_id` int(11) NOT NULL,
  `absence_debut` datetime NOT NULL,
  `absence_fin` datetime NOT NULL,
  `absence_desciption` text,
  `absence_valorisation` float NOT NULL,
  `absence_justifier` varchar(50) NOT NULL COMMENT 'ENUM: En attente, validé ou injustifié',
  `type_abs_id` int(11) NOT NULL,
  `contrat_contrat_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `civilite`
--

CREATE TABLE `civilite`(
  `civilite_id` int(11) NOT NULL,
  `civilite_identifiant` varchar(8) NOT NULL,
  `civilite_sexe` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `civilite`
--

INSERT INTO `civilite` (`civilite_id`, `civilite_identifiant`, `civilite_sexe`) VALUES
(1, 'Monsieur', 'Homme'),
(2, 'Madame', 'Femme');

-- --------------------------------------------------------

--
-- Structure de la table `conges`
--

CREATE TABLE `conges` (
  `absence_id` int(11) NOT NULL,
  `conges_id` int(11) NOT NULL,
  `conges_acquis` float NOT NULL,
  `conges_pris` float NOT NULL,
  `conges_validation` varchar(50) NOT NULL COMMENT 'enum:  En attente, validé, refusé ou rejeté',
  `absence_debut` datetime NOT NULL,
  `absence_fin` datetime NOT NULL,
  `absence_desciption` text,
  `absence_valorisation` float NOT NULL,
  `absence_justifier` varchar(50) NOT NULL COMMENT 'ENUM: En attente, validé ou injustifié',
  `type_abs_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `conges__periodes_conges`
--

CREATE TABLE `conges__periodes_conges` (
  `periode_id` int(11) NOT NULL,
  `absence_id` int(11) NOT NULL,
  `conges_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `contrat`
--

CREATE TABLE `contrat` (
  `contrat_id` int(11) NOT NULL,
  `contrat_date_embauche` date NOT NULL,
  `contrat_date_fin` date DEFAULT NULL,
  `contrat_tps_travail` float NOT NULL,
  `salarie_id` int(11) NOT NULL,
  `nature_ctr_id` int(11) NOT NULL,
  `emploi_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `contrat`
--

INSERT INTO `contrat` (`contrat_id`, `contrat_date_embauche`, `contrat_date_fin`, `contrat_tps_travail`, `salarie_id`, `nature_ctr_id`, `emploi_id`) VALUES
(1, '1990-09-21', NULL, 151.67, 1, 1, 11),
(2, '2005-11-14', NULL, 121.34, 2, 1, 17),
(3, '1998-03-04', NULL, 121.34, 3, 1, 17),
(4, '1995-02-01', NULL, 151.67, 4, 1, 20),
(5, '2004-03-18', NULL, 151.67, 5, 1, 6),
(6, '1997-11-19', NULL, 151.67, 6, 1, 22),
(7, '2000-08-08', NULL, 151.67, 7, 1, 10),
(8, '2005-11-14', NULL, 121.34, 8, 1, 11),
(9, '2014-02-24', NULL, 151.67, 9, 1, 15),
(10, '2014-05-14', NULL, 75.84, 10, 1, 17),
(11, '1990-01-13', NULL, 121.34, 11, 1, 2),
(12, '1990-10-08', NULL, 75.84, 12, 1, 11),
(13, '2007-01-09', NULL, 151.67, 13, 1, 14),
(14, '1991-09-13', NULL, 121.34, 14, 1, 17),
(15, '2002-04-21', NULL, 121.34, 15, 1, 3),
(16, '2000-08-16', NULL, 151.67, 16, 1, 4),
(17, '1999-08-06', NULL, 151.67, 17, 1, 11),
(18, '2006-04-11', NULL, 75.84, 18, 1, 3),
(19, '1997-02-02', NULL, 151.67, 19, 1, 16),
(20, '1997-09-14', NULL, 151.67, 20, 1, 7),
(21, '1997-12-28', NULL, 151.67, 21, 1, 3),
(22, '1998-05-11', NULL, 75.84, 22, 1, 23),
(23, '2001-02-05', NULL, 121.34, 23, 1, 13),
(24, '2001-02-13', NULL, 151.67, 24, 1, 4),
(25, '2001-11-20', NULL, 151.67, 25, 1, 8),
(26, '2002-04-05', NULL, 121.34, 26, 1, 17),
(27, '2009-02-27', NULL, 113.75, 27, 1, 4),
(28, '2003-04-01', NULL, 151.67, 28, 1, 19),
(29, '2004-10-06', NULL, 151.67, 29, 1, 1),
(30, '2005-03-09', NULL, 75.84, 30, 1, 15),
(31, '2005-07-08', NULL, 75.84, 31, 1, 17),
(32, '2008-02-02', NULL, 151.67, 32, 1, 15),
(33, '2008-12-19', NULL, 113.75, 33, 1, 11),
(34, '2009-04-30', NULL, 75.84, 34, 1, 23),
(35, '2010-02-10', NULL, 151.67, 35, 1, 21),
(36, '2011-07-12', NULL, 151.67, 36, 1, 9),
(37, '2012-01-13', NULL, 75.84, 37, 1, 17),
(38, '2013-04-27', NULL, 151.67, 38, 1, 5),
(39, '2015-07-29', NULL, 151.67, 39, 1, 18),
(40, '2015-07-30', NULL, 75.84, 40, 1, 23),
(41, '2015-11-24', NULL, 151.67, 41, 1, 1),
(42, '2016-03-05', NULL, 75.84, 42, 1, 11),
(43, '2016-03-25', NULL, 151.67, 43, 1, 3),
(44, '2016-09-02', NULL, 151.67, 44, 1, 21),
(45, '2017-02-01', NULL, 75.84, 45, 1, 11),
(46, '2017-02-21', NULL, 151.67, 46, 1, 7),
(47, '2018-05-17', NULL, 151.67, 47, 1, 12),
(48, '2018-06-17', NULL, 151.67, 48, 1, 6);

-- --------------------------------------------------------

--
-- Structure de la table `contrat__service`
--

CREATE TABLE `contrat__service` (
  `contrat_id` int(11) NOT NULL,
  `service_id` int(11) NOT NULL,
  `contrat__service_debut` date NOT NULL,
  `contrat__service_fin` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `emploi`
--

CREATE TABLE `emploi` (
  `emploi_id` int(11) NOT NULL,
  `emploi_libelle` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `emploi`
--

INSERT INTO `emploi` (`emploi_id`, `emploi_libelle`) VALUES
(1, 'Agent de service intérieur'),
(2, 'Agent technique supérieur'),
(3, 'aide medico psychologique'),
(4, 'Aide Soignant'),
(5, 'Auxiliaire de vie sociale'),
(6, 'Chef de service'),
(7, 'Chef de service éducatif'),
(8, 'Comptable'),
(9, 'Directeur'),
(10, 'Directeur général'),
(11, 'Educateur spécialisé'),
(12, 'Educateur sportif'),
(13, 'Ergothérapeute'),
(14, 'Gestionnaire de paie'),
(15, 'Infirmier'),
(16, 'Kinésithérapeute'),
(17, 'Moniteur éducateur'),
(18, 'Psychologue'),
(19, 'Responsable Gestion Comptabilité'),
(20, 'Responsable Ressources Humaines'),
(21, 'Secrétaire d\'accueil'),
(22, 'Secrétaire de direction'),
(23, 'Surveillant de nuit');

-- --------------------------------------------------------

--
-- Structure de la table `etablissement`
--

CREATE TABLE `etablissement` (
  `etab_id` int(11) NOT NULL,
  `etab_nom` varchar(35) NOT NULL,
  `etab_siret` bigint(14) NOT NULL,
  `etab_adresse` varchar(50) NOT NULL,
  `etab_code_postal` int(11) NOT NULL,
  `etab_ville` varchar(25) NOT NULL,
  `etab_numero` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etablissement`
--

INSERT INTO `etablissement` (`etab_id`, `etab_nom`, `etab_siret`, `etab_adresse`, `etab_code_postal`, `etab_ville`, `etab_numero`) VALUES
(1, 'SIEGE SOCIAL', 74891735739628, 'Villa Damrémont', 34070, 'Montpellier', '04.67.97.84.00'),
(2, 'IME LES HIRONDELLES', 74855712483081, 'Rue de l\'Hirondelle', 34690, 'Fabrègues', '04.67.00.90.80');

-- --------------------------------------------------------

--
-- Structure de la table `nature_contrat`
--

CREATE TABLE `nature_contrat` (
  `nature_ctr_id` int(11) NOT NULL,
  `nature_ctr_libelle` varchar(20) NOT NULL,
  `nature_ctr_actif` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `nature_contrat`
--

INSERT INTO `nature_contrat` (`nature_ctr_id`, `nature_ctr_libelle`, `nature_ctr_actif`) VALUES
(1, 'CDI', 1),
(2, 'CDD', 1),
(3, 'CAE', 1),
(4, 'Apprenti', 1);

-- --------------------------------------------------------

--
-- Structure de la table `periodes_conges`
--

CREATE TABLE `periodes_conges` (
  `periode_id` int(11) NOT NULL,
  `periode_debut` date NOT NULL,
  `periode_fin` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `planning`
--

CREATE TABLE `planning` (
  `planning_id` int(11) NOT NULL,
  `planning_title` varchar(250) NOT NULL,
  `planning_start` datetime NOT NULL,
  `planning_end` datetime NOT NULL,
  `contrat_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role_libelle` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`role_id`, `role_libelle`) VALUES
(1, 'Administrateur'),
(2, 'Salarie'),
(3, 'Manager');

-- --------------------------------------------------------

--
-- Structure de la table `salarie`
--

CREATE TABLE `salarie` (
  `id` int(11) NOT NULL,
  `salarie_nom` varchar(35) NOT NULL,
  `salarie_nom_naissance` varchar(35) NOT NULL,
  `salarie_prenom` varchar(50) NOT NULL,
  `salarie_num_secu` bigint(13) NOT NULL,
  `salarie_cle_secu` int(2) NOT NULL,
  `salarie_adresse` varchar(50) NOT NULL,
  `salarie_code_postal` int(5) NOT NULL,
  `salarie_ville` varchar(30) NOT NULL,
  `salarie_telephone` bigint(10) NOT NULL,
  `salarie_mail` varchar(50) NOT NULL,
  `salarie_date_naissance` date NOT NULL,
  `salarie_cp_naissance` int(5) NOT NULL,
  `salarie_ville_naissance` varchar(30) NOT NULL,
  `salarie_date_entree` date NOT NULL,
  `civilite_id` int(11) NOT NULL,
  `fam_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `salarie`
--

INSERT INTO `salarie` (`id`, `salarie_nom`, `salarie_nom_naissance`, `salarie_prenom`, `salarie_num_secu`, `salarie_cle_secu`, `salarie_adresse`, `salarie_code_postal`, `salarie_ville`, `salarie_telephone`, `salarie_mail`, `salarie_date_naissance`, `salarie_cp_naissance`, `salarie_ville_naissance`, `salarie_date_entree`, `civilite_id`, `fam_id`) VALUES
(1, 'Caron', '', 'Florian', 1700926362113, 24, 'Villa Emile-Loubet', 34090, 'MONTPELLIER', 655286709, 'caron.florian@fakemail.com', '1970-09-17', 26000, 'VALENCE', '1990-09-21', 1, 1),
(2, 'Merle', '', 'Adrian', 1850754395020, 29, '154 Rue Dieu', 34990, 'JUVIGNAC', 670058169, 'merle.adrian@fakemail.com', '1985-07-01', 54000, 'NANCY', '2005-11-14', 1, 2),
(3, 'Maire', '', 'Alexis', 1790794067030, 52, '155 Rue Gaston-Pinot', 34000, 'MONTPELLIER', 693832159, 'maire.alexis@fakemail.com', '1979-07-07', 94160, 'ST MANDE', '1998-03-04', 1, 1),
(4, 'Fortin', 'Dumont', 'Solene', 2690460157190, 54, '57 Rue Caron', 34830, 'CLAPIERS', 660755650, 'fortin.solene@fakemail.com', '1969-04-09', 60600, 'CLERMONT', '1995-02-01', 2, 2),
(5, 'Chevalier', 'Cornu', 'Agathe', 2790734172396, 46, '142 Avenue Carnot', 34170, 'CASTELNAU LE LEZ', 605324046, 'chevalier.agathe@fakemail.com', '1979-07-28', 34000, 'MONTPELLIER', '2004-03-18', 2, 2),
(6, 'Auger', '', 'Alice', 2740929019131, 75, '130 Rue Georges-Leclanché', 34660, 'COURNONTERAL', 631563947, 'auger.alice@fakemail.com', '1974-09-13', 29200, 'BREST', '1997-11-19', 2, 1),
(7, 'Louis', '', 'Baptiste', 1620564102138, 20, '136 Rue Darcy', 34790, 'GRABELS', 601106285, 'louis.baptiste@fakemail.com', '1962-05-26', 64100, 'BAYONNE', '2000-08-08', 1, 1),
(8, 'Robin', '', 'Anaïs', 2870230189229, 18, '49 Rue Belidor', 34980, 'ST CLEMENT DE RIVIERE', 640944515, 'robin.anais@fakemail.com', '1987-02-02', 30000, 'NIMES', '2005-11-14', 2, 1),
(9, 'Munoz', '', 'Pauline', 2821071475121, 27, '142 Rue du Chalet', 34820, 'TEYRAN', 643510146, 'munoz.pauline@fakemail.com', '1982-10-30', 71100, 'SAINT REMY', '2014-02-24', 2, 1),
(10, 'Blin', 'Baron', 'Clotilde', 2721169387030, 20, '82 Rue Chapon', 34170, 'CASTELNAU LE LEZ', 611511013, 'blin.clotilde@fakemail.com', '1972-11-03', 69001, 'LYON', '2014-05-14', 2, 2),
(11, 'Fischer', '', 'Gilbert', 1650134172194, 15, '190 Rue Fromentin', 34990, 'JUVIGNAC', 691620872, 'fischer.gilbert@fakemail.com', '1965-01-18', 34000, 'MONTPELLIER', '1990-01-13', 1, 1),
(12, 'Leconte', '', 'Alicia', 2720294080021, 78, '90 Rue Desprez', 34660, 'COURNONTERAL', 628309330, 'leconte.alicia@fakemail.com', '1972-02-13', 94300, 'VINCENNES', '1990-10-08', 2, 1),
(13, 'Andre', '', 'Dorian', 1830381004079, 44, '150 Rue Xavier-Privas', 34170, 'CASTELNAU LE LEZ', 687056510, 'andre.dorian@fakemail.com', '1983-03-18', 81000, 'ALBI', '2007-01-09', 1, 1),
(14, 'Pottier', '', 'Arthur', 1700865286015, 72, '193 Rue Guénégaud', 34830, 'CLAPIERS', 661166139, 'pottier.arthur@fakemail.com', '1970-08-04', 65100, 'LOURDES', '1991-09-13', 1, 2),
(15, 'Fouquet', '', 'Enzo', 1800712202076, 61, '47 Rue Fernand-Labori', 34170, 'CASTELNAU LE LEZ', 666335367, 'fouquet.enzo@fakemail.com', '1980-07-13', 12000, 'RODEZ', '2002-04-21', 1, 2),
(16, 'Hebert', '', 'Manon', 2820748095023, 70, '168 Rue Delouvain', 34570, 'SAINT PAUL ET VALMALLE', 674451670, 'hebert.manon@fakemail.com', '1982-07-13', 48000, 'MENDE', '2000-08-16', 2, 1),
(17, 'Renault', '', 'Nicolas', 1790811262033, 45, '119 Rue Godot-de-Mauroy', 34090, 'MONTPELLIER', 639573663, 'renault.nicolas@fakemail.com', '1979-08-10', 11100, 'NARBONNE', '1999-08-06', 1, 1),
(18, 'Caron', '', 'Françoise', 2871075110074, 1, 'Villa Jamot', 34070, 'MONTPELLIER', 658297925, 'caron.françoise@fakemail.com', '1987-10-13', 75010, 'PARIS EME ARRONDISSEMENT', '2006-04-11', 2, 1),
(19, 'Le roux', 'Marie', 'Emilie', 2600992802431, 5, '145 Rue Evette', 34230, 'SAINT PARGOIRE', 608179619, 'le roux.emilie@fakemail.com', '1960-09-12', 92000, 'NANTERRE', '1997-02-02', 2, 2),
(20, 'Vasseur', '', 'Maxime', 1750145234138, 43, '47 Rue Grétry', 34080, 'MONTPELLIER', 651267626, 'vasseur.maxime@fakemail.com', '1975-01-11', 45100, 'ORLEANS', '1997-09-14', 1, 2),
(21, 'Le', '', 'Mathis', 1701197302137, 12, '62 Rue Abel-Rabaud', 34070, 'MONTPELLIER', 621460129, 'le.mathis@fakemail.com', '1970-11-19', 973, 'GUYANE', '1997-12-28', 1, 2),
(22, 'Morvan', '', 'Gaspard', 1771183069038, 55, '46 Rue des Cévennes', 34790, 'GRABELS', 661931099, 'morvan.gaspard@fakemail.com', '1977-11-17', 83400, 'HYERES', '1998-05-11', 1, 1),
(23, 'Denis', '', 'Lena', 2701173008043, 18, '18 Impasse Grimaud', 34380, 'NOTRE DAME DE LONDRES', 605218160, 'denis.lena@fakemail.com', '1970-11-26', 73100, 'AIX LES BAINS', '2001-02-05', 2, 1),
(24, 'Peron', '', 'Laura', 2790631555022, 53, '27 Place du Bataillon-du-Pacifique', 34190, 'MOULES ET BAUCELS', 603096905, 'peron.laura@fakemail.com', '1979-06-01', 31000, 'TOULOUSE', '2001-02-13', 2, 1),
(25, 'Serre', 'Gillet', 'Amélie', 2710734032014, 73, '130 Rue Fourneyron', 34000, 'MONTPELLIER', 631995282, 'serre.amelie@fakemail.com', '1971-07-02', 34500, 'BEZIERS', '2001-11-20', 2, 2),
(26, 'Tanguy', '', 'Lorenzo', 1820878172034, 12, '140 Passage Barrault', 34880, 'LAVERUNE', 661052963, 'tanguy.lorenzo@fakemail.com', '1982-08-09', 78700, 'CONFLANS ST HONORINE', '2002-04-05', 1, 1),
(27, 'Leon', 'Louis', 'Ambre', 2880734301081, 27, '93 Rue des Degrés', 34690, 'FABREGUES', 678639973, 'leon.ambre@fakemail.com', '1988-07-23', 34200, 'SETE', '2009-02-27', 2, 2),
(28, 'Toussaint', '', 'Inès', 2680615162150, 76, '73 Place Henri-Langlois', 34070, 'RESTINCLIERES', 624508369, 'toussaint.ines@fakemail.com', '1968-06-20', 15400, 'RIOM ES MONTAGNE', '2003-04-01', 2, 1),
(29, 'Leleu', '', 'Bruno', 1770509160048, 90, '130 Boulevard Adolphe-Pinard', 34570, 'PIGNAN', 644115007, 'leleu.bruno@fakemail.com', '1977-05-28', 9300, 'LAVELANET', '2004-10-06', 1, 1),
(30, 'Flament', 'Jacquemin', 'Léane', 2790715014049, 20, 'Villa Gabriel', 34190, 'GANGES', 689180761, 'flament.leane@fakemail.com', '1979-07-10', 15000, 'AURILLAC', '2005-03-09', 2, 2),
(31, 'Lacoste', 'Michaud', 'Agathe', 2770834199022, 15, '43 Rue Censier', 34070, 'MONTPELLIER', 656805937, 'lacoste.agathe@fakemail.com', '1977-08-17', 34120, 'PEZENAS', '2005-07-08', 2, 2),
(32, 'Blanchard', '', 'Antoine', 1560583137322, 22, 'Villa Hallé', 34170, 'CASTELNAU LE LEZ', 639101021, 'blanchard.antoine@fakemail.com', '1956-05-31', 83000, 'TOULON', '2008-02-02', 1, 2),
(33, 'Tellier', '', 'Margaux', 2810590010048, 23, '180 Rue Belidor', 34080, 'MONTPELLIER', 622370575, 'tellier.margaux@fakemail.com', '1981-05-06', 90000, 'BELFORT', '2008-12-19', 2, 1),
(34, 'Pereira', '', 'Victor', 1560124322060, 46, '122 Rue Gassendi', 34150, 'ST JEAN DE FOS', 612910793, 'pereira.victor@fakemail.com', '1956-01-15', 24000, 'PERIGUEUX', '2009-04-30', 1, 1),
(35, 'Pruvost', '', 'Carla', 2831113103026, 11, '195 Rue Balny-d\'Avricourt', 34280, 'LA GRANDE MOTTE', 633039740, 'pruvost.carla@fakemail.com', '1983-11-15', 13300, 'SALON DE PROVENCE', '2010-02-10', 2, 1),
(36, 'Schmitt', '', 'Lana', 2580930007014, 48, '163 Avenue du Général-Maistre', 34170, 'CASTELNAU LE LEZ', 632856417, 'schmitt.lana@fakemail.com', '1958-09-06', 30000, 'ALES', '2011-07-12', 2, 1),
(37, 'Perez', 'Fabre', 'Fanny', 2800181163012, 62, '121 Avenue de l\'Ermitage', 34570, 'MONTARNAUD', 635561263, 'perez.fanny@fakemail.com', '1980-01-01', 81200, 'MAZAMET', '2012-01-13', 2, 2),
(38, 'Le goff', '', 'Elsa', 2831295210011, 50, '116 Avenue du Général-Dodds', 34070, 'MONTPELLIER', 672626590, 'le goff.elsa@fakemail.com', '1983-12-01', 95880, 'ENGHIEN LES BAINS', '2013-04-27', 2, 1),
(39, 'Guillou', '', 'Anthony', 1551275073140, 76, '197 Rue de Florence', 34730, 'PRADES LE LEZ', 680076910, 'guillou.anthony@fakemail.com', '1955-12-23', 92150, 'SURESNES', '2015-07-29', 1, 1),
(40, 'Etienne', '', 'Ethan', 1700912145014, 27, '152 Avenue du Général-Sarrail', 34160, 'CASTRIES', 699453084, 'etienne.ethan@fakemail.com', '1970-09-06', 12100, 'MILLAU', '2015-07-30', 1, 2),
(41, 'Roques', '', 'Angelina', 2870104209019, 23, '143 Rue du Général-Archinard', 34090, 'MONTPELLIER', 692155756, 'roques.angelina@fakemail.com', '1987-01-26', 4200, 'SISTERON', '2015-11-24', 2, 1),
(42, 'Pons', '', 'Eléna', 2850934172468, 3, '146 Boulevard des Frères-Voisin', 34070, 'MONTPELLIER', 647011831, 'pons.elena@fakemail.com', '1985-09-29', 34000, 'MONTPELLIER', '2016-03-05', 2, 1),
(43, 'Jacquemin', 'Moreno', 'Emma', 2680792012167, 71, '3 Rue Chambiges', 34830, 'CLAPIERS', 620851581, 'jacquemin.emma@fakemail.com', '1968-07-22', 92100, 'BOULOGNE BILLANCOURT', '2016-03-25', 2, 2),
(44, 'Briand', '', 'Valentine', 2880684087082, 36, '107 Rue Danielle-Casanova', 34230, 'SAINT PARGOIRE', 673107827, 'briand.valentine@fakemail.com', '1988-06-18', 84100, 'ORANGE', '2016-09-02', 2, 1),
(45, 'Mary', '', 'Sara', 2620721464058, 83, '138 Rue de Babylone', 34190, 'GANGES', 601929932, 'mary.sara@fakemail.com', '1962-07-09', 21700, 'NUITS ST GEORGES', '2017-02-01', 2, 1),
(46, 'Lejeune', 'Leblanc', 'Eloïse', 2690982121063, 68, '195 Rue du Capitaine-Olchanski', 34080, 'MONTPELLIER', 650308880, 'lejeune.eloise@fakemail.com', '1969-09-17', 82000, 'MONTAUBAN', '2017-02-21', 2, 2),
(47, 'Renard', '', 'Benjamin', 1940660159410, 86, '40 Rue Frédéric-Brunet', 34090, 'MONTPELLIER', 698139890, 'renard.benjamin@fakemail.com', '1994-06-22', 60200, 'COMPIEGNE', '2018-05-17', 1, 1),
(48, 'Lopes', '', 'Guillaume', 1690634172111, 79, '186 Passage Dagorno', 34170, 'CASTELNAU LE LEZ', 632929187, 'lopes.guillaume@fakemail.com', '1969-06-09', 34000, 'MONTPELLIER', '2018-06-17', 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `service`
--

CREATE TABLE `service` (
  `service_id` int(11) NOT NULL,
  `service_nom` varchar(50) NOT NULL,
  `etab_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `situation_familiale`
--

CREATE TABLE `situation_familiale` (
  `fam_id` int(11) NOT NULL,
  `fam_libelle` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `situation_familiale`
--

INSERT INTO `situation_familiale` (`fam_id`, `fam_libelle`) VALUES
(1, 'Célibataire'),
(2, 'Marié(e)'),
(3, 'Divorcé(e)'),
(4, 'Veuf(ve)'),
(5, 'Séparé(e)'),
(6, 'PACS'),
(7, 'Union libre');

-- --------------------------------------------------------

--
-- Structure de la table `type_absence`
--

CREATE TABLE `type_absence` (
  `type_abs_id` int(11) NOT NULL,
  `type_abs_libelle_court` varchar(15) NOT NULL,
  `type_abs_libelle` varchar(50) NOT NULL,
  `type_abs_format` varchar(50) NOT NULL COMMENT 'Valorisé en heures ou en jours',
  `type_abs_statut` varchar(250) NOT NULL COMMENT 'Enum (Absences, Conges)'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `utilisateur_id` int(11) NOT NULL,
  `utilisateur_identifiant` varchar(25) NOT NULL,
  `utilisateur_mdp` varchar(25) NOT NULL,
  `salarie_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`utilisateur_id`, `utilisateur_identifiant`, `utilisateur_mdp`, `salarie_id`) VALUES
(1, 'f.caron', 'vjmEW434', 1),
(2, 'a.merle', 'd2gK64eR', 2),
(3, 'a.maire', 'DJ764fsy', 3),
(4, 's.fortin', '5Pf8iAb5', 4),
(5, 'a.chevalier', 'd2wjL89T', 5),
(6, 'a.auger', 'e2z82ZaH', 6),
(7, 'b.louis', 'xKP73gb8', 7),
(8, 'a.robin', 'b9C9fe4B', 8),
(9, 'p.munoz', 'uD7et7U5', 9),
(10, 'c.blin', '8wC8qe9J', 10),
(11, 'g.fischer', 'cDW6i23k', 11),
(12, 'a.leconte', '85Rx3sxB', 12),
(13, 'd.andre', 'P24gc2Yf', 13),
(14, 'a.pottier', '6pwEQ5w3', 14),
(15, 'e.fouquet', '6p9Jf7Yd', 15),
(16, 'm.hebert', '2zwNL96j', 16),
(17, 'n.renault', 'dL8Hvn57', 17),
(18, 'f.caron', '54jbTt8B', 18),
(19, 'e.le roux', 'QFj3y84n', 19),
(20, 'm.vasseur', 'ezW2w4A8', 20),
(21, 'm.le', 'PjM9e53z', 21),
(22, 'g.morvan', 'a8xa6W2B', 22),
(23, 'l.denis', 'WMh2ip98', 23),
(24, 'l.peron', '23w7kVEi', 24),
(25, 'a.serre', '8kX7A8zk', 25),
(26, 'l.tanguy', '3d3vQ2nC', 26),
(27, 'a.leon', '467gNeMj', 27),
(28, 'i.toussaint', '22b7NPut', 28),
(29, 'b.leleu', 'T8e45zCv', 29),
(30, 'l.flament', 'i89u6BvW', 30),
(31, 'a.lacoste', '6sYaAz42', 31),
(32, 'a.blanchard', 'a4KR2sb8', 32),
(33, 'm.tellier', 'Qp4V8k3s', 33),
(34, 'v.pereira', 'd95zQVm4', 34),
(35, 'c.pruvost', 'u4Bd55uE', 35),
(36, 'l.schmitt', 'iJ8cm7E6', 36),
(37, 'f.perez', '3a2M2ygQ', 37),
(38, 'e.le goff', 'kLA83dw6', 38),
(39, 'a.guillou', 'zHP9tn28', 39),
(40, 'e.etienne', 'T4cr6Gm9', 40),
(41, 'a.roques', '73cMTsf4', 41),
(42, 'e.pons', 'M4q6Dc2j', 42),
(43, 'e.jacquemin', 'mm3EX84t', 43),
(44, 'v.briand', '7Rr47Vgb', 44),
(45, 's.mary', 'm87GNn8g', 45),
(46, 'e.lejeune', 'v2d97SMc', 46),
(47, 'b.renard', 'mcUw35W9', 47),
(48, 'g.lopes', 'h2Rd43Yx', 48);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur__role`
--

CREATE TABLE `utilisateur__role` (
  `role_id` int(11) NOT NULL,
  `utilisateur_id` int(11) NOT NULL,
  `utilisateur_role_date_debut` date NOT NULL,
  `utilisateur_role_date_fin` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur__role`
--

INSERT INTO `utilisateur__role` (`role_id`, `utilisateur_id`, `utilisateur_role_date_debut`, `utilisateur_role_date_fin`) VALUES
(2, 1, '2018-01-01', NULL),
(2, 2, '2018-01-01', NULL),
(2, 3, '2018-01-01', NULL),
(2, 4, '2018-01-01', NULL),
(2, 5, '2018-01-01', NULL),
(2, 6, '2018-01-01', NULL),
(2, 7, '2018-01-01', NULL),
(2, 8, '2018-01-01', NULL),
(2, 9, '2018-01-01', NULL),
(2, 10, '2018-01-01', NULL),
(2, 11, '2018-01-01', NULL),
(2, 12, '2018-01-01', NULL),
(2, 13, '2018-01-01', NULL),
(2, 14, '2018-01-01', NULL),
(2, 15, '2018-01-01', NULL),
(2, 16, '2018-01-01', NULL),
(2, 17, '2018-01-01', NULL),
(2, 18, '2018-01-01', NULL),
(2, 19, '2018-01-01', NULL),
(2, 20, '2018-01-01', NULL),
(2, 21, '2018-01-01', NULL),
(2, 22, '2018-01-01', NULL),
(2, 23, '2018-01-01', NULL),
(2, 24, '2018-01-01', NULL),
(2, 25, '2018-01-01', NULL),
(2, 26, '2018-01-01', NULL),
(2, 27, '2018-01-01', NULL),
(2, 28, '2018-01-01', NULL),
(2, 29, '2018-01-01', NULL),
(2, 30, '2018-01-01', NULL),
(2, 31, '2018-01-01', NULL),
(2, 32, '2018-01-01', NULL),
(2, 33, '2018-01-01', NULL),
(2, 34, '2018-01-01', NULL),
(2, 35, '2018-01-01', NULL),
(2, 36, '2018-01-01', NULL),
(2, 37, '2018-01-01', NULL),
(2, 38, '2018-01-01', NULL),
(2, 39, '2018-01-01', NULL),
(2, 40, '2018-01-01', NULL),
(2, 41, '2018-01-01', NULL),
(2, 42, '2018-01-01', NULL),
(2, 43, '2018-01-01', NULL),
(2, 44, '2018-01-01', NULL),
(2, 45, '2018-01-01', NULL),
(2, 46, '2018-01-01', NULL),
(2, 47, '2018-01-01', NULL),
(2, 48, '2018-01-01', NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `absence`
--
ALTER TABLE `absence`
  ADD PRIMARY KEY (`absence_id`),
  ADD KEY `ABSENCE_TYPE_ABSENCE_FK` (`type_abs_id`),
  ADD KEY `fk_absence_contrat1_idx` (`contrat_contrat_id`);

--
-- Index pour la table `civilite`
--
ALTER TABLE `civilite`
  ADD PRIMARY KEY (`civilite_id`);

--
-- Index pour la table `conges`
--
ALTER TABLE `conges`
  ADD PRIMARY KEY (`absence_id`,`conges_id`),
  ADD KEY `CONGES_TYPE_ABSENCE0_FK` (`type_abs_id`);

--
-- Index pour la table `conges__periodes_conges`
--
ALTER TABLE `conges__periodes_conges`
  ADD PRIMARY KEY (`periode_id`,`absence_id`,`conges_id`),
  ADD KEY `conges__periodes_conges_CONGES0_FK` (`absence_id`,`conges_id`);

--
-- Index pour la table `contrat`
--
ALTER TABLE `contrat`
  ADD PRIMARY KEY (`contrat_id`),
  ADD KEY `CONTRAT_SALARIE_FK` (`salarie_id`),
  ADD KEY `CONTRAT_NATURE_CONTRAT0_FK` (`nature_ctr_id`),
  ADD KEY `CONTRAT_EMPLOI1_FK` (`emploi_id`);

--
-- Index pour la table `contrat__service`
--
ALTER TABLE `contrat__service`
  ADD PRIMARY KEY (`contrat_id`,`service_id`),
  ADD KEY `contrat__service_SERVICE0_FK` (`service_id`);

--
-- Index pour la table `emploi`
--
ALTER TABLE `emploi`
  ADD PRIMARY KEY (`emploi_id`);

--
-- Index pour la table `etablissement`
--
ALTER TABLE `etablissement`
  ADD PRIMARY KEY (`etab_id`);

--
-- Index pour la table `nature_contrat`
--
ALTER TABLE `nature_contrat`
  ADD PRIMARY KEY (`nature_ctr_id`);

--
-- Index pour la table `periodes_conges`
--
ALTER TABLE `periodes_conges`
  ADD PRIMARY KEY (`periode_id`);

--
-- Index pour la table `planning`
--
ALTER TABLE `planning`
  ADD PRIMARY KEY (`planning_id`),
  ADD KEY `PLANNING_CONTRAT_FK` (`contrat_id`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Index pour la table `salarie`
--
ALTER TABLE `salarie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `SALARIE_CIVILITE_FK` (`civilite_id`),
  ADD KEY `SALARIE_SITUATION_FAMILIALE0_FK` (`fam_id`);

--
-- Index pour la table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`service_id`),
  ADD KEY `SERVICE_ETABLISSEMENT_FK` (`etab_id`);

--
-- Index pour la table `situation_familiale`
--
ALTER TABLE `situation_familiale`
  ADD PRIMARY KEY (`fam_id`);

--
-- Index pour la table `type_absence`
--
ALTER TABLE `type_absence`
  ADD PRIMARY KEY (`type_abs_id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`utilisateur_id`),
  ADD UNIQUE KEY `UTILISATEUR_SALARIE_AK` (`salarie_id`);

--
-- Index pour la table `utilisateur__role`
--
ALTER TABLE `utilisateur__role`
  ADD PRIMARY KEY (`role_id`,`utilisateur_id`),
  ADD KEY `utilisateur__role_UTILISATEUR0_FK` (`utilisateur_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `civilite`
--
ALTER TABLE `civilite`
  MODIFY `civilite_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `contrat`
--
ALTER TABLE `contrat`
  MODIFY `contrat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT pour la table `emploi`
--
ALTER TABLE `emploi`
  MODIFY `emploi_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT pour la table `etablissement`
--
ALTER TABLE `etablissement`
  MODIFY `etab_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `nature_contrat`
--
ALTER TABLE `nature_contrat`
  MODIFY `nature_ctr_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `periodes_conges`
--
ALTER TABLE `periodes_conges`
  MODIFY `periode_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `planning`
--
ALTER TABLE `planning`
  MODIFY `planning_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `salarie`
--
ALTER TABLE `salarie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT pour la table `service`
--
ALTER TABLE `service`
  MODIFY `service_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `situation_familiale`
--
ALTER TABLE `situation_familiale`
  MODIFY `fam_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `type_absence`
--
ALTER TABLE `type_absence`
  MODIFY `type_abs_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `utilisateur_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `absence`
--
ALTER TABLE `absence`
  ADD CONSTRAINT `ABSENCE_TYPE_ABSENCE_FK` FOREIGN KEY (`type_abs_id`) REFERENCES `type_absence` (`type_abs_id`),
  ADD CONSTRAINT `fk_absence_contrat1` FOREIGN KEY (`contrat_contrat_id`) REFERENCES `contrat` (`contrat_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `conges`
--
ALTER TABLE `conges`
  ADD CONSTRAINT `CONGES_ABSENCE_FK` FOREIGN KEY (`absence_id`) REFERENCES `absence` (`absence_id`),
  ADD CONSTRAINT `CONGES_TYPE_ABSENCE0_FK` FOREIGN KEY (`type_abs_id`) REFERENCES `type_absence` (`type_abs_id`);

--
-- Contraintes pour la table `conges__periodes_conges`
--
ALTER TABLE `conges__periodes_conges`
  ADD CONSTRAINT `conges__periodes_conges_CONGES0_FK` FOREIGN KEY (`absence_id`,`conges_id`) REFERENCES `conges` (`absence_id`, `conges_id`),
  ADD CONSTRAINT `conges__periodes_conges_PERIODES_CONGES_FK` FOREIGN KEY (`periode_id`) REFERENCES `periodes_conges` (`periode_id`);

--
-- Contraintes pour la table `contrat`
--
ALTER TABLE `contrat`
  ADD CONSTRAINT `CONTRAT_EMPLOI1_FK` FOREIGN KEY (`emploi_id`) REFERENCES `emploi` (`emploi_id`),
  ADD CONSTRAINT `CONTRAT_NATURE_CONTRAT0_FK` FOREIGN KEY (`nature_ctr_id`) REFERENCES `nature_contrat` (`nature_ctr_id`),
  ADD CONSTRAINT `CONTRAT_SALARIE_FK` FOREIGN KEY (`salarie_id`) REFERENCES `salarie` (`id`);

--
-- Contraintes pour la table `contrat__service`
--
ALTER TABLE `contrat__service`
  ADD CONSTRAINT `contrat__service_CONTRAT_FK` FOREIGN KEY (`contrat_id`) REFERENCES `contrat` (`contrat_id`),
  ADD CONSTRAINT `contrat__service_SERVICE0_FK` FOREIGN KEY (`service_id`) REFERENCES `service` (`service_id`);

--
-- Contraintes pour la table `planning`
--
ALTER TABLE `planning`
  ADD CONSTRAINT `PLANNING_CONTRAT_FK` FOREIGN KEY (`contrat_id`) REFERENCES `contrat` (`contrat_id`);

--
-- Contraintes pour la table `salarie`
--
ALTER TABLE `salarie`
  ADD CONSTRAINT `SALARIE_CIVILITE_FK` FOREIGN KEY (`civilite_id`) REFERENCES `civilite` (`civilite_id`),
  ADD CONSTRAINT `SALARIE_SITUATION_FAMILIALE0_FK` FOREIGN KEY (`fam_id`) REFERENCES `situation_familiale` (`fam_id`);

--
-- Contraintes pour la table `service`
--
ALTER TABLE `service`
  ADD CONSTRAINT `SERVICE_ETABLISSEMENT_FK` FOREIGN KEY (`etab_id`) REFERENCES `etablissement` (`etab_id`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `UTILISATEUR_SALARIE_FK` FOREIGN KEY (`salarie_id`) REFERENCES `salarie` (`id`);

--
-- Contraintes pour la table `utilisateur__role`
--
ALTER TABLE `utilisateur__role`
  ADD CONSTRAINT `utilisateur__role_ROLE_FK` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  ADD CONSTRAINT `utilisateur__role_UTILISATEUR0_FK` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`utilisateur_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
