@echo off
cd /d "%~dp0"
where java >nul 2>nul || (echo Install JDK 17+ first.& pause & exit /b 1)
where mvn >nul 2>nul || (echo Install Maven 3.9+ first. See SETUP_GUIDE.md.& pause & exit /b 1)
call mvn clean test -Dbrowser=chrome -Dheadless=true
pause
