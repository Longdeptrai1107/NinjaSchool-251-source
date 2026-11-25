param(
    [string]$JavaHome = '',
    [string]$OutputDirectory = '',
    [string]$OriginalJar = '',
    [switch]$DebugSymbols,
    [switch]$CompileOnly
)
$ErrorActionPreference = 'Stop'
. (Join-Path $PSScriptRoot 'toolchain\JavaHome.ps1')
$java = Find-ProjectJava -JavaHome $JavaHome
& (Join-Path $PSScriptRoot 'prepare.ps1') -JavaHome $JavaHome -OriginalJar $OriginalJar
if (-not $OutputDirectory) {
    if ($DebugSymbols) { $OutputDirectory = Join-Path $PSScriptRoot 'debug-dist' }
    else { $OutputDirectory = Join-Path $PSScriptRoot 'dist' }
}
$mode = 'release'
if ($DebugSymbols) { $mode = 'debug' }
$action = 'build'
if ($CompileOnly) { $action = 'compile' }
& $java '-Dfile.encoding=UTF-8' (Join-Path $PSScriptRoot 'toolchain\StandaloneJarBuild.java') $action $PSScriptRoot $OutputDirectory $mode
if ($LASTEXITCODE -ne 0) { throw "Java ME source build failed (exit $LASTEXITCODE)." }
exit 0
