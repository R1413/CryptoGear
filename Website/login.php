<?php
$servername = "64.6.232.42";
$username = "vivoapps";
$password = "Jump2tinydoc";
$dbname = "vivoapps_CryptoDatabase";


/*
if (!isset($_GET["email"])) {
    print("email not valid.");
}

if (!isset($_GET["password"])) {
    print("password not valid.");
}
*/

// else {


    //$Email = $_GET["email"];
    //$Password = $_GET["password"];

    $Email = "jose.canizares@colorado.edu";
    $Password = "1234";



// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);


// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

//$sqlEmail =  $conn->quote($Email);
//$sqlPassword = $conn->quote($Password);


$sql = "SELECT * FROM User_Accounts";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    //while($row = $result->fetch_assoc()) {
        
        
        //echo "id: " . $row["id"]. " - Name: " . $row["UserName"]. " " . $row["Password"]. "<br>";
    //}
    
    ?>
    
    <h1>Results for <?= $first_name ?> <?= $last_name ?></h1>
                            
        <table>
            <caption>All Users</caption>
            <?= printTable($result) ?>
        </table>
        
<?php
} else {
    echo "0 results";
}


$conn->close();

// }




function printTable($rows) {
        $count = 1;
        ?>
        <tr><th>#</th><th>username</th><th>password</th></tr>
        <?php
        foreach($rows as $row) { 
            ?>
            <tr>
                <td><?= $count ?></td>
                <td><?=$row["UserName"]?></td>
                <td><?=$row["Password"]?></td>
            </tr>
            <?php
            $count++;
        }
    }
?>



