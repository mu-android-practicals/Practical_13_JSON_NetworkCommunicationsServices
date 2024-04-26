2. Create MYSQL Database and Table
Create database user_db;
use user_db;
Create table user_info (name varchar(20), email varchar(50), mobile varchar(20));
Insert into user_info values (“practical13”, “practical13@gmail.com”, “9876543210”);
Select * from user_info;

PHP file code 

 Create PHP file
C:\xampp\htdocs\scripts\getInfo.php
<?php
$user_name = "root";
$password= "root";
$host = "localhost";
$db_name = "user_db";
$con= mysqli_connect($host,$user_name,$password,$db_name);
$sql="select * from user_info where name like practical13;";
$result = mysqli_query($con, $sql);
if(mysqli_num_rows($result)>0)
$row=mysqli_fetch_assoc($result);
echo json_encode(array("Name"=>$row["name"],
"Email"=>$row["email"],"Mobile"=>$row["mobile"]));
}
?>



how to check on browser

localhost/scripts/getInfo.php
