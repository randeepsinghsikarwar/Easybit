param (
    [string]$newPath
)

# Get the current system path
$oldPath = [Environment]::GetEnvironmentVariable('PATH', 'Machine');

# Check if newPath already exists in the oldPath
if ($oldPath -notlike "*$newPath*") {
    # If not, update the PATH environment variable
    [Environment]::SetEnvironmentVariable('PATH', "$newPath;$oldPath", 'Machine');
    Write-Host "PATH updated successfully. New PATH: $newPath"
} else {
    Write-Host "The path is already present in the PATH variable."
}
