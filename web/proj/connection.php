<?php
$host = '127.0.0.1';
$username = 'root';
$passwd = 'toor';
$dbname = 'issr';

$dsn = 'mysql:host=' . $host . ';dbname=' . $dbname;
$pdo = new PDO($dsn, $username, $passwd);

$pdo->setAttribute(PDO::ATTR_DEFAULT_FETCH_MODE, PDO::FETCH_OBJ);
?>
