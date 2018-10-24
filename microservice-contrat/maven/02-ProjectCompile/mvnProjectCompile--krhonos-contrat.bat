REM **********************************************************************************************************
REM * (01.)EFFECTUER LES OPERATIONS SUIVANTES :
REM *
REM *      ->NETTOYER LE PROJET
REM *      ->COMPILER LE PROJET (GENERER LES CLASSES EN BYTE-CODE).
REM *      ->GENERER LE FICHIER EXECUTABLE DU PROJET.
REM *      ->COPIER LE FICHIER EXECUTABLE DANS LE DEPOT MAVEN LOCAL.
REM **********************************************************************************************************
mvn clean install ^
 -e -X ^
 > .\logCompile\compile--krhonos-Contrat--%date:~6,4%.%date:~3,2%.%date:~0,2%--0%time:~1,1%.%time:~3,2%.%time:~6,2%.log
 
mvn clean install ^
 -e -X ^
 > .\logCompile\compile--krhonos-Contrat--%date:~6,4%.%date:~3,2%.%date:~0,2%--%time:~0,2%.%time:~3,2%.%time:~6,2%.log
