<?php

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

  $to = $_POST['mobile'];

  $phone = $_POST['phone'];

  $email = $_POST['email'];

  $otp = rand(1000, 9999);

  require_once('database.php');

  $host = HOST;

  $user = USER;

  $db = DB;

  $pass = PASS;

  $url = 'https://rest.nexmo.com/sms/json?' . http_build_query(
      [
        'api_key' =>  '6244b3b7',
        'api_secret' => '87a9cd1279b776e6',
        'to' => $to,
        'from' => '919871495638',
        'text' => 'Welcome To A2O. Your One Time Password Is '.$otp
      ]
  );

  $link = new PDO("mysql:host=$host; dbname=$db", $user, $pass);

  $stmt = $link->prepare("UPDATE users SET mobile = :mo WHERE email = :em");

  $result = $stmt->execute(array("mo" => $phone, "em" => $email));

  if ($result) {

    $ch = curl_init($url);

    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

    $response = curl_exec($ch);

    echo $otp;

  }

  else {

    echo "Please Try Again Later";

  }

}

else {

  echo "Error! Do Not Worry. We're Working On It!";

}

?>
