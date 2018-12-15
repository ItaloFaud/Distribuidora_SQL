-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 15-Dez-2018 às 19:54
-- Versão do servidor: 10.1.34-MariaDB
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `distribuidora`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nome` varchar(145) DEFAULT NULL,
  `user` varchar(60) NOT NULL,
  `senha` varchar(60) NOT NULL,
  `CPF` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `user`, `senha`, `CPF`) VALUES
(9, 'Ítalo Faud de Sena Nogueira', 'ItaloFaud', 'qwert', '099.898.989-89'),
(10, 'Pedro Henrique', 'Pedim121', 'qwert', '092.102.193-80'),
(12, 'Ped', 'ped', 'qwert', '098.789.098-90'),
(14, 'Pedr', 'Pedr', 'qwert', '111.111.111-11');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fatura`
--

CREATE TABLE `fatura` (
  `id` int(11) NOT NULL,
  `Subtotal` varchar(30) DEFAULT NULL,
  `idCliente` int(11) NOT NULL,
  `situacao` varchar(30) NOT NULL,
  `entrega` varchar(28) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `fatura`
--

INSERT INTO `fatura` (`id`, `Subtotal`, `idCliente`, `situacao`, `entrega`) VALUES
(15, '85.20000000000002', 14, 'Paga', 'Em andamento'),
(16, '0', 9, 'À pagar', 'Não Liberada'),
(17, '0', 9, 'À pagar', 'Não Liberada'),
(18, '0', 9, 'À pagar', 'Não Liberada'),
(19, '0', 9, 'À pagar', 'Não Liberada'),
(20, '0', 9, 'À pagar', 'Não Liberada'),
(21, '197.9', 9, 'Paga', 'Em andamento');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `user` varchar(120) NOT NULL,
  `senha` varchar(50) NOT NULL,
  `cpf` varchar(32) NOT NULL,
  `nivel` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`id`, `nome`, `user`, `senha`, `cpf`, `nivel`) VALUES
(5, 'Chefe da Empresa', 'AdminMaster', 'qwert12345', '', 3),
(7, 'Pedim', 'Pedim', 'qwert', '909.888.782-88', 2),
(8, 'André', 'andre12', 'qwert', '123.453.212-31', 1),
(9, 'José Castro Alves', 'JseCstr12', 'qwert', '123.456.555-43', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedido`
--

CREATE TABLE `pedido` (
  `id` int(11) NOT NULL,
  `Caixas` int(11) DEFAULT NULL,
  `idProduto` int(11) NOT NULL,
  `idFatura` int(11) NOT NULL,
  `total` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pedido`
--

INSERT INTO `pedido` (`id`, `Caixas`, `idProduto`, `idFatura`, `total`) VALUES
(11, 2, 4, 15, '19.8'),
(12, 2, 2, 15, '25.8'),
(13, 3, 4, 15, '29.700000000000003'),
(14, 1, 4, 15, '9.9'),
(15, 10, 4, 21, '99.0'),
(16, 1, 6, 21, '98.9');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `caixas` int(11) NOT NULL,
  `preco` varchar(25) DEFAULT NULL,
  `marca` varchar(50) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `data_validade` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id`, `caixas`, `preco`, `marca`, `tipo`, `data_validade`) VALUES
(1, 101, '9.90', 'Fortaleza', 'Arroz', '09/09/2021'),
(2, 80, '12.90', 'Fortaleza', 'Macarrão', '09/09/2021'),
(4, 144, '9.90', 'Fortaleza', 'Bolacha', '09/12/2020'),
(5, 120, '150.75', 'Havaianas', 'Chinela', '02/06/2026'),
(6, 1199, '98.90', 'Realengo', 'Arroz', '12/12/2021');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user` (`user`),
  ADD UNIQUE KEY `CPF` (`CPF`);

--
-- Indexes for table `fatura`
--
ALTER TABLE `fatura`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idCliente` (`idCliente`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user` (`user`);

--
-- Indexes for table `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idProduto` (`idProduto`),
  ADD KEY `idFatura` (`idFatura`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `fatura`
--
ALTER TABLE `fatura`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `fatura`
--
ALTER TABLE `fatura`
  ADD CONSTRAINT `fatura_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`);

--
-- Limitadores para a tabela `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`id`),
  ADD CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`idFatura`) REFERENCES `fatura` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
