<?php

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

  $fullname = $_POST['fullname'];

  $email = $_POST['email'];

  $password = $_POST['password'];

  $bloodgroup = $_POST['bloodgroup'];

  include_once('database.php');

  $host = HOST;

  $user = USER;

  $db = DB;

  $pass = PASS;

  $link = new PDO("mysql:host=$host;dbname=$db", $user, $pass);

  $check = $link->prepare("SELECT * FROM users WHERE email = :em");

  $check->execute(array("em" => $email));

  $result = $check->fetch(PDO::FETCH_ASSOC);

  if ($result) {

    echo "Email Already Exists!";

  }

  else {

    $stmt = $link->prepare("INSERT INTO users(fullname, email, password, bloodgroup) VALUES(:fn, :em, :pa, :bg)");

    $result = $stmt->execute(array("fn" => $fullname, "em" => $email, "pa" => $password, "bg" => $bloodgroup));

    if ($result) {

      echo "Successfully Registered!";

    }

    else {

      echo "Please Try Again Later!";

    }

  }

}

else {

  echo "Error! Do Not Worry. We're Working On It!";

}

?>
