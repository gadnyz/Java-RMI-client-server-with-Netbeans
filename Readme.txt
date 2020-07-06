
	Project Name	:	<< CUSTUMER-SERVER APPLICATION FOR MANAGING BANK ACCOUNTS >>

	Ask by		:	Joseph NDONG (joesis00@gmail.com )

	Author		:	GAD NYUMBAIZA (gadnyumbaiza@gmail.com)
				And Joseph (youremail@gmail.com)

	Date		:	26 Juin 2020

------------------------------------------------------------------------------------------------
# T H E   G O A L
------------------------------------------------------------------------------------------------


The goal of this mini project is to master the RMI technology and develop an application for it.
distributed client/server for bank account management with the use of an
data.

The application is subdivided into two parts, the client part and the server one


------------------------------------------------------------------------------------------------
# D E V S  - T  O O L S
------------------------------------------------------------------------------------------------



	* IDE : Netbeans 8.2

	* JDK 8.2

	* Database : Postegres 12

	* GITHUB Repository > https://github.com/gadnyz/Java-RMI-client-server-with-Netbeans



------------------------------------------------------------------------------------------------
# I N S T A L L   T O O L S
------------------------------------------------------------------------------------------------


1. Download of POSTEGRES: https://www.postgresql.org/download/

2. Launch pgAdmin4.exe

3. Import the tools/banque.sql in pgAdmin4 > Create first a the database with the name banque. after copy the sql script in banque.sql run it in pgadmin4

4. Download of Java DataBase Connectivity (JDBC) postegres : https://jdbc.postgresql.org/download.html

   The JDBC must match with the version of your installed Java
    
	* For >= JAVA 8 download PostgreSQL JDBC 4.2 Driver, 42.2.14

	* For JAVA 7 download PostgreSQL JDBC 4.1 Driver, 42.2.14.jre7

	* For JAVA 6 download  PostgreSQL JDBC 4.0 Driver, 42.2.14.jre6


------------------------------------------------------------------------------------------------
# L A U N C H   T H E   A P P L I C A T I O N 
------------------------------------------------------------------------------------------------

	* In case of using on two PC 		> 	You must coonect the both hosts on the same ccess point (you can use Smartphone to create the access point)

	* Run the serveur rmi.RMIServeur	>	Put the server IP in the Network, the Databas access (login , password and  server port) Default port is 5432

	* Run the client client.client		>	Give server IP, rmi access port and the current account numRef 