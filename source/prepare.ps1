param([string]$JavaHome = '', [string]$OriginalJar = '')
$ErrorActionPreference = 'Stop'
[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12
$lock = Get-Content -LiteralPath (Join-Path $PSScriptRoot 'config\dependencies.lock.json') -Raw -Encoding UTF8 | ConvertFrom-Json
$lib = Join-Path $PSScriptRoot 'lib'
New-Item -ItemType Directory -Force -Path $lib | Out-Null
foreach ($dependency in $lock.dependencies) {
    $target = Join-Path $lib $dependency.name
    if (Test-Path -LiteralPath $target) {
        if ((Get-FileHash -LiteralPath $target -Algorithm SHA256).Hash.ToLowerInvariant() -ne $dependency.sha256) {
            throw "Existing dependency differs from the pinned hash; not overwritten: $target"
        }
        continue
    }
    $temporary = Join-Path $lib ('.download-' + [Guid]::NewGuid().ToString('N') + '.tmp')
    Invoke-WebRequest -UseBasicParsing -Uri $dependency.url -OutFile $temporary
    if ((Get-FileHash -LiteralPath $temporary -Algorithm SHA256).Hash.ToLowerInvariant() -ne $dependency.sha256) {
        throw "Downloaded dependency checksum mismatch: $($dependency.name)"
    }
    Move-Item -LiteralPath $temporary -Destination $target
}
if ($OriginalJar) {
    . (Join-Path $PSScriptRoot 'toolchain\JavaHome.ps1')
    $java = Find-ProjectJava -JavaHome $JavaHome
    & $java '-Dfile.encoding=UTF-8' (Join-Path $PSScriptRoot 'toolchain\StandaloneJarBuild.java') 'import' $PSScriptRoot $OriginalJar
    if ($LASTEXITCODE -ne 0) { throw "Resource import failed (exit $LASTEXITCODE)." }
}
