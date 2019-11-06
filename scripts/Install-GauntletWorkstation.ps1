param {
    [switch]$Version
};
if($Version){return '0.3'};
Set-ExecutionPolicy Bypass -Scope Process -Force
$wc = New-Object System.Net.WebClient;
$wc.Proxy.Credentials = [System.Net.CredentialCache]::DefaultNetworkCredentials;
iex ($wc.DownloadString('https://chocolatey.org/install.ps1'));
refreshenv;
choco upgrade jdk8 -y;
refreshenv;
choco upgrade jdk11 -y;
refreshenv;
choco upgrade git -y;
refreshenv;
choco upgrade poshgit -y;
refreshenv;
choco upgrade gradle -y;
refreshenv;
choco upgrade intellijidea-community -y;
refreshenv;
"Confirm that System Environment Property 'JAVA_HOME' is set to the correct installation of Java'";
"Confirm that System Environment Property 'Path' includes `"%JAVA_HOME%\bin`" (replace any explicit path to Java\bin";
'It is advised that this Powershell console be closed, and a new PowerShell console opened, before expeting full functionality';
