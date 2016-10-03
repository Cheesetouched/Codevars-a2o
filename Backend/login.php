<?php

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

  $email = $_POST['email'];

  $password = $_POST['password'];

  require_once('database.php');

  $host = HOST;

  $user = USER;

  $db = DB;

  $pass = PASS;

  $link = new PDO("mysql:host=$host; dbname=$db", $user, $pass);

  $stmt = $link->prepare("SELECT * FROM users WHERE email = :em AND password = :pa");

  $stmt->execute(array("em" => $email, "pa" => $password));

  $result = $stmt->fetch(PDO::FETCH_ASSOC);

  if ($result) {

    echo "Successfully Logged In!";

  }

  else {

    echo "Invalid Email Or Password!";

  }

}

else {

  echo "Error! Do Not Worry. We Are Working On It.";

}

?>
