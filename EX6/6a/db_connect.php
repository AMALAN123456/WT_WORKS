<?php
// Database connection details
$servername = "localhost";  // Change to your server address
$username = "root";         // Change to your database username
$password = "";             // Change to your database password
$dbname = "cricket_db";     // Your database name

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Query to fetch player data
$sql = "SELECT id, name, team, runs FROM players";
$result = $conn->query($sql);

// Check if there are any results
if ($result->num_rows > 0) {
    // Start table HTML
    echo "<!DOCTYPE html>
    <html lang='en'>
    <head>
        <meta charset='UTF-8'>
        <meta name='viewport' content='width=device-width, initial-scale=1.0'>
        <title>Cricket Player Stats</title>
        <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css'>
    </head>
    <body>
        <div class='container mt-5'>
            <h1 class='text-center'>Cricket Player Stats</h1>
            <table class='table table-bordered'>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Team</th>
                        <th>Runs</th>
                    </tr>
                </thead>
                <tbody>";
    
    // Output data of each row
    while($row = $result->fetch_assoc()) {
        echo "<tr>
                <td>" . $row["id"] . "</td>
                <td>" . $row["name"] . "</td>
                <td>" . $row["team"] . "</td>
                <td>" . $row["runs"] . "</td>
              </tr>";
    }

    echo "</tbody></table></div></body></html>";
} else {
    echo "0 results found";
}

// Close connection
$conn->close();
?>
