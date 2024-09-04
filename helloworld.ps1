$hello_url = "http://127.0.0.1:57030/hello"
$world_url = "http://127.0.0.1:56958/world"

$hello_response = Invoke-WebRequest -Uri $hello_url -UseBasicParsing
$world_response = Invoke-WebRequest -Uri $world_url -UseBasicParsing

Write-Output "$($hello_response.Content) $($world_response.Content)"
