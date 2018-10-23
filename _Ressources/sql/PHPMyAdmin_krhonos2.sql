-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  Dim 21 oct. 2018 à 16:51
-- Version du serveur :  10.1.33-MariaDB
-- Version de PHP :  7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES latin1 */;

--
-- Base de données :  `krhonos2`
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
  `absence_justifier` varchar(50) NOT NULL COMMENT 'ENUM: En attente, valide ou injustifie',
  `contrat_id` int(11) NOT NULL,
  `type_abs_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

CREATE TABLE `adresse` (
  `adresse_id` int(11) NOT NULL,
  `adresse_latitude` float NOT NULL,
  `adresse_longitude` float NOT NULL,
  `adresse_numero` int(11) NOT NULL,
  `adresse_complement` varchar(70) NOT NULL,
  `contact_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `candidat`
--

CREATE TABLE `candidat` (
  `personne_id` int(11) NOT NULL,
  `candidat_id` int(11) NOT NULL,
  `candiat_date_dispo` date NOT NULL,
  `personne_nom` varchar(35) NOT NULL,
  `personne_nom_naissance` varchar(35) NOT NULL,
  `personne_prenom` varchar(50) NOT NULL,
  `civilite_id` int(11) NOT NULL,
  `utilisateur_id` int(11) NOT NULL,
  `contact_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `civilite`
--

CREATE TABLE `civilite` (
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
-- Structure de la table `coefficient`
--

CREATE TABLE `coefficient` (
  `coefficient_id` int(11) NOT NULL,
  `coefficient_valeur` float NOT NULL,
  `coefficient_anciennete` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `coefficient`
--

INSERT INTO `coefficient` (`coefficient_id`, `coefficient_valeur`, `coefficient_anciennete`) VALUES
(1, 360, 0),
(2, 376, 1),
(3, 391, 3),
(4, 403, 5),
(5, 415, 7),
(6, 432, 10),
(7, 448, 13),
(8, 462, 16),
(9, 479, 20),
(10, 493, 24),
(11, 501, 28),
(12, 396, 0),
(13, 405, 1),
(14, 418, 3),
(15, 432, 5),
(16, 448, 7),
(17, 461, 10),
(18, 474, 13),
(19, 486, 16),
(20, 498, 20),
(21, 516, 24),
(22, 530, 28),
(23, 348, 0),
(24, 362, 1),
(25, 371, 3),
(26, 381, 5),
(27, 391, 7),
(28, 400, 10),
(29, 406, 13),
(30, 415, 16),
(31, 421, 20),
(32, 432, 24),
(33, 445, 28),
(34, 358, 0),
(35, 371, 1),
(36, 380, 3),
(37, 390, 5),
(38, 399, 7),
(39, 409, 10),
(40, 415, 13),
(41, 425, 16),
(42, 431, 20),
(43, 442, 24),
(44, 455, 28),
(45, 406, 0),
(46, 414, 1),
(47, 429, 3),
(48, 446, 5),
(49, 460, 7),
(50, 473, 10),
(51, 486, 13),
(52, 499, 16),
(53, 511, 20),
(54, 528, 24),
(55, 544, 28),
(56, 870, 0),
(57, 896.1, 3),
(58, 922.2, 6),
(59, 948.3, 9),
(60, 974.4, 12),
(61, 1000.5, 15),
(62, 1026.6, 18),
(63, 1052.7, 21),
(64, 1078.8, 24),
(65, 1113.6, 28),
(66, 800, 0),
(67, 824, 3),
(68, 848, 6),
(69, 872, 9),
(70, 896, 12),
(71, 920, 15),
(72, 944, 18),
(73, 968, 21),
(74, 992, 24),
(75, 1024, 28),
(76, 850, 0),
(77, 875.5, 3),
(78, 901, 6),
(79, 926.5, 9),
(80, 952, 12),
(81, 977.5, 15),
(82, 1003, 18),
(83, 1028.5, 21),
(84, 1054, 24),
(85, 1088, 28),
(86, 770, 0),
(87, 793.1, 3),
(88, 816.2, 6),
(89, 839.3, 9),
(90, 862.4, 12),
(91, 885.5, 15),
(92, 908.6, 18),
(93, 931.7, 21),
(94, 954.8, 24),
(95, 985.6, 28),
(96, 720, 0),
(97, 741.6, 3),
(98, 763.2, 6),
(99, 784.8, 9),
(100, 806.4, 12),
(101, 828, 15),
(102, 849.6, 18),
(103, 871.2, 21),
(104, 892.8, 24),
(105, 921.6, 28),
(106, 680, 0),
(107, 700.4, 3),
(108, 720.8, 6),
(109, 741.2, 9),
(110, 761.6, 12),
(111, 782, 15),
(112, 802.4, 18),
(113, 822.8, 21),
(114, 843.2, 24),
(115, 870.4, 28),
(116, 1000, 0),
(117, 1030, 3),
(118, 1060, 6),
(119, 1090, 9),
(120, 1120, 12),
(121, 1150, 15),
(122, 1180, 18),
(123, 1210, 21),
(124, 1240, 24),
(125, 1280, 28),
(126, 603, 0),
(127, 638, 3),
(128, 673, 6),
(129, 708, 9),
(130, 748, 12),
(131, 783, 15),
(132, 818, 18),
(133, 578, 0),
(134, 613, 3),
(135, 648, 6),
(136, 683, 9),
(137, 713, 12),
(138, 753, 15),
(139, 783, 18),
(140, 553, 0),
(141, 583, 3),
(142, 618, 6),
(143, 653, 9),
(144, 683, 12),
(145, 718, 15),
(146, 753, 18),
(147, 577, 0),
(148, 598, 2),
(149, 622, 4),
(150, 653, 6),
(151, 686, 8),
(152, 720, 10),
(153, 755, 14),
(154, 789, 18),
(155, 592, 0),
(156, 614, 2),
(157, 640, 4),
(158, 670, 6),
(159, 708, 8),
(160, 743, 10),
(161, 779, 14),
(162, 814, 18),
(163, 446, 0),
(164, 459, 1),
(165, 491, 3),
(166, 517, 5),
(167, 552, 7),
(168, 586, 9),
(169, 597, 11),
(170, 632, 14),
(171, 665, 17),
(172, 698, 20),
(173, 735, 24),
(174, 783, 28),
(175, 393, 0),
(176, 407, 1),
(177, 423, 3),
(178, 447, 5),
(179, 462, 7),
(180, 481, 9),
(181, 501, 11),
(182, 516, 13),
(183, 528, 16),
(184, 557, 19),
(185, 421, 0),
(186, 434, 1),
(187, 450, 2),
(188, 464, 3),
(189, 476, 5),
(190, 493, 7),
(191, 513, 9),
(192, 525, 12),
(193, 539, 15),
(194, 568, 18),
(195, 600, 21),
(196, 630, 24),
(197, 665, 28),
(198, 368, 0),
(199, 384, 1),
(200, 400, 3),
(201, 411, 5),
(202, 425, 7),
(203, 442, 10),
(204, 458, 13),
(205, 472, 16),
(206, 489, 20),
(207, 504, 24),
(208, 512, 28),
(209, 497, 0),
(210, 537, 1),
(211, 565, 2),
(212, 597, 3),
(213, 629, 5),
(214, 669, 8),
(215, 709, 11),
(216, 760, 14),
(217, 811, 17),
(218, 875, 20),
(219, 940, 24),
(220, 454, 0),
(221, 467, 1),
(222, 498, 3),
(223, 523, 5),
(224, 557, 7),
(225, 590, 9),
(226, 601, 11),
(227, 635, 14),
(228, 667, 17),
(229, 699, 20),
(230, 735, 24),
(231, 782, 28),
(232, 466, 0),
(233, 479, 1),
(234, 511, 3),
(235, 537, 5),
(236, 472, 7),
(237, 606, 9),
(238, 617, 11),
(239, 652, 14),
(240, 685, 17),
(241, 718, 20),
(242, 755, 24),
(243, 803, 28),
(244, 411, 0),
(245, 424, 1),
(246, 438, 2),
(247, 453, 3),
(248, 465, 5),
(249, 482, 7),
(250, 501, 9),
(251, 513, 12),
(252, 527, 15),
(253, 556, 18),
(254, 587, 21),
(255, 617, 24),
(256, 652, 28),
(257, 434, 0),
(258, 447, 1),
(259, 478, 3),
(260, 503, 5),
(261, 537, 7),
(262, 570, 9),
(263, 581, 11),
(264, 615, 14),
(265, 647, 17),
(266, 679, 20),
(267, 715, 24),
(268, 762, 28);

-- --------------------------------------------------------

--
-- Structure de la table `conges`
--

CREATE TABLE `conges` (
  `absence_id` int(11) NOT NULL,
  `conges_id` int(11) NOT NULL,
  `conges_pris` float NOT NULL,
  `conges_validation` varchar(50) NOT NULL COMMENT 'enum:  En attente, valide, refuse ou rejete',
  `absence_debut` datetime NOT NULL,
  `absence_fin` datetime NOT NULL,
  `absence_desciption` text,
  `absence_valorisation` float NOT NULL,
  `absence_justifier` varchar(50) NOT NULL COMMENT 'ENUM: En attente, valide ou injustifie',
  `periode_id` int(11) NOT NULL,
  `contrat_id` int(11) NOT NULL,
  `type_abs_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `contact`
--

CREATE TABLE `contact` (
  `contact_id` int(11) NOT NULL,
  `contact_telephone` varchar(10) NOT NULL,
  `contact_mail` varchar(50) NOT NULL,
  `etab_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `contact`
--

INSERT INTO `contact` (`contact_id`, `contact_telephone`, `contact_mail`, `etab_id`) VALUES
(1, '0655286709', 'caron.florian@fakemail.com', NULL),
(2, '0670058169', 'merle.adrian@fakemail.com', NULL),
(3, '0693832159', 'maire.alexis@fakemail.com', NULL),
(4, '0660755650', 'fortin.solene@fakemail.com', NULL),
(5, '0605324046', 'chevalier.agathe@fakemail.com', NULL),
(6, '0631563947', 'auger.alice@fakemail.com', NULL),
(7, '0601106285', 'louis.baptiste@fakemail.com', NULL),
(8, '0640944515', 'robin.anais@fakemail.com', NULL),
(9, '0643510146', 'munoz.pauline@fakemail.com', NULL),
(10, '0611511013', 'blin.clotilde@fakemail.com', NULL),
(11, '0691620872', 'fischer.gilbert@fakemail.com', NULL),
(12, '0628309330', 'leconte.alicia@fakemail.com', NULL),
(13, '0687056510', 'andre.dorian@fakemail.com', NULL),
(14, '0661166139', 'pottier.arthur@fakemail.com', NULL),
(15, '0666335367', 'fouquet.enzo@fakemail.com', NULL),
(16, '0674451670', 'hebert.manon@fakemail.com', NULL),
(17, '0639573663', 'renault.nicolas@fakemail.com', NULL),
(18, '0658297925', 'caron.fran?oise@fakemail.com', NULL),
(19, '0608179619', 'le roux.emilie@fakemail.com', NULL),
(20, '0651267626', 'vasseur.maxime@fakemail.com', NULL),
(21, '0621460129', 'le.mathis@fakemail.com', NULL),
(22, '0661931099', 'morvan.gaspard@fakemail.com', NULL),
(23, '0605218160', 'denis.lena@fakemail.com', NULL),
(24, '0603096905', 'peron.laura@fakemail.com', NULL),
(25, '0631995282', 'serre.amelie@fakemail.com', NULL),
(26, '0661052963', 'tanguy.lorenzo@fakemail.com', NULL),
(27, '0678639973', 'leon.ambre@fakemail.com', NULL),
(28, '0624508369', 'toussaint.ines@fakemail.com', NULL),
(29, '0644115007', 'leleu.bruno@fakemail.com', NULL),
(30, '0689180761', 'flament.leane@fakemail.com', NULL),
(31, '0656805937', 'lacoste.agathe@fakemail.com', NULL),
(32, '0639101021', 'blanchard.antoine@fakemail.com', NULL),
(33, '0622370575', 'tellier.margaux@fakemail.com', NULL),
(34, '0612910793', 'pereira.victor@fakemail.com', NULL),
(35, '0633039740', 'pruvost.carla@fakemail.com', NULL),
(36, '0632856417', 'schmitt.lana@fakemail.com', NULL),
(37, '0635561263', 'perez.fanny@fakemail.com', NULL),
(38, '0672626590', 'le goff.elsa@fakemail.com', NULL),
(39, '0680076910', 'guillou.anthony@fakemail.com', NULL),
(40, '0699453084', 'etienne.ethan@fakemail.com', NULL),
(41, '0692155756', 'roques.angelina@fakemail.com', NULL),
(42, '0647011831', 'pons.elena@fakemail.com', NULL),
(43, '0620851581', 'jacquemin.emma@fakemail.com', NULL),
(44, '0673107827', 'briand.valentine@fakemail.com', NULL),
(45, '0601929932', 'mary.sara@fakemail.com', NULL),
(46, '0650308880', 'lejeune.eloise@fakemail.com', NULL),
(47, '0698139890', 'renard.benjamin@fakemail.com', NULL),
(48, '0632929187', 'lopes.guillaume@fakemail.com', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `contrat`
--

CREATE TABLE `contrat` (
  `contrat_id` int(11) NOT NULL,
  `contrat_date_embauche` date NOT NULL,
  `contrat_date_fin` date DEFAULT NULL,
  `contrat_tps_travail` float(5,2) NOT NULL,
  `nature_ctr_id` int(11) NOT NULL,
  `personne_id` int(11) NOT NULL,
  `salarie_id` int(11) NOT NULL,
  `emploi_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `contrat`
--

INSERT INTO `contrat` (`contrat_id`, `contrat_date_embauche`, `contrat_date_fin`, `contrat_tps_travail`, `nature_ctr_id`, `personne_id`, `salarie_id`, `emploi_id`) VALUES
(1, '1990-09-21', NULL, 151.67, 1, 1, 1, 11),
(2, '2005-11-14', NULL, 121.34, 1, 2, 2, 17),
(3, '1998-03-04', NULL, 121.34, 1, 3, 3, 17),
(4, '1995-02-01', NULL, 151.67, 1, 4, 4, 20),
(5, '2004-03-18', NULL, 151.67, 1, 5, 5, 6),
(6, '1997-11-19', NULL, 151.67, 1, 6, 6, 22),
(7, '2000-08-08', NULL, 151.67, 1, 7, 7, 10),
(8, '2005-11-14', NULL, 121.34, 1, 8, 8, 11),
(9, '2014-02-24', NULL, 151.67, 1, 9, 9, 15),
(10, '2014-05-14', NULL, 75.84, 1, 10, 10, 17),
(11, '1990-01-13', NULL, 121.34, 1, 11, 11, 2),
(12, '1990-10-08', NULL, 75.84, 1, 12, 12, 11),
(13, '2007-01-09', NULL, 151.67, 1, 13, 13, 14),
(14, '1991-09-13', NULL, 121.34, 1, 14, 14, 17),
(15, '2002-04-21', NULL, 121.34, 1, 15, 15, 3),
(16, '2000-08-16', NULL, 151.67, 1, 16, 16, 4),
(17, '1999-08-06', NULL, 151.67, 1, 17, 17, 11),
(18, '2006-04-11', NULL, 75.84, 1, 18, 18, 3),
(19, '1997-02-02', NULL, 151.67, 1, 19, 19, 16),
(20, '1997-09-14', NULL, 151.67, 1, 20, 20, 7),
(21, '1997-12-28', NULL, 151.67, 1, 21, 21, 3),
(22, '1998-05-11', NULL, 75.84, 1, 22, 22, 23),
(23, '2001-02-05', NULL, 121.34, 1, 23, 23, 13),
(24, '2001-02-13', NULL, 151.67, 1, 24, 24, 4),
(25, '2001-11-20', NULL, 151.67, 1, 25, 25, 8),
(26, '2002-04-05', NULL, 121.34, 1, 26, 26, 17),
(27, '2009-02-27', NULL, 113.75, 1, 27, 27, 4),
(28, '2003-04-01', NULL, 151.67, 1, 28, 28, 19),
(29, '2004-10-06', NULL, 151.67, 1, 29, 29, 1),
(30, '2005-03-09', NULL, 75.84, 1, 30, 30, 15),
(31, '2005-07-08', NULL, 75.84, 1, 31, 31, 17),
(32, '2008-02-02', NULL, 151.67, 1, 32, 32, 15),
(33, '2008-12-19', NULL, 113.75, 1, 33, 33, 11),
(34, '2009-04-30', NULL, 75.84, 1, 34, 34, 23),
(35, '2010-02-10', NULL, 151.67, 1, 35, 35, 21),
(36, '2011-07-12', NULL, 151.67, 1, 36, 36, 9),
(37, '2012-01-13', NULL, 75.84, 1, 37, 37, 17),
(38, '2013-04-27', NULL, 151.67, 1, 38, 38, 5),
(39, '2015-07-29', NULL, 151.67, 1, 39, 39, 18),
(40, '2015-07-30', NULL, 75.84, 1, 40, 40, 23),
(41, '2015-11-24', NULL, 151.67, 1, 41, 41, 1),
(42, '2016-03-05', NULL, 75.84, 1, 42, 42, 11),
(43, '2016-03-25', NULL, 151.67, 1, 43, 43, 3),
(44, '2016-09-02', NULL, 151.67, 1, 44, 44, 21),
(45, '2017-02-01', NULL, 75.84, 1, 45, 45, 11),
(46, '2017-02-21', NULL, 151.67, 1, 46, 46, 7),
(47, '2018-05-17', NULL, 151.67, 1, 47, 47, 12),
(48, '2018-06-17', NULL, 151.67, 1, 48, 48, 6);

-- --------------------------------------------------------

--
-- Structure de la table `contrat__planning`
--

CREATE TABLE `contrat__planning` (
  `planning_id` int(11) NOT NULL,
  `contrat_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
-- Structure de la table `convention`
--

CREATE TABLE `convention` (
  `convention_id` int(11) NOT NULL,
  `convention_libelle` varchar(150) NOT NULL,
  `convention_valeur_point` float(4,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `convention`
--

INSERT INTO `convention` (`convention_id`, `convention_libelle`, `convention_valeur_point`) VALUES
(1, 'Convention collective nationale de travail des etablissements et services pour personnes inadaptées et handicapées du 15 mars 1966', 3.77);

-- --------------------------------------------------------

--
-- Structure de la table `diplome`
--

CREATE TABLE `diplome` (
  `diplome_id` int(11) NOT NULL,
  `diplome_libelle` varchar(50) NOT NULL,
  `diplome_obtention` tinyint(1) NOT NULL,
  `diplome_annee_obtention` varchar(4) NOT NULL,
  `personne_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `documents`
--

CREATE TABLE `documents` (
  `documents_id` int(11) NOT NULL,
  `documents_rib` varchar(80) NOT NULL,
  `documents_secu` varchar(80) NOT NULL,
  `personne_id` int(11) NOT NULL,
  `salarie_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `doc_diplome`
--

CREATE TABLE `doc_diplome` (
  `doc_diplome_id` int(11) NOT NULL,
  `doc_diplome_adresse` varchar(80) NOT NULL,
  `diplome_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `emploi`
--

CREATE TABLE `emploi` (
  `emploi_id` int(11) NOT NULL,
  `emploi_libelle` varchar(70) NOT NULL,
  `emploi_cadre` tinyint(1) NOT NULL,
  `convention_id` int(11) NOT NULL,
  `grille_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `emploi`
--

INSERT INTO `emploi` (`emploi_id`, `emploi_libelle`, `emploi_cadre`, `convention_id`, `grille_id`) VALUES
(1, 'Agent de service intérieur', 0, 1, 1),
(2, 'Agent technique supérieur', 0, 1, 8),
(3, 'Aide médico-psychologique', 0, 1, 6),
(4, 'Aide-soignant', 0, 1, 6),
(5, 'Auxiliaire de vie sociale', 0, 1, 6),
(6, 'Chef de service', 1, 1, 16),
(7, 'Chef de service éducatif', 1, 1, 16),
(8, 'Comptable 1ere classe', 0, 1, 10),
(9, 'Directeur', 1, 1, 23),
(10, 'Directeur général', 1, 1, 26),
(11, 'Educateur spécialisé', 0, 1, 10),
(12, 'Educateur sportif', 0, 1, 10),
(13, 'Ergothérapeute', 0, 1, 10),
(14, 'Gestionnaire de paie', 0, 1, 10),
(15, 'Infirmier', 0, 1, 10),
(16, 'Kinésithérapeute', 0, 1, 10),
(17, 'Moniteur-éducateur', 0, 1, 8),
(18, 'Psychologue', 1, 1, 14),
(19, 'Directeur administratifs et financiers', 1, 1, 25),
(20, 'Directeur des ressources humaines', 1, 1, 25),
(21, 'Secrétaire d\'accueil', 0, 1, 8),
(22, 'Secrétaire de direction', 0, 1, 10),
(23, 'Surveillant de nuit', 0, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `emploi__taux_charges`
--

CREATE TABLE `emploi__taux_charges` (
  `emploi_id` int(11) NOT NULL,
  `tx_charges_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `emploi__taux_charges`
--

INSERT INTO `emploi__taux_charges` (`emploi_id`, `tx_charges_id`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 2),
(7, 2),
(8, 1),
(9, 2),
(10, 2),
(11, 1),
(12, 1),
(13, 1),
(14, 1),
(15, 1),
(16, 1),
(17, 1),
(18, 2),
(19, 2),
(20, 2),
(21, 1),
(22, 1),
(23, 1);

-- --------------------------------------------------------

--
-- Structure de la table `etablissement`
--

CREATE TABLE `etablissement` (
  `etab_id` int(11) NOT NULL,
  `etab_nom` varchar(35) NOT NULL,
  `etab_siret` bigint(20) NOT NULL,
  `convention_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etablissement`
--

INSERT INTO `etablissement` (`etab_id`, `etab_nom`, `etab_siret`, `convention_id`) VALUES
(1, ' 	SIEGE SOCIAL', 74891735739628, 1),
(2, ' 	IME LES HIRONDELLES', 74855712483081, 1);

-- --------------------------------------------------------

--
-- Structure de la table `experience`
--

CREATE TABLE `experience` (
  `experience_id` int(11) NOT NULL,
  `experience_nom_entreprise` varchar(50) NOT NULL,
  `experience_date_debut` date NOT NULL,
  `experience_date_fin` date NOT NULL,
  `experience_descriptif` text NOT NULL,
  `personne_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `grille`
--

CREATE TABLE `grille` (
  `grille_id` int(11) NOT NULL,
  `grille_libelle` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `grille`
--

INSERT INTO `grille` (`grille_id`, `grille_libelle`) VALUES
(1, 'GRILLE START TO 348 FINISH TO 445'),
(2, 'GRILLE START TO 358 FINISH TO 455'),
(3, 'GRILLE START TO 360 FINISH TO 501'),
(4, 'GRILLE START TO 368 FINISH TO 512'),
(5, 'GRILLE START TO 393 FINISH TO 557'),
(6, 'GRILLE START TO 396 FINISH TO 530'),
(7, 'GRILLE START TO 406 FINISH TO 544'),
(8, 'GRILLE START TO 411 FINISH TO 652'),
(9, 'GRILLE START TO 421 FINISH TO 665'),
(10, 'GRILLE START TO 434 FINISH TO 762'),
(11, 'GRILLE START TO 446 FINISH TO 783'),
(12, 'GRILLE START TO 454 FINISH TO 782'),
(13, 'GRILLE START TO 466 FINISH TO 803'),
(14, 'GRILLE START TO 497 FINISH TO 940'),
(15, 'GRILLE START TO 553 FINISH TO 753'),
(16, 'GRILLE START TO 577 FINISH TO 789'),
(17, 'GRILLE START TO 578 FINISH TO 783'),
(18, 'GRILLE START TO 592 FINISH TO 814'),
(19, 'GRILLE START TO 603 FINISH TO 818'),
(20, 'GRILLE START TO 680 FINISH TO 870.4'),
(21, 'GRILLE START TO 720 FINISH TO 921.6'),
(22, 'GRILLE START TO 770 FINISH TO 985.6'),
(23, 'GRILLE START TO 800 FINISH TO 1024'),
(24, 'GRILLE START TO 850 FINISH TO 1088'),
(25, 'GRILLE START TO 870 FINISH TO 1113.6'),
(26, 'GRILLE START TO 1000 FINISH TO 1280');

-- --------------------------------------------------------

--
-- Structure de la table `grille__coefficient`
--

CREATE TABLE `grille__coefficient` (
  `coefficient_id` int(11) NOT NULL,
  `grille_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `grille__coefficient`
--

INSERT INTO `grille__coefficient` (`coefficient_id`, `grille_id`) VALUES
(1, 3),
(2, 3),
(3, 3),
(4, 3),
(5, 3),
(6, 3),
(7, 3),
(8, 3),
(9, 3),
(10, 3),
(11, 3),
(12, 6),
(13, 6),
(14, 6),
(15, 6),
(16, 6),
(17, 6),
(18, 6),
(19, 6),
(20, 6),
(21, 6),
(22, 6),
(23, 1),
(24, 1),
(25, 1),
(26, 1),
(27, 1),
(28, 1),
(29, 1),
(30, 1),
(31, 1),
(32, 1),
(33, 1),
(34, 2),
(35, 2),
(36, 2),
(37, 2),
(38, 2),
(39, 2),
(40, 2),
(41, 2),
(42, 2),
(43, 2),
(44, 2),
(45, 7),
(46, 7),
(47, 7),
(48, 7),
(49, 7),
(50, 7),
(51, 7),
(52, 7),
(53, 7),
(54, 7),
(55, 7),
(56, 25),
(57, 25),
(58, 25),
(59, 25),
(60, 25),
(61, 25),
(62, 25),
(63, 25),
(64, 25),
(65, 25),
(66, 23),
(67, 23),
(68, 23),
(69, 23),
(70, 23),
(71, 23),
(72, 23),
(73, 23),
(74, 23),
(75, 23),
(76, 24),
(77, 24),
(78, 24),
(79, 24),
(80, 24),
(81, 24),
(82, 24),
(83, 24),
(84, 24),
(85, 24),
(86, 22),
(87, 22),
(88, 22),
(89, 22),
(90, 22),
(91, 22),
(92, 22),
(93, 22),
(94, 22),
(95, 22),
(96, 21),
(97, 21),
(98, 21),
(99, 21),
(100, 21),
(101, 21),
(102, 21),
(103, 21),
(104, 21),
(105, 21),
(106, 20),
(107, 20),
(108, 20),
(109, 20),
(110, 20),
(111, 20),
(112, 20),
(113, 20),
(114, 20),
(115, 20),
(116, 26),
(117, 26),
(118, 26),
(119, 26),
(120, 26),
(121, 26),
(122, 26),
(123, 26),
(124, 26),
(125, 26),
(126, 19),
(127, 19),
(128, 19),
(129, 19),
(130, 19),
(131, 19),
(132, 19),
(133, 17),
(134, 17),
(135, 17),
(136, 17),
(137, 17),
(138, 17),
(139, 17),
(140, 15),
(141, 15),
(142, 15),
(143, 15),
(144, 15),
(145, 15),
(146, 15),
(147, 16),
(148, 16),
(149, 16),
(150, 16),
(151, 16),
(152, 16),
(153, 16),
(154, 16),
(155, 18),
(156, 18),
(157, 18),
(158, 18),
(159, 18),
(160, 18),
(161, 18),
(162, 18),
(163, 11),
(164, 11),
(165, 11),
(166, 11),
(167, 11),
(168, 11),
(169, 11),
(170, 11),
(171, 11),
(172, 11),
(173, 11),
(173, 12),
(174, 11),
(175, 5),
(176, 5),
(177, 5),
(178, 5),
(179, 5),
(180, 5),
(181, 5),
(182, 5),
(183, 5),
(184, 5),
(185, 9),
(186, 9),
(187, 9),
(188, 9),
(189, 9),
(190, 9),
(191, 9),
(192, 9),
(193, 9),
(194, 9),
(195, 9),
(196, 9),
(197, 9),
(198, 4),
(199, 4),
(200, 4),
(201, 4),
(202, 4),
(203, 4),
(204, 4),
(205, 4),
(206, 4),
(207, 4),
(208, 4),
(209, 14),
(210, 14),
(211, 14),
(212, 14),
(213, 14),
(214, 14),
(215, 14),
(216, 14),
(217, 14),
(218, 14),
(219, 14),
(220, 12),
(221, 12),
(222, 12),
(223, 12),
(224, 12),
(225, 12),
(226, 12),
(227, 12),
(228, 12),
(229, 12),
(231, 12),
(232, 13),
(233, 13),
(234, 13),
(235, 13),
(236, 13),
(237, 13),
(238, 13),
(239, 13),
(240, 13),
(241, 13),
(242, 13),
(243, 13),
(244, 8),
(245, 8),
(246, 8),
(247, 8),
(248, 8),
(249, 8),
(250, 8),
(251, 8),
(252, 8),
(253, 8),
(254, 8),
(255, 8),
(256, 8),
(257, 10),
(258, 10),
(259, 10),
(260, 10),
(261, 10),
(262, 10),
(263, 10),
(264, 10),
(265, 10),
(266, 10),
(267, 10),
(268, 10);

-- --------------------------------------------------------

--
-- Structure de la table `justificatif`
--

CREATE TABLE `justificatif` (
  `justificatif_id` int(11) NOT NULL,
  `justificatif_adresse` varchar(80) NOT NULL,
  `absence_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
-- Structure de la table `periode_conges`
--

CREATE TABLE `periode_conges` (
  `periode_id` int(11) NOT NULL,
  `periode_debut` date NOT NULL,
  `periode_fin` date NOT NULL,
  `periode_acquisition` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `personne_id` int(11) NOT NULL,
  `personne_nom` varchar(35) NOT NULL,
  `personne_nom_naissance` varchar(35) NOT NULL,
  `personne_prenom` varchar(50) NOT NULL,
  `civilite_id` int(11) NOT NULL,
  `utilisateur_id` int(11) NOT NULL,
  `contact_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`personne_id`, `personne_nom`, `personne_nom_naissance`, `personne_prenom`, `civilite_id`, `utilisateur_id`, `contact_id`) VALUES
(1, 'Caron', '', 'Florian', 1, 1, 1),
(2, 'Merle', '', 'Adrian', 1, 2, 2),
(3, 'Maire', '', 'Alexis', 1, 3, 3),
(4, 'Fortin', 'Dumont', 'Solene', 2, 4, 4),
(5, 'Chevalier', 'Cornu', 'Agathe', 2, 5, 5),
(6, 'Auger', '', 'Alice', 2, 6, 6),
(7, 'Louis', '', 'Baptiste', 1, 7, 7),
(8, 'Robin', '', 'Anaïs', 2, 8, 8),
(9, 'Munoz', '', 'Pauline', 2, 9, 9),
(10, 'Blin', 'Baron', 'Clotilde', 2, 10, 10),
(11, 'Fischer', '', 'Gilbert', 1, 11, 11),
(12, 'Leconte', '', 'Alicia', 2, 12, 12),
(13, 'Andre', '', 'Dorian', 1, 13, 13),
(14, 'Pottier', '', 'Arthur', 1, 14, 14),
(15, 'Fouquet', '', 'Enzo', 1, 15, 15),
(16, 'Hebert', '', 'Manon', 2, 16, 16),
(17, 'Renault', '', 'Nicolas', 1, 17, 17),
(18, 'Caron', '', 'Françoise', 2, 18, 18),
(19, 'Le roux', 'Marie', 'Emilie', 2, 19, 19),
(20, 'Vasseur', '', 'Maxime', 1, 20, 20),
(21, 'Le', '', 'Mathis', 1, 21, 21),
(22, 'Morvan', '', 'Gaspard', 1, 22, 22),
(23, 'Denis', '', 'Lena', 2, 23, 23),
(24, 'Peron', '', 'Laura', 2, 24, 24),
(25, 'Serre', 'Gillet', 'Amélie', 2, 25, 25),
(26, 'Tanguy', '', 'Lorenzo', 1, 26, 26),
(27, 'Leon', 'Louis', 'Ambre', 2, 27, 27),
(28, 'Toussaint', '', 'Inès', 2, 28, 28),
(29, 'Leleu', '', 'Bruno', 1, 29, 29),
(30, 'Flament', 'Jacquemin', 'Léane', 2, 30, 30),
(31, 'Lacoste', 'Michaud', 'Agathe', 2, 31, 31),
(32, 'Blanchard', '', 'Antoine', 1, 32, 32),
(33, 'Tellier', '', 'Margaux', 2, 33, 33),
(34, 'Pereira', '', 'Victor', 1, 34, 34),
(35, 'Pruvost', '', 'Carla', 2, 35, 35),
(36, 'Schmitt', '', 'Lana', 2, 36, 36),
(37, 'Perez', 'Fabre', 'Fanny', 2, 37, 37),
(38, 'Le goff', '', 'Elsa', 2, 38, 38),
(39, 'Guillou', '', 'Anthony', 1, 39, 39),
(40, 'Etienne', '', 'Ethan', 1, 40, 40),
(41, 'Roques', '', 'Angelina', 2, 41, 41),
(42, 'Pons', '', 'Eléna', 2, 42, 42),
(43, 'Jacquemin', 'Moreno', 'Emma', 2, 43, 43),
(44, 'Briand', '', 'Valentine', 2, 44, 44),
(45, 'Mary', '', 'Sara', 2, 45, 45),
(46, 'Lejeune', 'Leblanc', 'Eloïse', 2, 46, 46),
(47, 'Renard', '', 'Benjamin', 1, 47, 47),
(48, 'Lopes', '', 'Guillaume', 1, 48, 48);

-- --------------------------------------------------------

--
-- Structure de la table `planning`
--

CREATE TABLE `planning` (
  `planning_id` int(11) NOT NULL,
  `planning_time_start` time NOT NULL,
  `planning_time_end` time NOT NULL,
  `planning_dow` int(11) NOT NULL,
  `planning_date_start` date NOT NULL,
  `planning_date_end` date NOT NULL,
  `planning_frequency` int(11) NOT NULL
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
(1, 'administrateur'),
(2, 'manager'),
(3, 'salarie'),
(4, 'candidat');

-- --------------------------------------------------------

--
-- Structure de la table `salarie`
--

CREATE TABLE `salarie` (
  `personne_id` int(11) NOT NULL,
  `salarie_id` int(11) NOT NULL,
  `salarie_num_secu` varchar(13) NOT NULL,
  `salarie_cle_secu` int(11) NOT NULL,
  `salarie_date_naissance` date NOT NULL,
  `personne_nom` varchar(35) NOT NULL,
  `personne_nom_naissance` varchar(35) NOT NULL,
  `personne_prenom` varchar(50) NOT NULL,
  `fam_id` int(11) DEFAULT NULL,
  `civilite_id` int(11) NOT NULL,
  `utilisateur_id` int(11) NOT NULL,
  `contact_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `salarie`
--

INSERT INTO `salarie` (`personne_id`, `salarie_id`, `salarie_num_secu`, `salarie_cle_secu`, `salarie_date_naissance`, `personne_nom`, `personne_nom_naissance`, `personne_prenom`, `fam_id`, `civilite_id`, `utilisateur_id`, `contact_id`) VALUES
(1, 1, '1700926362113', 24, '1970-09-17', 'Caron', '', 'Florian', 1, 1, 1, 1),
(2, 2, '1850754395020', 29, '1985-07-01', 'Merle', '', 'Adrian', 2, 1, 2, 2),
(3, 3, '1790794067030', 52, '1979-07-07', 'Maire', '', 'Alexis', 1, 1, 3, 3),
(4, 4, '2690460157190', 54, '1969-04-09', 'Fortin', 'Dumont', 'Solene', 2, 2, 4, 4),
(5, 5, '2790734172396', 46, '1979-07-28', 'Chevalier', 'Cornu', 'Agathe', 2, 2, 5, 5),
(6, 6, '2740929019131', 75, '1974-09-13', 'Auger', '', 'Alice', 1, 2, 6, 6),
(7, 7, '1620564102138', 20, '1962-05-26', 'Louis', '', 'Baptiste', 1, 1, 7, 7),
(8, 8, '2870230189229', 18, '1987-02-02', 'Robin', '', 'Anaïs', 1, 2, 8, 8),
(9, 9, '2821071475121', 27, '1982-10-30', 'Munoz', '', 'Pauline', 1, 2, 9, 9),
(10, 10, '2721169387030', 20, '1972-11-03', 'Blin', 'Baron', 'Clotilde', 2, 2, 10, 10),
(11, 11, '1650134172194', 15, '1965-01-18', 'Fischer', '', 'Gilbert', 1, 1, 11, 11),
(12, 12, '2720294080021', 78, '1972-02-13', 'Leconte', '', 'Alicia', 1, 2, 12, 12),
(13, 13, '1830381004079', 44, '1983-03-18', 'Andre', '', 'Dorian', 1, 1, 13, 13),
(14, 14, '1700865286015', 72, '1970-08-04', 'Pottier', '', 'Arthur', 2, 1, 14, 14),
(15, 15, '1800712202076', 61, '1980-07-13', 'Fouquet', '', 'Enzo', 2, 1, 15, 15),
(16, 16, '2820748095023', 70, '1982-07-13', 'Hebert', '', 'Manon', 1, 2, 16, 16),
(17, 17, '1790811262033', 45, '1979-08-10', 'Renault', '', 'Nicolas', 1, 1, 17, 17),
(18, 18, '2871075110074', 1, '1987-10-13', 'Caron', '', 'Françoise', 1, 2, 18, 18),
(19, 19, '2600992802431', 5, '1960-09-12', 'Le roux', 'Marie', 'Emilie', 2, 2, 19, 19),
(20, 20, '1750145234138', 43, '1975-01-11', 'Vasseur', '', 'Maxime', 2, 1, 20, 20),
(21, 21, '1701197302137', 12, '1970-11-19', 'Le', '', 'Mathis', 2, 1, 21, 21),
(22, 22, '1771183069038', 55, '1977-11-17', 'Morvan', '', 'Gaspard', 1, 1, 22, 22),
(23, 23, '2701173008043', 18, '1970-11-26', 'Denis', '', 'Lena', 1, 2, 23, 23),
(24, 24, '2790631555022', 53, '1979-06-01', 'Peron', '', 'Laura', 1, 2, 24, 24),
(25, 25, '2710734032014', 73, '1971-07-02', 'Serre', 'Gillet', 'Amélie', 2, 2, 25, 25),
(26, 26, '1820878172034', 12, '1982-08-09', 'Tanguy', '', 'Lorenzo', 1, 1, 26, 26),
(27, 27, '2880734301081', 27, '1988-07-23', 'Leon', 'Louis', 'Ambre', 2, 2, 27, 27),
(28, 28, '2680615162150', 76, '1968-06-20', 'Toussaint', '', 'Inès', 1, 2, 28, 28),
(29, 29, '1770509160048', 90, '1977-05-28', 'Leleu', '', 'Bruno', 1, 1, 29, 29),
(30, 30, '2790715014049', 20, '1979-07-10', 'Flament', 'Jacquemin', 'Léane', 2, 2, 30, 30),
(31, 31, '2770834199022', 15, '1977-08-17', 'Lacoste', 'Michaud', 'Agathe', 2, 2, 31, 31),
(32, 32, '1560583137322', 22, '1956-05-31', 'Blanchard', '', 'Antoine', 2, 1, 32, 32),
(33, 33, '2810590010048', 23, '1981-05-06', 'Tellier', '', 'Margaux', 1, 2, 33, 33),
(34, 34, '1560124322060', 46, '1956-01-15', 'Pereira', '', 'Victor', 1, 1, 34, 34),
(35, 35, '2831113103026', 11, '1983-11-15', 'Pruvost', '', 'Carla', 1, 2, 35, 35),
(36, 36, '2580930007014', 48, '1958-09-06', 'Schmitt', '', 'Lana', 1, 2, 36, 36),
(37, 37, '2800181163012', 62, '1980-01-01', 'Perez', 'Fabre', 'Fanny', 2, 2, 37, 37),
(38, 38, '2831295210011', 50, '1983-12-01', 'Le goff', '', 'Elsa', 1, 2, 38, 38),
(39, 39, '1551275073140', 76, '1955-12-23', 'Guillou', '', 'Anthony', 1, 1, 39, 39),
(40, 40, '1700912145014', 27, '1970-09-06', 'Etienne', '', 'Ethan', 2, 1, 40, 40),
(41, 41, '2870104209019', 23, '1987-01-26', 'Roques', '', 'Angelina', 1, 2, 41, 41),
(42, 42, '2850934172468', 3, '1985-09-29', 'Pons', '', 'Eléna', 1, 2, 42, 42),
(43, 43, '2680792012167', 71, '1968-07-22', 'Jacquemin', 'Moreno', 'Emma', 2, 2, 43, 43),
(44, 44, '2880684087082', 36, '1988-06-18', 'Briand', '', 'Valentine', 1, 2, 44, 44),
(45, 45, '2620721464058', 83, '1962-07-09', 'Mary', '', 'Sara', 1, 2, 45, 45),
(46, 46, '2690982121063', 68, '1969-09-17', 'Lejeune', 'Leblanc', 'Eloïse', 2, 2, 46, 46),
(47, 47, '1940660159410', 86, '1994-06-22', 'Renard', '', 'Benjamin', 1, 1, 47, 47),
(48, 48, '1690634172111', 79, '1969-06-09', 'Lopes', '', 'Guillaume', 1, 1, 48, 48);

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
-- Structure de la table `taux_charges`
--

CREATE TABLE `taux_charges` (
  `tx_charges_id` int(11) NOT NULL,
  `tx_charges_libelle` varchar(50) DEFAULT NULL,
  `tx_charges_valeur` float(5,3) NOT NULL,
  `tx_charges_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `taux_charges`
--

INSERT INTO `taux_charges` (`tx_charges_id`, `tx_charges_libelle`, `tx_charges_valeur`, `tx_charges_date`) VALUES
(1, 'Non cadre 2018', 20.870, '2018-01-01'),
(2, 'Cadre 2018', 23.480, '2018-01-01');

-- --------------------------------------------------------

--
-- Structure de la table `type_absence`
--

CREATE TABLE `type_absence` (
  `type_abs_id` int(11) NOT NULL,
  `type_abs_libelle_court` varchar(15) NOT NULL,
  `type_abs_libelle` varchar(70) NOT NULL,
  `type_abs_format` varchar(50) NOT NULL COMMENT 'Valoris? en heures ou en jours',
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
  `personne_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`utilisateur_id`, `utilisateur_identifiant`, `utilisateur_mdp`, `personne_id`) VALUES
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
(3, 1, '2018-01-01', NULL),
(3, 2, '2018-01-01', NULL),
(3, 3, '2018-01-01', NULL),
(3, 4, '2018-01-01', NULL),
(3, 5, '2018-01-01', NULL),
(3, 6, '2018-01-01', NULL),
(3, 7, '2018-01-01', NULL),
(3, 8, '2018-01-01', NULL),
(3, 9, '2018-01-01', NULL),
(3, 10, '2018-01-01', NULL),
(3, 11, '2018-01-01', NULL),
(3, 12, '2018-01-01', NULL),
(3, 13, '2018-01-01', NULL),
(3, 14, '2018-01-01', NULL),
(3, 15, '2018-01-01', NULL),
(3, 16, '2018-01-01', NULL),
(3, 17, '2018-01-01', NULL),
(3, 18, '2018-01-01', NULL),
(3, 19, '2018-01-01', NULL),
(3, 20, '2018-01-01', NULL),
(3, 21, '2018-01-01', NULL),
(3, 22, '2018-01-01', NULL),
(3, 23, '2018-01-01', NULL),
(3, 24, '2018-01-01', NULL),
(3, 25, '2018-01-01', NULL),
(3, 26, '2018-01-01', NULL),
(3, 27, '2018-01-01', NULL),
(3, 28, '2018-01-01', NULL),
(3, 29, '2018-01-01', NULL),
(3, 30, '2018-01-01', NULL),
(3, 31, '2018-01-01', NULL),
(3, 32, '2018-01-01', NULL),
(3, 33, '2018-01-01', NULL),
(3, 34, '2018-01-01', NULL),
(3, 35, '2018-01-01', NULL),
(3, 36, '2018-01-01', NULL),
(3, 37, '2018-01-01', NULL),
(3, 38, '2018-01-01', NULL),
(3, 39, '2018-01-01', NULL),
(3, 40, '2018-01-01', NULL),
(3, 41, '2018-01-01', NULL),
(3, 42, '2018-01-01', NULL),
(3, 43, '2018-01-01', NULL),
(3, 44, '2018-01-01', NULL),
(3, 45, '2018-01-01', NULL),
(3, 46, '2018-01-01', NULL),
(3, 47, '2018-01-01', NULL),
(3, 48, '2018-01-01', NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `absence`
--
ALTER TABLE `absence`
  ADD PRIMARY KEY (`absence_id`),
  ADD KEY `ABSENCE_CONTRAT0_FK` (`contrat_id`),
  ADD KEY `ABSENCE_TYPE_ABSENCE1_FK` (`type_abs_id`);

--
-- Index pour la table `adresse`
--
ALTER TABLE `adresse`
  ADD PRIMARY KEY (`adresse_id`),
  ADD UNIQUE KEY `ADRESSE_CONTACT0_AK` (`contact_id`);

--
-- Index pour la table `candidat`
--
ALTER TABLE `candidat`
  ADD PRIMARY KEY (`personne_id`,`candidat_id`),
  ADD UNIQUE KEY `CANDIDAT_UTILISATEUR0_AK` (`utilisateur_id`),
  ADD UNIQUE KEY `CANDIDAT_CONTACT1_AK` (`contact_id`),
  ADD KEY `CANDIDAT_CIVILITE1_FK` (`civilite_id`);

--
-- Index pour la table `civilite`
--
ALTER TABLE `civilite`
  ADD PRIMARY KEY (`civilite_id`);

--
-- Index pour la table `coefficient`
--
ALTER TABLE `coefficient`
  ADD PRIMARY KEY (`coefficient_id`);

--
-- Index pour la table `conges`
--
ALTER TABLE `conges`
  ADD PRIMARY KEY (`absence_id`,`conges_id`),
  ADD KEY `CONGES_PERIODE_CONGES1_FK` (`periode_id`),
  ADD KEY `CONGES_CONTRAT2_FK` (`contrat_id`),
  ADD KEY `CONGES_TYPE_ABSENCE3_FK` (`type_abs_id`);

--
-- Index pour la table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`contact_id`),
  ADD KEY `CONTACT_ETABLISSEMENT0_FK` (`etab_id`);

--
-- Index pour la table `contrat`
--
ALTER TABLE `contrat`
  ADD PRIMARY KEY (`contrat_id`),
  ADD KEY `CONTRAT_NATURE_CONTRAT0_FK` (`nature_ctr_id`),
  ADD KEY `CONTRAT_SALARIE1_FK` (`personne_id`,`salarie_id`),
  ADD KEY `CONTRAT__EMPLOI_FK` (`emploi_id`);

--
-- Index pour la table `contrat__planning`
--
ALTER TABLE `contrat__planning`
  ADD PRIMARY KEY (`planning_id`,`contrat_id`),
  ADD KEY `contrat__planning_CONTRAT1_FK` (`contrat_id`);

--
-- Index pour la table `contrat__service`
--
ALTER TABLE `contrat__service`
  ADD PRIMARY KEY (`contrat_id`,`service_id`),
  ADD KEY `contrat__service_SERVICE1_FK` (`service_id`);

--
-- Index pour la table `convention`
--
ALTER TABLE `convention`
  ADD PRIMARY KEY (`convention_id`);

--
-- Index pour la table `diplome`
--
ALTER TABLE `diplome`
  ADD PRIMARY KEY (`diplome_id`),
  ADD KEY `DIPLOME_PERSONNE0_FK` (`personne_id`);

--
-- Index pour la table `documents`
--
ALTER TABLE `documents`
  ADD PRIMARY KEY (`documents_id`),
  ADD UNIQUE KEY `DOCUMENTS_SALARIE0_AK` (`personne_id`,`salarie_id`);

--
-- Index pour la table `doc_diplome`
--
ALTER TABLE `doc_diplome`
  ADD PRIMARY KEY (`doc_diplome_id`),
  ADD UNIQUE KEY `DOC_DIPLOME_DIPLOME0_AK` (`diplome_id`);

--
-- Index pour la table `emploi`
--
ALTER TABLE `emploi`
  ADD PRIMARY KEY (`emploi_id`),
  ADD KEY `EMPLOI_CONVENTION0_FK` (`convention_id`),
  ADD KEY `EMPLOI_GRILLE1_FK` (`grille_id`);

--
-- Index pour la table `emploi__taux_charges`
--
ALTER TABLE `emploi__taux_charges`
  ADD PRIMARY KEY (`emploi_id`,`tx_charges_id`),
  ADD KEY `emploi__taux_charges_TAUX_CHARGES0_FK` (`tx_charges_id`);

--
-- Index pour la table `etablissement`
--
ALTER TABLE `etablissement`
  ADD PRIMARY KEY (`etab_id`),
  ADD KEY `ETABLISSEMENT_CONVENTION0_FK` (`convention_id`);

--
-- Index pour la table `experience`
--
ALTER TABLE `experience`
  ADD PRIMARY KEY (`experience_id`),
  ADD KEY `EXPERIENCE_PERSONNE0_FK` (`personne_id`);

--
-- Index pour la table `grille`
--
ALTER TABLE `grille`
  ADD PRIMARY KEY (`grille_id`);

--
-- Index pour la table `grille__coefficient`
--
ALTER TABLE `grille__coefficient`
  ADD PRIMARY KEY (`coefficient_id`,`grille_id`),
  ADD KEY `grille__coefficient_GRILLE0_FK` (`grille_id`);

--
-- Index pour la table `justificatif`
--
ALTER TABLE `justificatif`
  ADD PRIMARY KEY (`justificatif_id`),
  ADD UNIQUE KEY `JUSTIFICATIF_ABSENCE0_AK` (`absence_id`);

--
-- Index pour la table `nature_contrat`
--
ALTER TABLE `nature_contrat`
  ADD PRIMARY KEY (`nature_ctr_id`);

--
-- Index pour la table `periode_conges`
--
ALTER TABLE `periode_conges`
  ADD PRIMARY KEY (`periode_id`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`personne_id`),
  ADD UNIQUE KEY `PERSONNE_CONTACT1_AK` (`contact_id`),
  ADD UNIQUE KEY `PERSONNE_UTILISATEUR_AK` (`utilisateur_id`),
  ADD KEY `PERSONNE_CIVILITE0_FK` (`civilite_id`);

--
-- Index pour la table `planning`
--
ALTER TABLE `planning`
  ADD PRIMARY KEY (`planning_id`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Index pour la table `salarie`
--
ALTER TABLE `salarie`
  ADD PRIMARY KEY (`personne_id`,`salarie_id`),
  ADD UNIQUE KEY `SALARIE_UTILISATEUR0_AK` (`utilisateur_id`),
  ADD UNIQUE KEY `SALARIE_CONTACT1_AK` (`contact_id`),
  ADD KEY `SALARIE_SITUATION_FAMILIALE1_FK` (`fam_id`),
  ADD KEY `SALARIE_CIVILITE2_FK` (`civilite_id`);

--
-- Index pour la table `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`service_id`),
  ADD KEY `SERVICE_ETABLISSEMENT0_FK` (`etab_id`);

--
-- Index pour la table `situation_familiale`
--
ALTER TABLE `situation_familiale`
  ADD PRIMARY KEY (`fam_id`);

--
-- Index pour la table `taux_charges`
--
ALTER TABLE `taux_charges`
  ADD PRIMARY KEY (`tx_charges_id`);

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
  ADD UNIQUE KEY `UTILISATEUR_PERSONNE0_AK` (`personne_id`);

--
-- Index pour la table `utilisateur__role`
--
ALTER TABLE `utilisateur__role`
  ADD PRIMARY KEY (`role_id`,`utilisateur_id`),
  ADD KEY `utilisateur__role_UTILISATEUR1_FK` (`utilisateur_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `adresse`
--
ALTER TABLE `adresse`
  MODIFY `adresse_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `civilite`
--
ALTER TABLE `civilite`
  MODIFY `civilite_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `coefficient`
--
ALTER TABLE `coefficient`
  MODIFY `coefficient_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=269;

--
-- AUTO_INCREMENT pour la table `contact`
--
ALTER TABLE `contact`
  MODIFY `contact_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT pour la table `contrat`
--
ALTER TABLE `contrat`
  MODIFY `contrat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT pour la table `convention`
--
ALTER TABLE `convention`
  MODIFY `convention_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `diplome`
--
ALTER TABLE `diplome`
  MODIFY `diplome_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `documents`
--
ALTER TABLE `documents`
  MODIFY `documents_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `doc_diplome`
--
ALTER TABLE `doc_diplome`
  MODIFY `doc_diplome_id` int(11) NOT NULL AUTO_INCREMENT;

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
-- AUTO_INCREMENT pour la table `experience`
--
ALTER TABLE `experience`
  MODIFY `experience_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `grille`
--
ALTER TABLE `grille`
  MODIFY `grille_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT pour la table `justificatif`
--
ALTER TABLE `justificatif`
  MODIFY `justificatif_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `nature_contrat`
--
ALTER TABLE `nature_contrat`
  MODIFY `nature_ctr_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `periode_conges`
--
ALTER TABLE `periode_conges`
  MODIFY `periode_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `personne_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT pour la table `planning`
--
ALTER TABLE `planning`
  MODIFY `planning_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

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
-- AUTO_INCREMENT pour la table `taux_charges`
--
ALTER TABLE `taux_charges`
  MODIFY `tx_charges_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
  ADD CONSTRAINT `ABSENCE_CONTRAT0_FK` FOREIGN KEY (`contrat_id`) REFERENCES `contrat` (`contrat_id`),
  ADD CONSTRAINT `ABSENCE_TYPE_ABSENCE1_FK` FOREIGN KEY (`type_abs_id`) REFERENCES `type_absence` (`type_abs_id`);

--
-- Contraintes pour la table `adresse`
--
ALTER TABLE `adresse`
  ADD CONSTRAINT `ADRESSE_CONTACT0_FK` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`);

--
-- Contraintes pour la table `candidat`
--
ALTER TABLE `candidat`
  ADD CONSTRAINT `CANDIDAT_CIVILITE1_FK` FOREIGN KEY (`civilite_id`) REFERENCES `civilite` (`civilite_id`),
  ADD CONSTRAINT `CANDIDAT_CONTACT3_FK` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`),
  ADD CONSTRAINT `CANDIDAT_PERSONNE0_FK` FOREIGN KEY (`personne_id`) REFERENCES `personne` (`personne_id`),
  ADD CONSTRAINT `CANDIDAT_UTILISATEUR2_FK` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`utilisateur_id`);

--
-- Contraintes pour la table `conges`
--
ALTER TABLE `conges`
  ADD CONSTRAINT `CONGES_ABSENCE0_FK` FOREIGN KEY (`absence_id`) REFERENCES `absence` (`absence_id`),
  ADD CONSTRAINT `CONGES_CONTRAT2_FK` FOREIGN KEY (`contrat_id`) REFERENCES `contrat` (`contrat_id`),
  ADD CONSTRAINT `CONGES_PERIODE_CONGES1_FK` FOREIGN KEY (`periode_id`) REFERENCES `periode_conges` (`periode_id`),
  ADD CONSTRAINT `CONGES_TYPE_ABSENCE3_FK` FOREIGN KEY (`type_abs_id`) REFERENCES `type_absence` (`type_abs_id`);

--
-- Contraintes pour la table `contact`
--
ALTER TABLE `contact`
  ADD CONSTRAINT `CONTACT_ETABLISSEMENT0_FK` FOREIGN KEY (`etab_id`) REFERENCES `etablissement` (`etab_id`);

--
-- Contraintes pour la table `contrat`
--
ALTER TABLE `contrat`
  ADD CONSTRAINT `CONTRAT_NATURE_CONTRAT0_FK` FOREIGN KEY (`nature_ctr_id`) REFERENCES `nature_contrat` (`nature_ctr_id`),
  ADD CONSTRAINT `CONTRAT_SALARIE1_FK` FOREIGN KEY (`personne_id`,`salarie_id`) REFERENCES `salarie` (`personne_id`, `salarie_id`),
  ADD CONSTRAINT `CONTRAT__EMPLOI_FK` FOREIGN KEY (`emploi_id`) REFERENCES `emploi` (`emploi_id`);

--
-- Contraintes pour la table `contrat__planning`
--
ALTER TABLE `contrat__planning`
  ADD CONSTRAINT `contrat__planning_CONTRAT1_FK` FOREIGN KEY (`contrat_id`) REFERENCES `contrat` (`contrat_id`),
  ADD CONSTRAINT `contrat__planning_PLANNING0_FK` FOREIGN KEY (`planning_id`) REFERENCES `planning` (`planning_id`);

--
-- Contraintes pour la table `contrat__service`
--
ALTER TABLE `contrat__service`
  ADD CONSTRAINT `contrat__service_CONTRAT0_FK` FOREIGN KEY (`contrat_id`) REFERENCES `contrat` (`contrat_id`),
  ADD CONSTRAINT `contrat__service_SERVICE1_FK` FOREIGN KEY (`service_id`) REFERENCES `service` (`service_id`);

--
-- Contraintes pour la table `diplome`
--
ALTER TABLE `diplome`
  ADD CONSTRAINT `DIPLOME_PERSONNE0_FK` FOREIGN KEY (`personne_id`) REFERENCES `personne` (`personne_id`);

--
-- Contraintes pour la table `documents`
--
ALTER TABLE `documents`
  ADD CONSTRAINT `DOCUMENTS_SALARIE0_FK` FOREIGN KEY (`personne_id`,`salarie_id`) REFERENCES `salarie` (`personne_id`, `salarie_id`);

--
-- Contraintes pour la table `doc_diplome`
--
ALTER TABLE `doc_diplome`
  ADD CONSTRAINT `DOC_DIPLOME_DIPLOME0_FK` FOREIGN KEY (`diplome_id`) REFERENCES `diplome` (`diplome_id`);

--
-- Contraintes pour la table `emploi`
--
ALTER TABLE `emploi`
  ADD CONSTRAINT `EMPLOI_CONVENTION0_FK` FOREIGN KEY (`convention_id`) REFERENCES `convention` (`convention_id`),
  ADD CONSTRAINT `EMPLOI_GRILLE1_FK` FOREIGN KEY (`grille_id`) REFERENCES `grille` (`grille_id`);

--
-- Contraintes pour la table `emploi__taux_charges`
--
ALTER TABLE `emploi__taux_charges`
  ADD CONSTRAINT `emploi__taux_charges_EMPLOI_FK` FOREIGN KEY (`emploi_id`) REFERENCES `emploi` (`emploi_id`),
  ADD CONSTRAINT `emploi__taux_charges_TAUX_CHARGES0_FK` FOREIGN KEY (`tx_charges_id`) REFERENCES `taux_charges` (`tx_charges_id`);

--
-- Contraintes pour la table `etablissement`
--
ALTER TABLE `etablissement`
  ADD CONSTRAINT `ETABLISSEMENT_CONVENTION0_FK` FOREIGN KEY (`convention_id`) REFERENCES `convention` (`convention_id`);

--
-- Contraintes pour la table `experience`
--
ALTER TABLE `experience`
  ADD CONSTRAINT `EXPERIENCE_PERSONNE0_FK` FOREIGN KEY (`personne_id`) REFERENCES `personne` (`personne_id`);

--
-- Contraintes pour la table `grille__coefficient`
--
ALTER TABLE `grille__coefficient`
  ADD CONSTRAINT `grille__coefficient_COEFFICIENT_FK` FOREIGN KEY (`coefficient_id`) REFERENCES `coefficient` (`coefficient_id`),
  ADD CONSTRAINT `grille__coefficient_GRILLE0_FK` FOREIGN KEY (`grille_id`) REFERENCES `grille` (`grille_id`);

--
-- Contraintes pour la table `justificatif`
--
ALTER TABLE `justificatif`
  ADD CONSTRAINT `JUSTIFICATIF_ABSENCE0_FK` FOREIGN KEY (`absence_id`) REFERENCES `absence` (`absence_id`);

--
-- Contraintes pour la table `personne`
--
ALTER TABLE `personne`
  ADD CONSTRAINT `PERSONNE_CIVILITE0_FK` FOREIGN KEY (`civilite_id`) REFERENCES `civilite` (`civilite_id`),
  ADD CONSTRAINT `PERSONNE_CONTACT2_FK` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`),
  ADD CONSTRAINT `PERSONNE_UTILISATEUR1_FK` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`utilisateur_id`);

--
-- Contraintes pour la table `salarie`
--
ALTER TABLE `salarie`
  ADD CONSTRAINT `SALARIE_CIVILITE2_FK` FOREIGN KEY (`civilite_id`) REFERENCES `civilite` (`civilite_id`),
  ADD CONSTRAINT `SALARIE_CONTACT4_FK` FOREIGN KEY (`contact_id`) REFERENCES `contact` (`contact_id`),
  ADD CONSTRAINT `SALARIE_PERSONNE0_FK` FOREIGN KEY (`personne_id`) REFERENCES `personne` (`personne_id`),
  ADD CONSTRAINT `SALARIE_SITUATION_FAMILIALE1_FK` FOREIGN KEY (`fam_id`) REFERENCES `situation_familiale` (`fam_id`),
  ADD CONSTRAINT `SALARIE_UTILISATEUR3_FK` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`utilisateur_id`);

--
-- Contraintes pour la table `service`
--
ALTER TABLE `service`
  ADD CONSTRAINT `SERVICE_ETABLISSEMENT0_FK` FOREIGN KEY (`etab_id`) REFERENCES `etablissement` (`etab_id`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `UTILISATEUR_PERSONNE0_FK` FOREIGN KEY (`personne_id`) REFERENCES `personne` (`personne_id`);

--
-- Contraintes pour la table `utilisateur__role`
--
ALTER TABLE `utilisateur__role`
  ADD CONSTRAINT `utilisateur__role_ROLE0_FK` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  ADD CONSTRAINT `utilisateur__role_UTILISATEUR1_FK` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`utilisateur_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
