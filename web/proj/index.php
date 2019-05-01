<?php require_once('connection.php'); ?>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Directory</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <style>

        div.row.insert {
            margin-top: 26px;
            margin-bottom: 26px;
        }

    </style>

</head>
<body>

<div class="jumbotron text-center">
    <h1>ISSR DIRECTORY</h1>
    <p>This is a basic directory app</p>
</div>

<div class="container">

    <div class="row">
        <div class="col-sm-3">
            <h3>Name</h3>
        </div>
        <div class="col-sm-4">
            <h3>Email</h3>
        </div>
        <div class="col-sm-3">
            <h3>Telephone</h3>
        </div>
        <div class="col-sm-2">

        </div>
    </div>

    <div class="row insert">

        <form method="post" action="create.php">

            <div class="col-sm-3">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input type="text" class="form-control" name="name" placeholder="Name">
                </div>
            </div>

            <div class="col-sm-4">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                    <input type="email" class="form-control" name="email" placeholder="Email">
                </div>
            </div>

            <div class="col-sm-3">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-headphones"></i></span>
                    <input type="tel" class="form-control" name="telephone" placeholder="Telephone">
                </div>
            </div>

            <div class="col-sm-2">
                <input class='btn btn-success btn-block' type='submit' value='Insert'>
            </div>

        </form>

    </div>

    <?php

    $stmt = $pdo->query("SELECT * FROM users");
    while ($row = $stmt->fetch()) {
        echo("
                <div class='row'>
                    <div class='col-sm-3'>
                        <p>" . $row->name . "</p>
                    </div>
                    <div class='col-sm-4'>
                        <p>" . $row->email . "</p>
                    </div>
                    <div class='col-sm-3'>
                        <p>" . $row->telephone . "</p>
                    </div>
                    <div class='col-sm-2'>
                        <form method='post' action='delete.php'>
                            <input type='hidden' name='id' value='$row->id'>
                            <input class='btn btn-danger btn-block' type='submit' value='Delete'>
                        </form>
                    </div>
                </div>
        ");
    }

    ?>

</div>

</body>
</html>

