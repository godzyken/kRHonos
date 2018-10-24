-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  Dim 14 oct. 2018 à 19:04
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
-- Base de données :  `myevents2`
--

-- --------------------------------------------------------

--
-- Structure de la table `events`
--

CREATE TABLE `events` (
  `id` int(11) NOT NULL,
  `timeStart` time NOT NULL,
  `timeEnd` time NOT NULL,
  `dow` int(1) NOT NULL,
  `date_start` date NOT NULL,
  `date_end` date DEFAULT NULL,
  `range` tinyblob,
  `frequency` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `events`
--

INSERT INTO `events` (`id`, `timeStart`, `timeEnd`, `dow`, `date_start`, `date_end`, `range`, `frequency`) VALUES
(1, '09:00:00', '12:00:00', 1, '2018-10-01', NULL, NULL, 2),
(2, '13:00:00', '17:00:00', 1, '2018-10-01', '2018-10-20', NULL, 1),
(3, '08:00:00', '12:00:00', 2, '2018-10-02', '2018-10-20', NULL, 1),
(4, '13:00:00', '17:00:00', 2, '2018-10-02', '2018-10-20', NULL, 1),
(5, '08:00:00', '12:00:00', 3, '2018-10-03', '2018-10-20', NULL, 1),
(6, '13:00:00', '17:00:00', 3, '2018-10-03', '2018-10-20', NULL, 1),
(7, '08:00:00', '12:00:00', 4, '2018-10-04', '2018-10-20', NULL, 1),
(8, '13:00:00', '17:00:00', 4, '2018-10-04', '2018-10-20', NULL, 1),
(9, '08:00:00', '12:00:00', 5, '2018-10-05', '2018-10-20', NULL, 1);

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
(56);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `events`
--
ALTER TABLE `events`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
