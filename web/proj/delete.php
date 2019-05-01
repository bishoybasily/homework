<?php require_once('connection.php'); ?>

<?php

$id = $_POST['id'];

$stmt = $pdo->prepare("DELETE FROM users WHERE id=:id");
$stmt->execute(['id' => $id]);

header('Location: ' . $_SERVER['HTTP_REFERER']);
die()

?>
