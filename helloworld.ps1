$hello_url = "http://127.0.0.1:50552/hello"
$world_url = "http://127.0.0.1:50577/world"

$hello_response = Invoke-WebRequest -Uri $hello_url -UseBasicParsing
$world_response = Invoke-WebRequest -Uri $world_url -UseBasicParsing

Write-Output "$($hello_response.Content) $($world_response.Content)"
