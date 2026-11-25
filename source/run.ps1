param(
    [switch]$Debug,
    [ValidateRange(1024,65535)][int]$Port = 5005,
    [string]$JavaHome = '',
    [string]$OriginalJar = ''
)
$ErrorActionPreference = 'Stop'
. (Join-Path $PSScriptRoot 'toolchain\JavaHome.ps1')
$java = Find-ProjectJava -JavaHome $JavaHome
$arguments = @('-NoProfile', '-ExecutionPolicy', 'Bypass', '-File', (Join-Path $PSScriptRoot 'eclipse-build.ps1'))
if ($JavaHome) { $arguments += @('-JavaHome', $JavaHome) }
if ($OriginalJar) { $arguments += @('-OriginalJar', $OriginalJar) }
$directory = 'dist'
if ($Debug) { $arguments += '-DebugSymbols'; $directory = 'debug-dist' }
& powershell.exe @arguments
if ($LASTEXITCODE -ne 0) { throw "Build failed (exit $LASTEXITCODE)." }
$javaArguments = @('-Xmx768m', '-Dfile.encoding=UTF-8')
if ($Debug) {
    $javaArguments += "-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=127.0.0.1:$Port"
    Write-Host "Waiting for Eclipse debugger on 127.0.0.1:$Port. Attach and Resume (F8)."
}
$classpath = (Join-Path $PSScriptRoot 'lib\microemulator-2.0.4.jar') + ';' + (Join-Path $PSScriptRoot 'lib\microemu-jsr-120-2.0.4.jar')
$javaArguments += @('-cp', $classpath, 'org.microemu.app.Main', '--rms', 'memory', (Join-Path $PSScriptRoot "$directory\NinjaSchool_251-source-rebuilt.jar"))
& $java @javaArguments
exit $LASTEXITCODE
