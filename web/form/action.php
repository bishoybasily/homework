<html>
<body>

Username: <?php echo $_POST["username"]; ?> <br>
Password: <?php echo $_POST["password"]; ?> <br>
Preferred Time: <?php echo $_POST["time"]; ?> <br>
Courses: <?php echo print_r($_POST["courses"]); ?> <br>
City: <?php echo $_POST["city"]; ?> <br>
About you: <?php echo $_POST["about"]; ?> <br>
Preferred Language : <?php echo print_r($_POST["lang"]); ?>

</body>
</html>
