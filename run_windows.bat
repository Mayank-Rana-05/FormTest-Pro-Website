@echo off
setlocal
cd /d "%~dp0"
title FormTest Pro - Java Selenium Automation
color 0B
echo ================================================
echo             FORMTEST PRO - JAVA
echo       Selenium WebDriver + TestNG + Maven
echo ================================================
echo.
where java >nul 2>nul
if errorlevel 1 (
  echo ERROR: Java is not installed or JAVA_HOME/PATH is not configured.
  echo Install JDK 17 or newer, then reopen this file.
  pause
  exit /b 1
)
where mvn >nul 2>nul
if errorlevel 1 (
  echo ERROR: Apache Maven is not installed or not added to PATH.
  echo Install Maven 3.9 or newer, then reopen this file.
  echo See SETUP_GUIDE.md for instructions.
  pause
  exit /b 1
)
echo Choose browser:
echo 1. Chrome (default)
echo 2. Firefox
echo 3. Edge
set /p choice="Enter 1, 2 or 3: "
set browser=chrome
if "%choice%"=="2" set browser=firefox
if "%choice%"=="3" set browser=edge
echo.
echo Starting all 300 designed automated test executions using %browser%...
echo First run may take longer while Maven downloads dependencies and Selenium Manager obtains the driver if needed.
echo.
call mvn clean test -Dbrowser=%browser% -Dheadless=false
if errorlevel 1 (
  echo.
  echo Some tests failed or the run could not complete. Check target\surefire-reports.
) else (
  echo.
  echo Test run completed. Open target\surefire-reports\index.html or the TestNG report files.
)
echo.
pause
