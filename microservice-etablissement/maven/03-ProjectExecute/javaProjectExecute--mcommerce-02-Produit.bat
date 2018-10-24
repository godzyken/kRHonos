REM **********************************************************************************************************
REM * (01.)EFFECTUER LES OPERATIONS SUIVANTES :
REM *
REM *      ->LANCER LE FICHIER EXECUTABLE DU PROJET.
REM *      ->CONFIGURATION DU SERVER : PORT=9010
REM **********************************************************************************************************
java -verbose ^
 -Dserver.port=9010 ^
 -jar ^
 ./target/mproduit.jar ^
 > .\logExecute\execute--mcommerce-02-Produit--Port9010--%date:~6,4%.%date:~3,2%.%date:~0,2%--0%time:~1,1%.%time:~3,2%.%time:~6,2%.log
 
java -verbose ^
 -Dserver.port=9010 ^
 -jar ^
 ./target/mproduit.jar ^
 > .\logExecute\execute--mcommerce-02-Produit--Port9010--%date:~6,4%.%date:~3,2%.%date:~0,2%--%time:~0,2%.%time:~3,2%.%time:~6,2%.log

REM **********************************************************************************************************
REM * (02.)EFFECTUER LES OPERATIONS SUIVANTES :
REM *
REM *      ->LANCER LE FICHIER EXECUTABLE DU PROJET.
REM *      ->CONFIGURATION DU SERVER : PORT=9011
REM **********************************************************************************************************
 java -verbose ^
 -Dserver.port=9011 ^
 -jar ^
 ./target/mproduit.jar ^
 > .\logExecute\run--mcommerce-02-Produit--Port9011--%date:~6,4%.%date:~3,2%.%date:~0,2%--0%time:~1,1%.%time:~3,2%.%time:~6,2%.log
 
java -verbose ^
 -Dserver.port=9011 ^
 -jar ^
 ./target/mproduit.jar ^
 > .\logExecute\run--mcommerce-02-Produit--Port9011--%date:~6,4%.%date:~3,2%.%date:~0,2%--%time:~0,2%.%time:~3,2%.%time:~6,2%.log
