<?php include_once('../config/connection.php'); ?>

<?php

header("Access-Control-Allow-Origin: *");
header("Content-Type: application/json; charset=UTF-8");

$stmt = $pdo->query("SELECT * FROM users");

$users_arr = array();

while ($row = $stmt->fetch()) {
    extract($row);

    $user_item = array(
        "id" => $id,
        "name" => $name,
        "email" => $email,
        "telephone" => $telephone
    );

    array_push($users_arr, $user_item);
}

http_response_code(200);
echo json_encode($users_arr);

?>
