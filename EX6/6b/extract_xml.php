<?php
// Load the XML file
$xml = simplexml_load_file("players.xml") or die("Error: Cannot create object");

// Display the XML data in a table
echo "<!DOCTYPE html>
<html lang='en'>
<head>
    <meta charset='UTF-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'>
    <title>Cricket Players XML</title>
    <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css'>
</head>
<body>
    <div class='container mt-5'>
        <h1 class='text-center'>Cricket Players from XML</h1>
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

// Loop through each player in the XML file
foreach ($xml->player as $player) {
    echo "<tr>
            <td>" . $player->id . "</td>
            <td>" . $player->name . "</td>
            <td>" . $player->team . "</td>
            <td>" . $player->runs . "</td>
          </tr>";
}

echo "    </tbody>
        </table>
    </div>
</body>
</html>";
?>
