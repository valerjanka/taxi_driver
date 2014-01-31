@echo off
setLocal EnableDelayedExpansion
rem
rem  run-script
rem
rem  USAGE: run.bat
rem

set BASE_DIR=..
set LIB_DIR=lib
set CFG_DIR=cfg
rem change JAVA_HOME in line below
rem set JAVA_HOME=C:\Program Files\Java\jdk1.7.0_04

set JAVA="%JAVA_HOME%\bin\java.exe"

set RDL_OPTS=-Xms128M -Xmx512M -XX:-UseSplitVerifier

set CP=%CFG_DIR%\

pushd %BASE_DIR%
pushd %LIB_DIR%
for %%L in (*.jar) do set CP=!CP!;%LIB_DIR%\%%L
popd
popd

pushd %BASE_DIR%
%JAVA% %RDL_OPTS% -cp %CP% com.taxi.driver.server.ServerBootstrap %*
popd

pause
