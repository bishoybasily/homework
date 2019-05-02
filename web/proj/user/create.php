<?php require_once('../config/connection.php'); ?>

<?php

$name = $_POST['name'];
$email = $_POST['email'];
$telephone = $_POST['telephone'];

$stmt = $pdo->prepare("INSERT INTO users(name, email, telephone) VALUES (:name, :email, :telephone)");
$stmt->execute(['name' => $name, 'email' => $email, 'telephone' => $telephone]);

header('Location: ' . $_SERVER['HTTP_REFERER']);
die()

?>
