Oracle JDBC Driver patch release 18.15.0.0.0 Readme.txt
======================================================

Driver Versions
---------------

These are the driver versions in the 18.15 release:

  - JDBC Thin Driver 18.15
    100% Java client-side JDBC driver for use in client applications,
    middle-tier servers and applets.

  - JDBC OCI Driver 18.15
    Client-side JDBC driver for use on a machine where OCI 18.15
    is installed.

  - JDBC Thin Server-side Driver 18.15
    JDBC driver for use in Java program in the database to access
    remote Oracle databases.

  - JDBC Server-side Internal Driver 18.15
    Server-side JDBC driver for use by Java Stored procedures.  This
    driver used to be called the "JDBC Kprb Driver".

For complete documentation, please refer to "JDBC Developer's Guide
and Reference".


Contents Of This Release
------------------------

For all platforms:

  [ORACLE_HOME]/jdbc/lib contains:

  - ojdbc8.jar
    Classes for use with JDK 8. It contains the JDBC driver classes
    except classes for NLS support in Oracle Object and Collection
    types. 

  - ojdbc8_g.jar
    Same as ojdbc8.jar except compiled with "javac -g" and contains
    tracing code.

  - ojdbc8dms.jar
    Same as ojdbc8.jar, except that it contains instrumentation to
    support DMS and limited java.util.logging calls.

  - ojdbc8dms_g.jar
    Same as ojdbc8_g.jar except that it contains instrumentation to
    support DMS.


  Note: The dms versions of the jar files are the same as 
    standard jar files, except that they contain additional code
    to support Oracle Dynamic Monitoring Service. They contain a
    limited amount of tracing code. These can only be used
    when dms.jar is in the classpath. dms.jar is provided as part of
    Oracle Application Server releases. As a result the dms versions
    of the jar files can only be used in an Oracle Application Server
    environment. 

  [ORACLE_HOME]/jdbc/doc/javadoc.tar contains the JDBC Javadoc
  for the public API of the public classes of Oracle JDBC. This
  JavaDoc is the primary reference for Oracle JDBC API extensions. The
  Oracle JDBC Development Guide contains high level discussion of
  Oracle extensions. The details are in this JavaDoc. The JavaDoc is
  every bit as authorative as the Dev Guide.

  [ORACLE_HOME]/jdbc/demo/demo.tar contains sample JDBC programs.

  [ORACLE_HOME]/jlib/orai18n.jar
    NLS classes for use with JDK 1.6, and 7.  It contains
    classes for NLS support in Oracle Object and Collection types.
    This jar file replaces the old nls_charset jar/zip files. In 
    Oracle 10g R1 it was duplicated in [ORACLE_HOME]/jdbc/lib. We
    have removed the duplicate copy and you should now get it from
    its proper location.


For the Windows platform:

  [ORACLE_HOME]\bin directory contains ocijdbc18.dll and
  heteroxa18.dll, which are the libraries used by the JDBC OCI
  driver.

For non-Windows platforms:

  [ORACLE_HOME]/lib directory contains libocijdbc18.so,
  libocijdbc18_g.so, libheteroxa11.so and libheteroxa18_g.so, which
  are the shared libraries used by the JDBC OCI driver.


NLS Extension Jar File (for client-side only)
---------------------------------------------

The JDBC Server-side Internal Driver provides complete NLS support.
It does not require any NLS extension jar file.  Discussions in this
section only apply to the Oracle JDBC Thin and JDBC OCI drivers.

The basic jar files (ojdbc8.jar) contain all the
necessary classes to provide complete NLS support for:

  - Oracle Character sets for CHAR/VARCHAR/LONGVARCHAR/CLOB type data
    that is not retrieved or inserted as a data member of an Oracle
    Object or Collection type.

  - NLS support for CHAR/VARCHAR data members of Objects and
    Collections for a few commonly used character sets.  These
    character sets are:  US7ASCII, WE8DEC, WE8ISO8859P1, WE8MSWIN1252,
    AL32UTF8 and UTF8.

Users must include the NLS extension jar file
([ORACLE_HOME]/jlib/orai18n.jar) in their CLASSPATH if utilization of
other character sets in CHAR/VARCHAR data members of
Objects/Collections is desired.  

The file orai18n.jar contains many important character-related files.
Most of these files are essential to globalization support.  Instead
of extracting only the character-set files your application uses, it
is safest to follow this three-step process: 1.  Unpack orai18n.jar
into a temporary directory.  2.  Delete the character-set files that
your application does not use.  Do not delete any territory, collation
sequence, or mapping files.  3.  Create a new orai18n.jar file from
the temporary directory and add the altered file to your CLASSPATH.
See the JDBC Developers Guide for more information.


Installation
------------

Please do not try to put multiple versions of the Oracle JDBC drivers
in your CLASSPATH.  The Oracle installer installs the JDBC Drivers in
the [ORACLE_HOME]/jdbc directory.


Setting Up Your Environment
---------------------------

In order to use the JDBC Thin Driver 18.15, please add ojdbc8.jar to
your CLASSPATH.

You may also add the following jars:
- orai18n.jar in order to get full NLS support;
- ucp.jar, ons.jar and simplefan.jar in case you usr RAC
- oraclepki.jar and osdt_cert.jar if you use Wallets
- xdb.jar if your use XMLType or SQLXML


Known Problems Fixed in This Patch Release (on top of 18.14)
---------------------------------------------------------------

18.15 is the July Critical Patch Update (CPU) which contains NNE fix for the vulnerability CVE-2021-2351. 
Refer MOS note 2791571.1 for more details. 

BUG-32720458 - SECURITY BUG

