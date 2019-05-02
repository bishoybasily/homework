<?php require_once('../config/connection.php'); ?>

<?php

$id = $_POST['id'];

$name = $_POST['name'];
$email = $_POST['email'];
$telephone = $_POST['telephone'];

$stmt = $pdo->prepare("UPDATE users SET name=:name, email=:email, telephone=:telephone WHERE id=:id");
$stmt->execute(['id' => $id, "name" => $name, "email" => $email, "telephone" => $telephone]);

header('Location: ' . $_SERVER['HTTP_REFERER']);
die()

?>
