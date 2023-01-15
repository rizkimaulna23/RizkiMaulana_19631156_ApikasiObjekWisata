-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 11 Jan 2023 pada 13.40
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `objek_wisata`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_event`
--

CREATE TABLE `tbl_event` (
  `id_event` varchar(11) NOT NULL,
  `nama_event` varchar(250) NOT NULL,
  `tgl_event` date NOT NULL,
  `keterangan` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbl_event`
--

INSERT INTO `tbl_event` (`id_event`, `nama_event`, `tgl_event`, `keterangan`) VALUES
('EVT01', 'Kembang Api', '2023-01-01', 'Tahun Baru Aku Baru'),
('EVT02', 'Malam Jenaka', '2023-01-05', 'Haha Lucu ini');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_tiket`
--

CREATE TABLE `tbl_tiket` (
  `id_tiket` varchar(11) NOT NULL,
  `id_wisata` varchar(11) NOT NULL,
  `id_event` varchar(11) NOT NULL,
  `tgl_tiket` date NOT NULL,
  `jml_tiket` varchar(250) NOT NULL,
  `biaya_tiket` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbl_tiket`
--

INSERT INTO `tbl_tiket` (`id_tiket`, `id_wisata`, `id_event`, `tgl_tiket`, `jml_tiket`, `biaya_tiket`) VALUES
('TKT01', 'W1', 'Evt01', '2023-01-11', '10', '10000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_wisata`
--

CREATE TABLE `tbl_wisata` (
  `id_wisata` varchar(11) NOT NULL,
  `nama` varchar(250) NOT NULL,
  `alamat` varchar(250) NOT NULL,
  `keterangan` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbl_wisata`
--

INSERT INTO `tbl_wisata` (`id_wisata`, `nama`, `alamat`, `keterangan`) VALUES
('W1', 'Pantai Batakan', 'jl batakan', 'Pantai Umum'),
('W2', 'Pantai Tangkisung', 'jl Tangkisung', 'Pantai Umum'),
('W3', 'Bukit Matang Kaladan', 'jl. BJB', 'Umum');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tbl_event`
--
ALTER TABLE `tbl_event`
  ADD PRIMARY KEY (`id_event`);

--
-- Indeks untuk tabel `tbl_tiket`
--
ALTER TABLE `tbl_tiket`
  ADD PRIMARY KEY (`id_tiket`),
  ADD KEY `id_wisata` (`id_wisata`),
  ADD KEY `id_event` (`id_event`);

--
-- Indeks untuk tabel `tbl_wisata`
--
ALTER TABLE `tbl_wisata`
  ADD PRIMARY KEY (`id_wisata`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
