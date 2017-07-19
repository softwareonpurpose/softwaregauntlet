$completeInstall = 'Restart PowerShell to complete install/upgrade.`nPress any key to continue';

if($PSVersionTable.PSVersion.Major -ne '5'){
    choco upgrade powershell;
    Read-Host completeInstall;
    exit;
    }

if((Get-ExecutionPolicy) -ne 'RemoteSigned'){
    Set-ExecutionPolicy RemoteSigned;
    Read-Host completeInstall;
    exit;
    }

if((choco --version) -ne '0.10.7'){
    iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'));
    Read-Host completeInstall;
    exit;
    }

if((java -version) -ne '1.8'){
    choco upgrade jdk8;
    Read-Host completeInstall;
    exit;
    }

if((git --version) -notcontains '2.13.3'){
    choco upgrade git;
    Read-Host completeInstall;
    exit;
    }

if(!Test-Path 'C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 2017.1.5\bin'){
    choco upgrade intellij;
    Read-Host completeInstall;
    exit;
    }
