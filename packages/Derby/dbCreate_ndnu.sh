#!/bin/sh

#     *************************************************
#     this script creates the database schema

. ./dbSetenv_ndnu.sh

java -classpath $CLASSPATH -Dij.driver=org.apache.derby.jdbc.ClientDriver -Dij.database=$DB_NAME\;create=true -Dij.user=guest -Dij.password=password org.apache.derby.tools.ij dbCreate_ndnu.sql
