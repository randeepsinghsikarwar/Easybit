param (
    [string]$newPath
)

$oldPath = [Environment]::GetEnvironmentVariable('PATH', 'Machine');
[Environment]::SetEnvironmentVariable('PATH', "$newPath;$oldPath", 'Machine');
Write-Host "PATH updated successfully. New PATH: $newPath"
