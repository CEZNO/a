======================================================
Oracle Free Use Terms and Conditions (FUTC) License 
======================================================
https://www.oracle.com/downloads/licenses/oracle-free-license.html
===================================================================


ojdbc8-full.tar.gz - JDBC Thin Driver and Companion JARS
========================================================
This TAR archive (ojdbc8-full.tar.gz) contains the 18.15 release of the Oracle JDBC Thin driver(ojdbc8.jar), 
the Universal Connection Pool (ucp.jar) and other companion JARs grouped by category. 

(1) ojdbc8.jar (4,178,170 bytes)-(SHA1 Checksum: 01769cd061fd0df71bc0d18b175fe6708fd87a19)Certified with JDK 8; 

(2) ucp.jar (1,401,183 bytes) - (SHA1 Checksum:b2e128a97045d96afe5c66c5778ba1b47fe74af8)
Universal Connection Pool classes for use with JDK 8 -- for performance, scalability, high availability, sharded and multitenant databases.

(3) ojdbc.policy (11,596 bytes) - Sample security policy file for Oracle Database JDBC drivers

======================
Security Related JARs
======================
Java applications require some additional jars to use Oracle Wallets. 
You need to use all the three jars while using Oracle Wallets. 

(4) oraclepki.jar (310,291 bytes) - (SHA1 Checksum: d450475f1c140784150f261b8d37d79c40d137c2)
Additional jar required to access Oracle Wallets from Java
(5) osdt_cert.jar (208,738 bytes) - (SHA1 Checksum: 3a48452f19891c1aa7a032589c225aaa03d746c8)
Additional jar required to access Oracle Wallets from Java
(6) osdt_core.jar (312,198 bytes) - (SHA1 Checksum: cf2c5ad72b06865ec8390839e40cbb6b0b201181)
Additional jar required to access Oracle Wallets from Java

=============================
JARs for NLS and XDK support 
=============================
(7) orai18n.jar (1,664,011 bytes) - (SHA1 Checksum: 3e770b1e25cc572810156422cf5587efb656cd14) 
Classes for NLS support
(8) xdb.jar (264,881 bytes) - (SHA1 Checksum: b3a581464195b3ac90cb50537615a2c3571311fc)
Classes to support standard JDBC 4.x java.sql.SQLXML interface 
(9) xmlparserv2.jar (1,906,855 bytes) - (SHA1 Checksum: 4afe35e54345621bbef0ba094a67b03ae07e1444)
Classes to support standard JDBC 4.x java.sql.SQLXML interface 

====================================================
JARs for Real Application Clusters(RAC), ADG, or DG 
====================================================
(10) ons.jar (148,462 bytes) - (SHA1 Checksum: 03928c5cc2099e78c3e07befb3ad06b8d4f2758c)
for use by the pure Java client-side Oracle Notification Services (ONS) daemon
(11) simplefan.jar (32,066 bytes) - (SHA1 Checksum: 292e9329798fed8ae5ad418068c8cc312f7cf1b5)
Java APIs for subscribing to RAC events via ONS; simplefan policy and javadoc

=====================================================================================

NOTE: The diagnosability JARs **SHOULD NOT** be used in the production environment. 
These JARs (ojdbc8_g.jar,ojdbc8dms.jar, ojdbc8dms_g.jar) are meant to be used in the 
development, testing, or pre-production environment to diagnose any JDBC related issues. 

=====================================
OJDBC - Diagnosability Related JARs
=====================================
The TAR archive (ojdbc8-diag.tar.gz) contains the Oracle JDBC diagnosability related JARs listed below. 

(12) ojdbc8_g.jar (6,963,100 bytes) - (SHA1 Checksum: 7ffd565ae6b48c339ad395e7bcce708f71e979b2)
Same as ojdbc8.jar except compiled with "javac -g" and contains tracing code.

(13) ojdbc8dms.jar (5,824,618 bytes) - (SHA1 Checksum: ea205eaa03026f98f9eb1b3365340abe0572f1eb)
Same as ojdbc8.jar, except that it contains instrumentation to support DMS and limited java.util.logging calls.

(14) ojdbc8dms_g.jar (6,992,804 bytes) - (SHA1 Checksum: bb4b2f179401955e58e5b70ba7cdc1b22e9e6d73)
Same as ojdbc8_g.jar except that it contains instrumentation to support DMS.

(15) dms.jar (2,194,305 bytes) - (SHA1 Checksum: 4a3c129ecebf287d009db6a1ff1218c4819085b5)
dms.jar required for DMS-enabled JAR files.

==================================================================
Javadoc and README for JDBC Thin driver 
and Universal Connection Pool (UCP)
==================================================================
The TAR archive (ojdbc-javadoc.tar.gz) contains the files listed here. 

(16) Javadoc-JDBC-18c.jar (1,693,561 bytes) - JDBC API Reference 18c 

(17) Javadoc-UCP-18c.jar (365,611 bytes) - UCP Java API Reference 18c 

(18) Readme-JDBC.txt: It contains some details of 18.15 features and bugs that have been fixed in the 18.15 release. 

(19) Readme-UCP.txt: It contains some details about the bugs that are fixed in the 18.15 release. 

(20) Bugs-fixed-in-1815.txt: Contains the list of bugs fixed in 18.15 release.


=================
USAGE GUIDELINES
=================
Refer to the JDBC Developers Guide (https://docs.oracle.com/en/database/oracle/oracle-database/18/jjdbc/index.html) and Universal Connection Pool Developers Guide (https://docs.oracle.com/en/database/oracle/oracle-database/18/jjucp/index.html)for more details. 
