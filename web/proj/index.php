<?php

require_once('connection.php');

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
</head>
<body>

<table>
    <thead>
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Telephone</td>
        <td></td>
    </tr>
    </thead>
    <tbody>

    <?php

    $stmt = $pdo->query("SELECT * FROM users");
    while ($row = $stmt->fetch()) {
        echo("
                <tr>
                    <td>" . $row->name . "</td>
                    <td>" . $row->email . "</td>
                    <td>" . $row->telephone . "</td>
                    <td>
                        <form method='post' action='delete.php'>
                            <input type='hidden' name='id' value='$row->id'>
                            <input type='submit' value='Delete'>
                        </form>
                    </td>
                </tr>
        ");
    }

    ?>

    </tbody>
</table>

<div>

    <form method="post" action="create.php">
        <table>
            <tr>
                <td><input type="text" placeholder="name" name="name"></td>
                <td><input type="email" placeholder="email" name="email"></td>
                <td><input type="tel" placeholder="telephone" name="telephone"></td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="submit" value="Insert">
                </td>
            </tr>
        </table>
    </form>

</div>

</body>
</html>

