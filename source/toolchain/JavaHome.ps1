function Find-ProjectJava {
    param([string]$JavaHome = '')
    $candidates = @()
    if ($JavaHome) { $candidates += (Join-Path $JavaHome 'bin\java.exe') }
    $candidates += (Join-Path $PSScriptRoot 'java\bin\java.exe')
    if ($env:JAVA_HOME) { $candidates += (Join-Path $env:JAVA_HOME 'bin\java.exe') }
    $command = Get-Command java -ErrorAction SilentlyContinue
    if ($command) { $candidates += $command.Source }
    $selected = $candidates | Where-Object { $_ -and (Test-Path -LiteralPath $_ -PathType Leaf) } | Select-Object -First 1
    if (-not $selected) { throw 'JDK 17+ not found. Set JAVA_HOME or pass -JavaHome.' }
    return $selected
}
